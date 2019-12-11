import java.util.ArrayList;
import java.util.Scanner;

public class O_128 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int[][] a = new int[n + 4][n + 4];
		int yStart = my.nextInt() - 1 + 2;
		int xStart = my.nextInt() - 1 + 2;
		ArrayList<Integer> list = new ArrayList<>();
		int nn = yStart * (n+4) + xStart;
		list.add(nn);
		int yEnd = my.nextInt() - 1 + 2;
		int xEnd = my.nextInt() - 1 + 2;
		a=Helper_128.DO_ZaborMinus1(a);
	//	Helper_128.pr(a);
		a[yStart][xStart]=1;
		a[yEnd][xEnd]=-5;
	//	Helper_128.pr(a);
		

		int ans[] = { -1 };
		work_218.beganAnswear(a,  list, ans);
		System.out.println(ans[0]);
		
		
	}

}
