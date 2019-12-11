import java.util.Arrays;


public class Helper_611 {

	public static void pr(char[] cs) {
		for(int i=0; i< cs.length;i++)
			//System.out.print(""+cs[i]);
			System.out.print(cs[i]);
		System.out.println();
	}

	public static char[][] CopiMassiv(char[][] firstSqwear, char[][] currencySqwear) {
		for(int i=0;i<firstSqwear.length;i++)
			firstSqwear[i]= Arrays.copyOf(currencySqwear[i], currencySqwear[0].length);
			
		return firstSqwear;
		
		
	}

	public static boolean ChekPopytka(char[][] currencySqwear, int n) {
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				if(currencySqwear[i][j]!=currencySqwear[j][i])
					return false;
			}
		return true;
	}

}
