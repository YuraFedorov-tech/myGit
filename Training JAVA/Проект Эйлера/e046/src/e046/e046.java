package e046;

import java.util.ArrayList;

public class e046 {
	private static boolean erot[];
	private static int max;
	private static int cur;
	private static int mi;
	private static int ma;
	private static ArrayList<Integer> list;
	static long ans;

	public e046(int m, int i, int j) {
		erot = new boolean[m];
		max = m;
		ans = 0;
		mi = i;
		ma = j;
		cur = 0;
		list = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		int m = 4_000_001;

		e046 q = new e046(m, 0, m - 5);
		q.work();
		q.print();

	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		DoErot();
		DoList();
		Goldenbux();
	}

	private void Goldenbux() {
		int i = 9;
		while (true) {
			if(erot[i])
			if (!GOLD(i)) {
				ans = i;
				break;
			}

			i+=2;
		}

	}

	private boolean GOLD(int n) {
		for (int i = 0; i < max; i++) {
			int q=list.get(i);
			if(q>=n)
				return false;
			if(go(q, n))
				return true;
		}

		return false;
	}

	private boolean go(int q, int n) {
		for(int i=1;i<=Integer.MAX_VALUE;i++) {
			if(i==Integer.MAX_VALUE) {
				System.out.print(n);
				return false;
			}
			int z=q+2*i*i;
			if(z==n)
				return true;
			if(z>n)
				break;
		}
		return false;
	}

	private void DoList() {
		for (int i = 2; i < ma; i++)
			if (!erot[i])
				list.add(i);

	}

	private void DoErot() {
		for (int i = 2; i < max; i++) {
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
 * Goldbach's other conjecture Problem 46
 */