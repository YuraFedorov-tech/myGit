package e059;

import java.util.ArrayList;
import java.util.Scanner;

public class e059 {
	private static int ans;
	private static String s;

	public static void main(String[] args) {

		e059 q = new e059();
		q.Input();
		q.work();
		q.print();

	}

	private void Input() {
		Scanner M = new Scanner(System.in);
		s = M.nextLine().trim();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		String c = "the";
		String[] p = c.split(",");
		e059_2 w = new e059_2(s, p);
		for (int i = 97; i < 123; i++)
			for (int j = 97; j < 123; j++)
				for (int k = 97; k < 123; k++) {
					w.Job(i, j, k);
					if (w.getFind()) {
						ans = w.FindAns();
						return;
					}
				}
	}
}
/*
 * XOR decryption   
 * Problem 59
 */