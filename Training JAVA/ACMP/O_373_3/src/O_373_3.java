import java.util.ArrayList;
import java.util.Scanner;

public class O_373_3 {

	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
		int n = u.nextInt();
		int k = u.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = u.nextInt();
		int[][] c = new int[n][n];
		boolean[][] b = new boolean[n][n];
		c[0][0] = a[0][0];

		ArrayList<Integer> l = new ArrayList<Integer>();

		l.add(0);
		l.add(0);
		int g = 1;
		int m[][] = T(a, n);
		int s = 0;
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			int ii = i % 2;
			for (int j = 0; j < n; j++) {
				if (ii == 0) {
					if (j % 2 == 1)
						d[i][j] = 1;
				}
				if (ii == 1) {
					if (j % 2 == 0)
						d[i][j] = 1;
				}
			}

		}
		while (g != 0 & s < k - 1) {
			int q = 1 - s % 2;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int x = i * n + j;
					if (!b[i][j])
						break;
					if (d[i][j] == q)
						c[i][j] += m[i][j];
				}
			}

			for (int o = 0; o < g; o++) {
				int z = l.get(0);
				int v = l.get(1);
				b[z][v] = true;
				int r = c[z][v];
				l.remove(0);
				l.remove(0);
				// price.remove(0);
				int Y[] = { -1, 0, 1, 0 };
				int X[] = { 0, 1, 0, -1 };

				for (int i = 0; i < 4; i++) {

					int y = z + Y[i];
					int x = v + X[i];
					if (y > n - 1 | y < 0 | x > n - 1 | x < 0)
						continue;

					int Z = r + a[y][x];
					if (c[y][x] < Z) {

						if (b[y][x] | (!b[y][x] & c[y][x] == 0)) {
							l.add(y);
							l.add(x);

						}
						c[y][x] = Z;
					}

				}

			}

			g = l.size() / 2;
			s++;
		}

		if (s == k - 1) {
			System.out.println(P(c, n));
		} else {
			int t[][] = new int[n][n];
			int h = (k - 2 - s) / 2 + 1;
			for (int jj = 0; jj < n; jj++)
				for (int j = 0; j < n; j++) {
					t[jj][j] = m[jj][j] * h + c[jj][j];
					if ((k - 2 - s) % 2 == 0)
						t[jj][j] -= a[jj][j];
				}

			System.out.println(P(t, n));
		}
	}

	private static int P(int[][] c, int n) {
		int m = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (m < c[i][j])
					m = c[i][j];

		// System.out.println(max);
		return m;
	}

	private static int[][] T(int[][] a, int n) {
		int A[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = F(i, j, a, n);

		return A;
	}

	private static int F(int Y, int X, int[][] a, int n) {
		int m = -5;

		int z[] = { -1, 0, 1, 0 };
		int h[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int y = Y + z[i];
			int x = X + h[i];

			if (y < 0 | y > n - 1 | x < 0 | x > n - 1)
				continue;
			if (m < a[y][x])
				m = a[y][x];
		}
		return m + a[Y][X];
	}

}
