package e050;

import java.util.ArrayList;

public class e050 {
	private static boolean erot[];
	private static int max;
	private static int mi;
	private static int ma;
	private static ArrayList<Integer> list;
	private static int ans;
	private static int ansMean;

	public e050(int m, int i, int j) {
		erot = new boolean[m];
		max = m;
		ans = ansMean = 0;
		mi = i;
		ma = j;
		list = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		int m = 5_000_000;
		e050 q = new e050(m, 0, 1_000_000);
		q.work();
		q.print();

	}

	private void print() {
		System.out.print(ansMean);
	}

	private void work() {
		DoErot();
		DoList();
		FindAns();
	}

	private void FindAns() {
		for (int i = 2; i < list.size() - 1; i++) {
			GO(i);
		}
	}

	private int GO(int j) {
		int CurAns = 0;
		int CurMean = 0;
		for (int i = j; i < list.size(); i++) {
			CurMean += list.get(i);
			if (CurMean > ma)
				break;
			if (!erot[CurMean])
				if (CurAns > ans) {
					ans = CurAns + 1;
					ansMean = CurMean;
				}
			CurAns++;
		}
		return Math.max(ans, CurAns);
	}

	private void DoList() {
		for (int i = mi; i < ma; i++)
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
 * Consecutive prime sum Problem 50
 */
