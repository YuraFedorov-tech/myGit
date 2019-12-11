public class Helper {
	public static void pr(int[][] a, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
