package e061;

import java.util.ArrayList;

public class e061_2 extends e061 {
	private static int[][] a;
	private static boolean buz[];

	public e061_2() {
		a = new int[6][6];
	}

	public static boolean Chek(int step, int next) {
		boolean f = false;
		if (have(0, list3.size() - 1, list3, next)) {
			a[step][0] = 1;
			f = true;
		}
		if (have(0, list4.size() - 1, list4, next)) {
			a[step][1] = 1;
			f = true;
		}
		if (have(0, list5.size() - 1, list5, next)) {
			a[step][2] = 1;
			f = true;
		}
		if (have(0, list6.size() - 1, list6, next)) {
			a[step][3] = 1;
			f = true;
		}
		if (have(0, list7.size() - 1, list7, next)) {
			a[step][4] = 1;
			f = true;
		}
		if (have(0, list8.size() - 1, list8, next)) {
			a[step][5] = 1;
			f = true;
		}
		return f;
	}

	private static boolean have(int le, int re, ArrayList<Integer> list, int next) {
		if (le == re) {
			int x = list.get(le);
			return x == next;
		}
		int mid = le + (re - le) / 2;
		int x = list.get(mid);
		if (next > x)
			return have(mid + 1, re, list, next);
		else
			return have(le, mid, list, next);
	}

	public boolean AllPoint() {
		buz = new boolean[6];
		return reur(0);
	}

	private boolean reur(int step) {
		if (step == 6) {
			return true;
		}
		for (int i = 0; i < 6; i++) {
			if (buz[i])
				continue;
			if (a[step][i] == 0)
				continue;
			buz[i] = true;
			boolean a = reur(step + 1);
			if (a)
				return true;
			buz[i] = false;
		}
		return false;
	}

	public void DeleteA(int step) {
		a[step] = new int[6];
	}
	}
