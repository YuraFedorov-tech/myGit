import java.util.Arrays;

import java.util.Scanner;

public class O_121 {

	public static void main(String[] args) {

		Scanner u = new Scanner(System.in);
		int n = u.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = u.nextInt();
		Arrays.sort(a);
		int[] b = new int[n + 1];
		b[0] = b[n] = 100000;
		for (int i = 1; i < n; i++)
			b[i] = a[i] - a[i - 1];

	
		n++;
		int j[][] = new int[n + 1][3];
		j[1][0] =b[0];

		for (int i = 2; i < n + 1; i++) {
			int z = j[i - 1][2] + b[i - 1];
			int x = j[i - 1][0];

			j[i][0] = z;
			j[i][1] = x;
			j[i][2] = Math.min(z, x);
		}


		System.out.println(j[n][2]);
	}



}
