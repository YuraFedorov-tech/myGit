import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_355_2 {

	public static void main(String[] args) {
		
		Scanner my = new Scanner(System.in);
		String s = my.nextLine();
		int n = s.length();
		// ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();

		// удаление 1 символа
		// s=s.substring(0, s.length()-1);
		// System.out.println(s);

		char myChar[] = s.toCharArray();
		Arrays.sort(myChar);
		boolean buzy[] = new boolean[n];
		char[] currencySqwear = new char[n];
		char[][] itog = new char[40320][n];
		String curensy = "";
		long timestart1 = System.currentTimeMillis();
		int nn = 0;
		list = FindPovtor(myChar, list);
		int ans[]={0};
		n = rekursia(0, buzy, currencySqwear, myChar, list, itog, nn,ans);
		long timestart2 = System.currentTimeMillis();
	//	System.out.println(timestart2 - timestart1 +"\t"+ans[0]);

	}

	private static ArrayList<Integer> FindPovtor(char[] myChar,
			ArrayList<Integer> list) {
		for (int i = 0; i < myChar.length - 1; i++) {
			for (int j = i + 1; j < myChar.length; j++) {
				if (myChar[i] == myChar[j]) {
					list.add(i);
					list.add(j);
				}
			}

		}
		return list;
	}

	private static int rekursia(int step, boolean[] buzy,
			char[] currencySqwear, char[] myChar, ArrayList<Integer> list,
			char[][] itog, int nn, int[] ans) {
		if (step == myChar.length) {
			boolean chek = true;
			
			if (list.size() != 0)
				chek = ChekChek(currencySqwear, itog, nn);
			if (chek) {
			//	PrintWriter out = new PrintWriter(System.out);
		//		ans[0]++;
				nn++;
				System.out.println(Do(currencySqwear));
		 
			//	out.println(Do(currencySqwear));
			//	out.flush();
			}
			return nn;
		}

		for (int i = 0; i < myChar.length; i++) {
			if (buzy[i])
				continue;

			if (step == 0 & tru(list, i)) {
				 itog=Itog0(itog);
				 nn=0;
			}
			buzy[i] = true;
			currencySqwear[step] = myChar[i];
			nn = rekursia(step + 1, buzy, currencySqwear, myChar, list, itog,
					nn,ans);

			buzy[i] = false;

		}
		return nn;

	}

	private static boolean tru(ArrayList<Integer> list, int n) {
for(int i:list)
	if(i==n)
		return false;
		return true;
	}

	private static String Do(char[] currencySqwear) {
		String s = "";
		for (char i : currencySqwear)
			s += "" + i;

		return s;
	}

	private static char[][] Itog0(char[][] itog) {
		int n = itog[0].length;
		itog = null;
		itog = new char[40320][n];

		return itog;
	}

	private static boolean ChekChek(char[] currencySqwear, char[][] itog, int nn) {

		for (int i = 0; i < nn; i++)
			if (Arrays.equals(currencySqwear, itog[i]))
				return false;

		itog[nn] = Arrays.copyOf(currencySqwear, currencySqwear.length);

		return true;
	}

}
