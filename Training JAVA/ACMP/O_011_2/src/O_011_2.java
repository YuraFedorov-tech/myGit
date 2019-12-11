import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_011_2 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int k = myScanner.nextInt();
		int n = myScanner.nextInt();
		ArrayList<Integer> road = new ArrayList<Integer>();
		boolean[] findNumberBoolean = new boolean[n + 1];
		int[] findNumberInt = new int[n + 1];
		int[] CounrForNewInt = new int[n + 1];
		int[] plusInt = new int[n + 1];
		int ans = Rekursia(n, k, 0, road, 0, findNumberBoolean, findNumberInt,
				CounrForNewInt,plusInt);
	//	System.out.println(road);
		System.out.println(ans);

	}

	private static int Rekursia(int n, int k, int ans, ArrayList<Integer> road,
			int count, boolean[] findNumberBoolean, int[] findNumberInt,
			int[] counrForNewInt, int[] plusInt) {

		if (count == n) {
			counrForNewInt=Helping.plus_counrForNewInt_on_road(counrForNewInt,road,1,1);
			// System.out.print( road);
			System.out.println( ans + 1);
			return ans + 1;

		}

		for (int i = 0; i < k; i++) {
			int newCount = count + i + 1;
			if (newCount > n)
				break;
			
			if (findNumberBoolean[newCount]) {
				counrForNewInt=Helping.plus_counrForNewInt_on_road(counrForNewInt,road,0,findNumberInt[newCount]);
				ans += findNumberInt[newCount];
				continue;
			}
			road.add(i + 1);
		//	int[] copiedCounrForNewInt = Arrays.copyOf(counrForNewInt,				counrForNewInt.length);
			// counrForNewInt=Helping.Plus1toall(counrForNewInt,road);
			

			ans = Rekursia(n, k, ans, road, newCount, findNumberBoolean,
					findNumberInt, counrForNewInt,plusInt);
			road.remove(road.size() - 1);
			// counrForNewInt=null;
			// counrForNewInt = Arrays.copyOf(copiedCounrForNewInt,
			// copiedCounrForNewInt.length);
			
		}
	//	int n1 = Helping.FindNumber(road);
		if (!findNumberBoolean[count]) {

		//	int y = ans - counrForNewInt[n1]+plusInt[n1];
			findNumberInt[count] =counrForNewInt[count];
			findNumberBoolean[count] = true;

		}
		return ans;
	}

}
