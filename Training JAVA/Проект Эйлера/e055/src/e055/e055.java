package e055;

import java.math.BigInteger;

public class e055 {
	private static int ans;
	private static BigInteger b;

	public e055(BigInteger zero) {
		b = zero;
		ans = 0;
	}

	public static void main(String[] args) {

		e055 d = new e055(BigInteger.ZERO);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		for (int i = 1; i < 10_000; i++) {
			b = new BigInteger(Integer.toString(i));
			e055_2 w = new e055_2(b);
			w.job();
			boolean e = e055_2.FindAnswear();
			if (!e)
				ans++;
		}
	}
}

/*
 * Lychrel numbers  
 * Problem 55
 *
 * */

