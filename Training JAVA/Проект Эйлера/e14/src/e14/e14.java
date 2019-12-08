package e14;

import java.math.BigInteger;

public class e14 {
	static BigInteger a;
	static int ans;
	static int ansMean;

	public e14(BigInteger one, int i) {
		a = one;
		ans =ansMean= 0;
	}

	public static void main(String[] args) {

		e14 d = new e14(BigInteger.ONE, 0);
		d.work();
		d.print();
	}

	private void work() {
		for (int i = 1; i < 1_000_000; i+=2) {
			int ansCur = Kolatc(0, new BigInteger(Integer.toString(i)));
			if (ans < ansCur) {			
				ans = ansCur;
				ansMean=i;
			}
		}

	}

	private int Kolatc(int step, BigInteger e) {
		if (e.compareTo(BigInteger.ONE) == 0)
			return step;
		if (e.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0)
			return Kolatc(step + 1, e.divide(new BigInteger("2")));
		else
			return Kolatc(step + 1, e.multiply(new BigInteger("3")).add(BigInteger.ONE));

	}

	private void print() {
		System.out.print(ansMean);

	}
}
/*
https://projecteuler.net/problem=14
Longest Collatz sequence   
ans 837799

*/