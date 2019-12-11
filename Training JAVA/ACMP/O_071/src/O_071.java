import java.math.BigInteger;

import java.util.Scanner;

public class O_071 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
	
	
		BigInteger []a  = new BigInteger [1001] ;
		a[0]=BigInteger.ONE;
		a[1]=BigInteger.valueOf(2);
		for(int i=2;i<=n;i++)
			a[i]=a[i-1].add(a[i-2]);
		System.out.println(a[n]);
		
		
		
	}



}
