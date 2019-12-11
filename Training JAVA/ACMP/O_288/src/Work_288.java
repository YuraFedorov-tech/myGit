import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Work_288 {

	public static void Began() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String s;
		int ans[] = new int[3];
		int[] x = new int[3];
		do {

			String line = reader.readLine();
			line = line.trim();
			line += " ";
			ans[2] = 1;

			switch (ans[1]) {
			case 0:
				Metod0(0, ans, line, x);
				break;
			case 1:
				Metod1(0, ans, line, x);
				break;
			case 2:
				Metod2(0, ans, line, x);
				break;
			case 3:
				Metod4(0, ans, line, x);
				break;
			}

		} while (reader.ready());

		System.out.println(ans[0]);

	}

	private static void Metod4(int number, int[] ans, String line, int[] x) {
		// ищем окончание - '
		for (int i = number; i < line.length() - 1; i++) {

			String s = line.charAt(i) + "";
			if (s == "'") {
				Metod0(i + 1, ans, line, x);
				return;
			}

		}

	}

	private static void Metod2(int number, int[] ans, String line, int[] x) {
		// ищем окончание - *)
		for (int i = number; i < line.length() - 1; i++) {
			if (line.charAt(i) == '*')
				if (line.charAt(i + 1) == ')') {
					x[2]--;
					if (x[2] == 0) {
						ans[0]++;
						ans[1]=0;
						Metod0(i + 2, ans, line, x);
						return;
					}
				}

			if (line.charAt(i) == '(')
				if (line.charAt(i + 1) == '*') {
					x[2]++;

				}

		}
		ans[2] = 0;
		ans[1] = 2;

	}

	private static void Metod1(int number, int[] ans, String line, int[] x) {
		// ищем нокончание 1-ого коентамрия "}"
		for (int i = number; i < line.length() - 1; i++) {
			if (line.charAt(i) == '}') {
				x[1]--;
				if (x[1] == 0) {
					ans[0]++;
					ans[1]=0;
					Metod0(i + 1, ans, line, x);
					return;
				}
			}
			if (line.charAt(i) == '{')
				x[1]++;

		}
		ans[2] = 0;
		ans[1] = 1;
	}

	public static void Metod0(int number, int[] ans, String line, int[] x) {
		// ищем начало какого то коментария
		for (int i = number; i < line.length() - 1; i++) {

			int k = Helper_288.FindhAVEkOMENTARII_bEGAN(line.charAt(i),
					line.charAt(i + 1));
			if (k == 3)
				continue;
			if (k == 0) {
				// нашли апостроф 1-ого типа
				ans[0]++;
				ans[1] = 0;
				ans[2] = 0;
				return;
			}
			if (k == 1) {
				// нашли начало апостроф 2-ого типа {
				x[1]++;
				Metod1(i + 1, ans, line, x);
			}
			if (k == 2) {
				// нашли начало апостроф 3-ого типа (*
				x[2]++;
				Metod2(i + 2, ans, line, x);
			}
			if (k == 4) {
				// нашли начало не коментария а - '
				Metod4(i + 1, ans, line, x);

			}
			return;
		}
	}

}
