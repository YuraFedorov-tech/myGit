package e6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class e6 {
	static BigInteger a;
	static BigInteger b;

	public e6(BigInteger zero) {
		a = b = zero;
	}

	public static void main(String[] args) {

		e6 d = new e6(BigInteger.ZERO);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(b.subtract(a));
		
	}

	private void work() {
		for (int i = 1; i < 101; i++) {
			go(i);
		}
		b = b.multiply(b);
	}

	private void go(int i) {
		a = a.add(new BigInteger(Integer.toString(i * i)));
		b = b.add(new BigInteger(Integer.toString(i)));

	}

}
