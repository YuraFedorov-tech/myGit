import java.util.Scanner;

public class O_626 {

	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);

		int n = M.nextInt();
		String[] s = new String[n];
		String a = M.nextLine().trim();
		for (int i = 0; i < n; i++)
			s[i] = M.nextLine().trim();
		a = M.nextLine().trim();
		B(n, s, a);

	}

	private static void B(int n, String[] s, String a) {
		int l = a.length();
		boolean buzy[] = new boolean[l];
		boolean delete[] = new boolean[l];
		int maybe[] = new int[l];
		Findmaybe(maybe,l);
		for (int i = 0; i < n; i++) {
			if (s[i].equals(""))
				continue;
			GO(s[i], a, l, buzy, delete,maybe);
			Dobuzy(s[i], a, l, buzy);
		}

		String ans = print(a, l, delete);
		System.out.println(ans);
	}

	private static void Findmaybe(int[] maybe, int l) {
	for(int i=0;i<l;i++)
		maybe[i]=i;
		
	}

	private static String print(String a, int l, boolean[] buzy) {
		boolean start = false;
		String ans = "";
		for (int i = 0; i < l; i++) {
			if (!buzy[i]) {
				start = true;
				// System.out.print(a.charAt(i));
				ans += "" + a.charAt(i);
			}

		}

		return ans;
	}

	private static void Dobuzy(String ruls, String a, int l, boolean[] buzy) {
		for (int i = 0; i < l; i++) {
			if (buzy[i])
				continue;
			buzy[i] = FindBuzy(ruls, a.charAt(i));

		}

	}

	private static boolean FindBuzy(String ruls, char charAt) {
		for (int i = 0; i < ruls.length(); i++)
			if (ruls.charAt(i) == charAt)
				return true;

		return false;
	}

	private static void GO(String ruls, String a, int l, boolean[] buzy,
			boolean[] delete, int[] maybe) {

		int m = ruls.length();
		int i = 0;
		int u = 1;
		int min = 0;
		
		int count = 0;
		int[] g = new int[m];
		while (true) {
			if (i >= l)
				break;
			if (i < 0)
				i = 0;
			// if(count==m |i==0)
			if (count == m)
				i = FindFisatPoint(a, l, i, ruls.charAt(0), delete, u, maybe,
						m, min, buzy);
			count = 0;

			if (i == -1)
				break;
			// maybe[i]=true;

			for (int j = 0; j < m; j++) {
				if (i >= l)
					break;
				while (delete[i]) {

					i++;
					if (i == l)
						break;
				}
				if (i >= l)
					break;
				if (buzy[i] & !delete[i])
					min = i;

				if (a.charAt(i) == ruls.charAt(j)) {
					g[j] = i;
					count++;
					i++;
					// delete[i + j] = true;

				} else {
					// if(a.charAt(i)!=ruls.charAt(0))
					i = g[0] + 1;
					g[0]++;
					break;
				}
			}
			if (count == m) {
		//		maybe[g[0]] = true;

				DOdelete(delete, l, g, m,maybe);
				i--;
				continue;
			}

		}



	}

	private static int FindFisatPoint(String a, int l, int j, char charFirst,
			boolean[] delete, int u, int[] maybe, int rulslength, int min,
			boolean[] buzy) {
	if(maybe[j]<=0)
		return j;
		
		int begin = FindBefor(j, charFirst, a, maybe, rulslength, delete, buzy,min);
		// if(begin!=-1)
		// return begin;
		int end =Math.max(begin, min);
		for (int i = end; i < l; i++) {
			if (charFirst == a.charAt(i) & !delete[i])

				return i;
		}
		return -1;
	}

	private static int FindBefor(int j, char charFirst, String a,
			int[] maybe, int rulslength, boolean[] delete, boolean[] buzy, int min) {
int lastMogikan=j;
		int i = j;
		for (; i >= min; i--) {
			if (!delete[i]) {
				rulslength--;
				lastMogikan=i;
			} else
				continue;

			if (buzy[i])
				return i;
if(rulslength==1)
	return i;
		}
		
		return lastMogikan;
	}

	private static void DOdelete(boolean[] delete, int l, int[] g, int m, int[] maybe) {
		for (int i = 0; i < m; i++) {
			delete[g[i]] = true;
			maybe[g[i]]--;
		}

	}

}