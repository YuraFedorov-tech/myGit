package e037;

import java.util.ArrayList;

public class e037 {
	private static boolean erot[];
	private static int max;
	private static int mi;
	private static int ma;
	private static ArrayList<Integer> list;
	private static int ans;

	public e037(int m, int i) {
		erot = new boolean[m];
		max = m;
		ans = 0;
		// mi = m;
		// ma = j;
		list = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		int m = 5_000_000;
		e037 q = new e037(m, 0);
		q.work();
		q.print();

	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		DoErot();
		DoList();
		FindAns();
	}

	private void FindAns() {
		int i = 0;
		int cur = 0;
		while (true) {
			int sim = list.get(i++);
			if (sim < 10)
				continue;
			if (Chek(Integer.toString(sim))) {
				ans += sim;
				cur++;
			}
			if (cur == 11)
				break;
		}

	}

	private boolean Chek(String s) {
		if (!forward(s))
			return false;
		return forward2(s);
	}

	private boolean forward2(String s) {
		String w = "";
		for (int i = 0; i < s.length(); i++) {
			w = w + s.charAt(i);
			int z = Integer.parseInt(w);
			if (erot[z])
				return false;
		}
		return true;
	}

	private boolean forward(String s) {
		String w = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			w = s.charAt(i) + w;
			int z = Integer.parseInt(w);
			if (erot[z])
				return false;
		}
		return true;
	}

	private void DoList() {
		for (int i = 0; i < max; i++)
			if (!erot[i])
				list.add(i);
	}

	private void DoErot() {
		erot[1] = true;
		for (int i = 2; i < 100000; i++) {
			if (!erot[i])
				changErot(i);
		}
	}

	private void changErot(int i) {
		int j = i * 2;
		while (j < max) {
			erot[j] = true;
			j += i;
		}
	}
}
/*
 * Truncatable primes Problem 37
 */
