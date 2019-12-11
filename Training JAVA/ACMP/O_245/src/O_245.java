import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class O_245 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader us = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(us.readLine().trim());
		ArrayList<Long> list = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(us.readLine().trim());
			if (x != 0)
				list.add((long) x);
		}
		Collections.sort(list);
		B(list);
	}

	 static void B(ArrayList<Long> list) {
int n=list.size();
long max=0;
		for(int i=0;i<n;i++){
			if(i!=0)
				if(list.get(i)==list.get(i-1))
					continue;
			long a=FindA(list,i,n);
			if(a>max)
				max=a;
		}
		System.out.println(max);

	 }

	private static long FindA(ArrayList<Long> list, int j, int n) {
	int rightIndex=Find_rightIndex(j,list,n); //индексы включительно
	int leftIndex=Find_leftIndex(j,list,n); 
	
	long a=Help245.BB(list,j,n,leftIndex,rightIndex);
	
	
	return a;
	}

	private static int Find_leftIndex(int j, ArrayList<Long> list, int n) {
		long x=list.get(j);
		if(j==0 |j==1)
			return 0;	
		for(int i=j-2;i>=0;i--)	
		if(list.get(i)+list.get(i+1)<x)
			return i+1;
		
		return 0;
	}

	private static int Find_rightIndex(int j, ArrayList<Long> list, int n) {
		if(j==n-1 |j==n-2)
			return n-1;
	long x=list.get(j)+list.get(j+1);

	
		
	for(int i=j+2;i<list.size();i++)
		if(list.get(i)>x)
		return i-1;
	return n-1;
	}
}