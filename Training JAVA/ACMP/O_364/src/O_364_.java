import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_364_ {  //Main

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int m = my.nextInt();
		ArrayList<Integer> simple_number = new ArrayList<Integer>();
		simple_number = Find_simple_number(m, simple_number);
	//	System.out.println(simple_number);

		int[] ans = new int[1];
		ans = Finf_all_Byuty_Number(ans, n, m, simple_number);
if(ans[0]==0)
	System.out.print("Absent");
	}

	private static int[] Finf_all_Byuty_Number(int[] ans, int n, int m,
			ArrayList<Integer> simple_number) {
		for (int i = n; i <= m; i++) {
			ans = Finf_I_Byuty_Number_orNo(simple_number, i, ans);
		}

		return ans;
	}

	private static int[] Finf_I_Byuty_Number_orNo(
			ArrayList<Integer> simple_number, int n, int[] ans) {
		ArrayList<Integer> deliteli_simpl = new ArrayList<Integer>();
		ArrayList<Integer> deliteli_all = new ArrayList<Integer>();

		deliteli_simpl = Find_deliteli_simpl(simple_number, n, deliteli_simpl);

		if (deliteli_simpl.size() > 1) {
			deliteli_all = Find_all_deliteli(deliteli_simpl, deliteli_all, n);
			if (deliteli_all.get(deliteli_all.size() - 1) >= n)
				deliteli_all.remove(deliteli_all.size() - 1);
		}
		boolean chek = chek_byuty(n, deliteli_all);
		if (!chek)
			return ans;
		System.out.println(n);
		ans[0] = 1;
		return ans;
	}

	private static ArrayList<Integer> Find_deliteli_simpl(
			ArrayList<Integer> simple_number, int n,
			ArrayList<Integer> deliteli_simpl) {
		deliteli_simpl.add(1);

		for (int i = 1; i < simple_number.size(); i++) {
			if (simple_number.get(i) >= n)
				break;
			int y = n;
			int x = 1;
			while (y % simple_number.get(i) == 0 & y > 0) {
				x *= simple_number.get(i);
				deliteli_simpl.add(simple_number.get(i));
				y /= simple_number.get(i);
			}
		}
		return deliteli_simpl;
	}

	private static boolean chek_byuty(int n, ArrayList<Integer> deliteli_all) {
		for (int i = 0; i < deliteli_all.size(); i++)
			n -= deliteli_all.get(i);
		if (n == 0)
			return true;

		return false;
	}

	private static ArrayList<Integer> Find_all_deliteli(
			ArrayList<Integer> deliteli_simpl, ArrayList<Integer> deliteli_all,
			int n) {
		int step = 0;
		// deliteli_all.add(1);
		// boolean[] used = No_diferent_find(deliteli_simpl);
		int b = find_B(deliteli_simpl);
		int[][] a = new int[2][b];
		a = find_a(deliteli_simpl, a);
		deliteli_all = rekur(1, a, deliteli_all, 1);
		Collections.sort(deliteli_all);

		return deliteli_all;
	}

	private static ArrayList<Integer> rekur(int step, int[][] a,
			ArrayList<Integer> deliteli_all, int itog) {
		if (step == a[0].length) {
			deliteli_all.add(itog);
			return deliteli_all;
		}
		for (int i = 0; i <= a[1][step] + 1; i++) {
			int y = (int) Math.pow(a[0][step], i);
			deliteli_all = rekur(step + 1, a, deliteli_all, itog * y);
		}

		return deliteli_all;
	}

	private static int[][] find_a(ArrayList<Integer> deliteli_simpl, int[][] a) {
		a[0][0] = 1;
		int n = 0;
		int count = 0;
		for (int i = 1; i < deliteli_simpl.size(); i++) {
			if (deliteli_simpl.get(i) == deliteli_simpl.get(n)) {
				a[1][n] += 1;
				continue;
			}
			a[0][n + 1] = deliteli_simpl.get(i);

			count = 0;
			n++;
		}

		return a;
	}

	private static int find_B(ArrayList<Integer> deliteli_simpl) {
		int n = 0;
		for (int i = 1; i < deliteli_simpl.size(); i++) {
			if (deliteli_simpl.get(i) == deliteli_simpl.get(n))
				continue;
			n++;

		}
		return n + 1;
	}

	private static boolean May(ArrayList<Integer> deliteli_simpl, int step,
			int i, boolean[] used) {
		if (step == 0 | !used[i])
			return true;
		for (int j = step + 1; j <= i; j++) {
			if (!used[j])
				return true;
		}

		return false;
	}

	private static boolean[] No_diferent_find(ArrayList<Integer> deliteli_simpl) {
		boolean[] used = new boolean[deliteli_simpl.size()];
		int n = 0;
		for (int i = 1; i < deliteli_simpl.size(); i++) {
			if (deliteli_simpl.get(i) != deliteli_simpl.get(n)) {
				n++;
				continue;
			}
			used[i] = true;
			// deliteli_simpl.set(i, deliteli_simpl.get(i - 1) *
			// deliteli_simpl.get(n));

		}
		return used;
	}

	private static ArrayList<Integer> Find_simple_number(int m,
			ArrayList<Integer> simple_number) {
		int end = (int) Math.sqrt(m);
		boolean[] used = new boolean[m];
		simple_number.add(1);
		for (int i = 2; i < m / 2+1; i++) {

			if (!used[i]) {
				simple_number.add(i);
				used = deleteFromUsed(used, i);
			}

		}

		return simple_number;
	}

	private static boolean[] deleteFromUsed(boolean[] used, int i) {
		int step = 1;
		while (true) {
			int y = step++ * i;
			if (y > used.length - 1)
				break;
			used[y] = true;
		}
		return used;
	}

}
