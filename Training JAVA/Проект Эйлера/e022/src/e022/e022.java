package e022;

import java.util.Arrays;
import java.util.Scanner;

public class e022 {
	private static long ans;
	private String[] s;

	public e022() {
		ans = 0;
	}

	public static void main(String[] args) {

		e022 d = new e022();
		d.Input();
		d.work();
		d.print();

	}

	private void Input() {
		Scanner M = new Scanner(System.in);
		String ss = M.nextLine();
		s = ss.split(",", -1);
	}

	private void work() {
		DoNormS();
		Count();
	}

	private void Count() {
		for (int i = 0; i < s.length; i++) {
			CountEach(s[i], i);
		}
	}

	private void CountEach(String str, int n) {
		int z = 0;
		for (int i = 0; i < str.length(); i++)
			z += (str.charAt(i) - 'A' + 1);
		z *= (n + 1);
		ans += z;
	}

	private void DoNormS() {
		for (int i = 0; i < s.length; i++)
			s[i] = s[i].substring(1, s[i].length() - 1);
		Arrays.sort(s);	

	}

	private void print() {
		System.out.println(ans);
	}
	/*
	 * Names scores Problem 22
	 */
}