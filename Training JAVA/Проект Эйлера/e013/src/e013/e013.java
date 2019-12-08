package e013;

import java.math.BigInteger;
import java.util.Scanner;

public class e013 {
	static String ans;
	static BigInteger sum;

	public e013(BigInteger zero) {
		sum = zero;
		ans = "";
	}

	public static void main(String[] args) {
		e013 q = new e013(BigInteger.ZERO);

		q.inputAndWork();
		q.work();
		q.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		ans = sum.toString();
		ans = ans.substring(0, 10);
	}

	private static void inputAndWork() {
		Scanner M = new Scanner(System.in);
		for (int i = 0; i < 100; i++) {
			sum = sum.add(new BigInteger(M.nextLine()));
		}

	}
}
/*
 * Large sum Problem 13
 */