import java.util.Arrays;

public class Helper {

	public static int[][] Find_newA(int[][] a, int i2) {
		int n = a.length;
		int s[][] = new int[n][n];
		for (int i = i2 + 1; i < n; i++)
			s[i] = Arrays.copyOf(a[i], n);

		return s;
	}


	static void insideHorse(int[][] newA, int i, int j, int n) {
		int[] yy = { 1, 2, 2, 1, };
		int[] xx = { 2, 1, -1, -2, };
		for (int t = 0; t < 4; t++) {
			int y = i + yy[t];
			int x = j + xx[t];
			if (y > n - 1 | x < 0 | x > n - 1)
				continue;
			newA[y][x]++;
		}

	}






	public static int[][] MinusHorse(int[][] a, int i, int j, int n) {

		int[] yy = { 1, 2, 2, 1, };
		int[] xx = { 2, 1, -1, -2, };
		for (int t = 0; t < 4; t++) {
			int y = i + yy[t];
			int x = j + xx[t];
			if (y > n - 1 | x < 0 | x > n - 1)
				continue;
			a[y][x]--;

		}
		return a;
	}

	public static boolean Find_newElefant(int[][] pointMagarage, int i, int j,
			int count) {
		for (int i1 = 0; i1 < count; i1++) {
			int y = pointMagarage[i1][0];
			int x = pointMagarage[i1][1];
			int raz = i - y;
			if (x - raz == j | x + raz == j)
				return false;
		}

		return true;
	}
}
