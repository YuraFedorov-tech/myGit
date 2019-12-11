import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class O_346 {

	public static void main(String[] args) {

		Scanner my = new Scanner(System.in);
		int a = my.nextInt();
		int b = my.nextInt();
		int c = my.nextInt();
		int NumberInMassiv_B[] = new int[10];
		ArrayList<Integer> List_A = new ArrayList<>();
		NumberInMassiv_B = Helper_346.DoHowMuch(NumberInMassiv_B, b);
		
		List_A = Helper_346.DO_ussulyListFromInt(List_A, a);
		int Massiv_Currrency[] = new int[List_A.size()];
		Collections.sort(List_A);
		boolean buzy[] = new boolean[List_A.size()];
		int ans[] = { -1 };

		rekursia(0, List_A, buzy, NumberInMassiv_B, Massiv_Currrency, c, ans);
		if (ans[0] == -1)
			System.out.println("NO");

	}

	private static void rekursia(int step, ArrayList<Integer> list_A,
			boolean[] buzy, int[] numberInMassiv_B, int[] massiv_Currrency,
			int c, int[] ans) {
		if (step == list_A.size()) {
			int x = Helper_346.DoNumberFromMassiv(massiv_Currrency);
			int raznit = c - x;
			if (raznit > 0) {
				int NumberInMassiv_Raznitza[] = new int[10];

				NumberInMassiv_Raznitza = Helper_346.DoHowMuch(
						NumberInMassiv_Raznitza, raznit);
				
				boolean	find= Helper_346.Find_or_no(NumberInMassiv_Raznitza, numberInMassiv_B);
				if (find) {
					ans[0] = 1;
					Helper_346.print(massiv_Currrency, NumberInMassiv_Raznitza);

					System.out.println("YES");
					System.out.println(x + " " + raznit);
				}

			}
	return;
		}

		for (int i = 0; i < list_A.size(); i++) {
			if (buzy[i])
				continue;
			buzy[i] = true;
			massiv_Currrency[step] = list_A.get(i);
			rekursia(step + 1, list_A, buzy, numberInMassiv_B,
					massiv_Currrency, c, ans);
			if (ans[0] == 1)
				return;
			buzy[i] = false;
		}

	}

}
