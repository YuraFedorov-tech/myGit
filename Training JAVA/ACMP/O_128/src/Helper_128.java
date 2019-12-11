import java.util.Arrays;


public class Helper_128 {
	public static int[][] DO_ZaborMinus1(int[][] a) {
		Arrays.fill(a[0], -1);
		Arrays.fill(a[1], -1);
		Arrays.fill(a[a.length-1], -1);
		Arrays.fill(a[a.length-2], -1);
		
for(int i=0;i<a.length;i++){
	a[i][0]=a[i][1]=a[i][a.length-1]=a[i][a.length-2]=-1;
}


		
		
		return a;
	}

	public static void pr(int[][] a) {
		for(int i=0;i<a[0].length;i++){
			for(int j=0;j<a.length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}

		
		
	}

}
