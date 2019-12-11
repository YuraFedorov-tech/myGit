

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_165 {

	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);

		int n = M.nextInt();
		int m = M.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++)

			for (int j = 0; j < m; j++)
				a[i][j] = M.nextInt();

		a[n - 1][m - 1] = 1;

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		int[][] b = new int[n][m];
		b[0][0] = 1;
		while (l.size() != 0) {
			int h = l.get(0);
			l.remove(0);
			int f = h / m;
			int g = h - f * m;
		
			int z = a[f][g];
			int[] Y = { 0, z };
			int[] X = { z, 0 };
			for (int i = 0; i < 2; i++) {
				int y = f + Y[i];
				int x = g + X[i];

				if (y > n - 1 | x > m - 1)
					continue;
				if (b[y][x] == 0)
					l.add(y * m + x);
				b[y][x] +=  b[f][g];

			}
			Collections.sort(l);
		}

		System.out.println(b[n - 1][m - 1]);
	}

	}
