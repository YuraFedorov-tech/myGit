import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class O_236 {

	public static void main(String[] args) {

		
		Scanner my = new Scanner(System.in);
		String s = my.nextLine();
		s=s.trim();
		int x=my.nextInt();
		s =Helper_236.MinusSqwearSkoba(s);
	//	System.out.println(s);
		ArrayList<String> polynomial  = new ArrayList<>();
		ArrayList<Integer> znak = new ArrayList<>();
		polynomial=Helper_236.Devide_S(s,polynomial,znak);
		BigInteger sum  = BigInteger.valueOf(0);
		
		sum=FindAnswear(polynomial,znak,x);
		System.out.println(sum);
		

	}

	private static BigInteger FindAnswear(ArrayList<String> polynomial,
			ArrayList<Integer> znak, int x) {
		BigInteger answear  = BigInteger.valueOf(0);

ArrayList<Integer> number = new ArrayList<>();
		for(int i=0;i<polynomial.size();i++){
			int q=Find_1_Mnogochlen(polynomial.get(i),x);
			int e=q*znak.get(i);
			answear.add(BigInteger.valueOf(e));
		}


		
		return answear;
	}

	private static int Find_1_Mnogochlen(String s, int x) {
		ArrayList<Integer> number = new ArrayList<>();
		s=Helper_236.FindFirstNumber(number,s);
	if(s=="")
		return number.get(0);
	int answear =Helper_236.FindSecond(number,s,x);
	
	
		return answear;
	}



		
	
}
