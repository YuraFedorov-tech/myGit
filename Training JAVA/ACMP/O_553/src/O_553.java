import java.util.ArrayList;
import java.util.Scanner;

public class O_553 {  //Main

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		ArrayList<Integer> current = new ArrayList<Integer>();
		int[][] a = new int[2][n];
		for (int i = 0; i < a[0].length; i++) {
			a[0][i] = myScanner.nextInt();
			a[1][i] = myScanner.nextInt();
		}
		for (int i = 0; i < a[0].length; i++) {
			current.add(a[0][i]);
			current.add(a[1][i]);
		}
		current.add(0);
		int ans[] = new int[1];
		ArrayList<Integer> listBuzy = new ArrayList<Integer>();

		ans[0] = -1;
		ans = rekursia(0, listBuzy, a, n, current, ans);
		System.out.print(ans[0]);
	}

	private static int[] rekursia(int step, ArrayList<Integer> listBuzy,
			int[][] a, int n, ArrayList<Integer> current, int[] ans) {
		if (current.get(current.size()-1) > ans[0]   &ans[0] != -1  )
			return ans;
		
		if (++step == n) {
			if (current.get(current.size()-1) < ans[0] | ans[0] == -1)
				ans[0] = current.get(current.size()-1);

			return ans;

		}
		ArrayList<Integer> currentThis = new ArrayList<Integer>();
		currentThis.addAll(current);
		for (int i = 0; i < n - step; i++) {

			current = DoCurrent(current, a, i);
			ans = rekursia(step, listBuzy, a, n, current, ans);
			current.clear();
			current.addAll(currentThis);

		}

		return ans;
	}

	private static ArrayList<Integer> DoCurrent(ArrayList<Integer> current,
			int[][] a, int number) {
		int m0 = number * 2;
		int k0 = number * 2 + 1;
		int m1 = m0 + 2;
		int k1 = k0 + 2;
		int m=current.get(m0);
		int k=current.get(k1);
		int last=current.get(current.size()-1);
		last+=m*k;
		
		current.set(current.size()-1, last);
		current.remove(m0);
		current.remove(m0);
		current.set(m0,m);
		current.set(k0,k);

		return current;
	}

	private static boolean FindBuzyOrNo(int number, ArrayList<Integer> listBuzy) {
		for (int i = 0; i < listBuzy.size(); i++) {
			if (listBuzy.get(i) == number)
				return true;

		}

		return false;
	}

}
