import java.math.BigInteger;
import java.util.Scanner;


public class O_510 {
	 public static void main(String[] args) {
	Scanner u = new Scanner(System.in);
	int n = u.nextInt();
	BigInteger ans  = BigInteger.valueOf(0);
	if(n%2==0){
		ans=Helper.Chet(n);
		
	}
	System.out.println(ans);
}
}