import java.math.BigInteger;
import java.util.Scanner;


public class O_256 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
	
		int t[]={1,0};
		int p[]={1,0};
		String q=S(M.next(),t);
		String	w=S(M.next(),p);
		q=P(q,p[1]);
		w=P(w,t[1]);
		BigInteger x=new BigInteger(q);
		BigInteger y=new BigInteger(w);
		int ans=x.compareTo(y);
		if(ans==0){
			System.out.println("=");
		}else
			if(ans==1){
				System.out.println(">");
			}else
				System.out.println("<");
	}

	





	private static String P(String q, int j) {
		for(int i=0;i<j;i++)
			q+="0";
		return q;
	}



	private static String S(String q, int[] t) {

	String f[]=q.split("\\.",-1);
	String s=f[0];
	if(f.length==2){
		int minus=F(f[1]);
	
		t[1]=f[1].length()-minus;
		f[1]=f[1].substring(0,f[1].length()-minus);
		s+=f[1];
		
	}
	
		return s;
	}



	private static int F(String s) {

		int i=s.length()-1;
		for(;i>=0;i--)
			if(s.charAt(i)!='0')
				break;
			
			
		
		return s.length()-1-i;
	}
	
}
