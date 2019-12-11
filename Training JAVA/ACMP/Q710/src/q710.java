import java.util.ArrayList;
import java.util.Scanner;

public class q710 {
	static ArrayList<String> symvol = new ArrayList<String>();
	static ArrayList<Boolean> mean = new ArrayList<Boolean>();

	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);
		String s = M.nextLine().trim();
		int n = M.nextInt();
		int k = M.nextInt();
		String s1 = M.nextLine().trim();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {

				s1 = M.nextLine().trim();
				symvol.add("" + s1.charAt(0));

				boolean q = true;
				if (s1.charAt(2) == 'F')
					q = false;
				mean.add(q);
			}
			GO(s);

			symvol = new ArrayList<String>();
			mean = new ArrayList<Boolean>();
		}

	}

	private static void GO(String s) {

		// 1
		int kod = NEXT_AND_OR_NOT(s);
		if (kod == 3) {
			printOne(s, symvol, mean);
			return;
		}
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		int kodDeliteFirstSyl[] = { 4, 3, 4 };
		s = s.substring(kodDeliteFirstSyl[kod], s.length());
		boolean ans = rekurs(s, symvol, mean, kod, list);
		pr(ans);

	}

	private static void pr(boolean ans) {
		String s = "FALSE";
		if (ans)
			s = "TRUE";
		System.out.println(s);

	}

	static int NEXT_AND_OR_NOT(String s) {
		int ans = 3;
		s += "    ";
		String s1 = "" + s.charAt(0) + s.charAt(1);
		if (s1.equals("OR"))
			ans = 1;
		s1 += s.charAt(2);
		if (s1.equals("AND"))
			ans = 0;
		if (s1.equals("NOT"))
			ans = 2;

		return ans;
	}

	public static void printOne(String s, ArrayList<String> symvol,
			ArrayList<Boolean> mean) {
		s = s.trim();
		int i = 0;

		for (; i < s.length(); i++)
			if (NextA_Z(s.charAt(i)))
				break;
		boolean ans = FindNextBooleanOne(s, i, symvol, mean);
		pr(ans);
		return;

	}

	private static boolean FindNextBooleanOne(String s, int i,
			ArrayList<String> symvol, ArrayList<Boolean> mean) {
		String s1 = "" + s.charAt(i);
		int index = symvol.indexOf(s1);
		boolean ans = mean.get(index);
		return ans;
	}

	private static boolean NextA_Z(char c) {
		if (c >= 'A' & c <= 'Z')
			return true;
		;
		return false;
	}

	public static boolean rekurs(String s, ArrayList<String> symvol,
			ArrayList<Boolean> mean, int kod, ArrayList<Boolean> list) {
		int kodDeliteFirstSymbol[] = { 3, 2, 3 };
		while (true) {
			s = DeleteAllApfrt_A_Z(s);

			s = s.trim();
			if (s.isEmpty())
				break;
			if (s.length() == 1 & NextA_Z(s.charAt(0)))
				s += ")";
			if (!NextA_Z(s.charAt(1))) {
				boolean e = FindNextBooleanOne(s, 0, symvol, mean);
				list.add(e);
				s = s.substring(2, s.length());
				continue;
			}
			int kodNew = q710.NEXT_AND_OR_NOT(s);

			if (kod > 2)
				break;
			s = s.substring(kodDeliteFirstSymbol[kodNew], s.length());
			int lastIndex = FindLastIndex(s);
			String s_WithOperator = s.substring(0, lastIndex);
			s = s.substring(lastIndex + 1, s.length());
			ArrayList<Boolean> listNew = new ArrayList<Boolean>();
			boolean ans1 = rekurs(s_WithOperator, symvol, mean, kodNew, listNew);
			list.add(ans1);

		}

		boolean ans = FindAns(list, kod);

		return ans;
	}

	private static boolean FindAns(ArrayList<Boolean> list, int kod) {
		if (kod == 0)
			return (FindAns0(list));
		if (kod == 1)
			return (FindAns1(list));
		if (kod == 2)
			return (!list.get(0));
		if (kod == 3)
			return (list.get(0));

		int q = 8 / 0;
		return false;
	}

	private static boolean FindAns1(ArrayList<Boolean> list) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) == true)
				return true;
		return false;
	}

	private static boolean FindAns0(ArrayList<Boolean> list) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) == false)
				return false;
		return true;
	}

	private static int FindLastIndex(String s) {
		int lastIndex = 0;
		int an = 0;
		for (; lastIndex < s.length(); lastIndex++) {
			if (s.charAt(lastIndex) == '(')
				an++;
			if (s.charAt(lastIndex) == ')')
				an--;
			if (an == 0)
				break;

		}

		return lastIndex;
	}

	private static String DeleteAllApfrt_A_Z(String s) {
		int i = 0;
		for (; i < s.length(); i++)

			if (NextA_Z(s.charAt(i)))
				break;

		s = s.substring(i, s.length());
		return s;
	}

}