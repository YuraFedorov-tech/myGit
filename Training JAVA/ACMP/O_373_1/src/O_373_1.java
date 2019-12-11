import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class O_373_1 {
	public static void main(String[] args) throws IOException {
		long timestart1=System.currentTimeMillis() ;
	      BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String f[]=stdin.readLine().trim().split(" ");
		int n = Integer.parseInt(f[0]);
		int k = Integer.parseInt(f[1]);
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++){
	String[]		 ff=stdin.readLine().trim().split("\\ ",-1);
			for (int j = 0; j < n; j++)
				a[i][j] =Integer.parseInt(ff[j]);
		}
		long timestart2=System.currentTimeMillis() ;
		B(a, n, k);
		long timestart3=System.currentTimeMillis() ;
		System.out.println(timestart2-timestart1);
		System.out.println(timestart3-timestart2);
		System.out.println(timestart3-timestart1);
	}

	private static void B(int[][] a, int n, int k) {
		int[][] chet = new int[n][n];
		int[][] nechet = new int[n][n];
		nechet[0][0] = a[0][0];
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(0);
		list.add(0);
		int max = n*2-2;
		 if (n < 20 ) max = 1000000;

		int count = 0;
		int ans[] = { 0, 0 };
		int i = 0;
		int plus[][] = FindPlus(a, n);
		for (; i < k - 1; i++) {
			 if (i>n*2+6) 
				 System.out.println("drhdrh");
			if (count == 1) {
				if ((i) % 2 == 1) {
					ans[0] = FindAns1(plus, i, k, chet, a,n);
				} else
					ans[0] = FindAns1(plus, i, k, nechet, a,n);
				System.out.println(ans[0]);
				return;
			}
			if (count == 2) {
				if (( i) % 2 == 1) {
					ans[1] = FindAns1(plus, i, k, chet, a,n);
				} else
					ans[1] = FindAns1(plus, i, k, nechet, a,n);
				System.out.println(Math.max(ans[0], ans[1]));
				System.out.println((ans[0]+"\t"+ ans[1]));
				return;
			}
		//	int o = list.size() / 2;
			if (i >= max)
				count++;
			if (i % 2 == 0) {
				GO(list, a, n, k, chet, nechet);
			//	nechet = null;
				nechet = new int[n][n];
				prin(chet, n);
			} else {
				GO(list, a, n, k, nechet, chet);
			//	chet = null;
				chet = new int[n][n];
				prin(nechet, n);
			}
		}
		// System.out.println(count);
		int h = 0;
		if ((k - 1) % 2 == 1) {
			h = pr(chet, n);
		} else
			h = pr(nechet, n);
		System.out.println(h);
	}

	private static int FindAns1(int[][] plus, int i, int k, int[][] chet,
			int[][] a, int n) {
		int yy[][]=new int[n][n];
		int rest = (k - 2 - i) / 2 +1;
		for (int jj = 0; jj< n; jj++)
			for (int j = 0; j < n; j++) {
				yy[jj][j] = plus[jj][j] * rest + chet[jj][j];
				if ((k -2 - i) % 2 ==0)
					yy[jj][j] -= a[jj][j];
			}

		return pr(yy, n);
	}

	private static int[][] FindPlus(int[][] a, int n) {
		int ans[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				ans[i][j] = FindONE_element(i, j, a, n);

		return ans;
	}

	private static int FindONE_element(int Y, int X, int[][] a, int n) {
		int max = -5;

		int YY[] = { -1, 0, 1, 0 };
		int XX[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int y = Y + YY[i];
			int x = X + XX[i];

			if (y < 0 | y > n - 1 | x < 0 | x > n - 1)
				continue;
			if (max < a[y][x])
				max = a[y][x];
		}
		return max + a[Y][X];
	}

	private static void prin(int[] ans, int i, int k) {
		int h = ans[1] - ans[0];
		int rest = (k - 1 - i) / 2 + 1;
		int y = h * rest;
		System.out.println(y + ans[0]);
	}

	private static void prin(int[][] chet, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(chet[i][j] + "\t");
			}
			System.out.println();

		}
		System.out.println();
	}

	private static int pr(int[][] chet, int n) {
		int max = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (max < chet[i][j])
					max = chet[i][j];

		// System.out.println(max);
		return max;
	}

	private static void GO(ArrayList<Integer> list, int[][] a, int n, int k,
			int[][] chet, int[][] nechet) {
		int step = list.size() / 2;
		for (int i = 0; i < step; i++) {
			GoOne(list, a, n, k, chet, nechet);

		}

	}

	private static void GoOne(ArrayList<Integer> list, int[][] a, int n, int k,
			int[][] chet, int[][] nechet) {

		int yOld = list.get(0);
		int xOld = list.get(1);
		int priceOld = nechet[yOld][xOld];
		list.remove(0);
		list.remove(0);
		// price.remove(0);
		int Y[] = { -1, 0, 1, 0 };
		int X[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {

			int y = yOld + Y[i];
			int x = xOld + X[i];
			if (y > n - 1 | y < 0 | x > n - 1 | x < 0)
				continue;
			int newPrice = priceOld + a[y][x];
			if (chet[y][x] == 0) {
				list.add(y);
				list.add(x);
			}
			if (newPrice > chet[y][x])
				chet[y][x] = newPrice;

		}

	}
}