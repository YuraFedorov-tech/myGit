import java.util.ArrayList;
import java.util.Scanner;

public class O_368 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int[][] a = new int[n + 2][n + 2];
		int[][] aDuble = new int[n + 2][n + 2];
		boolean[][] buzy = new boolean[n + 2][n + 2];
		int[][] aPutForPrint = new int[n + 2][n + 2];
		int[][] aPutAll = new int[n + 2][n + 2];
		a = Helper_368.DO_ZaborMinus1(a);
	//	a = Helper_368.DO_ZaborMinus1(aDuble);
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> listLineRoad = new ArrayList<>();
		String s=my.nextLine();
		for (int i = 1; i < n + 1; i++) {
 s=my.nextLine();
char[] chArray = s.toCharArray();
			for (int j = 1; j < n + 1; j++) {

				a[i][j] =   Integer.parseInt(""+chArray[j-1]); 
			}
		}
		listLineRoad.add(a[1][1]);
		aDuble[1][1] = 0;
		list.add(n + 2 + 1);
	//	Helper_368.pr(a);
	//	Helper_368.pr(aDuble);
		int ans[] = { -1 };
		
		work_368.beganAnswear(a, list, ans, aDuble,listLineRoad,buzy);
//		Helper_368.pr(aDuble);
		
		
		
		aPutForPrint=Helper_368.Do_Helper_368(aPutForPrint,a,aDuble,buzy);
//		Helper_368.pr(aPutForPrint);
		Helper_368.pr_aPutForPrint(aPutForPrint);
	}

}
