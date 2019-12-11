
public class Helper {
	public static void pr(int[][] a, int m, int n) {
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]==-1){
					System.out.print(-1+ "\t");
				}else
				System.out.print(a[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
