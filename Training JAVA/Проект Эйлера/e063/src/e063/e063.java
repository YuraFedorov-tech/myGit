package e063;

import java.math.BigInteger;
import java.util.Scanner;


public class e063 {
	private static int ans;
	private static String s;

	public static void main(String[] args) {

		e063 q = new e063();		
		q.work();
		q.print();

	}
	private void print() {
		System.out.print(ans);
	}

	private void work() {
		for(int i=1;i<22;i++)
			ans+=GO(i);
	}



	private int GO(int x) {
		boolean find=false;
		int n=0;
		int i=1;
		while(true ) {
			find=false;
			BigInteger a=new BigInteger(Long.toString(i));
			 a=a.pow(x);
			if(a.toString().length()==x) {
				find=true;
				n++;
				System.out.println(i+"^"+x+"="+a);
			}
			i++;
			if(n!=0&!find)
				break;
		}
		return n;		
	}
}
/*
 * Powerful digit counts   
 * Problem 63
 */