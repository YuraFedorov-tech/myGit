import java.math.BigInteger;
import java.util.Scanner;


public class O_671_2 {
    public static void main(String[] args) {
    Scanner M = new Scanner(System.in);
    String s = M.next();
 
/*    if(s.length()==1){
		if(s.charAt(0)>='4'){
			if(s.charAt(0)>='7'){
				System.out.println(2);
			}else
				System.out.println(1);
		}else
			System.out.println(0);
		return;
		}*/
		int n=s.length();
char q=s.charAt(0);
BigInteger s1= BigInteger.valueOf(0);
long s2= 0;
s1=M(n-1,s);
boolean four=false;
s2=R(0,n,s,0l,four);

System.out.println(s1.add(new BigInteger(Long.toString(s2))));	
}

	

	private static long R(int e, int m, String s, long A, boolean f) {
if(m==e){
	
return A;
}
int q=s.charAt(e);
long x=0;
while(true){
if(q<'4'){
	return A;
	
}
if(q>'7'){
	x=MM(m-e); 
	return A+x;	
}
if(q=='7'){
	f=false;
	int minus=1;
	if(e==m-1)
		minus=0;
	x=MM(m-e-minus); 
 break;
}
if(q>'4'){
	
	x=MM(m-e-1); 

	return A+x;

}
if(q=='4' &e==m-1){
	return A+1;
}
f=true;
break;
}
A=R(e+1,m,s,A+x,f);

		
		return A;
	}



	private static long MM(int n) {
		// TODO Auto-generated method stub
		return (long) Math.pow(2, n);
	}

	private static BigInteger M(int n, String s) {
		BigInteger a= G(s,n);
		BigInteger p= BigInteger.valueOf(2);
		for(int i=1;i<n;i++){
			p=p.multiply(BigInteger.valueOf(2));
			a=a.add(p);
		}
		
		return a;
	}

	private static BigInteger G(String s, int n) {
	if(n==0){
		if(s.charAt(0)>=7)
			return BigInteger.valueOf(2);
		if(s.charAt(0)>=4)
			return BigInteger.valueOf(1);
		return BigInteger.valueOf(0);
	}
		return BigInteger.valueOf(2);
	}

	
}