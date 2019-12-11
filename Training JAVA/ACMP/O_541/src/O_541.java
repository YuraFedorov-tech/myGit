import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class O_541 {

	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
	
		System.out.println(new BigInteger(S( M.next(), 1)).subtract(new BigInteger(S( M.next(), -1))));
	}

	private static String S(String s, int j) {

		int n = 0;
		int e = s.length();
		char m[]={0};
		if(j==1)
			m[0]=T(s);
		if(j==-1)
			m[0]=G(s);
		
		
		String u = "";
		while (n <= e) {
			int d = 0;
			if (j == 1)// находим большее число
				d = R(s,m);
			if (j == -1)// находим меньшее число
				d = Q(s,m);
			d++;
			
			s = s.substring(e - d, e)+ s.substring(0,e - d) ;
			n += d;
		
			if (s.charAt(0) != '0') {
				// s = new String(c);
				if (C(s,u,j))
					u = s;
			}

		}

		return u;

	}

	private static boolean C(String s, String u, int j) {
		if(u.equals(""))
		return true;
		if(u.equals(s))
			return false;
		int n=s.length();
		boolean A=false;
		for(int i=0;i<n;i++){
			if(s.charAt(i)==u.charAt(i))
				continue;
			if(s.charAt(i)>u.charAt(i)){
				A=true;
				break;
			}
			break;
			
		}
		if(j==-1){
		if(A)
			return false;
		return true;
		}
		
		return A;
		
		
	}

	private static char G(String s) {
		char n='9';
		int t=s.length();
		for(int i=0;i<t;i++){
			if(n=='1')
				break;
			if(n>s.charAt(i) &s.charAt(i)!='0')
				n=s.charAt(i);
		}
			return n;
	
	}

	private static char T(String s) {
	char n='0';
	int t=s.length();
	for(int i=0;i<t;i++){
		if(n=='9')
			break;
		if(n<s.charAt(i))
			n=s.charAt(i);
	}
		return n;
	}

	private static int Q(String s, char[] m) {
		int n=0;
		

		while(true){
			if(n==s.length())
				break;
			if(s.charAt(s.length()-1-n)!=m[0]){
				n++;
				continue;
			}
		
		break;
			
		}
		return n;
	}


/*	private static String FindEEND(int b, String s) {
		String q="";
	
	
	for(int i=0;i<b;i++){
		String d=""+s.charAt(i);
		q=d+q;
	}
		
		return q;
	}*/

	private static int R(String s, char[] m) {
		int n=0;
		int e=s.length()-1;
	boolean find=false;
		while(true){
			if(n==s.length())
				break;
			if(s.charAt(e-n)!=m[0]){
				n++;
				continue;
			}
			while(true){
				if(n==s.length())
					break;
				if(s.charAt(e-n)!=m[0]){
					n++;
					continue;
				}
				
				return n;
			}
		
			
		}
		return n;
	}

}