package e052;

import java.util.Arrays;

public class e052_2 {
	private static boolean find;
	static boolean[] a;
	private static int cur;

	public e052_2(boolean[] a, int i) {
		this.a = a;
		cur = i;
		find = false;
	}

	public void job() {
		for (int i = 2; i < 7; i++) {
			if (!Chek(i))
				return;
			
		}

		find = true;
	}

	private boolean Chek(int n) {
		long curNew = cur * n;
		boolean[] aa = new boolean[10];
		e052.Find_A(curNew, aa);
		if (Arrays.equals(a, aa))
			return true;
		return false;
	}

	public boolean getFind() {
		// TODO Auto-generated method stub
		return find;
	}

}
