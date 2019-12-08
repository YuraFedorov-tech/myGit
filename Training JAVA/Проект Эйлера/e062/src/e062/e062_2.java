package e062;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class e062_2 {
		private static int l;
	private static int [][]cub;
	private static int con;
	
	public e062_2(int l) {
		cub=new int[l][10];
		this.l=l;				
		con=0;
	}

	public void DoCub() {
		for(int i=0;i<l;i++)
			DO(i);		
	}

	private void DO(int i) {
	long x= (long)i*i*i;
	String s=Long.toString(x);
	inside(s,i);		
	}

	private void inside(String s, int j) {
		for(int i=0;i<s.length();i++) {
			int q=s.charAt(i)-'0';
			cub[j][q]++;			
		}		
	}

	public void Job(int j) {
		con=0;
		for(int i=j;i<l;i++) {
			if(Arrays.equals(cub[i], cub[j])) {		
				con++;
			}
		}		
	}

	public int FindListSize() {	
		return con;
	}
}
