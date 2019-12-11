
public class Helping {

	public static int[][] DoPartSumm(int[][] partSumm, int[][] price) {
		for (int i = 0; i <price.length; i++)
			for (int j = 0; j < price[0].length; j++){
				if(j!=0)
					partSumm[i][j]=partSumm[i][j-1];
				partSumm[i][j]+=price[i][j];
				
				
				
			}
		
		
		return partSumm;
	}

	public static int Find1Stroka(int xL, int xR, int[]partSumm) {
int ans=0;
if(xR==0)
	return partSumm[0];
if(xL==0)
	return partSumm[xR];
		
		
		return partSumm[xR]-partSumm[xL-1];
	}

}
