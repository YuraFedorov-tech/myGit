import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_687 {
	private static void pr(int[][] a, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + "\t");

			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	       BufferedReader us = new BufferedReader(new InputStreamReader(System.in));
	       String s[]=us.readLine().split(" ");
		int n =Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		if (n != 0 & m != 0) {
			int a[][] = new int[n][m];

			for (int i = 0; i < n; i++){
				 s=us.readLine().trim().split(" ");
				for (int j = 0; j < m; j++)
					a[i][j] =Integer.parseInt(s[j]);
			}
	//		pr(a, n, m);
			B(a, n, m);
		}
	}

	private static void B(int[][] a, int n, int m) {
		int roades[][] = new int[n][m + 1];

		for (int j = 0; j < m; j++) {
			// roades[0][j] = j;
			roades[0][m] += a[0][j];
		}
		int min = roades[0][m];
		int rezult[] = new int[m + 1];
		rezult[m] = min;
		for (int i = 0; i < n; i++) {
			roades[i][m] = min;
			FindRoadOne(i, roades, a, n, m, i);
			if (min > roades[i][m]) {
				min = roades[i][m];
				rezult = Arrays.copyOf(roades[i], m + 1);
			}
		}
//		pr(roades, n, m + 1);
		for(int i=0;i<m;i++)
		System.out.print((rezult[i]+1)+" ");
		System.out.println();
		System.out.print(rezult[m]);
	}

	private static void FindRoadOne(int j, int[][] roades, int[][] a, int n,
			int m, int cut) {
		int[] curensyRoad = new int[m + 1];
		curensyRoad[0] = j;
		Rekur(0, n, m, roades, a, curensyRoad, j, a[j][0], cut);

	}

	private static void Rekur(int step, int n, int stepMax, int[][] roades,
			int[][] a, int[] curensyRoad, int jCurensy, int lineCurensy, int cut) {

		if (step == stepMax - 1) {
			FindCurensy(curensyRoad, stepMax, a);
			if (roades[cut][stepMax] > lineCurensy) {
				curensyRoad[stepMax] = lineCurensy;
				roades[cut] = Arrays.copyOf(curensyRoad, stepMax + 1);
			}
			return;
		}

		for (int i = -1; i < 2; i++) {
			int newJ = jCurensy + i;
			if (newJ < 0 | newJ > n - 1)
				continue;

			int newStepLine = a[newJ][step + 1] + lineCurensy;
			if (newStepLine >= roades[cut][stepMax])
				continue;
			curensyRoad[step + 1] = newJ;
			Rekur(step + 1, n, stepMax, roades, a, curensyRoad, newJ,
					newStepLine, cut);

		}

	}

	private static void FindCurensy(int[] curensyRoad, int stepMax, int[][] a) {
		for (int i = 0; i < stepMax; i++)
			curensyRoad[stepMax] += a[curensyRoad[i]][i];
	}

}
