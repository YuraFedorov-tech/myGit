import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class O_690 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		String s = stdin.readLine();
		s = s.trim();
		String f[] = s.split(" ");
		int n = Integer.parseInt(f[0]);
		int m = Integer.parseInt(f[1]);
		int[][] a = new int[n][m];
		int y = 0;
		int x = 0;
		int e = 0;
		for (int i = 0; i < n; i++) {
			s = stdin.readLine();
			s = s.trim();

			for (int j = 0; j < m; j++) {
				char ch = s.charAt(j);
				if (ch == 'X')
					a[i][j] = -1;
				if (ch == '.') {
					a[i][j] = 0;
					e++;
				}
				if (ch == 'K') {
					y = i;
					x = j;
					a[i][j] = 1;

				}

			}

		}
		B(a, y, x, n, m, e + 1);
		pr(a, n, m);
	}

	private static void B(int[][] a, int y, int x, int n, int m, int e) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(y);
		list.add(x);
		int ans[] = { -1 };
		int step = 2;
		while (step != e + 1) {
			go(list, a, n, m, step,e);
			Helper.pr(a, n, m);
			step++;
			
		}
	}

	private static void go(ArrayList<Integer> list, int[][] a, int n, int m,
			int step, int e) {
		int yOld = list.get(0);
		int xOld = list.get(1);
		list.remove(0);
		list.remove(0);
		int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int proper[] = new int[8];
		Arrays.fill(proper, 200);
		for (int i = 0; i < 8; i++) {

			int y = yOld + Y[i];
			int x = xOld + X[i];
			if (y > n - 1 | y < 0 | x > m - 1 | x < 0)
				continue;
			if (a[y][x] == -1)
				continue;
			if (a[y][x] != 0)
				continue;
			if(lastCourse(a, n, m, y, x,e,step))
				continue;
			proper[i] = FindHowMuch(a, y, x, n, m);

		}
		ArrayList<Integer> listNew = new ArrayList<Integer>();
		FindI(proper, listNew);
		
		
		int j = Find_J(listNew, a, n, m, yOld, xOld);
//		int i = listNew.get(j);
		int i = listNew.get(0);
		int y = yOld + Y[i];
		int x = xOld + X[i];
		a[y][x] = step;
		list.add(y);
		list.add(x);

	}

	private static boolean lastCourse(int[][] a, int n, int m, int yOld,
			int xOld, int e, int step) {
		if(step==e)
		return false;
		int count=0;
		int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i < 8; i++) {

			int y = yOld + Y[i];
			int x = xOld + X[i];
			if (y > n - 1 | y < 0 | x > m - 1 | x < 0)
				continue;
			if (a[y][x] == -1)
				continue;
			if (a[y][x] != 0)
				continue;
		
		}
		count--;
		if(count==0)
			return true;
		
		return false;
	}

	private static int Find_J(ArrayList<Integer> listNew, int[][] a, int n,
			int m, int yOld, int xOld) {
		int min_curency = 1000;
		int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int jj[] = new int[listNew.size()];
		for (int i = 0; i < listNew.size(); i++) {

			int y = yOld + Y[i];
			int x = xOld + X[i];

			int l_up = y + x;
			int r_up = y + m - x;
			int l_down = x + n - y;
			int r_down = m - x + n - y;
			int f[] = new int[4];
			f[0] = l_up;
			f[1] = r_up;
			f[2] = l_down;
			f[3] = r_down;
			Arrays.sort(f);
			jj[i] = f[0];
		}
		int min = jj[0];
		int ans = 0;
		for (int i = 1; i < listNew.size(); i++)
			if (min > listNew.get(i)) {
				min = listNew.get(i);
				ans = i;
			}

		return ans;
	}

	private static void FindI(int[] proper, ArrayList<Integer> listNew) {
		int min = proper[0];
		for (int i = 1; i < 8; i++)
			if (min > proper[i])
				min = proper[i];
		for (int i = 0; i < 8; i++)
			if (proper[i] == min)
				listNew.add(i);

	}

	private static int FindHowMuch(int[][] a, int yOld, int xOld, int n, int m) {
		int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		int count = 0;
		for (int i = 0; i < 8; i++) {
			int y = yOld + Y[i];
			int x = xOld + X[i];
			if (y > n - 1 | y < 0 | x > m - 1 | x < 0)
				continue;
			if (a[y][x] == -1)
				continue;
			if (a[y][x] != 0)
				continue;
			count++;
		}

		return count;
	}

	public static void pr(int[][] a, int m, int n) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == -1) {
					System.out.print(0 + " ");
				} else
					System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
