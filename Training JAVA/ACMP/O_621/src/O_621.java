import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_621 {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		long timestart2=0;
		String s = stdin.readLine();
		s = s.trim();
		int n = Integer.parseInt(s);
		long timestart1 = System.currentTimeMillis();
		int[][] a = new int[n][n];
	//	byte [][] c = new byte[n][n];
		short d[][] = new short[400005][2];
		
		int verx[]=new int[n];
		if (n != 1) {
			int uu = 0;
			for (int i = 0; i < n; i++) {
				s = stdin.readLine();
				s = s.trim();
				String f[] = s.split(" ");
				for (int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(f[j]);
					if (a[i][j] != 0) {
//c[i][j]=0;
						d[uu][0] = (short) i;
						d[uu][1] = (short) j;
						uu++;
						// verx[i]=1;
					}
				}
			}
			// for (int i = 0; i < n; i++)
			// System.out.println(Arrays.toString(a[i]));
			 timestart2 = System.currentTimeMillis();
			System.out.println(timestart2 - timestart1);
			int[][] b = new int[n][n];
			if (uu != 0) {
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++) {
						if (a[i][j] != 0) {
							b[i][j] = a[i][j];
							continue;
						}
					//	b[i][j] = FindB(c, i, j, n, d, uu,verx);
						b[i][j] = FindB(a, i, j, n, d, uu,verx);

					}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(b[i][j] + " ");

					}
					System.out.println();
				}
			} else {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						System.out.print(0 + " ");
					System.out.println();
				}
			}

		} else
			System.out.println(Integer.parseInt(stdin.readLine()));

		 timestart2 = System.currentTimeMillis();
		System.out.println(timestart2 - timestart1);
	}

	private static int FindB(int[][] a, int yO, int xO, int n, short[][] d, int uu, int[] verx) {
		int yMax = n - 1;
		
		int step =1000;
		int ans = 0;
		int count = 0;

		for (int i = 0; i < uu; i++) {
		short y=d[i][0];
		short x=d[i][1];	
			
			if (d[i][0]> yMax)
				break;
			
			int stepCurensy = Math.abs(y - yO) + Math.abs(x - xO);
			if (stepCurensy == step){
				count++;
				continue;
			}
			if (stepCurensy < step) {
				step = stepCurensy;
				ans = a[y][x];
				count = 0;
				yMax=yO+step;

			}
		//	if (count > 0 & step == 1)
		//		return 0;
		}
		if (count == 0)
			return ans;

		return 0;
	}

	

}