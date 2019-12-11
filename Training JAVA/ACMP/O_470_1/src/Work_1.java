
public class Work_1 {

	public static int FindAnswear(int[][] PartPrice, int yL, int xL, int yR, int xR) {
if(yL==0 & xL==0)
	return PartPrice[yR][xR];
if(yL==0)  //если первая колонка
return PartPrice[yR][xR]-PartPrice[yR][xR-1];

if(xL==0)  //если первый ряд
return PartPrice[yR][xR]-PartPrice[yR-1][xR];		
		
		
		return PartPrice[yR][xR]-PartPrice[yR][xR-1]-PartPrice[yR-1][xR]+PartPrice[yR-1][xR-1];
	}

}
