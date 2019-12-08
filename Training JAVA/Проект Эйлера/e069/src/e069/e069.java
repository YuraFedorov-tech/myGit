package e069;

public class e069 {
	private static boolean erot[];
	private static int max;
	private static int max2;
	private static int[] a;
	static int ans;

	public e069(int m, int i) {
		erot = new boolean[m];
		max = m;
		max2 = i;
		a = new int[m + 1];
	}

	public static void main(String[] args) {
		int m = 4_000_001;
		e069 q = new e069(m, 1_000_000);
		q.work();
		q.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		DoErot();
		GO();
	}

	private void GO() {
		a[2] = 1;
		a[3] = 2;

		double an = 0;
		for (int i = 4; i <= max2; i++) {
			if (!erot[i]) {
				a[i] = i - 1;
			} else if (i % 2 == 0) {
				int q = i / 2;
				a[i] = q % 2 == 0 ? 2 * a[q] : a[q];

			} else
				a[i] = F(i);
			double z = (double) i / a[i];
			if (an < z) {
				an = z;
				ans = i;
			}
		}
	}

	private int F(int n) {
		int g = n;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				g -= g / i;
			}
		}
		if (n > 1)
			g -= g / n;
		return g;
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
 * Totient maximum   
 * Problem 69
 */