package e060;

import java.util.ArrayList;

public class e060 {
	private static boolean erot[];
	private static int max;
	private static int max2;
	private ArrayList<Integer> list;
	private ArrayList<Integer> simple;
	private static int[] a;
	static int ans;
	private static int stop;

	public e060(int m, int i, int j) {
		erot = new boolean[m];
		max = m;
		list = new ArrayList<Integer>();
		simple = new ArrayList<Integer>();
		a = new int[j];
		stop = j;
		max2 = 1200;
		
	}

	public static void main(String[] args) {
		int m = 100_000_001;
		e060 q = new e060(m, 1_000_000, 5);
		q.work();
		
	}

	private void print() {
		System.out.println(ans);	
	}

	private void work() {
		DoErot();
		DoList();
		 GO();
		print();
	}

	private void GO() {
		for (int i = 0; i < max2; i++) {
			simple.add(list.get(i));
			Rek(0, i);
			if (ans != 0)
				return;
			simple.remove(0);
		}

	}

	private void Rek(int step, int j) {
		if (step == stop-1) {
			Count();
			return;
		}
		for (int i = j + 1; i < max2; i++) {
			int w = list.get(i);
			if (!Chek(w))
				continue;
			simple.add(w);
			Rek(step + 1, i);
			if (ans != 0)
				return;
			simple.remove(simple.size() - 1);
		}

	}

	private boolean Chek(int w) {
		for (int i = 0; i < simple.size(); i++)
			if (!YES(w, simple.get(i)))
				return false;
		return true;
	}

	private boolean YES(int w, int t) {
		String s = w + "" + t;
		int z = Integer.parseInt(s);
		if (erot[z])
			return false;
		s = t + "" + w;
		z = Integer.parseInt(s);		
		if (erot[z])
			return false;
		return true;
	}

	private void Count() {
		for (int i = 0; i < simple.size(); i++) {
			ans += simple.get(i);

		}
	}

	private void DoList() {
		for (int i = 2; i < max; i++)
			if (!erot[i]) {
				list.add(i);
			}
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
 * Prime pair sets   
 * Problem 60
 */