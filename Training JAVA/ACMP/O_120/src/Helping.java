import java.util.ArrayList;


public class Helping {

	public static int[][] DoNew(int[][] costStep) {
		for(int i=0;i<costStep.length;i++){
			costStep[i][0]=costStep[i][costStep[0].length-1]=-1;		
			
		}

		for(int i=0;i<costStep[0].length;i++){
			costStep[0][i]=costStep[ costStep.length-1 ][i]=-1;		
			
		}
		
		return costStep;
	}

	public static int[][] DoNewMinus1(int[][] price) {
		for(int i=0;i<price.length;i++){
			for(int j=0;j<price[0].length;j++)
					price[i][j]=-1;

		
		}
		return price;
	}

	public static int[] FindXY_fromI(Integer i, int y, int x, int[] yx) {
 yx[0]=i/x;
 yx[1]=i-yx[0]*x;		
		
		return yx;
	}

	public static boolean YX(int[] yx, int[][] costStep) {
if(costStep[yx[0]][yx[1]]==-1)
	return false;
		
		return true;
	}

	public static int[][] ChangePrice(int[][] price, int y, int x,
			int[][] costStep, int yy, int xx) {
int newPrice=price[y][x]+costStep[yy][xx];
int q= price[yy][xx];
int q1= newPrice;
if(costStep[yy][xx]==-1)
	return price;
if(price[yy][xx]==-1 | price[yy][xx]>newPrice)
	price[yy][xx]=newPrice;
//Printing.pr1(price);
		
		
		return price;
	}

	public static int FindI_fromXY( int x, int yy, int xx) {
   int newNumberListing=yy*x+xx;
		
		
		return newNumberListing;
	}

	public static boolean chek_newNumberListing(int newNumberListing,
			ArrayList<Integer> list) {
		for(int i : list) 
			if(i==newNumberListing)
				return false;
		
		return true;
	}

}
