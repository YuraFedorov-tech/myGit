
public class Print {

	public static void pr(int[][] price) {
	
		
		for (int i = 0; i <price.length; i++){
			for (int j = 0; j < price[0].length; j++)
			System.out.print(	price[i][j]+"\t");
			
			System.out.println();
			
		}
		System.out.println("-----------------------------------------------------------------------");
	}

}
