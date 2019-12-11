import java.util.Scanner;

public class O_544 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt()+1;
		long[] a = new long[n];
		if (n != 1) {

			a[n - 1] = 1;
			for (int i = n - 1; i > 0; i--) {
				int p = i - 1;
				a[p] += a[i];

				for (int j = 0; j < 2; j++) {
					p--;
					if (p < 0)
						continue;
					a[p] += a[i];
				}

			}
		}
		System.out.print(a[0]);

	}


}