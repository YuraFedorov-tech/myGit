package e066;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class e066 {
	private static BigInteger x;
	private static BigInteger y;
	private static BigInteger ans;
	private static int D;

	public e066(BigInteger zero, int i) {
		ans = x = y = zero;
		D = i;
	}

	public static void main(String[] args) {

		e066 d = new e066(BigInteger.ZERO, 1000);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);

	}

	private void work() {
		for (int i = 61; i <= D; i++) {
			if (sqwear(i) )
				continue;
			Job(i);
		}
	}

	private void Job(int j) {
		BigInteger d = new BigInteger(Integer.toString(j));
		x = y = BigInteger.ZERO;
		while (true) {
		
			BigInteger q1 = x.multiply(x).subtract(d.multiply(y).multiply(y).add(BigInteger.ONE));
			System.out.println(x+" "+j+" "+y+"   q1"+q1);
			int q=q1.compareTo(BigInteger.ONE);
			if (q == 1)
				y = y.add(BigInteger.ONE);
			else if (q == -1)
				x = x.add(BigInteger.ONE);
			else {
				if (x.compareTo(ans) == 1)
					ans = x;
				System.out.println(x+" "+j+" "+y);
				return;
			}
		}

	}

	private boolean sqwear(int i) {
		int w = (int) Math.sqrt(i);
		return w * w == i;
	}

}
/*
 * Cyclical figurate numbers Problem 61
 */