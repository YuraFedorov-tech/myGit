package e049;

import java.util.ArrayList;
import java.util.Arrays;

public class e049 {
	private static boolean erot[];
	private static int max;
	private static int mi;
	private static int ma;
	private static ArrayList<Integer> list;
	private static String ans;

	public e049(int m, int i, int j) {
		erot = new boolean[m];
		max = m;
		ans = "";
		mi = i;
		ma = j;
		list = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		int m = 100_000;
		e049 q = new e049(m, 1000, 10_000);
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
		for (int i = 0; i < list.size() - 1; i++) {
			GO(list.get(i), i);
		}

	}

	private void GO(int first, int j) {
		for (int i = j + 1; i < list.size(); i++) {
			int second = list.get(i);
			if (erot[second])
				continue;
			int thried = second + (second - first);
			if (thried > 10000 | erot[thried])
				continue;
			if (Chek(first, second, thried)) {			
				if(first!=1487)
				ans += first + "" + second + "" + thried;
			}
		}

	}

	private boolean Chek(int first, int second, int thried) {
		int[] f = FindF(Integer.toString(first));
		int[] ff = FindF(Integer.toString(second));
		int[] fff = FindF(Integer.toString(thried));
		if (Arrays.equals(f, ff))
			if (Arrays.equals(f, fff))
				return true;
		return false;
	}

	private int[] FindF(String s) {
		int[] an = new int[10];
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt("" + s.charAt(i));
			an[n]++;
		}
		return an;
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
 * Prime permutations  
 * Problem 49
 */
