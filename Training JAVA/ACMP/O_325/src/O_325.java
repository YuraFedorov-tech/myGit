import java.util.Scanner;

public class O_325 {
	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		String s = my.nextLine();
		String aaaa[] = s.split("\\, ", -1);
		int[][] a = new int[8 + 4][8 + 4];
		a = Helper_325.DO_ZaborMinus1(a);
		int[] ans = { -1 };
		int yStart = Integer.valueOf("" + aaaa[0].charAt(1)) - 1+2;
		int xStart = Helper_325.FindIntFromLetter("" + aaaa[0].charAt(0))+2;

		int yEnd = Integer.valueOf("" + aaaa[1].charAt(1)) - 1+2;
		int xEnd = Helper_325.FindIntFromLetter("" + aaaa[1].charAt(0))+2;
		rekursia(1, yStart, xStart, yEnd, xEnd, ans, a);
		if (ans[0] == -1) {
			System.out.println("NO");
		} else
			System.out.println(ans[0]-1);

	}



	private static void rekursia(int step, int yStart, int xStart, int yEnd,
			int xEnd, int[] ans, int[][] a) {
		if (a[yStart][xStart] != 0)
			return;
		a[yStart][xStart] = step;
	//	pr(a);
		if (step == 3 | step == 2) {
			if (yStart == yEnd & xStart == xEnd) {
				ans[0] = step;
				return;
			}
			if(step==3)
				return;
		}
		int[] yy = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] xx = { 1, 2, 2, 1, -1, -2, -2, -1 };
		for (int i = 0; i < 8; i++) {
			rekursia(step + 1, yStart + yy[i], xStart + xx[i], yEnd, xEnd, ans,
					a);
if(ans[0] != -1)
	return;
		}

	}
	
	public static void pr(int[][] a) {
		for (int i = 2; i < a[0].length-2; i++) {
			for (int j =2 ; j < a.length-2; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}