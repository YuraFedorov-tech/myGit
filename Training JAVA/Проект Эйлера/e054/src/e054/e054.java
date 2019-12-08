package e054;

import java.util.Scanner;

public class e054 {
	private int ans;
	private int max;

	public e054(int m) {
		max = m;
		ans = 0;
	}

	public static void main(String[] args) {
		e054 d = new e054(1_000);		
		d.work();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		input();
		print();
	}

	private void input() {
		int num[] = new int[5];
		int mean[] = new int[5];
		Scanner M = new Scanner(System.in);
		for (int j = 0; j < max; j++) {
			String o = M.nextLine().trim();
			String[] s = o.split("\\ ", -1);
			FindArray(num, mean, 0, 5, s);
			e054_2 w = new e054_2(num, mean);
			w.change();
			FindArray(num, mean, 5, 10, s);
			e054_2 e = new e054_2(num, mean);
			e.change();
			if (w.compear(e)) 
				ans++;	
		}
	}
	private void FindArray(int[] num, int[] mean, int i, int j, String[] s) {
		int t = i;
		for (; i < j; i++) {
			num[i - t] = Find(s[i].charAt(0));
			mean[i - t] = Find(s[i].charAt(1), 0);
		}
	}	
	private int Find(char ch, int i) {
		if (ch == 'S')
			return 1;
		if (ch == 'C')
			return 2;
		if (ch == 'H')
			return 3;
		if (ch == 'D')
			return 4;
		return 4 / 0;
	}

	private int Find(char ch) {
		if (ch == 'T')
			return 10;
		if (ch == 'J')
			return 11;
		if (ch == 'Q')
			return 12;
		if (ch == 'K')
			return 13;
		if (ch == 'A')
			return 14;
		return Integer.parseInt("" + ch);
	}
}
/*
 * Poker hands   
 * Problem 54
 */
