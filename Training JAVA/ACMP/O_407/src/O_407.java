import java.math.BigInteger;
import java.util.Scanner;

public class O_407 {
	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);
		int n=Integer.parseInt(M.nextLine());
		
		for (int i = 0; i < n; i++)

			if (new BigInteger(M.nextLine(), 2).mod((BigInteger.valueOf(7)))
					.compareTo(BigInteger.ZERO) == 0) {
				System.out.println("Yes");
			} else
				System.out.println("No");

	}

}