
import java.util.ArrayList;

import java.util.Scanner;

public class O_601_2 {

	public static void main(String[] args) {
		Scanner o = new Scanner(System.in);

		int n = o.nextInt();

		int m = o.nextInt();
		int a[][] = new int[n * 2 + 1][101];
		for (int i = 0; i < m; i++) {
			int y = o.nextInt();
			int x = o.nextInt();
			int z = o.nextInt();
			a[x][z] = y;
			a[y][z] = x;

		}

		int k = o.nextInt();
		if (k == 0) {
			System.out.println(1);
			return;
		}
		int p[] = new int[k];

		for (int i = 0; i < k; i++)
			p[i] = o.nextInt();


	int h=1;
		
		int s = 0;
		while (k != s ) {
			
		//while (k != s & l.size() != 0) {	

		h= a[h][p[s++]];
			
			if (h == 0)
				break;
			

	

		}
		if (k != s ) {
			System.out.println("INCORRECT");
		} else
			System.out.println(h);
	}
}
