package e076_3;

import java.util.ArrayList;

public class e076_3 {
	private long ans;
	private boolean zMax;
	private static int max;
	private static long dp[][];	

	public e076_3(int m) {
		max = m+1;
	//	dp = new int[m+1][m+1];
	}

	public static void main(String[] args) {
		e076_3 d = new e076_3(20);
		d.work();
	
	}

	private static void print(long[][] dp2, int limit) {
		for(int i=0;i<=limit;i++) {
			System.out.print(i+" " +"\t");
			for(int j=0;j<limit/2 + 2;j++) {
				System.out.print(dp2[i][j]+"\t");
			}
			 System.out.println();
		}
		 System.out.println();
	}

	private void work() {	
		
		    int limit =9;
		    long[][] dp = new long[limit + 1][limit/2 + 2]; // each row has to supply index up to limit/2 + 1. All values initialized to 0

		    // dp[i][j] records total number of ways i can be expressed by numbers larger or equal to j (presence of j is not mandatory) E.g. dp[8][2] = 1 + dp[6][2] + dp[8][3] + dp[8][4]
		    for (int i = 2; i <= limit; i++){
		        for (int j = i/2; j >= 1; j--) {
		            dp[i][j] = 1 + dp[i-j][j] + dp[i][j+1];
		            print(dp,limit) ;
		        }
		        System.out.println("/////////////////////////////////");
		    }
		 //   return dp[limit][1];
		    System.out.println(dp[limit][1]);
		print(dp,limit) ;
	}
}


	

/*
 * Digit factorial chains Problem 74
 */