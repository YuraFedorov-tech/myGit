import java.util.ArrayList;
import java.util.Scanner;

public class O_225 {// Main

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int a[][] = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int p = 0; p < 3; p++) {
				a[i][p] = myScanner.nextInt();
			}

		}
		int[] c = new int[n + 1];
	

			c[1] = a[0][0];
			if (n != 1) {

				c[2] = Math.min(a[0][1], c[1] + a[1][0]);
				if (n != 2) {

				
				int	x = Math.min(a[0][2], c[1] + a[1][1]);
					x = Math.min(x, c[2] + a[2][0]);
					c[3] = x;
					for (int i = 3; i <= n; i++) {
					
						x = Math.min(c[i - 3] + a[i - 3][2], c[i - 2] + a[i - 2][1]);
						x = Math.min(x,c[i - 1] + a[i - 1][0]);
						c[i] = x;
					}

				}
			}
			System.out.println(c[n]);

		
	}

	

}