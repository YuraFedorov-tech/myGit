
public class Printing {

	public static void pr1(int[][] costStep) {
		for(int i=0;i<costStep.length;i++){
			for(int j=0;j<costStep[0].length;j++)
				System.out.print(	costStep[i][j]+"\t");
			System.out.println(	);
		}
		
	}

	public static void pr2(int[][] costStep) {
		for(int i=1;i<costStep.length-1;i++){
			for(int j=1;j<costStep[0].length-1;j++)
				System.out.print(	costStep[i][j]+"\t");
			System.out.println(	);
		}
		
	}

	/*
	  for(int i=1;i<n-1;i++)
			for(int j=1;j<m-1;j++)
				System.out.println(	costStep[i][j]);
	 */

}
