import java.util.ArrayList;
import java.util.Scanner;

public class O_450 {
	public static void main(String[] args) {

		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int[][] a = new int[n][n];
		int[][] aShlyapa = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				aShlyapa[i][j]=	a[i][j] = my.nextInt();
			}
		int[] max = new int[n];

		for (int i = 0; i < n; i++) {
			int q = 0;
			for (int j = 0; j < n; j++) {
				q += a[j][i];
			}
			max[i] = q;
		}
		// Helper_450.pr(a);
		// Helper_450.pr1(max);

		boolean[] buzyGoriz = new boolean[n];
		boolean[] buzyVertik = new boolean[n];
		int[] ans = { Integer.MAX_VALUE };
		ArrayList<Integer> list_end = new ArrayList<>();
		ArrayList<Integer> list_Curensy = new ArrayList<>();
		
		long timestart1 = System.currentTimeMillis();
		
		//rekursia(0, a, max, buzyGoriz, buzyVertik, ans, 0, list_end,
		//		list_Curensy, list_Best.get(1), list_Best.get(0));
		
		rekursia(0, a, max, buzyGoriz, buzyVertik, ans, 0, list_end,
						list_Curensy, 0, 0,aShlyapa);
		long timestart2 = System.currentTimeMillis();
		System.out.println(timestart2 - timestart1);
		String s = "ABCDEFGHIJ";
		pr(s, n, list_end);
		System.out.println(ans[0]);
	}

	private static void pr(String s, int n, ArrayList<Integer> list_end) {
		char[] chArray = s.toCharArray();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < list_end.size(); j += 2) {
				if (list_end.get(j) == i) {
					System.out.print(chArray[list_end.get(j + 1)]);
					continue;
				}

			}
		System.out.println();
	}

	private static void rekursia(int step, int[][] a, int[] max,
			boolean[] buzyGoriz, boolean[] buzyVertik, int[] ans, int curensy,
			ArrayList<Integer> list_end, ArrayList<Integer> list_Curensy,
			Integer vertikal, Integer gorizont, int[][] aShlyapa) {
		if (step == a.length) {
			if (curensy < ans[0]) {
				ans[0] = curensy;
				list_end.clear();

				list_end.addAll(list_Curensy);
				System.out.println(list_Curensy + "\t" + curensy);
			}

			return;
		}
		if(a.length-step>5){
		ArrayList<Integer> list_Best = new ArrayList<>();
		list_Best = Helper_450.Find_list_Best(aShlyapa, max, list_Best);
		vertikal=list_Best.get(1);
		gorizont=list_Best.get(0);
		aShlyapa=Helper_450.Do_aShlyapa(aShlyapa,vertikal);
		}
		for (int k = vertikal; k <vertikal+ a.length; k++) {
			int i=k;
			if(i>=a.length)
				i-=a.length;
			if (buzyVertik[i])
				continue;
			buzyVertik[i] = true;
			list_Curensy.add(i);
			for (int p= gorizont; p <gorizont+ a.length; p++) {
				int j=p;
				if(j>=a.length)
					j-=a.length;
				if (buzyGoriz[j])
					continue;
				int x = (max[i] - a[i][j]);
				if (curensy + x >= ans[0])
					continue;

				buzyGoriz[j] = true;

				list_Curensy.add(j);
				rekursia(step + 1, a, max, buzyGoriz, buzyVertik, ans, curensy
						+ x, list_end, list_Curensy,vertikal,gorizont,aShlyapa);
				list_Curensy.remove(list_Curensy.size() - 1);

				buzyGoriz[j] = false;
			}
			list_Curensy.remove(list_Curensy.size() - 1);
			buzyVertik[i] = false;
		}

	}
}