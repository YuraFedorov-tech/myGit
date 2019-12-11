import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class O_535 {
	public static void main(String[] args) {
		double q = 20000*20000;
		System.out.println(q);
		System.out.print(q/(20000));
		Scanner M = new Scanner(System.in);
		double n = M.nextDouble();

		q=1/(10000 * 10000 * 200000);
		System.out.println(ChekZeroSinus(n));
		System.out.print(ChekZeroSinus(q));
		
	}

	private static boolean ChekZeroSinus(double sin1) {
		sin1 *= 100000;
		sin1 = Math.floor(sin1);
		String s = Double.toString(sin1);
		String u="";
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!='.'){
				u+=""+s.charAt(i);
			}else
				break;
		}


		BigInteger  w=new BigInteger (u);
		if (w.compareTo(BigInteger.ZERO) == 0)
			return true;

		return false;
	}

}
