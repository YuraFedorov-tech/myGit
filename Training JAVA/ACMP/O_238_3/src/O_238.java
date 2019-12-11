import java.util.ArrayList;
import java.util.Scanner;

public class O_238 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int n = p.nextInt();
		int m = p.nextInt();
		int a[][] = new int[n][m];
		int y = p.nextInt() - 1;
		int x = p.nextInt() - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = p.nextInt();
			}

		}
		int v = p.nextInt();
		int c[][] = new int[v][4];
		for (int i = 0; i < v; i++) {
			for (int o = 0; o < 4; o++)
				c[i][o] = p.nextInt() - 1;

		}
		int nExit = p.nextInt();
		int[][] exit = new int[nExit][2];
		a[y][x] = 2;
		for (int i = 0; i < nExit; i++) {
			int h = p.nextInt() - 1;
			int j = p.nextInt() - 1;
			a[h][j] = -1;
		}

		B(n, m, y, x, a, v, c);

	}

	private static void B(int n, int m, int y, int x, int[][] a, int h,
			int[][] u) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(y);
		l.add(x);
		int A[] = { -1 };

		while (l.size() != 0 & A[0] == -1) {

			int o = l.size();
			for (int i = 0; i < o; i += 2) {
				go1(l, n, m, h, u, A, a);

				if (A[0] != -1)
					break;
			}
		}

		if (A[0] == -1) {
			System.out.print("Impossible");
		} else
			System.out.print(A[0] - 1);

	}

	private static void go1(ArrayList<Integer> l, int n, int m, int u,
			int[][] b, int[] A, int[][] a) {
		int q = l.get(0);
		int w = l.get(1);
		l.remove(0);
		l.remove(0);

		int Y[] = { -1, 0, 1, 0 };
		int X[] = { 0, 1, 0, -1 };
		int h = a[q][w];
		for (int i = 0; i < 4; i++) {

			int y = q + Y[i];
			int x = w + X[i];
			if (y > n - 1 | y < 0 | x > m - 1 | x < 0)
				continue;

			if (a[y][x] == -1) {
				A[0] = h + 1;
				a[y][x] = h + 1;
				return;
			}
			if (a[y][x] != 0)
				continue;
			a[y][x] = h + 1;
			l.add(y);
			l.add(x);

		}
		Q(l, q, w, u, b, a, A, h);

	}

	private static void Q(ArrayList<Integer> l, int y, int x, int b,
			int[][] g, int[][] a, int[] A, int h) {
		for (int i = 0; i < b; i++)
			if (y == g[i][0])
				if (x == g[i][1]) {
					int yy = g[i][2];
					int xx = g[i][3];
					if (a[g[i][2]][g[i][3]] == 0) {

						l.add(yy);
						l.add(xx);
						a[yy][xx] = h + 1;
					}
					if (a[g[i][2]][g[i][3]] == -1) {
						A[0] = h + 1;

					}
				}
	}

}