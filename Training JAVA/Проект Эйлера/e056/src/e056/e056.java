package e056;

import java.math.BigInteger;

public class e056 {
	private static int ans;
	private static int max;

	public e056(int i) {
		ans = 0;
		max = i;
	}

	public static void main(String[] args) {
		e056 d = new e056(100);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		for (int i = 0; i < max; i++)
			GO(new BigInteger(Integer.toString(i)));
	}

	private void GO(BigInteger a) {
		for (int i = 0; i < max; i++)
			Go_2(a, i);
	}

	private void Go_2(BigInteger a, int i) {
		a = a.pow(i);
		int n = FindN(a.toString());
		if (ans < n)
			ans = n;
	}

	private int FindN(String s) {
		int an = 0;
		for (int i = 0; i < s.length(); i++)
			an += (s.charAt(i) - '0');
		return an;
	}
}

/*
 * Powerful digit sum   
 * Problem 56
 *
 */
