import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class O_432 {

	public static void main(String[] args) throws IOException {

		BufferedReader q = new BufferedReader(new InputStreamReader(System.in));
		String[] s = q.readLine().split(" ");

		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[][] a = new int[n][m];
		int c[] = { 0 };
		for (int i = 0; i < n; i++) {
			String h = q.readLine();
			for (int j = 0; j < m; j++) {
				if (h.charAt(j) == '#') {
					a[i][j] = 1;
					c[0]++;
				} else
					a[i][j] = 0;
			}
		}
		int A = 1;
		while (c[0] != 0) {
			c[0]--;
			A++;
			int t[] = R(a, n, m);
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(t[0] * m + t[1]);
		

			while (l.size() != 0) {
				int p = l.get(0);
				l.remove(0);
				int Y = p / m;
				int X = p - Y * m;
				a[Y][X] = A;
				int YY[] = { -1, 0, 1, 0 };
				int XX[] = { 0, 1, 0, -1 };

				for (int i = 0; i < 4; i++) {
					int y = Y + YY[i];
					int x = X + XX[i];

					if (y < 0 | y > n - 1 | x < 0 | x > m - 1)
						continue;
					if (a[y][x] != 1 | a[y][x] == 0)
						continue;
					a[y][x] = A;
					c[0]--;
					l.add(y * m + x);

				}

			}

			
		}
		System.out.println(A - 1);

	}


	

	public static int[] R(int[][] a, int n, int m) {
		int q[] = { 0, 0 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
					q[0] = i;
					q[1] = j;
					return q;
				}
			}

		}
		return q;
	}
}