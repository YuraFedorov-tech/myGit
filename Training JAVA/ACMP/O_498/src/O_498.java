import java.util.ArrayList;
import java.util.Scanner;

public class O_498 {  //Main

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int k = myScanner.nextInt();
		int ans[] = new int[1];

		ArrayList<Integer> list = new ArrayList<Integer>();
		ans = rekur(0, list, n, k, ans);
		System.out.println(ans[0]);
	}

	private static int[] rekur(int step, ArrayList<Integer> list, int n, int k,
			int[] ans) {
		if (step++ == n) {
	//		prin(list);
			ans[0]+= 1;
			return ans;

		}
		for (int i = 1; i <= n; i++) {
			boolean yes = FindYes(list, k, i);
			if (yes)
				continue;
			list.add(i);
			ans = rekur(step, list, n, k, ans);
			list.remove(list.size()-1);	
			
			
			
			
		}

		return ans;
	}

	private static boolean FindYes(ArrayList<Integer> list, int k, int number) {
		if (FindNumber(list, number))
			return true;

		ArrayList<Integer> listWork = new ArrayList<Integer>();
		listWork.addAll(list);
		listWork.add(number);
		if (FindDifferenceK(listWork, k))
			return true;

		return false;
	}

	private static boolean FindDifferenceK(ArrayList<Integer> listWork, int k) {
		if (listWork.size() == 1)
			return false;
		int last = listWork.get(listWork.size() - 1);
		int first = listWork.get(listWork.size() - 2);
		int h = last - first;
		if (h < 0)
			h = -h;
		if (h > k)
			return true;

		return false;
	}

	private static boolean FindNumber(ArrayList<Integer> list, int number) {
		for (int i = 0; i < list.size(); i++)
			if (number == list.get(i))
				return true;

		return false;
	}

	private static void prin(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i));
		System.out.println();
	}

}
