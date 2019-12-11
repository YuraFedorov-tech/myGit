import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_238 { // Main

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int y = my.nextInt();
		int x = my.nextInt();
		int y1 = my.nextInt(); // вход
		int x1 = my.nextInt(); // вход
		int Enter = From2_to_1(y1, x1, x + 2);
		int[][] baza = new int[y + 2][x + 2];
		int[][] shagi = new int[y + 2][x + 2];
		shagi[y1][x1] = 1;
		baza = Inside_Stena(baza);

		for (int i = 1; i < y + 1; i++) {
			for (int i1 = 1; i1 < x + 1; i1++) {
				baza[i][i1] = my.nextInt();
			}

		}
		baza[y1][x1] = -1;
		int kolichestvo_Giper_Tunel = my.nextInt();
		ArrayList<Integer> giper_Enter = new ArrayList<Integer>();
		ArrayList<Integer> giper_Exit = new ArrayList<Integer>();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(Enter);
		int[][] copi_baza = new int[y + 2][x + 2];
		// copi_baza=baza.clone();
		copi_baza = ArraysCopy(copi_baza, baza);
		for (int i = 0; i < kolichestvo_Giper_Tunel; i++) {
			int y_enter = my.nextInt();
			int x_enter = my.nextInt();
			int en = From2_to_1(y_enter, x_enter, x + 2);
			copi_baza[y_enter][x_enter] = -3;
			giper_Enter.add(en);
			y_enter = my.nextInt(); // на самом деле это выход
			x_enter = my.nextInt();// на самом деле это выход
			en = From2_to_1(y_enter, x_enter, x + 2);// на самом деле это выход
			giper_Exit.add(en);
			// copi_baza[y_enter][x_enter] = -4;
		}
		int Kolichvo_Exit_From_baza = my.nextInt();
		for (int i = 0; i < Kolichvo_Exit_From_baza; i++) {
			int y_exit = my.nextInt();
			int x_exit = my.nextInt();
			baza[y_exit][x_exit] = -5;
		}

	
//	prin.pr(baza);
//		prin.pr(copi_baza);
//		// prin.pr(giper_Enter);
		// prin.pr(giper_Exit);

		int[] ans = new int[2];
		ans = FindExit(1, baza, copi_baza, giper_Enter, giper_Exit, queue, ans,
				shagi);
		if (ans[1] == 1) {
			System.out.print(ans[0]);
		} else {
			System.out.print("Impossible");
		}

	}

	private static int[] FindExit(int step, int[][] baza, int[][] copi_baza,
			ArrayList<Integer> giper_Enter, ArrayList<Integer> giper_Exit,
			ArrayList<Integer> queue, int[] ans, int[][] shagi) {
		ArrayList<Integer> plusGiper = new ArrayList<Integer>();

		int t = 0;
		queue = FindFirst_gipertunel(queue, baza, copi_baza, shagi,
				giper_Enter, giper_Exit);
		if (queue.size() == 2)
			t = 1;
		while (queue.size() != 0 | ans[1] != 0) {
			step++;

	//		System.out.println(step);

			int n = queue.size();
			// ArrayList<Integer> plusUsually = new ArrayList<Integer>();

			queue = FindPlus_Usually_All(step, baza, copi_baza, queue, n, ans,
					shagi);// добовляем
			// prin.pr(baza);
			if (ans[1] != 0)
				break; // все// что// идет// обычным // путем

			plusGiper = FindPlus_Giper_All(step, baza, copi_baza, queue, n - t,
					ans, giper_Enter, giper_Exit, plusGiper, shagi);
//			prin.pr(baza);
//			prin.pr(shagi);
			if (ans[1] != 0)
				break;
			queue = Minus_N(queue, n);

			queue = Plus_plusGiper(queue, plusGiper);
			t = plusGiper.size();
			n = plusGiper.size();
			plusGiper.clear();
          
          
          
			// plusGiper = FindPlus_Usually_All(step, baza, copi_baza,
			// plusGiper, n, ans);
			// plusGiper=Minus_N(plusGiper,n);
			// if(plusGiper.size()!=0)
			// queue= Plus_plusGiper(queue,plusGiper) ;
			// /////////////////////////////// ///
		}

		return ans;
	}

	private static ArrayList<Integer> FindFirst_gipertunel(
			ArrayList<Integer> queue, int[][] baza, int[][] copi_baza,
			int[][] shagi, ArrayList<Integer> giper_Enter,
			ArrayList<Integer> giper_Exit) {
		int q0 = queue.get(0);
		int y = find_y_from_1(q0, baza[0].length);
		int x = find_x_from_1(q0, baza[0].length, y);
		if (copi_baza[y][x] == -3) {
			copi_baza[y][x] = 1;
			int n = FindNumber_giper_Enter(giper_Enter, q0);
			queue.add(giper_Exit.get(n));
			q0 = giper_Exit.get(n);
			y = find_y_from_1(q0, baza[0].length);
			x = find_x_from_1(q0, baza[0].length, y);
			shagi[y][x] = 2;
			giper_Exit.set(n, 0);

		}

		return queue;
	}

	private static ArrayList<Integer> Plus_plusGiper(ArrayList<Integer> queue,
			ArrayList<Integer> plusGiper) {
		for (int i = 0; i < plusGiper.size(); i++)
			queue.add(plusGiper.get(i));
		return queue;
	}

	private static ArrayList<Integer> Minus_N(ArrayList<Integer> queue, int n) {
		for (int i = 0; i < n; i++)
			queue.remove(0);
		return queue;
	}

	private static ArrayList<Integer> FindPlus_Giper_All(int step,
			int[][] baza, int[][] copi_baza, ArrayList<Integer> queue, int n,
			int[] ans, ArrayList<Integer> giper_Enter,
			ArrayList<Integer> giper_Exit, ArrayList<Integer> plusGiper,
			int[][] shagi) {
		for (int i = n; i < queue.size(); i++) {
			plusGiper = FindPlus_Giper_One(step, baza, copi_baza, ans,
					queue.get(i), giper_Enter, giper_Exit, plusGiper, shagi);

		}

		return plusGiper;
	}

	private static ArrayList<Integer> FindPlus_Giper_One(int step,
			int[][] baza, int[][] copi_baza, int[] ans, int q0,
			ArrayList<Integer> giper_Enter, ArrayList<Integer> giper_Exit,
			ArrayList<Integer> plusGiper, int[][] shagi) {
		int y = find_y_from_1(q0, baza[0].length);
		int x = find_x_from_1(q0, baza[0].length, y);
		if (copi_baza[y][x] == -3  ) {
			int n = FindNumber_giper_Enter(giper_Enter, q0);
			giper_Exit=used_or_no(giper_Exit,baza,n);
			if (giper_Exit.get(n) == 0)
				return plusGiper;
			int q_From_giper = giper_Exit.get(n);
			plusGiper.add(giper_Exit.get(n));

			ans = Find_Exit(shagi[y][x], baza, giper_Exit.get(n), ans, shagi,
					step);
			giper_Exit.set(n, 0);
		}

		return plusGiper;
	}

	private static ArrayList<Integer> used_or_no(ArrayList<Integer> giper_Exit,
			int[][] baza, int n) {
int q0=giper_Exit.get(n);
int y = find_y_from_1(q0, baza[0].length);
int x = find_x_from_1(q0, baza[0].length, y);
if(baza[y][x]==0 |baza[y][x]==-5){
	return giper_Exit;
}
	giper_Exit.set(n, 0);
		return giper_Exit;
	}

	private static int[] Find_Exit(int step, int[][] baza, int q0, int[] ans,
			int[][] shagi, int step2) {
		int y = find_y_from_1(q0, baza[0].length);
		int x = find_x_from_1(q0, baza[0].length, y);
		if (shagi[y][x] != 0)
			System.out.println("shagi[y][x]!=0");
		shagi[y][x] = step + 1;
		if (baza[y][x] != -5) {
			baza[y][x] = step2;
			return ans;
		}
		ans[0] = step + 1;
		ans[1] = 1;

		return ans;
	}

	private static int FindNumber_giper_Enter(ArrayList<Integer> giper_Enter,
			int q0) {
		for (int i = 0; i < giper_Enter.size(); i++) {
			if (giper_Enter.get(i) == q0)
				return i;
		}
		System.out.println("Error");
		return 0;
	}

	private static ArrayList<Integer> FindPlus_Usually_All(int step,
			int[][] baza, int[][] copi_baza, ArrayList<Integer> queue, int n,
			int[] ans, int[][] shagi) {

		for (int i = 0; i < n; i++) {
			queue = FindPlus_Usually_One(baza, ans, queue.get(i), queue, step,
					shagi);

		}

		return queue;
	}

	private static ArrayList<Integer> FindPlus_Usually_One(int[][] baza,
			int[] ans, int q0, ArrayList<Integer> queue, int step, int[][] shagi) {
		int[] y_Plus = { -1, 0, 1, 0 };
		int[] x_Plus = { 0, 1, 0, -1 };
		int y = find_y_from_1(q0, baza[0].length);
		int x = find_x_from_1(q0, baza[0].length, y);
		for (int i = 0; i < 4; i++) {
			int y_Cuurent = y + y_Plus[i];
			int x_Cuurent = x + x_Plus[i];
			if (baza[y_Cuurent][x_Cuurent] == -5) {
				ans[1] = 1;
				ans[0] = shagi[y][x] + 1;
				i = 4;
			}
			if (baza[y_Cuurent][x_Cuurent] > 0
					| baza[y_Cuurent][x_Cuurent] == -1)
				continue;
			if (shagi[y_Cuurent][x_Cuurent] != 0)
				System.out.println("[y_Cuurent][x_Cuurent]!=0");
			baza[y_Cuurent][x_Cuurent] = shagi[y][x] + 1;
			shagi[y_Cuurent][x_Cuurent] = shagi[y][x] + 1;
			int q = From2_to_1(y_Cuurent, x_Cuurent, baza[0].length);
			queue.add(q);
		}

		return queue;
	}

	private static int[][] ArraysCopy(int[][] copi_baza, int[][] baza) {
		for (int i = 0; i < baza.length; i++) {
			for (int i1 = 0; i1 < baza[0].length; i1++) {
				copi_baza[i][i1] = baza[i][i1];

			}

		}

		return copi_baza;
	}

	private static int[][] Inside_Stena(int[][] baza) {
		for (int i = 0; i < baza.length; i++)
			baza[i][0] = baza[i][baza[0].length - 1] = 1;
		for (int i = 0; i < baza[0].length; i++)
			baza[0][i] = baza[baza.length - 1][i] = 1;

		return baza;
	}

	private static int find_x_from_1(int q0, int length, int y) {

		return q0 - y * length;
	}

	private static int find_y_from_1(int q0, int length) {
		return q0 / length;
	}

	private static int From2_to_1(int y1, int x1, int x) {
		return y1 * x + x1;
	}

}
