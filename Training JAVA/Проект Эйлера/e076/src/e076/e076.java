package e076;

public class e076 {
	private static int max;
	private static int dp[][];	
	
	public e076(int m) {
		max = m;	
	}

	public static void main(String[] args) {
		e076 d = new e076(100);
		d.work();
		d.print();
	}

	private void print() {
		System.out.println(dp[max][1]);		
	}


	private void work() {	
		dp=new int[max+1][max];
		for(int i=2;i<=max;i++)
			for(int j=i/2;j>0;j--) {
				dp[i][j]=dp[i-j][j]+dp[i][j+1]+1;
			}
	}
}


	

/*
 * Counting summations   
 * Problem 76
 */