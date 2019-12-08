package e032;

import java.util.ArrayList;
import java.util.Set;

public class TWO {

	public static void Count(Set<Integer> list, int[] ansList) {
		String s = FindS(ansList);
		boolean z = Chek(s, list);
		if (z) {

		}

	}

	private static boolean Chek(String s, Set<Integer> list) {
		boolean z1 = Find1(2, 5, s, list);
		boolean z2 = Find1(1, 5, s, list);
		if (z1 | z2)
			return true;

		return false;
	}

	private static boolean Find1(int i, int j, String s, Set<Integer> list) {
		String s1 = s.substring(0, i);
		String s2 = s.substring(i, j);
		String s3 = s.substring(j, s.length());
		int q1 = Integer.parseInt(s1);
		int q2 = Integer.parseInt(s2);
		int q3 = Integer.parseInt(s3);
		if (q1 * q2 == q3) {
			list.add(Integer.parseInt(s3));
			return true;
		}
		return false;
	}

	private static String FindS(int[] ansList) {
		String s = "";
		for (int i = 0; i < 9; i++) {
			s += Integer.toString(ansList[i]);
		}
		return s;
	}

}
