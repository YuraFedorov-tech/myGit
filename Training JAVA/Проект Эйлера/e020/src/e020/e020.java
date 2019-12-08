package e020;

import java.math.BigInteger;

public class e020 {
	static int ans;
	static int max;
	static BigInteger a;

	public e020(BigInteger one, int m) {
		a = one;
		ans = 0;
		max = m;
	}

	public static void main(String[] args) {

		e020 d = new e020(BigInteger.ONE, 101);
		d.work();
		d.print();

	}

	private void work() {
		FindB();
		FindAns(a.toString());
	}

	private void FindAns(String string) {
		for (int i = 0; i < string.length(); i++)
			ans += Integer.parseInt("" + string.charAt(i));

	}

	private void FindB() {
		for (int i = 1; i < max; i++)
			a = a.multiply(new BigInteger(Integer.toString(i)));

	}

	private void print() {
		System.out.print(ans);
	}
	/*
	  Factorial digit sum
	  Problem 20
	 */
}