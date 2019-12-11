import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;


public class O_157 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		String s = stdin.readLine();
	
		B(s);
		
	}

	private static void B(String s) {
		int n=Integer.parseInt(s);
		int []a=new int [n];
		boolean bu[]=new boolean [n];
		Find_A(a,bu,s,n);
		ArrayList<Integer> list = new ArrayList<Integer>();
		FindList(list,a,n);
		BigInteger chisl  = BigInteger.valueOf(1);
		chisl=FindCHISLITEL(n,list,chisl);
		BigInteger znamen  = BigInteger.valueOf(1);
	//	if(list.size()!=0)
			znamen=	FindZnamen(list);
		chisl=chisl.divide(znamen);
		System.out.println(chisl);
		
	}

	private static BigInteger FindZnamen(ArrayList<Integer> list) {
		BigInteger znamen  = BigInteger.valueOf(1);
		while(list.size()!=0){
			BigInteger k  = BigInteger.valueOf(1);
			k=FindFactorial(list.get(0),1);
			znamen=znamen.multiply(k);
			list.remove(0);
		}
		
		
		return znamen;
	}

	private static BigInteger FindCHISLITEL(int n, ArrayList<Integer> list, BigInteger chisl) {
	
	chisl=FindFactorial(n,1);
	
	
	return chisl;
	
		
	}

	private static BigInteger FindFactorial(int n, int j) {
		BigInteger chisl  = BigInteger.valueOf(n);
	for(int i=n-1;i>j;i--)
		chisl=chisl.multiply(BigInteger.valueOf(i))	;
	
		
		return chisl;
	}

	private static void FindList(ArrayList<Integer> list, int[] a, int n) {
		for(int i=0;i<n;i++)
		if(a[i]>1)
			list.add(a[i]);
		Collections.sort(list);
		if(list.size()==0)
			list.add(1);
	}

	private static void Find_A(int[] a, boolean[] bu, String s, int n) {
for(int i=0;i<n;i++)
	if(!bu[i])
		doA(a,bu,s,n,i);
		
	}

	private static void doA(int[] a, boolean[] bu, String s, int n, int j) {
		a[j]++;
		char x=s.charAt(j);
		for(int i=j+1;i<n;i++)
			if(x==s.charAt(i)){
				a[j]++;
				bu[i]=true;
			}
				
		
	}
}
