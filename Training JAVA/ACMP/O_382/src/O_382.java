import java.util.ArrayList;

public class O_382 {

	public static void main(String[] args) {
		int[][] a = Input.input();
		// Helper_382.pr(a);
		int n = a.length;
		ArrayList<Integer> list = new ArrayList<>();

		list.add(Find_1From2(1, 1, n));
		int[] ans = { 0, -1 };
		a[1][1] = 2;
		a = BDF(a, list, ans);
		list.add(Find_1From2(n - 2, n - 2, n));
		a = BDF(a, list, ans);
		System.out.println((ans[0] - 4) * 25);
	}

	private static int[][] BDF(int[][] a, ArrayList<Integer> list, int[] ans) {
		while (list.size() != 0) {
			int n = list.size();
			for (int i = 0; i < n; i++) {
				a = PlusInListFromOnePoint(a, list, list.get(0), ans);
				list.remove(0);
			}

		}

		return a;
	}

	private static int[][] PlusInListFromOnePoint(int[][] a,
			ArrayList<Integer> list, int p, int[] ans) {
		int lengthOur = a.length;
		int y = Find_Y_From_1(p, lengthOur);
		int x = Find_X_From_1(p, lengthOur, y);
		int[] yy = { -1, 0, 1, 0 };
		int[] xx = { 0, 1, 0, -1 };
		list = DoNewPoint(y, x, yy, xx, a, list, ans);

		return a;
	}

	private static ArrayList<Integer> DoNewPoint(int yOld, int xOld, int[] yy,
			int[] xx, int[][] a, ArrayList<Integer> list, int[] ans) {
		for (int i = 0; i < 4; i++) {
			int x = xOld + xx[i];
			int y = yOld + yy[i];
			if (a[y][x] == 0) {
				list.add(Find_1From2(y, x, a.length));
				a[y][x] = 2;

			}
			if (xOld == a.length - 2 & yOld == a.length - 2) {
				if (ans[1] == 100)
					continue;

			}
			if (a[y][x] == -1) {

				ans[0]++;
			}

		}
		if (xOld == a.length - 2 & yOld == a.length -2)
			ans[1] = 100;
		return list;
	}

	private static int Find_X_From_1(int p, int lengthOur, int y) {

		return p - lengthOur * y;
	}

	private static int Find_Y_From_1(int p, int lengthOur) {
		// TODO Auto-generated method stub
		return p / lengthOur;
	}

	private static int Find_1From2(int y, int x, int length) {

		return length * y + x;
	}
}
