package e031;

public class e031 {

	private static int ans;
	private static int max;
	private static int[] a = { 1, 2, 5, 10, 20, 50, 100, 200 };

	public e031(int i) {
		ans = 0;
		max = i;
	}

	public static void main(String[] args) {

		e031 q = new e031(200);
		q.work();
		q.print();
	}

	private void print() {
		System.out.println(ans);
	}

	private void work() {
		rek(0, a.length - 1);
	}

	private void rek(int cur, int j) {
		if (cur > max)
			return;
		if (cur == max) {
			ans++;
			return;
		}
		for (int i = j; i >= 0; i--)
			rek(cur + a[i], i);
	}
}
/*
 * Coin sums Problem 31
 */