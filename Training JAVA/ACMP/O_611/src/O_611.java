import java.util.Arrays;
import java.util.Scanner;

public class O_611 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		// String []s=new String[2*n];
		char[][] myChar = new char[2 * n][n];
		String t1 = my.nextLine();

		for (int i = 0; i < 2 * n; i++) {
			String t = my.nextLine();
			myChar[i] = t.toCharArray();
		}
		for (int i = 0; i < 2 * n; i++) {
//			Helper_611.pr(myChar[i]);
		}
		boolean buzy[] = new boolean[2 * n];
		char[][] firstSqwear = new char[n][n];
		char[][] secondSqwear = new char[n][n];
		char[][] currencySqwear = new char[n][n];
		int ans[] = { -1 };
		firstSqwear = rekursia(0, myChar, buzy, firstSqwear, currencySqwear,
				ans);
		for (int i = 0; i < n; i++) {
			Helper_611.pr(firstSqwear[i]);
		}
		currencySqwear=null;
		currencySqwear = new char[n][n];
		ans[0] =- 1;
		firstSqwear = rekursia(0, myChar, buzy, secondSqwear, currencySqwear,
				ans);
		System.out.println();
		for (int i = 0; i < n; i++) {
			Helper_611.pr(secondSqwear[i]);
		}
}

	private static char[][] rekursia(int step, char[][] myChar, boolean[] buzy,
			char[][] firstSqwear, char[][] currencySqwear, int[] ans) {
		if (step == myChar[0].length) {
			firstSqwear = Helper_611.CopiMassiv(firstSqwear, currencySqwear);
			ans[0] = 1;
			return firstSqwear;
		}
		for (int i = 0; i < myChar.length; i++) {
			if (buzy[i])
				continue;
			buzy[i]=true;
			currencySqwear[step] = Arrays.copyOf(myChar[i], myChar[i].length);
			boolean chek = Helper_611.ChekPopytka(currencySqwear, step + 1);
			if(chek)
			firstSqwear = rekursia(step + 1, myChar, buzy, firstSqwear,
					currencySqwear, ans);
			if (ans[0] == 1)
				return firstSqwear;
			buzy[i]=false;
		}

		return firstSqwear;
	}

}
