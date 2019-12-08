package e047;

import java.util.ArrayList;
import java.util.Arrays;

public class e047 {
	private static long a;
	private static int n;
	private static boolean find;
	static int[] aa;
	

	public e047(int i) {
		a = 0;
		n = i;
		find = false;
		aa = new int[n];
	}

	public static void main(String[] args) {
		e047 d = new e047(3);
		d.work();
		d.print();

	}

	private void work() {
		long i = 9;
		while (true) {
			GO(i);
			if (find) {
				a = i;
				return;
			}
			i++;
		}
	}

	private void GO(long i) {

		ChangAA();
		aa[n - 1] = FindC(i + n - 1);
		if (chek(aa))
			find = true;
	}

	private void ChangAA() {
		for (int i = 0; i < n - 1; i++)
			aa[i] = aa[i + 1];
	}

	private boolean chek(int[] aa) {
		for (int i = 0; i < n; i++)
			if (aa[i] != n)
				return false;
		return true;
	}

	private int FindC(long i) {
		long ma = i / 2 + 1;
		int z = 0;
		for (long j = 2; j < ma; j++) {
			if (i % j == 0)
				z++;;
			if (z > n + 1 || i == 1)
				return z;
			while (i % j == 0)
				i /= j;
		}
		return z;
	}

	private void print() {
		System.out.println(a);
	}
	/*
	 * Задача 46
     * Другая проблема Гольдбаха
	 */
}
