
import java.util.Arrays;
import java.util.Scanner;

public class O_475 {
	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);

		int n = u.nextInt();
		int list[] = new int[n];

		for (int i = 0; i < n; i++)
			list[i] = u.nextInt();

		int listClon[] = Arrays.copyOf(list, n);

		Arrays.sort(list);
		long lo[] = new long[n - 1];
		for (int i = 0; i < n - 1; i++)
			lo[i] = ((long) (Math.abs(list[i + 1] - list[i])));

		long z = lo[0];
		for (int i = 1; i < n - 1; i++) {
			long g = lo[i];
			if (z > g)
				z = g;
		}

		System.out.println(z);

		int p= 0;
		for (; p < n - 1; p++)
			if (z - lo[p] == 0)
				break;

		int i = 0;
		for (; i < n; i++)
			if (list[p] == listClon[i])
				break;

		System.out.print(i + 1 + " ");

		i = 0;
		for (; i < n; i++)
			if (list[p + 1] == listClon[i])
				break;
		System.out.println(i + 1);

	}



}
