import java.util.ArrayList;
import java.util.Scanner;

public class O_352 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n=myScanner.nextInt();
	
		int znamenatel=n/2;
			znamenatel++;		
		int chislitel=n-znamenatel;
		System.out.println(chislitel+" / "+znamenatel);
		int  []ans={-1}		;
		began(ans,chislitel,znamenatel,n);
	//	if(ans[0]==-1)
		//	System.out.println(-1);
		
			
		
	}

	private static void began(int[] ans, int chislitel, int znamenatel, int n) {
		ArrayList<Integer> simpleNumber = new ArrayList<Integer>();
		simpleNumber = Find_SimpleNumber(simpleNumber, n);
		System.out.println(simpleNumber);

		while (true) {
			if (chislitel == 0)
				
				break;
			if (chislitel % 2 == 0 & znamenatel % 2 == 0) {
				chislitel--;
				znamenatel++;
				continue;
			}
			ArrayList<Integer> List_chislitel = new ArrayList<Integer>();
			ArrayList<Integer> List_znamenatel = new ArrayList<Integer>();
			List_chislitel = Find_List_chislitel(List_chislitel, simpleNumber,
					chislitel);
			List_znamenatel = Find_List_chislitel(List_znamenatel,
					simpleNumber, znamenatel);
			boolean y = Find_y(List_chislitel, List_znamenatel);
			// если ложь значит есть одинаковые делители
			if (y) {
				ans[0] = chislitel;
				System.out.println(List_chislitel);
				System.out.println(List_znamenatel);
				
				System.out.println(chislitel + " " + znamenatel);
				return;
			}
			chislitel--;
			znamenatel++;
		}

	}

	private static boolean Find_y(ArrayList<Integer> list_chislitel,
			ArrayList<Integer> list_znamenatel) {
		for (int i = 0; i < list_chislitel.size(); i++) {
			int ch = list_chislitel.get(i);
			for (int i1 = 0; i1 < list_znamenatel.size(); i1++) {
				int zn = list_znamenatel.get(i1);
				if (ch == zn)
					return false;
				if (ch > zn)
					break;

			}

		}

		return true;
	}

	private static ArrayList<Integer> Find_List_chislitel(
			ArrayList<Integer> list_chislitel, ArrayList<Integer> simpleNumber,
			int chislitel) {
		for (int i = 0; i < simpleNumber.size(); i++) {
			int x = simpleNumber.get(i);
			if (chislitel % x == 0)
				list_chislitel.add(x);
		}

		return list_chislitel;
	}

	private static ArrayList<Integer> Find_SimpleNumber(
			ArrayList<Integer> simpleNumber, int n) {
		int max = (int) (Math.sqrt(n) + 1);
		boolean buzy[] = new boolean[max + 1];
		buzy = Do_buzy(buzy, max);
		simpleNumber = Do_simpleNumber(simpleNumber, buzy, max);

		return simpleNumber;
	}

	private static ArrayList<Integer> Do_simpleNumber(
			ArrayList<Integer> simpleNumber, boolean[] buzy, int max) {
		for (int i = 2; i <= max; i++) {
			if (buzy[i])
				continue;
			simpleNumber.add(i);
		}

		return simpleNumber;
	}

	private static boolean[] Do_buzy(boolean[] buzy, int max) {
		for (int i = 2; i <= max; i++) {
			if (buzy[i])
				continue;
			buzy = Change_buzy(buzy, i, max);

		}

		return buzy;
	}

	private static boolean[] Change_buzy(boolean[] buzy, int t, int max) {
		for (int i = 2 * t; i <= max; i += t) {
			buzy[i] = true;

		}
		return buzy;
	}

}
