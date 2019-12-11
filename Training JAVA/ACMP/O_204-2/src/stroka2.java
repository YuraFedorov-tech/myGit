import java.io.PrintWriter;
import java.util.Scanner;

public class stroka2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String Str = in.nextLine();

		int Answear_Int = 0;

		String World;
		for (int i = 1; i < Str.length(); i++) {

			World = Str.substring(0, i) + "*" + Str;
			Answear_Int = prefixFunkcia(World, i);
			if (Answear_Int == 1) {
				Answear_Int = i;
				i = Str.length();
			}
		}
		if(Str.length()==1)
			Answear_Int=1;
		Answear_Int = Answear_Int == -1 ? Str.length() : Answear_Int;
		out.print(Answear_Int);
		out.flush();
	}

	static int prefixFunkcia(String world, int n) {
		int m = world.length();
		int k = 0;
		int y = 0;
		int[] p = new int[m];
		for (int i = 1; i < m; i++) {
			while (k > 0 & world.charAt(k) != world.charAt(i)) {
				k = p[k - 1];

			}

			if (world.charAt(k) == world.charAt(i)) {

				++k;

			} else {
				if (i > m)
					return -1;
			}
			p[i] = k;
			if (i > n) {

				int t = i - n;
				while (t > n)
					t -= n;
				if (k != t & i > n)
					return -1;
			}
		}

		return 1;
	}
}
