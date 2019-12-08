package e010;

public class e010 {
	private static boolean erot[];
	private static int max;
	static long ans;

	public e010(int m) {
		erot = new boolean[m];
		max = m;
		ans = 0;
	}

	public static void main(String[] args) {
		int m = 2_000_001;

		e010 q = new e010(m);
		q.work();
		q.print();

	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		DoErot();
		FindAns();
	}

	private void FindAns() {
		for (int i = 2; i < max; i++)
			if (!erot[i]) {
				ans += i;
				assert (ans>0);
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
Summation of primes   
Problem 10
*/