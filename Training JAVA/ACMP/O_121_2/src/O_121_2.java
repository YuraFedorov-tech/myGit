import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_121_2 {

	public static void main(String[] args) {
		ArrayList<Integer> listInput = new ArrayList<Integer>();
		ArrayList<Integer> listCurrent = new ArrayList<Integer>();
		ArrayList<Integer> listAnswear = new ArrayList<Integer>();
		ArrayList<Integer> raznitza = new ArrayList<Integer>();
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();

		for (int i = 0; i < n; i++)
			listInput.add(myScanner.nextInt());
		myScanner.close();
		Collections.sort(listInput);
		int ans[] = { -1 };
		raznitza = Work.DoRaxnitca(listInput, raznitza);
		// System.out.println( listInput);
		// System.out.println( raznitza);
		ans = rekursia(0, listInput, listCurrent, listAnswear, ans, raznitza, 0);
		System.out.println(listAnswear);
		System.out.println(ans[0]);

	}

	private static int[] rekursia(int previos, ArrayList<Integer> listInput,
			ArrayList<Integer> listCurrent, ArrayList<Integer> listAnswear,
			int[] ans, ArrayList<Integer> raznitza, int summa) {
		if (summa > ans[0] & ans[0] != -1)
			return ans;

		if (listCurrent.size() == raznitza.size() - 1) {
			int curAns = Work.count(listCurrent, raznitza);
			if (ans[0] > curAns | ans[0] == -1) {
				ans[0] = curAns;
				listAnswear.clear();
				listAnswear.addAll(listCurrent);

				listAnswear.add(1);
				// System.out.println(listAnswear );
				return ans;
			}
			return ans;
		}
		for (int i = 0; i < 2; i++) {
			if (i == 0 & previos == 0)
				continue;
			listCurrent.add(i);
			int n=i*raznitza.get(listCurrent.size()-1);
			ans = rekursia(i, listInput, listCurrent, listAnswear, ans,
					raznitza,summa+n);
			listCurrent.remove(listCurrent.size() - 1);
		}

		return ans;
	}
}
