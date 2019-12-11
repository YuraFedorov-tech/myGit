import java.util.ArrayList;
import java.util.Scanner;

public class O_130 {
	public static void main(String[] args) {
		Scanner j = new Scanner(System.in);

		int y[] = new int[2];
		int x[] = new int[2];
		String s = j.nextLine();
String t[]=s.split(" ");
		for (int i = 0; i < 2; i++) {
			
			y[i] = Integer.parseInt("" + t[i].charAt(1))-1;
			x[i] = W("" + t[i].charAt(0));
		}

		Began(y, x);

	}

	private static void Began(int[] y, int[] x) {
		if (y[0] == y[1] & x[0] == x[1]) {
			System.out.println(0);
			return;
		}
		ArrayList<Integer> red = new ArrayList<Integer>();
		red.add(y[0] * 8 + x[0]);

		ArrayList<Integer> green = new ArrayList<Integer>();
		green.add(y[1] * 8 + x[1]);

		int ans[] = { -1 };
		int a_green[][] = new int[64][64];
		int a_red[][] = new int[64][64];
		int step = 0;
		while (red.size() != 0 & green.size() != 0 &ans[0]==-1) {
			step++;
			ArrayList<Integer> redNew = new ArrayList<Integer>();
			go(red, redNew);
			ArrayList<Integer> greenNew = new ArrayList<Integer>();
			go(green, greenNew);
		
		Minus(redNew, greenNew, a_red);			
			Minus(greenNew, redNew, a_green);
			chek(redNew,greenNew,ans);
			
			red.addAll(redNew);
			green.addAll(greenNew);
		}
if(ans[0]==-1){
	System.out.println(-1);
}else
	System.out.println(step);
	}

	private static void chek(ArrayList<Integer> redNew,
			ArrayList<Integer> greenNew, int[] ans) {
		for (int i = 0; i < redNew.size(); i++) {
			// если ложь то не удаляем
		ChekOne(redNew.get(i), greenNew, ans);
		}
	}

	private static void ChekOne(int j, ArrayList<Integer> greenNew,
			int[] ans) {

		for (int i = 0; i < greenNew.size(); i++) {
			int t = greenNew.get(i);
		if(j==t)
			ans[0]=1;
		}
	}

	private static void Minus(ArrayList<Integer> redNew,
			ArrayList<Integer> greenNew, int[][] a) {
		for (int i = 0; i < redNew.size(); i++) {
			// если ложь то не удаляем
			boolean h = FindH(redNew.get(i), greenNew, a);
			if (h) {
				redNew.remove(i);
				i--;
				continue;
			}
Insiding(redNew.get(i), greenNew, a);
			
			
		}

	}

	private static void Insiding(int j, ArrayList<Integer> greenNew,
			int[][] a) {
		for (int i = 0; i < greenNew.size(); i++) {
			int t = greenNew.get(i);
		a[j][t]=a[t][j]=1;
		}
		
	}

	private static boolean FindH(int j, ArrayList<Integer> greenNew, int[][] a
			) {
		// если ложь то не удаляем
		for (int i = 0; i < greenNew.size(); i++) {
			int t = greenNew.get(i);
		
			if (a[j][t] == 0)
				return false;

		}
		return true;
	}

	private static void go(ArrayList<Integer> red, ArrayList<Integer> redNew) {
		int e = red.size();
		for (int i = 0; i < e; i++)
			go_only_1(red, redNew);

	}

	private static void go_only_1(ArrayList<Integer> red,
			ArrayList<Integer> redNew) {
		int n = red.get(0);
		int yO = n / 8;
		int xO = n - yO * 8;
		red.remove(0);

		int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i < 8; i++) {

			int y = yO + Y[i];
			int x = xO + X[i];

			if (y > 7 | y < 0 | x > 7 | x < 0)
				continue;
			Inside(redNew, y * 8 + x);

		}
	}

	private static void Inside(ArrayList<Integer> redNew, int n) {
		for (int i = 0; i < redNew.size(); i += 2)
			if (redNew.get(i) == n)
				return;
		redNew.add(n);

	}

	public static int Q(int i) {
		switch (i) {
		case 1:
			return 7;
		case 2:
			return 6;
		case 3:
			return 5;
		case 4:
			return 4;
		case 5:
			return 3;
		case 6:
			return 2;
		case 7:
			return 1;
		case 8:
			return 0;

		}

		return 9;
	}

	public static int W(String string) {
		switch (string) {
		case "h":
			return 7;
		case "g":
			return 6;
		case "f":
			return 5;
		case "e":
			return 4;
		case "d":
			return 3;
		case "c":
			return 2;
		case "b":
			return 1;
		case "a":
			return 0;

		}

		return 9;
	}

}