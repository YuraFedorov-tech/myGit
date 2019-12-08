package e077;

import java.math.BigInteger;

public class e077 {
	private static int max;
	private static BigInteger dp[][];	
	
	public e077(int m) {
		max = m;	
	}

	public static void main(String[] args) {
		e077 d = new e077(10000);
		d.work();
		d.print();
	}

	private void print() {
		System.out.println(dp[max][1]);		
	}


	private void work() {	
		dp=new BigInteger[max+1][max/2+2];
		iniz();
		for(int i=2;i<=max;i++) {
			for(int j=i/2;j>0;j--) {
	//			dp[i][j]=dp[i-j][j]+dp[i][j+1]+1;
				dp[i][j]=dp[i-j][j].add(dp[i][j+1]).add(BigInteger.ONE);
				dp[i][j]=dp[i][j].mod(new BigInteger("1000000"));
			}
			BigInteger q=dp[i][1].add(BigInteger.ONE);
			System.out.println(q);	
			if(q.mod(new BigInteger("100000")).compareTo(BigInteger.ZERO)==0) {			
				System.out.println(q);	
				return;
			}
			
			
		}
	}

	private void iniz() {
		for(int i=0;i<=max;i++) 
			for(int j=0;j<max/2+2;j++) 
				dp[i][j]=BigInteger.ZERO;
	}
}


	

/*
 * Counting summations   
 * Problem 76
 */