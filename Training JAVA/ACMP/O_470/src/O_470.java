import java.util.Scanner;


public class O_470 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int y = myScanner.nextInt();
		int x = myScanner.nextInt();
		int n  = myScanner.nextInt();
		int[][] price = new int[y][x]; //   цена участков
		int query[][]=new int [4][n];  // запрос
		for (int i = 0; i < y; i++)
			for (int j = 0; j < x; j++)
				price[i][j] = myScanner.nextInt();
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 4; j++)
				query[j][i] = myScanner.nextInt()-1;	
	//	Print.pr(price);
	//	Print.pr(query);
		
		for(int i=0;i<n;i++){
		
			int answear=Work.FindAnswear(price,query[0][i],query[1][i],query[2][i],query[3][i]);
		System.out.println(answear);
		
		}
	}






}
