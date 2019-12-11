import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class O_696 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		String s = stdin.readLine();
		s = s.trim();
		String f[] = s.split(" ");
		int n = Integer.parseInt(f[0]);
		int m = Integer.parseInt(f[1]);
		int k[] = new int[4];
		s = stdin.readLine();
		s = s.trim();
		f = s.split(" ");
		for (int i = 0; i < 4; i++)
			k[i] = Integer.parseInt(f[i]);
		int keyPrice[] = new int[4];
		String keyString[] = new String[4];
		// Helper.Find_keyses(keyPrice,keyString,k);
		Helper.Find_keyString(keyString);
		int a[][] = new int[n][m];
		int y = 0;
		int x = 0;
		for (int i = 0; i < n; i++) {
			s = stdin.readLine();
			s = s.trim();

			for (int j = 0; j < m; j++) {
				char ch = s.charAt(j);
				if (ch == 'X')
					a[i][j] = -1;
				if (ch == '.')
					a[i][j] = 4;
				if (ch == 'R' | ch == 'G' | ch == 'B' | ch == 'Y')
					a[i][j] = Helper.Inside(ch);
				if (ch == 'S') {
					a[i][j] = 5;
					y = i;
					x = j;
				}
				if (ch == 'E') {
					a[i][j] = -5;

				}

			}

		}
		Helper.pr(a, n, m);
		B(a, n, m, y, x, k, keyString);
	}

	private static void B(int[][] a, int n, int m, int y, int x, int[] key,
			String[] keyString) {
		int ans[] = new int[24];
		int keyProper[][] = new int[24][4];
		int h[] = new int[4];
		int noi = Helper.rekur(0, keyProper, 0, h);
		for (int k = 0; k < 24; k++) {
			int aNew[][] = Helper.Do_newa(a, n, m);
			ans[k] = Began(aNew, n, m, keyProper[k], keyString, y, x);
		}
		int min = Helper.Find_min(ans, keyProper, key);
	if(min==-1){
		System.out.println("Sleep");
	}else
		System.out.println(min);
	}

	private static int Began(int[][] a, int n, int m, int[] key,
			String[] keyString, int y, int x) {
		int ans[] = { -1 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(y);
		list.add(x);
		int step = 6;
		while (list.size() != 0 & ans[0] == -1) {
			int o = list.size();
			ArrayList<Integer> listNew = new ArrayList<Integer>();
			for (int i = 0; i < o; i += 2) {
				go1(a, n, m, key, keyString, list, listNew, ans, step);
				Helper.pr(a, n, m);
			}
			step++;
		}
		if (ans[0] == -1)
			return 0;
		return 1;
	}

	private static void go1(int[][] a, int n, int m, int[] key,
			String[] keyString, ArrayList<Integer> list,
			ArrayList<Integer> listNew, int[] ans, int step) {
		int yOld = list.get(0);
		int xOld = list.get(1);
		list.remove(0);
		list.remove(0);

		int Y[] = { -1, 0, 1, 0 };
		int X[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {

			int y = yOld + Y[i];
			int x = xOld + X[i];
			if (y > n - 1 | y < 0 | x > m - 1 | x < 0)
				continue;
			if (a[y][x] == -1 | a[y][x] > 4)
				continue;
			if (a[y][x] == -5) {
				ans[0] = 1;
			}
			if (a[y][x] >= 0 & a[y][x] <= 3) {
				if (NoNothing(a[y][x], key))
					continue;
			}

			a[y][x] = step;
			list.add(y);
			list.add(x);

		}
	}

	private static boolean NoNothing(int j, int[] key) {
		if (key[j] == 0)
			return true;
		return false;
	}
}