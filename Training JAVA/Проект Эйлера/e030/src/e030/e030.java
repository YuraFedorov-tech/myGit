package e030;

public class e030 {
	private static int pows;
	private static long ans;
	private static long max;

	public e030(int m, int i) {
		pows = m;
		ans = 0;
		max = i;
	}

	public static void main(String[] args) {

		e030 q = new e030(5, 200_000);
		q.work();
		q.print();
	}

	private void print() {
		System.out.println(ans);
	}

	private void work() {
		for (long i = 2; i < max; i++) {
			long w = findInPow(Long.toString(i));
			if (w == i)
				ans += i;
		}
	}

	private long findInPow(String s) {
		long e = 0;
		for (int i = 0; i < s.length(); i++) {
			long z = Long.parseLong("" + s.charAt(i));
			z = (long) Math.pow(z, pows);
			e += z;
		}
		return e;
	}
}
/*
 * Digit fifth powers   
 * Problem 30
 */