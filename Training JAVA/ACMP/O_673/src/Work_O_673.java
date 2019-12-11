import java.util.ArrayList;
import java.util.Collections;

public class Work_O_673 {

	public static void prin(int[][] matches, int[] amount_of_matches, int n) {
		int k = 0;
		for (int i = 0; i < amount_of_matches[0]; i++) {
			int t = Count(n, matches[i]);
			k += t;
		}

		System.out.println(k);
		
	}

	private static int Count(int n, int[] is) {
		ArrayList<Integer> list = new ArrayList<>();
		int summa=0;
		list = Find_list(is, list);
		int t = Find_znamenatel(list, n);
		int Verx=rekursia(n, list.get(list.size()-1));
		summa=Verx/t;
		
		
		return summa;
	}

	private static int Find_znamenatel(ArrayList<Integer> list, int n) {
		int s = 1;
		for (int i = 0; i < list.size() - 1; i++) {
			int t = rekursia(list.get(i), 0);
			s *= t;
		}
		if (s == 0)
			s = 1;
		return s;
	}

	private static int rekursia(int i, int stop) {
		if (i == stop)
			return 1;
		int t = rekursia(i - 1, stop);

		return t * i;
	}

	private static ArrayList<Integer> Find_list(int[] is,
			ArrayList<Integer> list) {
		for (int i = 0; i < is.length; i++)
			if (is[i] != 0)
				list.add(is[i]);

		Collections.sort(list);
		return list;
	}

}
