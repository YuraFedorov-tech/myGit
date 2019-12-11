import java.math.BigInteger;
import java.util.Scanner;

public class O_156 {

	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		int k = M.nextInt();

		int a = R(0, k, 0, n, n);
		System.out.print(a);

	}

	private static int R(int s, int k, int y, int x, int n) {
		if (s == k) {
			return 1;
		}
		if (y == n | x == 0) {
			return 0;
		}

		int g = 0;
		
	
		for (int i = 1; i <= n - y -k + s+1; i++) {

			int a = R(s + 1, k, y + i, x - 1, n);
			g = g + a * x;

		}

		return g;

	}
}
