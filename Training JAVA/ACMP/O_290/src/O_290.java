import java.util.Scanner;

public class O_290 {

	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);

		int q = u.nextInt();
		int w = u.nextInt();
		String s1 = u.nextLine();
		int e[][] = new int[q][w];
		for (int i = 0; i < q; i++) {
			s1 = u.nextLine();
			for (int j = 0; j < w; j++) {
				int p = 0;
				if (("" + s1.charAt(j)).equals("#"))
					p = 1;
				e[i][j] = p;
			}
		}

		int r = u.nextInt();
		int t = u.nextInt();
		int y[][] = new int[r][t];
		s1 = u.nextLine();
		for (int i = 0; i < r; i++) {
			s1 = u.nextLine();
			for (int j = 0; j < t; j++) {
				int p = 0;
				if (("" + s1.charAt(j)).equals("#"))
					p = 1;
				y[i][j] = p;
			}
		}

		int n = r - q;
		int m = t - w;
		int A = 0;
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++) {

				if (Q(e, q, w, y, i, j))
					A++;
			}
		System.out.println(A);
	}

	private static boolean Q(int[][] q, int w, int e,
			int[][] r, int o, int p) {

		for (int i = o; i < o + w; i++) {

			for (int j = p; j < p + e; j++) {

				if (q[i - o][j - p] == 1)
					if (r[i][j] == 0)
						return false;

			}
		}

		return true;
	}

}