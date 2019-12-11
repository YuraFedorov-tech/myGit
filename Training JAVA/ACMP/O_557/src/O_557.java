import java.util.Arrays;
import java.util.Scanner;

public class O_557 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int nMaatric = myScanner.nextInt();
		int n = myScanner.nextInt();
		int y = myScanner.nextInt() - 1;
		int x = myScanner.nextInt() - 1;

		int p = myScanner.nextInt();
		int a[][][] = new int[nMaatric][n][n];
		for (int t = 0; t < nMaatric; t++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[t][i][j] = myScanner.nextInt();
				}

			}

		}

		int[][] answear = Began(a, n, nMaatric, p, y, x);
		System.out.println(answear[y][x]);

	}

	private static int[][] Began(int[][][] a, int n, int nMaatric, int p,
			int yy, int xx) {
		// answear=Work.InsideFirstMatrica(answear,a,n,0);
		int x[][] = new int[n][n];
		int y[][] = new int[n][n];

		int peremennaya[][] = new int[n][n];
		x = InsideFirstMatrica(x, a, n, 0, yy, xx);
		for (int i = 1; i < nMaatric; i++) {
			peremennaya = InsideFirstMatrica(peremennaya, a, n, i, yy, xx);
			if (i % 2 == 1) {
				y = Multip(x, peremennaya, n, p, yy, xx);
			//	pr(x, peremennaya, y, n);
			} else {
				x = Multip(y, peremennaya, n, p, yy, xx);
			//	pr(y, peremennaya, x, n);
			}

		}

		if ((nMaatric - 1) % 2 == 1)
			return y;
		return x;
	}

	private static void pr(int[][] x, int[][] y, int[][] z, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(x[i][j] + "\t");
			}
			System.out.print("*" + "\t");
			for (int j = 0; j < n; j++) {
				System.out.print(y[i][j] + "\t");
			}
			System.out.print("=" + "\t");
			for (int j = 0; j < n; j++) {
				System.out.print(z[i][j] + "\t");
			}
			System.out.println();
		}

	}

	private static int[][] Multip(int[][] x, int[][] peremennaya, int n, int p,
			int yy, int xx) {
		int[][] answear = new int[n][n];
		if (yy == xx) {
			for (int m = 0; m < 2; m++) {
				int i = xx;
				

				for (int j = 0; j < n; j++) {
					
					int q = FindOneNumber(x, peremennaya, n, p, i, j);
					answear[i][j] = q;

				}

			}

		}

		for (int i = 0; i < n; i++) {
			if (i != xx & i != yy)
				continue;

			for (int j = 0; j < n; j++) {
				
				int q = FindOneNumber(x, peremennaya, n, p, i, j);
				answear[i][j] = q;

			}

		}

		return answear;
	}

	private static int FindOneNumber(int[][] a, int[][] b, int n, int p, int i,
			int j) {
		int summa = 0;
		for (int k = 0; k < n; k++) {
			int q = a[i][k] * b[k][j];
			summa += q;
		}
		if (summa >= p)
			summa = summa % p;
		return summa;
	}

	public static int[][] InsideFirstMatrica(int[][] answear, int[][][] a,
			int n, int j, int yy, int xx) {
		for (int i = 0; i < n; i++)
			answear[i] = Arrays.copyOf(a[j][i], n);
		return answear;
	}

}
