
public class Helper {

	public static void pr(int[][][] a, int h, int m, int n) {
		for(int t=0;t<h;t++){
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					System.out.print(a[t][i][j]+ " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("------------------------------------------");
	}

}
