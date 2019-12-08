package e029;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class e029 {
	private static BigInteger c;
	private static int max;
	private static int min;
	private static Set<BigInteger> set;

	public e029(BigInteger zero, int i, int j) {
		set = new HashSet<BigInteger>();
		c = zero;
		min = i;
		max = j;
	}

	public static void main(String[] args) {

		e029 d = new e029(BigInteger.ZERO, 2, 100);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(set.size());
	}

	private void work() {
		for (int i = min; i <= max; i++)
			Go(i);
	}

	private void Go(int a) {
		for (int i = min; i <= max; i++)
			Go(a, i);
	}

	private void Go(int a, int b) {
		c = new BigInteger(Integer.toString(a)).pow(b);
		set.add(c);
	}

	/*
	 * Distinct powers Problem 29
	 */

}
