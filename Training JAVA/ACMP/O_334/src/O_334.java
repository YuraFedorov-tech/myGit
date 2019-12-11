import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class O_334 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		int n = Integer.parseInt(stdin.readLine());
		long a[] = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = Finda(stdin.readLine());
		B(a, n);

	}

	private static void B(long[] a, int n) {
		Arrays.sort(a);
		long b[] = FindB(a, n);
		long minSumma = FindMinSumma(a[0], b, n);
		FindAns(a, b, minSumma, n);

	}

	private static void FindAns(long[] a, long[] b, long minSumma, int n) {
		long best = minSumma;
		long previos = minSumma;
		int bestI = 0;
		for (int i = 1; i < n; i++) {
			long minus = a[i - 1] + b[i];
			long plus = (a[i] - a[i - 1]) * (n - 1);
			long curensy = previos - minus + plus;
			previos = curensy;
			if (best > previos) {
				best = previos;
				bestI = i;
			}
		}
		pr(a[bestI]);

	}

	private static void pr(long best) {
		long x = best / 3600;
		long y = (best - x * 3600) / 60;
		long z = (best - x * 3600) - y * 60;

		System.out.print((x + 1) + ":");
		if (y > 9) {
			System.out.print(y);
		} else
			System.out.print("0" + y);
		if (z > 9) {
			System.out.print(":"+z);
		} else
			System.out.print(":"+ "0"+ z);
	}

	private static long FindMinSumma(long a, long[] b, int n) {
		long w = 0;
		for (int i = 1; i < n; i++)
			w += b[i];
		long f = a * (n - 1);
		return w + f;
	}

	private static long[] FindB(long[] a, int n) {
		long[] b = new long[n];
		for (int i = 0; i < n; i++)
			b[i] = 43200 - a[i];
		return b;
	}

	private static long Finda(String s) {
		String f[] = s.split(":");
		long g = (Integer.parseInt(f[0]) - 1) * 3600 + Integer.parseInt(f[1])
				* 60 + Integer.parseInt(f[2]);
		return g;
	}
}