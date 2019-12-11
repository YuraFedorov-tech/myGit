import java.math.BigInteger;
import java.util.Scanner;


public class O_671 {
	 public static void main(String[] args) {
		    Scanner M = new Scanner(System.in);
		    String s = M.next();
		    B(s);
		    
}

	private static void B(String s) {
		if(s.equals("7")){
			System.out.println(2);
			return;
		}
		if(s.equals("4")){
			System.out.println(1);
			return;
		}
		BigInteger sum []=new 	BigInteger [2];
	 sum  = Big(s.length(),sum);
char t=s.charAt(0);
if(t>='7'){
	if(t>'7'){
	System.out.println(sum[0]);
	}else
		M(s);
}else
	if(t>='4'){
		sum  = Big(s.length()-1,sum);
	if(t==4){
		sum[1]=	OnlyFourAfter(s);
		System.out.println(sum[0].add(sum[1]));	
	}else
		System.out.println(sum[0].add(sum[0]));		
		}else
			System.out.println(0);
		
		
		


	
	

	}
	private static BigInteger OnlyFourAfter(String s) {
int four=FindALLfour(s);
if(four==-1)
	return BigInteger.valueOf(0);
if(four==-5)// если все 4-ки
	return BigInteger.valueOf(1);

int n=s.length();
BigInteger sum []=new 	BigInteger [2];
sum [0] = SImpleFakt(n-four-1);

		return sum[0];
	}

	private static BigInteger SImpleFakt(int y) {
	
		BigInteger	sum = BigInteger.valueOf(2);
		for(int i=1;i<y;i++){
		
			sum =sum .multiply(BigInteger.valueOf(2));
	
		
		}
		
		return sum;
	}

	private static int FindALLfour(String s) {
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)<'4')
				return -1;
		
		for(int i=1;i<s.length();i++)
			if(s.charAt(i)>'4')
				return i;
		
		return -5;
	}

	private static void M(String s) {
int y=s.length();
int p=MinP(s);
BigInteger sum []=new 	BigInteger [2];
if(p==-1){
	sum  = Big(y-1,sum);
	sum [1] = SImpleFakt(y-1);
	System.out.println(sum[0].add(sum[1]));
	return;
}

sum  = Big(y,sum);

System.out.println(sum[0]);

	}


	private static int MinP(String s) {
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)<'7')
				return -1;
		return 0;
	}

	private static int FindFour(String s) {
	for(int i=0;i<s.length();i++)
		if(s.charAt(i)<'4')
			return -1;
		return 0;
	}

	private static int FindX(String s, int j) {
		char t=(char) j;
		for(int i=s.length()-1;i>=0;i--)
			if(s.charAt(i)>='j')
			return i;
	
		
		
		return 0;
		
	}

	private static BigInteger R(String s, String cur) {
		if(s.length()==cur.length()){
	if(new BigInteger(cur).compareTo(new BigInteger(s))==1)
	return  BigInteger.valueOf(0);
	return	BigInteger.valueOf(1);
		}
		BigInteger sur=BigInteger.valueOf(0);
		for(int i=4;i<8;i+=3){
			BigInteger su  = R(s,cur+Integer.toString(i));
			sur=sur.add(su);
		}
		return sur;
	}

	private static BigInteger[] Big(int y, BigInteger[] sum) {
//if(y==1)
//	return  BigInteger.ZERO;
		BigInteger sum222 = BigInteger.valueOf(1);
		sum[0] = BigInteger.valueOf(0);
		for(int i=0;i<y;i++){
			sum[1]=sum[0];
		sum222=sum222.multiply(BigInteger.valueOf(2));
		sum[0]=sum[0].add(sum222);
		
		}
		
		return sum;
	}
}