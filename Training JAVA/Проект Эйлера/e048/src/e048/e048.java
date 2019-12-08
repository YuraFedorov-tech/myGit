package e048;

import java.math.BigInteger;

public class e048 {
	static BigInteger ans;
	static int max;

	public e048(BigInteger zero, int i) {
		ans = zero;
		max = i;
	}

	public static void main(String[] args) {

		e048 d = new e048(BigInteger.ZERO, 1000);
		d.work();
		d.print();
	}

	private void print() {
		String s = ans.toString();
		s = s.substring(s.length() - 10, s.length());
		System.out.print(s);

	}

	private void work() {
		for (int i = 1; i <= max; i++) {
			BigInteger b = new BigInteger(Integer.toString(i));
			b = b.pow(i);
			ans = ans.add(b);
		}
	}
}
/*
 * Self powers
 * Problem 48
 */
