import java.util.ArrayList;
import java.util.Collections;

public class Helper_346 {

	public static int[] DoHowMuch(int[] numberInMassiv_B, int b) {
		ArrayList<Integer> list = new ArrayList<>();
		list = DO_ussulyListFromInt(list, b);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			numberInMassiv_B[n]++;
		}

		return numberInMassiv_B;
	}

	static ArrayList<Integer> DO_ussulyListFromInt(ArrayList<Integer> list,
			int b) {
		String str = Integer.toString(b);
		char[] chArray = str.toCharArray();
		for (int i = 0; i < chArray.length; i++)
			list.add(Integer.parseInt("" + chArray[i]));

		return list;
	}

	public static int DoNumberFromMassiv(int[] massiv_Currrency) {
		int x = 0;
		int j = 0;
		for (; j < massiv_Currrency.length; j++)
			if (massiv_Currrency[j] != 0)
				break;
		// if(massiv_Currrency[j]==0)

		for (int i = j; i < massiv_Currrency.length; i++) {

			x = x * 10 + massiv_Currrency[i];

		}

		return x;
	}

	public static void print(int[] massiv_Currrency,
			int[] numberInMassiv_Raznitza) {

	}

	static boolean Find_or_no(int[] numberInMassiv_Raznitza,
			int[] numberInMassiv_B) {
		if (numberInMassiv_B[0] < numberInMassiv_Raznitza[0])
			return false;

		for (int i = 1; i < numberInMassiv_Raznitza.length; i++) {

			if (numberInMassiv_B[i] != numberInMassiv_Raznitza[i])
				return false;

		}

		return true;
	}

}
