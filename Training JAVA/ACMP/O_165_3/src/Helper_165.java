import java.math.BigInteger;


public class Helper_165 {

	public static BigInteger Rekursia(BigInteger sum, int[][] matricaSmegnosti,
			int end, int curensy) {
if(end==curensy)
	return sum.add(BigInteger.ONE);
	
for(int i=1;i<=matricaSmegnosti[curensy][0];i++){

	sum=Rekursia(sum,matricaSmegnosti,end,matricaSmegnosti[curensy][i]);
}

		
		return sum;
	}

}
