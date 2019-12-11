import java.util.Arrays;


public class Helper_381 {

	public static int[][] DO_ZaborMinus1(int[][] a) {
		Arrays.fill(a[0], -1);
		Arrays.fill(a[a.length-1], -1);
for(int i=0;i<a.length;i++){
	a[i][0]=a[i][a.length-1]=-1;
}


		
		
		return a;
	}


	
}
