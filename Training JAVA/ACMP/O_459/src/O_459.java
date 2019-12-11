import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_459 {
	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		String g = m.nextLine().trim();
		int N = 0;
		int E = 0;
		int S = 0;
		int W = 0;
		int n, e, s, w;
		n = e = s = w = 0;
		for (int i = 0; i < g.length(); i++) {

			switch (g.charAt(i)) {
			case 'N':
				n++;
				s--;
				break;
			case 'E':
				e++;
				w--;
				break;
			case 'S':
				s++;
				n--;
				break;
			case 'W':
				w++;
				e--;
			}
			if (N < n)
				N = n;
			if (W < w)
				W = w;
			if (S < s)
				S = s;
			if (E < e)
				E = e;

		}
		int yE = n;
		int xE = e;
		if (n >= 0) {
			yE = N - n;
		} else
			yE = N + s;

		if (w >= 0) {
			xE = W - w;
		} else
			xE = W + e;
		int y = N + S + 1;
		int x = W + E + 1;
		int[][] a = new int[y][x];
		String[][] b = new String[y][x];
		int[][] ñ = new int[y][x];
		a[yE][xE] = -2;
		// Helper.pr(a, y, x);
		int start[] = { 0, 0 };
		FindA(a, ñ, y, x, g, yE, xE, start);
		for (int i = 0; i < y; i++)
			Arrays.fill(b[i], "");
		FindB(a, b, start[0], start[1], g);

		a[yE][xE] = -2;

		// Helper.pr(a, y, x);
		// Helper.pr(b, y, x);
		if (yE == start[0] & xE == start[1]) {
			System.out.println();
		} else
			Began(a, start[0], start[1], y, x, b);
	}

	private static void FindB(int[][] a, String[][] b, int i, int j, String g) {

		g += " ";
		for (int t = 0; t < g.length() - 1; t++) {
			char c = g.charAt(t);
			switch (c) {
			case 'N':
				if (mj(b[i][j], "0"))
					;
				b[i][j] += "0";
				i--;
				if (mj(b[i][j], "2"))
					;
				b[i][j] += "2";

				break;
			case 'S':
				if (mj(b[i][j], "2"))
					;
				b[i][j] += "2";
				i++;
				if (mj(b[i][j], "0"))
					;
				b[i][j] += "0";

				break;
			case 'E':
				if (mj(b[i][j], "1"))
					;
				b[i][j] += "1";
				j++;
				if (mj(b[i][j], "3"))
					;
				b[i][j] += "3";
				break;
			case 'W':
				if (mj(b[i][j], "3"))
					;
				b[i][j] += "3";
				j--;
				if (mj(b[i][j], "1"))
					;
				b[i][j] += "1";
				break;
			}
		}

	}

	private static boolean mj(String string, String letter) {
		for (int i = 0; i < string.length(); i++) {
			String s = "" + string.charAt(i);
			if (s.equals(letter))
				return false;
		}
		return true;
	}

	private static void Began(int[][] a, int y, int x, int yMax, int xMax,
			String[][] b) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(y);
		list.add(x);
		int step = 2;
		a[y][x] = 2;
		int ans[] = { -1, 0, 0, 0 };
		while (list.size() != 0) {
			step++;
			int o = list.size()/2;
			for (int k = 0; k < o; k++) {
				GOList(list, a, step, yMax, xMax, ans, b);
			//	 Helper.pr(a, yMax, xMax);
				if (ans[0] == 1)
					break;
				
			}
		
			if (ans[0] == 1)
				break;
		}
		pr(a, ans, yMax, xMax, b);
	}

	private static void pr(int[][] a, int[] ans, int yMax, int xMax,
			String[][] b) {
		int yOld = ans[1];
		int xOld = ans[2];
		int step = ans[3] - 1;

		int YY[] = { -1, 0, 1, 0 };
		int XX[] = { 0, 1, 0, -1 };
		while (step != 1) {
			for (int i = 0; i < 4; i++) {

				int y = yOld + YY[i];
				int x = xOld + XX[i];
				if (y > yMax - 1 | y < 0 | x > xMax - 1 | x < 0)
					continue;
				/*
				 * if(!may(b[yOld][xOld],i)) continue;
				 */
				if (a[y][x] != step)
					continue;

				prpr(i);
				yOld = y;
				xOld = x;
				break;
			}
			step--;
		}
	}

	private static void prpr(int i) {
		if (i == 0)
			System.out.print("N");
		if (i == 1)
			System.out.print("E");
		if (i == 2)
			System.out.print("S");
		if (i == 3)
			System.out.print("W");

	}

	private static void GOList(ArrayList<Integer> list, int[][] a, int step,
			int yMax, int xMax, int[] ans, String[][] b) {
		int yOld = list.get(0);
		int xOld = list.get(1);
		for (int i = 0; i < 2; i++)
			list.remove(0);
		int YY[] = { -1, 0, 1, 0 };
		int XX[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {

			int y = yOld + YY[i];
			int x = xOld + XX[i];

			if (y > yMax - 1 | y < 0 | x > xMax - 1 | x < 0)
				continue;
			if (!may(b[yOld][xOld], i))
				continue;
			if (a[y][x] == -2) {
				ans[0] = 1;
				ans[1] = y;
				ans[2] = x;
				ans[3] = step;
				a[y][x] = step;
				return;
			}
			if (a[y][x] != 1)
				continue;

			a[y][x] = step;
			list.add(y);
			list.add(x);

		}

	}

	private static boolean may(String string, int h) {
		for (int i = 0; i < string.length(); i++) {
			int s = Integer.parseInt("" + string.charAt(i));
			if (h == s)
				return true;
		}
		return false;
	}

	public static void FindA(int[][] a, int[][] b, int y, int x, String g,
			int yS, int xS, int[] start) {
		int n = g.length() - 1;
		int i = yS;
		int j = xS;
		a[i][j] = 1;
		b[i][j] = n + 1;
		while (n != -1) {
			// System.out.println(g.charAt(n));
			switch (g.charAt(n)) {
			case 'S':
				i--;
				break;
			case 'N':
				i++;
				break;
			case 'W':
				j++;
				break;
			case 'E':
				j--;
				break;

			}
			a[i][j] = 1;
			b[i][j] = n + 1;

			n--;
			// Helper.pr(b, y, x);
		}
		a[i][j] = 2;
		start[0] = i;
		start[1] = j;
	}
}