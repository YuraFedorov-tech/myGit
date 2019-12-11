import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_011 {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String s = stdin.readLine();
		int n = Integer.parseInt(s);

		int[][] a = new int[n][n];
		int[][] c = new int[n][n];
		if (n != 1) {
			int uu = 0;
			for (int i = 0; i < n; i++) {
				s = stdin.readLine();
				s = s.trim();
				String f[] = s.split(" ");
				for (int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(f[j]);
					if (a[i][j] != 0) {
						c[i][j] = 1;
						uu++;
					}
				}
			}
			// for (int i = 0; i < n; i++)
			// System.out.println(Arrays.toString(a[i]));
			int[][] b = new int[n][n];
			if (uu != 0) {
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++) {
						if (a[i][j] != 0) {
							b[i][j] = a[i][j];
							continue;
						}
						int step = Find(c, i, j, n, n);

						b[i][j] = FindB(a, i, j, n, n, step);

					}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(b[i][j] + " ");

					}
					System.out.println();
				}
			}else{
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) 
						System.out.print(0 + " ");
					System.out.println();
				}
			}

		} else
			System.out.println(Integer.parseInt(stdin.readLine()));
	}

	private static int FindB(int[][] a, int yO, int xO, int n, int m, int step) {
		int b = 4 * step;
		int XX[] = new int[b];
		int[] YY = new int[b];
		FindXXYY(XX, YY, step);
		// System.out.println(Arrays.toString(YY));
		// System.out.println(Arrays.toString(XX));
		int ans = 0;
		int count = 0;
		for (int i = 0; i < b; i++) {
			int y = yO + YY[i];
			int x = xO + XX[i];
			if (y > n - 1 | y < 0 | x > m - 1 | x < 0)
				continue;
			if (a[y][x] == 0)
				continue;
			ans = a[y][x];
			count++;
			if (count > 1)
				return 0;
		}
		if (count == 1)
			return ans;

		return 0;
	}

	private static void FindXXYY(int[] XX, int[] YY, int step) {
		for (int i = 0; i < step; i++) {
			int q = step - i;
			int w = i;
			YY[i * 4] = -q;
			XX[i * 4] = w;

			YY[i * 4 + 1] = w;
			XX[i * 4 + 1] = q;

			YY[i * 4 + 2] = q;
			XX[i * 4 + 2] = -w;

			YY[i * 4 + 3] = -w;
			XX[i * 4 + 3] = -q;
		}

	}

	private static int Find(int[][] a, int y, int x, int n, int m) {
		if (a[y][x] != 0)
			return 0;
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(y);
		l.add(x);
		int step = -2;
		int ans[] = { -1 };
		int[][] b = Copi(a, n, m);
		while (true) {
			int o = l.size() / 2;
			for (int i = 0; i < o; i++) {
				FindL(b, l, ans, step, n, m);
			}

			if (ans[0] == 1)
				return -step - 1;
			step--;
		}

	}

	private static void FindL(int[][] b, ArrayList<Integer> l, int[] ans,
			int step, int n, int m) {
		int yO = l.get(0);
		int xO = l.get(1);
		l.remove(0);
		l.remove(0);

		int YY[] = { -1, 0, 1, 0 };
		int XX[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int y = yO + YY[i];
			int x = xO + XX[i];
			if (y > n - 1 | y < 0 | x > m - 1 | x < 0)
				continue;
			if (b[y][x] > 0)
				ans[0] = 1;
			if (b[y][x] != 0)
				continue;

			l.add(y);
			l.add(x);

			b[y][x] = step;
		}

	}

	private static int[][] Copi(int[][] a, int n, int m) {
		int b[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			b[i] = Arrays.copyOf(a[i], m);

		return b;
	}
}
