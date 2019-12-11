import java.math.BigInteger;
import java.util.Arrays;


public class Helper_O_673 {

	public static void DO(int[][] matches, int[] amount_of_matches,
			BigInteger counter) {
boolean first=First_Or_NO(matches,amount_of_matches,counter);


	
		
		
	}

	private static boolean First_Or_NO(int[][] matches,
			int[] amount_of_matches, BigInteger counter) {
		
		int newCounter[]=new int[10];
		newCounter=Find_newCounter_from_counter(newCounter,counter);
		boolean WOzErly=Find_WOzErly(matches,amount_of_matches,newCounter);
		if(!WOzErly){
int x=amount_of_matches[0];

			matches[x]= Arrays.copyOf(newCounter, newCounter.length);
			amount_of_matches[0]++;
		}
		
		
		return WOzErly;
	}

	private static boolean Find_WOzErly(int[][] matches,
			int[] amount_of_matches, int[] newCounter) {
for(int i=0;i<amount_of_matches[0];i++){
if(	Arrays.equals(newCounter, matches[i]))
return true;
}

		return false;
	}

	private static int[] Find_newCounter_from_counter(int[] newCounter,
			BigInteger counter) {
		
		String s=counter.toString();
		for(int i=0;i<s.length();i++){
			int x=Integer.valueOf(""+s.charAt(i));
			newCounter[x]++;

		}
		
		
		return newCounter;
	}

}
