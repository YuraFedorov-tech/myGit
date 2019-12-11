
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class O_257_3 {
	public static BigInteger sqrt(BigInteger number, BigInteger trial) {
		BigInteger result = BigInteger.ZERO;
		BigInteger a = result;
		BigInteger b = result;

		boolean first = true;

		while (result.compareTo(trial) != 0) {

			if (!first)
				trial = result;
			else
				first = false;

			result = number.divide(trial).add(trial)
					.divide(BigInteger.valueOf(2));

			if (result.equals(b)) {
				return a;
			}

			b = a;
			a = result;
		}
		return result;

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int j1 = sc.nextInt();
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int c1 = sc.nextInt();

		double j = 1;
		double a = a1 / j1;
		double b = b1 / j1;
		double c = c1 / j1;

		double p = b - a * a / 3;
		double q = c + 2 * a * a * a / 27 - a * b / 3;

		BigInteger pp = BigInteger.valueOf(0);
		BigInteger qq = BigInteger.valueOf(0);
		// pp=Find_PP()

		ArrayList<Double> list = new ArrayList<>();
		if (j1 != 0) {

			list = Find_LIST(list, p, q, a, b, c);
			list = Find_X(list, a);
			pr_LIST(list, j1, a1, b1, c1);

		} else {
			if (a1 == 0 & b1 == 0 & c1 == 0) {
				System.out.print(-1);
			} else {
				if (a1 == 0) {
					System.out.print(-c1);
				} else {
					// решаем дичкрименант

					list = FinfDiskrimenant(a1, b1, c1);
					pr_LIST(list, j1, a1, b1, c1);
				}
			}

		}
	}

	private static void pr_LIST(ArrayList<Double> list, int a, int b, int c,
			int d) {
		ArrayList<Integer> listNew = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			double x = list.get(i);
			int xx = (int) x;
			listNew.add(xx);
		}
		Collections.sort(listNew);
		for (int i = 0; i < listNew.size() - 1; i++)
			if (listNew.get(i) == listNew.get(i + 1))
				listNew.remove(i);

		listNew = proverka(listNew, a, b, c, d);

		System.out.print(listNew.size() + " ");
		for (int i = 0; i < listNew.size(); i++)
			System.out.print(listNew.get(i) + " ");

	}

	private static ArrayList<Integer> proverka(ArrayList<Integer> listNew,
			int a, int b, int c, int d) {
		for (int i = 0; i < listNew.size(); i++) {

			boolean prov = beganProverka(listNew.get(i), a, b, c, d);
			if (!prov) {
				listNew.remove(i);
				i--;
			}
		}
		return listNew;
	}

	private static boolean beganProverka(Integer integer, int a, int b, int c,
			int d) {
		BigInteger n = BigInteger.valueOf(integer);

		BigInteger aa = BigInteger.valueOf(a);
		BigInteger bb = BigInteger.valueOf(b);
		BigInteger cc = BigInteger.valueOf(c);
		BigInteger dd = BigInteger.valueOf(d);
		aa = Umnogit(aa, n, 3);
		bb = Umnogit(bb, n, 2);
		cc = Umnogit(cc, n, 1);
		dd = dd.add(aa);
		dd = dd.add(bb);
		dd = dd.add(cc);
		if (dd == BigInteger.ZERO)
			return true;
		return false;
	}

	private static BigInteger Umnogit(BigInteger aa, BigInteger n, int j) {
		for (int i = 0; i < j; i++) {
			aa = aa.multiply(n);
		}

		return aa;
	}

	private static ArrayList<Double> FinfDiskrimenant(int a, int b, int c) {
		ArrayList<Double> list = new ArrayList<>();

		BigInteger ans1 = BigInteger.valueOf(0);
		BigInteger ans2 = BigInteger.valueOf(0);

		BigInteger aa = BigInteger.valueOf(a);
		BigInteger bb = BigInteger.valueOf(b);
		BigInteger cc = BigInteger.valueOf(c);

		BigInteger d1 = bb.pow(2);
		BigInteger d2 = aa.multiply(BigInteger.valueOf(4));
		d2 = d2.multiply(cc);
		BigInteger d3 = d1.subtract(d2);
		int x = d3.compareTo(BigInteger.valueOf(0));
		if (x == -1)
			return list;
		if (d3 != BigInteger.ZERO)
			d3 = sqrt(d3, BigInteger.valueOf(2));
		ans1 = ans1.subtract(bb);
		ans1 = ans1.subtract(d3);
		//
		// ans1 = ans1.multiply(BigInteger.TEN);
		ans1 = ans1.divide(aa);
		ans1 = ans1.divide(BigInteger.valueOf(2));

		ans2 = ans2.subtract(bb);
		ans2 = ans2.add(d3);
		// ans2 = ans2.multiply(BigInteger.TEN);
		ans2 = ans2.divide(aa);
		ans2 = ans2.divide(BigInteger.valueOf(2));

		double x1 = ans1.intValue();
		double x2 = ans2.intValue();
		list.add(x1);
		if (x1 != x2)
			list.add(x2);

		return list;
	}

	private static ArrayList<Double> Find_X(ArrayList<Double> list, double a) {
		int n = list.size();
		for (int i = 0; i < n; i++) {
			double y = list.get(0);
			double x = y - a / 3;
			list.add(x);
			list.remove(0);
		}
		return list;
	}

	private static ArrayList<Double> Find_LIST(ArrayList<Double> list,
			double p, double q, double a, double b, double c) {
		double Q = Find_Q(q, p, a, b, c);

		if (Q > 0.00005) {
			System.out.print("Q=>0. cчитаем по теореме кардо");// cчитаем по
																// теореме кардо
			list = FindTeoremaKardo(list, Q, q);
			return list;
		}
		// если Q==1 значит действительг=ные корни есть
		double UgolInRadian = Find_UgolInRadian(q, p);
		double ugol1 = Math.toDegrees(UgolInRadian);
		list = Find_list(list, UgolInRadian, q, p);

		return list;
	}

	private static ArrayList<Double> FindTeoremaKardo(ArrayList<Double> list,
			double Q, double q) {
		double A = (-q / 2 + Math.sqrt(Q));
		boolean aaa = false;
		if (A < 0) {
			A = -A;
			aaa = true;
		}
		double tret = 1 / 3;
		double AA = Math.pow(A, tret);
		if (aaa)
			AA = -AA;

		double B = (-q / 2 - Math.sqrt(Q));
		boolean bbb = false;
		if (B < 0) {
			B = -B;
			bbb = true;
		}

		double BB = Math.pow(B, tret);
		if (bbb)
			BB = -BB;
		double d = AA + BB;
		list.add(d);
		return list;
	}

	private static ArrayList<Double> Find_list(ArrayList<Double> list,
			double ugolInRadian, double q, double p) {
		ugolInRadian /= 3;
		double help = 2 * Math.sqrt(-p / 3);
		double y1 = help * Math.cos(ugolInRadian);
		double y2 = help * Math.cos(ugolInRadian + 2 * Math.PI / 3);
		double y3 = help * Math.cos(ugolInRadian - 2 * Math.PI / 3);
		list.add(y1);
		list.add(y2);
		list.add(y3);

		return list;
	}

	private static double Find_UgolInRadian(double q, double p) {
		double cos = ((-q / 2) * 3 / (-p)) * Math.sqrt(-3 / p);
		double ugol = Math.acos(cos);

		return ugol;
	}

	private static double Find_Q(double q, double p, double a, double b,
			double c) {
		double Q1 = (q / 2) * q / 2;
		double Q2 = p * p * p / 27;
		double Q = Q1 + Q2;

		BigInteger pp = BigInteger.valueOf(-2);
		BigInteger qq = BigInteger.valueOf(-3);
	//	pp = FIND_PP(pp, a, b);
	//	qq = FIND_QQ(qq, a, b, c);

		BigInteger Q22=Find_Q2(pp,qq);
		
		// Q=Math.abs(Q);

		return Q;
	}

	private static BigInteger Find_Q2(BigInteger pp, BigInteger qq) {
		BigInteger ans = BigInteger.valueOf(0);
		/*double Q1 = (q / 2) * q / 2;
		double Q2 = p * p * p / 27;
		double Q = Q1 + Q2;*/
		ans=qq;
		ans=ans.multiply(qq);
		ans=ans.divide(BigInteger.valueOf(4));
		BigInteger ans1 = BigInteger.valueOf(0);
		ans1=pp;
		ans1=ans1.multiply(pp);
		ans1=ans1.multiply(pp);
		ans1=ans1.divide(BigInteger.valueOf(27));
		ans=ans.add(ans1);
		return ans;
	}

	private static BigInteger FIND_QQ(BigInteger qq, double a, double b,
			double c) {
		BigInteger aa = BigInteger.valueOf((long) a);
		BigInteger bb = BigInteger.valueOf((long) b);
		BigInteger cc = BigInteger.valueOf((long) c);

		qq = cc;
		BigInteger q2 = BigInteger.valueOf(2);
		q2 = q2.multiply(aa);
		q2 = q2.multiply(aa);
		q2 = q2.multiply(aa);
		q2 = q2.divide(BigInteger.valueOf(27));

		BigInteger q3 = aa;
		q3 = q3.multiply(bb);
		q3 = q3.divide(BigInteger.valueOf(3));

		qq = qq.add(q2);
		qq = qq.subtract(q3);
		return qq;
	}

	private static BigInteger FIND_PP(BigInteger pp, double a, double b) {
		BigInteger aa = BigInteger.valueOf((long) a);
		BigInteger bb = BigInteger.valueOf((long) b);
		pp = pp.add(bb);

		BigInteger p2 = BigInteger.valueOf(0);
		p2 = aa;
		p2 = p2.multiply(aa);
		p2 = p2.divide(BigInteger.valueOf(3));
		pp = pp.subtract(p2);
		return pp;
	}

}