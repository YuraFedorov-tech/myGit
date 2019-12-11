import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_262 { // Main

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		ArrayList<Long> list = new ArrayList<Long>();
		int n = my.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(my.nextLong());
		}
		double[] ans = new double[1];
		Collections.sort(list);
		ans = find(ans, list);
		// ans[0]0.1023400025847=0.1023400025847;
		System.out.print(ans[0]);
	//	ans = printing(ans);

	}

	private static double[] moreThen100000(double[] ans) {
		double t = ans[0];
		t = t / 100000;
		int y = (int) (t);
		System.out.print(y);
		t -= y;
		t = t * 100000;
		double m = ans[0] - y * 100000;
		t = okrugl(t);
		ans[0] = t;

		return ans;
	}

	private static double okrugl(double t) {
		int y = (int) t;
		t -= y;
		String str = Double.toString(t);
		str=str.substring(0,4);
	t = Double.valueOf(str);
	//	t = okr(str);
		t += y;

		return t;
	}

	private static double okr(String str) {
		int change = 0;
		int end = 0;
		int next = 0;
		boolean more=false;
		for (int i = str.length() - 1; i >= 4; i--) {
			char ch = str.charAt(i);
			change = ch - '0';
			change += next;
			next = 1;
			if (change < 5)
				next = 0;
			if (i < 3 & next==0)
				break;
if(i==4 & next==1)
	more=true;
		}
		String NEwr=str.substring(0,3);
		
			double an=menyat(NEwr);
		if(more)
			an+=0.01;
			
		return an;
	}

	private static double menyat(String nEwr) {
		Double second = Double.valueOf(nEwr);
		second+=.01;
		
		return second;
	}

	private static double[] printing(double[] ans) {

		ans[0] = 1234567897.9944446;
		if (ans[0] > 1000000)
			ans = moreThen100000(ans);
		double newDouble = ans[0] * 100;
		newDouble = (int) newDouble;
		newDouble /= 100;

		String str = Double.toString(ans[0]);
		int how = how_after_Zapyataya(str);

		switch (how) {
		case 0:
			System.out.print(ans[0] + ".00");
			break;
		case 1:
			System.out.print(ans[0] + "0");
			break;
		case 2:
			System.out.print(ans[0]);
			break;
		default:
			PrNewDouble(newDouble);
		}

		return ans;

	}

	private static void PrNewDouble(double newDouble) {
		String str = Double.toString(newDouble);
		int how = how_after_Zapyataya(str);

		switch (how) {
		case 0:
			System.out.print(newDouble + ".00");
			break;
		case 1:
			System.out.print(newDouble + "0");
			break;
		case 2:
			System.out.print(newDouble);
			break;
		}

	}

	private static int how_after_Zapyataya(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.')
				return str.length() - 1 - i;

		}
		return 0;
	}

	private static double[] find(double[] ans, ArrayList<Long> list) {

		while (true) {
			if (list.size() == 1)
				break;
			ans = plus(list, ans);

		}
		// ans=procentit(ans,list.get(0));

		return ans;
	}

	private static double[] plus(ArrayList<Long> list, double[] ans) {
		long u = list.get(0) + list.get(1);
		ans = procentit(ans, u);

		list.remove(0);
		list.set(0, u);
		list = Sortirovat(list);

		return ans;
	}

	private static double[] procentit(double[] ans, Long u) {

		
		
		ans[0] += u * 0.05;
		return ans;
	}

	private static ArrayList<Long> Sortirovat(ArrayList<Long> list) {
		Collections.sort(list);

		return list;
	}

}
