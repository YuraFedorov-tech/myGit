import java.util.Arrays;
import java.util.Scanner;

public class q351 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		int k = M.nextInt();
		String S = M.nextLine();
		S = M.nextLine();
		char ch[] = S.toCharArray();
		int[] a = new int[100000];
		for (int i = 0; i < n; i++) {
			a[i] = ch[i];
			a[i] -= 65;
		}
		B(a, n, k);
		long usedBytes = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();

	}

	private static void B(int[] a, int n, int k) {
		int g[] = new int[26];
		int[] answear = new int[100001];
		Arrays.fill(g, -999999);
		g[a[0]] = 0;
		for (int i = 1; i < n; i++) {
			Find(g, a, i, k, answear);
		}

		System.out.println(answear[n - 1]);
	}

	private static void Find(int[] g, int[] a, int i, int k, int[] answear) {
		int min = 999999;
		int minIndex = 999999;

		for (int j = 0; j < 26; j++) {
			int lastIndex = g[j];
			if (k < i - lastIndex)
				continue;
			int t = 1;
			if (j == a[i])
				t = 0;
			if (min > answear[g[j]] + t) {
				min = answear[g[j]] + t;
				minIndex = j;
			}

		}
		answear[i] = min;
		g[a[i]] = i;

	}

}