
public class Print1 {

	public static void pr(int[][] price) {


		
		
		
		for (int i = 0; i <price.length; i++){
			for (int j = 0; j < price[0].length; j++)
			System.out.print(	price[i][j]+"\t");
			
			System.out.println();
			
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	static int[][] precomputeMatrix(int[][] matrix) {
		  int[][] sumMatrix = new int[matrix.length][matrix[0].length]; 
		  for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[0].length; j++) {
		      if (i == 0 && j == 0) { // перва€ €чейка
		        sumMatrix[i][j] = matrix[i][j];
		      } else if (j == 0) { // €чейка в первой колонке
		        sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i][j];
		      } else if (i == 0) { // €чейка в первом р€ду
		        sumMatrix[i][j] = sumMatrix[i][j-1] + matrix[i][j]; 
		      } else {
		        sumMatrix[i][j] = sumMatrix[i-1][j] +
		        sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + 
		        matrix[i][j];
		      }
		    }
		  }
		  return sumMatrix;
		}
}
