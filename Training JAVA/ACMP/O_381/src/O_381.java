import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_381 {

	
	
	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int[][] a = new int[n + 2][n + 2];
		int[][] aDuble = new int[n + 2][n + 2];
		a = Helper_381.DO_ZaborMinus1(a);
		// aDuble = Helper_381.DO_ZaborMinus1(aDuble);
		String s = my.nextLine();
		ArrayList<Integer> list = new ArrayList<>();
		int end[] = new int[2];
		for (int i = 1; i < n + 1; i++) {
			s = my.nextLine();
			char[] chArray = s.toCharArray();
			for (int j = 1; j < n + 1; j++) {
				if (chArray[j - 1] == 'O')
					a[i][j] = 1;
				if (chArray[j - 1] == '.')
					a[i][j] = 0;
				if (chArray[j - 1] == '.')
					a[i][j] = 0;
				if (chArray[j - 1] == '@') {
					a[i][j] = -5;
					end[0] = i;
					end[1] = j;
					aDuble[i][j] = -5;

				}
				if (chArray[j - 1] == 'X') {
					list.add((n + 2) * i + j);
					aDuble[i][j] = a[i][j] =-2;

				}

			}
		}
	//	pr.pr(a);
		// pr.pr(aDuble);

		int ans[] = { -1 };
		work_381.beganAnswear(a, end, list, ans);
	//	pr.pr(a);
		if (ans[0] != -1) {
			do_aDuble(end, ans[0], a, aDuble);
		//	pr.pr(aDuble);
			prRight_aDuble(aDuble,a);
		} else
			System.out.println("No");

	}

	private static void prRight_aDuble(int[][] aDuble, int[][] a) {

		for (int i= 1; i<aDuble.length-1; i++) {
			for (int j= 1; j<aDuble.length-1; j++) {
				if(a[i][j]==1){
					System.out.print(1);
				}
				if(a[i][j]==-2){
					System.out.print( "X");
				}
				if(a[i][j]==-5){
					System.out.print( "@");
				}
				if(aDuble[i][j]!=0 &aDuble[i][j]!=-5 &aDuble[i][j]!=-2){
					System.out.print( "+");
				}
			
			}
			System.out.println();
		}
		
		
	}

	private static void do_aDuble(int[] end, int n, int[][] a, int[][] aDuble) {
		int xOld = end[1];
		int yOld = end[0];
		int Step = n;
		while (true) {
			if (n == 1)
				return;
			int[] yy = { -1, 0, 1, 0 };
			int[] xx = { 0, 1, 0, -1 };

			for (int i = 0; i < 4; i++) {
				int x = xOld + xx[i];
				int y = yOld + yy[i];
				if (a[y][x] == n) {
					aDuble[y][x] = n;
					xOld=x;
					yOld=y;
					
					break;
				}

			}
n--;
			
			
		}

	}

}
