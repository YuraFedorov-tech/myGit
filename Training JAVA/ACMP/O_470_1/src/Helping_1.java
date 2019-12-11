
public class Helping_1 {

	public static int[][] DoPartSumma(int[][] partPrice, int[][] price) {
		for (int i = 0; i <price.length; i++)
			for (int j = 0; j < price[0].length; j++){
				partPrice[i][j]=doPart(partPrice,price,i,j);
				
			}

		
		
		return partPrice;
	}

	private static int doPart(int[][] partPrice, int[][] price, int i, int j) {
if(i==0 & j==0)
	return price[i][j];
if(i==0)                          //если первый столбец
	return  price[i][j]+partPrice[i][j-1];
if(j==0)                          //если первая строка
	return  price[i][j]+partPrice[i-1][j];
		
		
		return price[i][j] +partPrice[i][j-1]+partPrice[i-1][j]-partPrice[i-1][j-1] ;
	}

}
