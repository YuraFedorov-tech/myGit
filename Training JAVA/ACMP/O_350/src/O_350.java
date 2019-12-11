import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class O_350 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String world = myScanner.nextLine();
		world = world.trim();
		System.out.println(world);
		String end = world;
		int ans[] = new int[1];
		int q = world.length();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listFix = new ArrayList<String>();
		ArrayList<String> listWork = new ArrayList<String>();
		String Standart[] = new String[q];
		Standart = standartizazia(Standart, q, world, list);
		listFix.addAll(list);
		listWork.addAll(list);
		int y = rekursiaBig("", list, listWork, listFix, list.size() - 1,
				false, 0, end, ans);// indicator

		System.out.println(ans[0]+1);
		
	}

	private static int rekursiaBig(String stringLeft, ArrayList<String> list,
			ArrayList<String> listWork, ArrayList<String> listFixAlways,
			int indicator, boolean exit, int right, String end, int[] ans) {
		if (exit)
			return right;
		System.out.println("rekursiaBig");
		for (int i = indicator; i > 0; i--) {
			right = rekursiaMove(stringLeft, list, listWork, listFixAlways, i,
					exit, right, listWork.size() - 1, ans);

			listWork = listWorkFromEnd(listWork, end, list);

		}
		return right;

	}

	private static ArrayList<String> listWorkFromEnd(
			ArrayList<String> listWork, String end, ArrayList<String> list) {
		listWork.clear();
		list.clear();
		for (int i = 0; i < end.length(); i++) {
			char ch = end.charAt(i);
			listWork.add("" + ch);
		}
		list.addAll(listWork);
		return listWork;
	}

	private static int rekursiaMove(String stringLeft, ArrayList<String> list,
			ArrayList<String> listWork, ArrayList<String> listFixAlways,
			int indexMove, boolean exit, int right, int rightMax, int[] ans) {
	/*	if (right == 0) {
			list.clear();
			list.addAll(listWork);
		}*/

		right++;
		if (exit | right == rightMax + 1)
			return right;
		// stringLeft = FinfLeft(indexMove, listWork, stringLeft);
		if (indexMove > 0) {
			listWork = listMove(indexMove, listWork);
			print(listWork, stringLeft);
			ans[0]+=1;
		}
		if (right == 1) {
			rekursiaMove(stringLeft, list, listWork, listFixAlways,
					indexMove - 1, exit, right, rightMax, ans);
			return right;
		}
		if (right == 2) {
			pechat2LactNumber(listWork, stringLeft);
			ans[0]+=1;

			rekursiaMove(stringLeft, list, listWork, listFixAlways,
					indexMove - 1, exit, right, rightMax, ans);
			return right;
		}
		if (right > 2) {
			String more = FindMore(indexMove, listWork);
			stringLeft += more;
			listWork = listWorkMinus(indexMove, listWork);
			String en = DoingNewEnd(listWork);
			rekursiaBig(stringLeft, list, listWork, listFixAlways,
					listWork.size() - 1, exit, 0, en, ans);
			return right;

		}

		return right;

	}

	private static String DoingNewEnd(ArrayList<String> list) {
		String t = "";
		for (int i = 0; i < list.size(); i++)
			t += list.get(i);

		return t;
	}

	private static ArrayList<String> listWorkMinus(int indexMove,
			ArrayList<String> listWork) {
		int y = indexMove - 1;
		for (int i = 0; i <= indexMove - 1; i++)
			listWork.remove(0);

		return listWork;
	}

	private static String FindMore(int indexMove, ArrayList<String> listWork) {
		String str = "";
		for (int i = 0; i <= indexMove - 1; i++)
			str += listWork.get(i);

		return str;
	}

	private static void pechat2LactNumber(ArrayList<String> listWork,
			String stringLeft) {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(listWork);
		int n = listWork.size();
		list.set(n - 1, listWork.get(n - 2));
		list.set(n - 2, listWork.get(n - 1));
		print(list, stringLeft);

	}

	private static void print(ArrayList<String> listWork, String string) {
		System.out.print(string);
		for (int i = 0; i < listWork.size(); i++)
			System.out.print(listWork.get(i));

		System.out.println();

	}

	private static ArrayList<String> listMove(int indexMove,
			ArrayList<String> listWork) {
		String str = listWork.get(indexMove);
		listWork.set(indexMove, listWork.get(indexMove - 1));
		listWork.set(indexMove - 1, str);
		return listWork;
	}

	private static String FinfLeft(int indexMove, ArrayList<String> listWork,
			String stringLeft) {
		stringLeft = "";

		return stringLeft;
	}

	private static String[] standartizazia(String[] standart, int q, String s,
			ArrayList<String> list) {
		for (int i = 0; i < q; i++) {
			char myChar = s.charAt(i);
			standart[i] = "" + myChar;
			list.add(standart[i]);
		}
		return standart;
	}

}
