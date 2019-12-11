import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_300_1 {
	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
		// int n = u.nextInt();
		int a[][] = new int[4][4];
		double[] t = new double[4];
		for (int i = 0; i < 4; i++) {
			a[i][0] = u.nextInt();
			a[i][1] = u.nextInt();
		}
		int timeTern = u.nextInt();
		int l = u.nextInt();
		for (int i = 0; i < 4; i++) {
			t[i] = a[i][0] + (double) l / a[i][1];
			if (a[i][1] == 0)
				t[i] = 1000000000;
			// t[i] = new BigDecimal(t[i]).setScale(8, RoundingMode.UP)
			// .doubleValue();
		}
		int m = 0;

		B(t, timeTern, a);

	}

	private static void B(double[] t, int timeTern, int[][] a) {

		boolean[] buzyNewTN = new boolean[4];
		boolean[] buzyBeganenSimplT = new boolean[4];
		int ans = 0;
		int previos = 0;
		double[] tN = Arrays.copyOf(t, 4);
		Arrays.sort(tN);
		boolean first = true;
		;
		for (int i = 0; i < 4; i++) {
			if (tN[i] == -5) {
				int j = Find_j(tN[i], t, buzyBeganenSimplT);
				ans++;
				buzyBeganenSimplT[j] = true;
				continue;
			}
			boolean rest = FindRest(buzyBeganenSimplT, a);
			if (rest) {
				ans = 4;
				break;
			}
			int j = Find_j(tN[i], t, buzyBeganenSimplT);
			ArrayList<Integer> list = new ArrayList<Integer>();
			boolean noDifferent = FindNoDifferent(t, j, list);
			if (list.size() != 0)
				noDifferent = true;
			boolean one = false;
			if (noDifferent) {
				one = FindOne(list, j);
			}
			int turn = 1;
			if (!one)
				if ((previos % 2 == 0 & j % 2 == 0)
						| (previos % 2 == 1 & j % 2 == 1))
					turn = 2;
			previos = j;
			if (i == 0) {

				continue;
			}
			int time = turn * timeTern;
			if (time + t[previos] <= t[j]) {
				ans++;
				previos = j;
				if (noDifferent)
					break;
			} else {
				if (noDifferent)
					ans++;
				break;
			}

		}
		if (ans == 4) {
			System.out.println("ALIVE");
		} else
			System.out.println(ans);
	}

	private static boolean FindOne(ArrayList<Integer> list, int j) {
		int x = j % 2;
		for (int i = 0; i < list.size(); i++) {
			if (x != list.get(i) % 2)
				return true;
		}

		return false;
	}

	private static boolean FindNoDifferent(double[] t, int j,
			ArrayList<Integer> list) {
		double s = t[j];
		for (int i = 0; i < 4; i++) {
			if (i == j)
				continue;
			/*
			 * System.out.println((s - t[i])); System.out.println(((s - t[i]) /
			 * s)); System.out.println((((s - t[i]) / s) * 10000));
			 */
			int y = (int) (((s - t[i]) / s) * 10000);
			if (y == 0)
				list.add(i);
		}

		return false;
	}

	private static int Find_j(double tN, double[] t, boolean[] buzyBeganenSimplT) {

		for (int i = 0; i < 4; i++) {
			if (buzyBeganenSimplT[i] | tN != t[i])
				continue;

			buzyBeganenSimplT[i] = true;
			return i;
		}

		return -5;
	}

	private static boolean FindRest(boolean[] buzyBeganenSimplT, int[][] a) {

		for (int i = 0; i < 4; i++) {
			if (buzyBeganenSimplT[i])
				continue;
			if (a[i][1] != 0)
				return false;
		}
		return true;
	}

}
