import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class O_353_3 {
	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = my.nextInt();
		}
		Arrays.sort(a);
		double[] ans = { -1 };
		boolean[] buzy = new boolean[n];
		FindFirstCut(ans, n, a, buzy);
		if (ans[0] != -1) {
			prin(ans[0]);
		} else
			System.out.println(0);
	}

	private static void prin(double d) {
	//	System.out.println(d);
		double newDouble = d*1000;
		newDouble=(int)newDouble;
		newDouble/=1000;
		// System.out.println(newDouble);

		// d=25.444444544444444444449;
		double x = Helper_353.Do_X(newDouble, d);
		newDouble += x;
		NewPrint(newDouble, d);

	}

	private static void NewPrint(double newDouble, double d) {

		String str = Double.toString(newDouble);

		int x = 300;
		for (int i = 0; i < str.length(); i++) {
			x--;
			System.out.print(str.charAt(i));
			if (str.charAt(i) == '.')
				x = 3;
if(x==0)
	return;
		}
		for (int i = 0; i < x; i++) {
			System.out.print(0);
		}

	}

	private static void FindFirstCut(double[] ans, int n, int[] a,
			boolean[] buzy) {
		for (int i = 0; i < n; i++) {
			if (buzy[i])
				continue;
			buzy[i] = true;
			FindSecondCut(ans, n, a, i, buzy);
			buzy[i] = false;
			;
		}

	}

	// FindFirstCut

	private static void FindSecondCut(double[] ans, int n, int[] a, int i1,
			boolean[] buzy) {
		for (int i = i1; i < n; i++) {
			if (buzy[i])
				continue;
			buzy[i] = true;
			FindTherdCut(ans, n, a, i1, i, buzy);
			buzy[i] = false;
			;
		}

	}

	private static void FindTherdCut(double[] ans, int n, int[] a, int i1,
			int i2, boolean[] buzy) {
		double terac[] = { -1, -1 };
		for (int i = i2; i < n; i++) {
			if (buzy[i])
				continue;
			buzy[i] = true;
			FindSqwear(ans, n, a, i1, i2, i, terac);
			buzy[i] = false;
			if (terac[1] != 0 & terac[0] != 0) {
				if (terac[1] < terac[0])
					break;
			}

		}
double a1=terac[0];
if(terac[1] > terac[0])
		a1=terac[1];
	if(a1>ans[0])
		ans[0]=a1;
		
		
	}

	private static void FindSqwear(double[] ans, int n, int[] a, int i1,
			int i2, int i3, double[] terac) {
		int x = a[i1];
		int y = a[i2];
		int z = a[i3];
		if (x + y <= z)
			return;
		if (z + y <= x)
			return;
		if (z + x <= y)
			return;

		double pretendent = Geron.FindSqwearTreangle(x, y, z);
		terac[1] = terac[0];
		terac[0] = pretendent;

	}

}