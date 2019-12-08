package e051;

import java.util.ArrayList;

public class e051_2 {
	private static int mi;
	private static int ma;
	private static int coincidence;
	private static int minimum;
	private static boolean erot[];
	private static int max;
	ArrayList<Integer> list;

	public e051_2(Integer integer, Integer integer2, boolean[] erot2, int max2, ArrayList<Integer> list2) {
		mi = integer;
		ma = integer2;
		minimum = coincidence = 0;
		erot = erot2;
		max = max2;
		list = list2;
	}

	public void FindCoincidence() {
		for (int i = mi; i < ma; i++) {
			GO(i);
			if (minimum != 0)
				return;
		}
	}

	private void GO(int i) {
		int cur = list.get(i);
		i++;

		for (; i < ma; i++) {
			int z = list.get(i) - cur;
			if (Chek0_1(Integer.toString(z)))
				if (Chek0_2(Integer.toString(z), Integer.toString(cur))) {
					int m = FindM(cur, z);
					if (m == e051.ans) {
						coincidence = m;
						minimum = cur;
						return;
					}
				}
		}

	}

	private boolean Chek0_2(String sZ, String cur) {
		int l = sZ.length();
		char ch = cur.charAt(cur.length() - sZ.length());
		sZ = FindSZ(sZ, cur.length());
		for (int i = 0; i < sZ.length(); i++)
			if (sZ.charAt(i) == '1')
				if (cur.charAt(i) != ch)
					return false;
		return true;
	}

	private int FindM(int cur, int z) {
		int an = 0;
		int mm = list.get(ma);
		for (int i = 0; i < 10; i++) {
			int r = cur + z * i;
			if (NO_Change(cur, z, r))
				if (!erot[r])
					an++;
		}
		return an;
	}

	private boolean NO_Change(int cur, int z, int r) {
		String sC = Integer.toString(cur);
		String sZ = Integer.toString(z);
		String sR = Integer.toString(r);
		if (sC.length() != sR.length())
			return false;
		sZ = FindSZ(sZ, sC.length());
		for (int i = 0; i < sC.length(); i++) {
			if (sZ.charAt(i) == '1')
				continue;
			if (sC.charAt(i) != sR.charAt(i))
				return false;
		}
		return true;
	}

	private String FindSZ(String sZ, int l) {
		for (int i = sZ.length(); i < l; i++)
			sZ = "0" + sZ;
		return sZ;
	}

	private boolean Chek0_1(String s) {
		for (int i = 0; i < s.length(); i++) {
			int q = s.charAt(i) - '0';
			if (q != 0 && q != 1)
				return false;
		}
		return true;
	}

	public int getCoincidence() {
		return coincidence;
	}

	public int getMinimum() {
		return minimum;
	}

}
