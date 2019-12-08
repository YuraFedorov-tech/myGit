package e038;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class e038 {
	static BigInteger a;	
	static BigInteger ans;
	private static boolean sChart[];

	public e038(BigInteger zero) {
		ans=	a  = zero;
		sChart=new boolean[10];
	}

	public static void main(String[] args) {

		e038 d = new e038(BigInteger.ZERO);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);		
	}

	private void work() {
	for(int i=9;i<1000000;i++) {
		GO(i);
	}		
	}

	private void GO(int n) {
		String s="";
		sChart=new boolean[10];	
		for(int i=1;i<11;i++) {
			int w=i*n;
			String s2=Integer.toString(w);
			if(s2.length()+s.length()>9)
				return;
			if(!chekS2(s2))
				return;
			s+=s2;
			if(s.length()==9) {
				a=new BigInteger(s);			
				if(ans.compareTo(a)==-1) 
					ans=a;				
			}
		}
		
	}

	private boolean chekS2(String s) {
		sChart[0]=true;
		for(int i=0;i<s.length();i++) {
			int w=s.charAt(i)-'0';
			if(sChart[w])
				return false;
			sChart[w]=true;
		}
		return true;
	}
}
/*
 * Pandigital multiples  
 * Problem 38
 */