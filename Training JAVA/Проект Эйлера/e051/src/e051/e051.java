package e051;

import java.util.ArrayList;

public class e051 {
	private static boolean erot[];
	private static int max;
	static int ans;
	ArrayList<Integer> list;
	ArrayList<Integer> mean;

	public e051(int m, int i) {
		erot = new boolean[m];
		max = m;
		ans = i;
		list = new ArrayList<Integer>();
		mean = new ArrayList<Integer>();

	}

	public static void main(String[] args) {
		int m = 1_000_000;

		e051 q = new e051(m, 8);
		q.work();
		q.print();

	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		DoErot();
		DoList();
		DoListMean();
		GO();
	}

	private void GO() {
		for (int i = 1; i < mean.size() - 1; i++) {
			e051_2 w = new e051_2(mean.get(i), mean.get(i + 1), erot, max, list);
			w.FindCoincidence();
			int con = w.getCoincidence();
			if (ans == con) {
				ans = w.getMinimum();
				return;
			}
		}
	}

	private void DoListMean() {
		mean.add(0);
		long t = 10;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > t) {
				mean.add(i);
				t *= 10;
			}
		}
		mean.add(list.size() - 1);
	}

	private void DoList() {
		for (int i = 2; i < max; i++) {
			if (!erot[i])
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
 * Prime digit replacements Problem 51
 */