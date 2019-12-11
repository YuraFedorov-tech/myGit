import java.util.Arrays;
import java.util.Scanner;

public class O_640 {
	private static void pr(int y0, int y, int x0, int x, int[][] a) {
		if (y == y0)
			y++;
		if (x == x0)
			x++;
		for (int i = y0; i < a.length; i++) {
			for (int j = x0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);

		int y1 = M.nextInt();
		int x1 = M.nextInt();
		int[][] a = new int[y1][x1];
		String s = M.nextLine();
		int g = 0;
		for (int i = 0; i < y1; i++) {
			s = M.nextLine();
			for (int j = 0; j < x1; j++) {
				a[i][j] = s.charAt(j) == '.' ? 0 : 1;
				if (a[i][j] == 1)
					g++;
			}
		}
		int y2 = M.nextInt();
		int x2 = M.nextInt();
		int g1 = 0;
		int[][] b = new int[y2][x2];
		s = M.nextLine();
		for (int i = 0; i < y2; i++) {
			s = M.nextLine();
			for (int j = 0; j < x2; j++) {
				b[i][j] = s.charAt(j) == '.' ? 0 : 1;
				if (b[i][j] == 1)
					g1++;
			}
		}
g=g1;
		// pr(0, y1, 0, x1, a);
		// pr(0, y2, 0, x2, b);
	//	if (g == g1) {
			boolean ans = B(y1, x1, a, y2, x2, b);
			if (ans) {
				System.out.println("Yes");
			} else
				System.out.println("No");
//		} else
	//		System.out.print("No");

	}

	private static boolean B(int y1, int x1, int[][] a, int y2, int x2,
			int[][] b) {

		int aa[] = new int[4];
		int bb[] = new int[4];
		aa = FindAA(y1, x1, a, aa);
		bb = FindAA(y2, x2, b, bb);
		if (aa[0] == -5 & bb[0]==-5)
			return true;
		if (aa[0] == -5 | bb[0]==-5)
			return false;

		// pr(aa[0], aa[1], aa[2], aa[3], a);
		// pr(bb[0], bb[1], bb[2], bb[3], b);

		y1 = aa[1] - aa[0];
		x1 = aa[3] - aa[2];

		y2 = bb[1] - bb[0];
		x2 = bb[3] - bb[2];

		int ag[][] = new int[y1][x1];
		int bg[][] = new int[y2][x2];

		ag = FindAG(a, aa, ag);
		bg = FindAG(b, bb, bg);

		// pr(0, y2, 0, x2, bg);
		// pr(0, y1, 0, x1, ag);

		int[][] aCopy = new int[y1][x1];
		Find_aCopy(aCopy, y1, ag, x1);
		boolean[] f = { false };

		f[0] = Chek(y1, x1, ag, y2, x2, bg);
		if (!f[0]) {
			ag = turn(y1, x1, ag, y2, x2, bg, f);
			f[0] = false;
		}

		int q = x1;
		x1 = y1;
		y1 = q;
		// pr(0, y1, 0, x1, ag);
		if (!f[0])
			ag = turn(y1, x1, ag, y2, x2, bg, f);
		q = x1;
		x1 = y1;
		y1 = q;
		// pr(0, y1, 0, x1, ag);
		if (!f[0])
			ag = turn(y1, x1, ag, y2, x2, bg, f);
		q = x1;
		x1 = y1;
		y1 = q;
		// pr(0, y1, 0, x1, ag);
		if (!f[0])
			f[0] = Miror(x1, y1, aCopy, y2, x2, bg, f);

		return f[0];

	}

	private static boolean Miror(int y1, int x1, int[][] ag, int y2, int x2,
			int[][] bg, boolean[] f) {
		if (y1 == y2 & x1 == x2) {
			for (int i = 0; i < y1; i++)
				for (int j = 0; j < x1; j++) {
					int newJ = x1 - 1 - j;
					if (ag[i][newJ] != bg[i][j])
						return false;
				}

			return true;
		}

		return false;
	}

	private static int[][] turn(int y1, int x1, int[][] ag, int y2, int x2,
			int[][] bg, boolean[] f) {
		ag = turnA(y1, x1, ag);
		if (y1 == x2 & x1 == y2) {
			f[0] = Chek(x1, y1, ag, y2, x2, bg);

			return ag;
		}
		f[0] = false;
		return ag;

	}

	private static int[][] turnA(int y1, int x1, int[][] ag) {
		int[][] aCopy = new int[x1][y1];
		/*
		 * Find_aCopy(aCopy, y1, ag, x1); ag=null; ag = new int[x1][y1];
		 */
		// for (int i = 0; i < x1; i++)
		for (int j = 0; j < y1; j++)
			// aCopy[i][j] = ag[j][i];
			Go1(j, y1, x1, ag[j], aCopy);

		return aCopy;

	}

	private static void Go1(int j, int y1, int x1, int[] ag, int[][] aCopy) {
		for (int i = 0; i < x1; i++)
			aCopy[i][y1 - 1 - j] = ag[i];

	}

	private static boolean Chek(int y1, int x1, int[][] ag, int y2, int x2,
			int[][] bg) {
		if (y1 == y2 & x1 == x2) {
			for (int i = 0; i < y1; i++)
				for (int j = 0; j < x1; j++)
					if (ag[i][j] != bg[i][j])
						return false;
			return true;
		}

		return false;
	}

	private static int[][] FindAG(int[][] a, int[] aa, int[][] ag) {
		for (int i = aa[0]; i < aa[1]; i++)
			for (int j = aa[2]; j < aa[3]; j++)
				ag[i - aa[0]][j - aa[2]] = a[i][j];
		return ag;
	}

	private static int[] FindAA(int y1, int x1, int[][] a, int[] aa) {
		aa[0] = FindY0(y1, x1, a);
		aa[1] = FindY1(y1, x1, a) + 1;
		aa[2] = FindX0(y1, x1, a);
		aa[3] = FindX1(y1, x1, a) + 1;

		return aa;
	}

	private static int FindY1(int y1, int x1, int[][] a) {
		for (int i = y1 - 1; i >= 0; i--) {
			for (int j = 0; j < x1; j++) {

				if (a[i][j] == 1)
					return i;

			}

		}
		return -5;
	}

	private static int FindY0(int y1, int x1, int[][] a) {
		for (int i = 0; i < y1; i++) {
			for (int j = 0; j < x1; j++) {

				if (a[i][j] == 1)
					return i;

			}

		}
		return -5;
	}

	private static int FindX1(int y1, int x1, int[][] a) {
		for (int j = x1 - 1; j >= 0; j--) {
			for (int i = 0; i < y1; i++) {
				if (a[i][j] == 1)
					return j;

			}

		}
		return -5;
	}

	private static int FindX0(int y1, int x1, int[][] a) {

		for (int j = 0; j < x1; j++) {
			for (int i = 0; i < y1; i++) {
				if (a[i][j] == 1)
					return j;

			}

		}
		return -5;
	}

	private static void Find_aCopy(int[][] aCopy, int y1, int[][] ag, int x1) {
		for (int i = 0; i < y1; i++)
			aCopy[i] = Arrays.copyOf(ag[i], x1);

	}
}
