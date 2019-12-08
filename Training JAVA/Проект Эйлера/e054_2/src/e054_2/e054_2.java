package e054_2;


import java.util.Scanner;

public class e054_2 {
	private int ans;
	private int max;

	public e054_2(int m) {
		max = m;
		ans = 0;
	}

	public static void main(String[] args) {
		e054_2 d = new e054_2(1_000);
		// e054 d = new e054(1);
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
			for (int i = 0; i < 5; i++) {
				num[i] = Find(s[i].charAt(0));
				mean[i] = Find(s[i].charAt(1), 0);
			}
			DO w = new DO(num, mean);
			w.change();

			for (int i = 5; i < 10; i++) {
				num[i - 5] = Find(s[i].charAt(0));
				mean[i - 5] = Find(s[i].charAt(1), 0);
			}
			DO e = new DO(num, mean);
			e.change();

			if (w.compear(e)) {
				ans++;

			}
			if (j == 515) {
				pri(w);
				pri(e);
				System.out.print(j + "  "+o);
				System.out.println("Yes");
				System.out.println();
			}
		}

	}

	private void pri(DO w) {
		for (int i = 0; i < 5; i++)
			System.out.print(w.num[i] + " ");
		System.out.println("  n=" + w.n);

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
 * Counting fractions Problem 72
 */
