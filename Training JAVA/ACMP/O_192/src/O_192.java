import java.util.Scanner;

public class O_192 {

	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);
		long u = 0;
		int n = M.nextInt();
		while (true) {
			boolean buz[] = new boolean[260];
			String[] s = new String[n];
			String a = FindA(20, buz);
			String h = a;
			buz = new boolean[26];
			for (int i = 0; i < n; i++)
				s[i] = FindA(4, buz);
			// a = M.nextLine().trim();
			// a="abac";
			// s[0]="ba";
			// s[1]="ac";
			// for (int i = 0; i < n; i++)
			// System.out.print(s[i]+"                      ");
			// System.out.println(a);

			String ans1 = B(n, s, a);
			String ans2 = Helper.BBB(n, s, a);
			System.out.println(u++ + " ");
			/*
			 * System.out.println(h); System.out.println(ans1);
			 * System.out.println(ans2); System.out.println(s[0]);
			 * System.out.println(s[1]);
			 */
			if (!ans1.equals(ans2)) {
				for (int i = 0; i < n; i++)
					System.out.print(s[i] + "         ");
				System.out.println(a);
				for (int i = 0; i < 1000000; i++) {
					h = FindA(1000, buz);
				}

				int t = 9 / 0;
			}
		}
	}

	private static String FindA(int j, boolean[] buz) {
		String s = "";
		int max = 5;
		boolean[] newBuz = new boolean[26];
		for (int i = 0; i < j; i++) {
			int y = (int) (Math.random() * 26);
			if (buz[y]) {
				i--;
				continue;
			}
			if (!newBuz[y]) {
				if (max == 0) {
					i--;
					continue;
				}
				max--;
				newBuz[y] = true;
			}

			char a = (char) ('a' + y);

			s += "" + a;
		}
		for (int i = 0; i < 26; i++)
			if (newBuz[i])
				buz[i] = true;
		return s;
	}

	private static String B(int n, String[] s, String a) {
		int l = a.length();
		boolean[] buzy = new boolean[l];
		boolean[] minus = new boolean[l];
		for (int i = 0; i < n; i++) {
			int change = 1;
			while (change != 0) {
				change = 0;
				a = GO(s[i], s[i].length(), a, l);

			}

		}
		// System.out.print(a + " ");
		return a;
	}

	private static String GO(String rule, int lengthRule, String a, int l) {
		// for(int i=0;i<lengthRule;i++)
		// a+=" ";
		int i = 0;
		while (true) {
			if (i + lengthRule > a.length())
				break;
			int count = 0;
			int j = 0;
			for (; j < lengthRule; j++) {
				if (a.charAt(i + j) == rule.charAt(j)) {
					// count++;
				} else {
					j--;
					break;
				}

			}
			if (j == lengthRule) {

				a = a.substring(0, i) + a.substring(i + j, a.length());
				i -= lengthRule + 1;
				if (i < 0)
					i = 0;
				// i+=lengthRule;
			} else
				i++;

		}

		return a;
	}
}