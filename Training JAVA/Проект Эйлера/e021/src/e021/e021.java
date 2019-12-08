package e021;

import java.util.ArrayDeque;

public class e021 {
	static int ans;
	static boolean[] buzy;

	public e021(int m) {
		ans = 0;
		buzy = new boolean[m];
	}

	public static void main(String[] args) {

		e021 d = new e021(100000);
		d.work();
		d.print();

	}

	private void work() {
		for (int i = 220; i < 10000; i++) {
			if (buzy[i])
				continue;
			int first = FindDivider(i);
			int second = FindDivider(first);
			if (i == second && first != second) {
				ans += first + second;
			}
			buzy[first] = true;
		}
	}

	private int FindDivider(int n) {
		int a = 0;
		int max = n / 2 + 1;
		if (max > n)
			max = n - 1;
		for (int i = 1; i <= max; i++)
			if (n % i == 0)
				a += i;
		return a;
	}

	private void print() {
		System.out.print(ans);
	}
	/*
	 * Amicable numbers   
     * Problem 21
	 */
}