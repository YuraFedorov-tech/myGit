import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class O_099 {
	public static void main(String[] args) throws IOException {
		BufferedReader o = new BufferedReader(new InputStreamReader(System.in));
		String s = o.readLine();
		s = s.trim();
		String g[] = s.split(" ");
		int h = Integer.parseInt(g[0]);
		int m = Integer.parseInt(g[1]);
		int n = Integer.parseInt(g[2]);
		int yS = 0;
		int xS = 0;
		int[][][] a = new int[h][m][n];
		for (int H = 0; H < h; H++) {
			//
			for (int M = 0; M < m; M++) {
				s = o.readLine();
				s = s.trim();
				for (int N = 0; N < n; N++) {
					char ch = s.charAt(N);
					if (ch == 'o')
						a[H][M][N] = 1;
					if (ch == '.')
						a[H][M][N] = 0;
					if (ch == '1') {
						yS = M;
						xS = N;
						a[H][M][N] = 2;
					}
					if (ch == '2') {

						a[H][M][N] = -2;
					}
				}

			}
			if (H != h - 1)
				s = o.readLine();
		}

		// Helper.pr(a,h,m,n);
		Began(a, h, m, n, yS, xS);

	}

	private static void Began(int[][][] a, int h, int m, int n, int y, int x) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(y);
		l.add(x);
		int s = 2;
		int[] ans = { -1, 0 };
		while (l.size() != 0) {
			// Helper.pr(a,h,m,n);
			s++;
			int o = l.size() / 3;
			for (int t = 0; t < o; t++) {

				Find(a, l, ans, h, m, n, s);

				if (ans[0] == 1)
					break;
			}
			if (ans[0] == 1)
				break;

		}
		if (ans[0] == -1) {
			System.out.println(-1);
		} else
			System.out.println(ans[1] * 5);
	}

	private static void Find(int[][][] a, ArrayList<Integer> l, int[] A,
			int h, int m, int n, int step) {
		int Z = l.get(0);
		int Y = l.get(1);
		int X = l.get(2);
		for (int i = 0; i < 3; i++)
			l.remove(0);
		int ZZ[] = { 0, 0, 0, 0, 1 };
		int YY[] = { -1, 0, 1, 0, 0 };
		int XX[] = { 0, 1, 0, -1, 0 };

		for (int i = 0; i < 5; i++) {
			int z = Z + ZZ[i];
			int y = Y + YY[i];
			int x = X + XX[i];

			if (z > h - 1 | z < 0 | y > m - 1 | y < 0 | x > n - 1 | x < 0)
				continue;

			if (a[z][y][x] == -2) {
				A[0] = 1;
				A[1] = step - 2;
				return;
			}
			if (a[z][y][x] == 0) {

				a[z][y][x] = step;
				l.add(z);
				l.add(y);
				l.add(x);
			}
		}
	}
}
