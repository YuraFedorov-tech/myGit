import java.util.Scanner;

public class O_425 {
	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		int w = M.nextInt();
		int e = M.nextInt();

		B(n, w, e);

	}

	private static void B(int n, int w, int e) {
		double[] a = { 0, 0 };
		int ans[] = { 0 };
		FindA(a, n, w, e, ans);
		long newAns[] = { 0 };
		int tochnost = 1000;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				double y[] = { 0, 0 };
				double x[] = { 0, 0 };
				FINDYX(i, j, x, y);
				if (ans[0] == 1) {
					FindParalel_Os_X(x, y, newAns, a);
					continue;
				}
				if (ans[0] == 2) {
					FindParalel_Os_Y(x, y, newAns, a);
					continue;
				}
				chekFour(x, y, newAns, a, tochnost);
		/*	long []	xx={200,300};
			long []	yy={0,120};	
				chekFour(xx, yy, newAns, a, tochnost);*/

			}
		}
		System.out.println(newAns[0]);
	}

	private static void chekFour(double[] x, double[] y, long[] newAns, double[] a,
			int tochnost) {
		double newX = FindNewX(y[0], a);
		boolean chek = Compear(newX, x, tochnost);
		if (chek) {
			newAns[0]++;
			return;
		}
		newX = FindNewX(y[1], a);
		chek = Compear(newX, x, tochnost);
		if (chek) {
			newAns[0]++;
			return;
		}

		double newY = FindNewY(x[0], a);
		chek = Compear(newY, y, tochnost);
		if (chek) {
			newAns[0]++;
			return;
		}
		newY = FindNewY(x[1], a);
		chek = Compear(newY, y, tochnost);
		if (chek) {
			newAns[0]++;
			return;
		}

	}

	private static double FindNewY(double x, double[] a) {

		return a[0] * x + a[1];
	}

	private static boolean Compear(double newX, double[] x, int tochnost) {
	if(newX>=x[0] &newX<=x[1])
		return true;
		
		for (int i = 0; i < 2; i++) {
			double standart = x[i];
			double s = Math.abs(((newX - standart) / standart) * tochnost);
			int t = (int) s;
			if (t == 0)
				return true;

		}

		return false;
	}

	private static double FindNewX(double y, double[] a) {

		return (double)((y-a[1])/a[0]);
	}

	private static void FindParalel_Os_Y(double[] x, double[] y, long[] newAns,
			double[] a) {
		if (a[0] >= x[0] & a[0] <= x[1])
			newAns[0]++;
		System.out.println("sdgfsdf");
	}

	private static void FindParalel_Os_X(double[] x, double[] y, long[] newAns,
			double[] a) {
		if (a[0] >= y[0] & a[0] <= y[1])
			newAns[0]++;
		
	}

	private static void FINDYX(int i, int j, double[] x, double[] y) {
		x[0] = 100 * i;
		y[0] = 100 * j;
		x[1] = 100 * i - 100;
		y[1] = 100 * j - 100;

		if (x[1] < x[0]) {
			double t = x[0];
			x[0] = x[1];
			x[1] = t;
		}
		if (y[1] < y[0]) {
			double t = y[0];
			y[0] = y[1];
			y[1] = t;
		}

	}

	private static void FindA(double[] a, int n, int w, int e, int[] ans) {
		double x1 = 0;
		double y1 = w;
		double x2 = 100 * n;
		double y2 = e;

		if (x1 == x2) {
			ans[0] = 2;

			a[0] = x1;
			return;

		}
		if (y1 == y2) {
			ans[0] = 1;
			a[0] = y1;

			return;
		}
		a[0] = (double)((y2 - y1) / (x2 - x1));
		a[1] = (double)(y1-x1 / (x2 - x1) );

	}
}
