import java.util.ArrayList;
import java.util.Scanner;

public class O_365 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int[] currensyPointes = new int[n - 1];
		ArrayList<String> answear = new ArrayList<>();
		rekursia(0, currensyPointes, answear, n);
//		for (String i : answear)
//			System.out.println(i);
		printing(answear);
	}

	private static void printing(ArrayList<String> answear) {

		for (String j : answear) {
			boolean began = false;
			String str[] = j.split("n");
			for (int i = 0; i < str.length; i++) {
				int n = Integer.parseInt(str[i]);
				if (n == 0)
					continue;
				for (int t = 0; t < n; t++) {
					if (!began) {
						began = true;
						System.out.print(i + 1);
						continue;
					}
					System.out.print("+" + (i + 1));

				}

				
			}
			System.out.println();
		}

	}

	private static void rekursia(int summa, int[] currensyPointes,
			ArrayList<String> answear, int n) {
		if (summa > n)
			return;
		if (summa == n) {
			Helper_365.Find_plusToAnswear(currensyPointes, answear);
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			currensyPointes[i]++;
			rekursia(summa + i + 1, currensyPointes, answear, n);
			currensyPointes[i]--;
		}

	}
	public static void Find_plusToAnswear(int[] currensyPointes,
			ArrayList<String> answear) {
		String currensy = "";
		for (int i = 0; i < currensyPointes.length; i++) {
			String str = Integer.toString(currensyPointes[i]);
			if(i!=currensyPointes.length-1)
				str+="n";
			currensy += str;
		}
		for (String i : answear)
			if (i.equals(currensy))
				return;

		answear.add(currensy);
		
		return ;
	}

}
