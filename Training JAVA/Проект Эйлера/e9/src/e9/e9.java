package e9;

import java.util.ArrayList;

public class e9 {
	private static int a;
	private static int b;
	private static int c;

	public e9() {
		a = 0;
		b = 0;
		c = 0;
	}

	public static void main(String[] args) {
		e9 q = new e9();
		q.count();
		q.print();
	}

	private void print() {
		System.out.println(a * b * c);

	}

	private void count() {
		for (int i = 1; i < 1000; i++) {
			go(i);
			if (a != 0)
				break;
		}

	}

	private void go(int i) {
		for (int j = i + 1; j < 1000; j++)
			go2(i, j);
	}

	private void go2(int i, int j) {
		for (int d = 1; d < 1000; d++) {
			if (i + j + d == 1000)
				if (i * i + j * j == d * d) {
					a = i;
					b = j;
					c = d;
					return;
				}
		}

	}
}
