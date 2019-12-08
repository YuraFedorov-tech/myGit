package e019;

import java.util.ArrayDeque;

public class e019 {
	static int ans;
	static int cur;
	static int lastDayOfMonth;
	static int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public e019(int m) {
		ans = 0;
		cur = 0;
		lastDayOfMonth = m;
	}

	public static void main(String[] args) {

		e019 d = new e019(7);
		d.work();
		d.print();

	}

	private void work() {
		for (int i = 1900; i < 2001; i++) {
			count(i);
		}
	}

	private void count(int year) {
		for (int i = 0; i < 12; i++) {
			int dif = FindDif(year, i);
			Find_lastDayOfMonth(dif, year, i);
			if (year == 1900)
				continue;
			if (lastDayOfMonth == 6)
				ans++;
		}

	}

	private void Find_lastDayOfMonth(int dif, int year, int m) {
		dif %= 7;
		lastDayOfMonth += dif;
		if (lastDayOfMonth > 7)
			lastDayOfMonth -= 7;

	}

	private int FindDif(int year, int monthCur) {
		if (monthCur != 1)
			return month[monthCur];
		if (year % 4 != 0)
			return 28;
		if (year % 100 == 0 & year % 400 != 0)
			return 28;
		return 29;
	}

	private void print() {
		System.out.print(ans);
	}
	/*
	 * Counting Sundays 
	 * Problem 19
	 */
}