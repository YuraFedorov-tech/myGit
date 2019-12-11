import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_257_2 {
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

	private static BigInteger[] ToNull(BigInteger[] big1, int a, int b, int c,
			int d) {
		// for(int i=0;i<3;i++)
		// big1[i]=BigInteger.valueOf(0);
		big1[0] = BigInteger.valueOf(a);
		big1[1] = BigInteger.valueOf(b);
		big1[2] = BigInteger.valueOf(c);
		big1[3] = BigInteger.valueOf(d);
		return big1;
	}

	private static BigInteger Find_BigSumma(BigInteger[] big1, int i,
			BigInteger bigSumma) {
		BigInteger[] BigIII = new BigInteger[4];
		BigIII[0] = BigInteger.valueOf(1);
		BigIII[1] = BigInteger.valueOf(1);
		BigIII[2] = BigInteger.valueOf(1);
		BigIII[3] = BigInteger.valueOf(i);

		BigIII[0] = Umnogit(BigIII[0], BigIII[3], 3);
		BigIII[1] = Umnogit(BigIII[1], BigIII[3], 2);
		BigIII[2] = Umnogit(BigIII[2], BigIII[3], 1);
		bigSumma = Find_bigSumma(big1, bigSumma, BigIII);

		return bigSumma;
	}

	private static BigInteger Umnogit(BigInteger bigInteger,
			BigInteger bigInIII, int i) {
		for (int j = 0; j < i; j++) {
			bigInteger = bigInteger.multiply(bigInIII);

		}
		return bigInteger;
	}

	private static BigInteger Find_bigSumma(BigInteger[] big1,
			BigInteger bigSumma, BigInteger[] bigIII) {
		for (int i = 0; i < 3; i++)
			big1[i] = big1[i].multiply(bigIII[i]);

		for (int i = 0; i < 4; i++)
			bigSumma = bigSumma.add(big1[i]);
		return bigSumma;
	}

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> extrenum = new ArrayList<>();
		int a = my.nextInt();
		int b = my.nextInt();
		int c = my.nextInt();
		int d = my.nextInt();

		boolean answear = false;
		if (a == 0 & b != 0) {
			list = Find_Diskriinant(list, b, c, d);
			list = DoGood(list);
			printList(list);
			answear = true;
		}
		/*
		 * for(int i =-20000;i<200000;i++){ BigInteger[] Big1 = new
		 * BigInteger[4]; Big1 = ToNull(Big1, a, b, c, d); BigInteger BigSumma
		 * =BigInteger.valueOf(0); ; BigSumma=Find_BigSumma(Big1,i,BigSumma);
		 * if(BigSumma==BigInteger.ZERO) list.add(i); }
		 */
		if (a == 0 & b == 0 & c == 0 & d == 0) {

			System.out.print(-1);

		} else {

			if (!answear) {
				int umnogitAt10[] = { 10 };
				extrenum = Find_extrenumPoint(extrenum, a, b, c, umnogitAt10);
				BigInteger[] BigSuummsExtrenum = new BigInteger[extrenum.size()];
				extrenum = ProverkaMoreLessNull(extrenum, a, b, c, d,
						BigSuummsExtrenum, umnogitAt10);

				ArrayList<Integer> new_Extrenum_without0 = new ArrayList<>();
				// list = Find_new_Extrenum_without0(new_Extrenum_without0,
				// extrenum,
				// BigSuummsExtrenum, list);
				list = GO_TO_rekursia(list, extrenum, BigSuummsExtrenum, a, b,
						c, d, umnogitAt10);
				list = DoGood(list);
				// list=Collections.sort(list);

				printList(list);
			}
		}

	}

	private static ArrayList<Integer> Find_Diskriinant(ArrayList<Integer> list,
			int a, int b, int c) {

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
	//	ans1 = ans1.multiply(BigInteger.TEN);
		ans1 = ans1.divide(aa);
		ans1 = ans1.divide(BigInteger.valueOf(2));
		double x11 = (double) (-bb.intValue() + d3.intValue())
				/ (aa.intValue());
		x11 /= 2;

		ans2 = ans2.subtract(bb);
		ans2 = ans2.add(d3);
	//	ans2 = ans2.multiply(BigInteger.TEN);
		ans2 = ans2.divide(aa);
		ans2 = ans2.divide(BigInteger.valueOf(2));
		double x22 = (double) (-bb.intValue() - d3.intValue())
				/ (aa.intValue());
		x22 /= 2;

	/*	BigInteger ans11 = BigInteger.valueOf(0);
		ans11 = ans1.abs();
		int yes1 = ans11.compareTo(BigInteger.TEN);
		BigInteger ans22 = BigInteger.valueOf(0);
		ans22 = ans2.abs();
		int yes2 = ans22.compareTo(BigInteger.TEN);*/

		int x1 = ans1.intValue();
		
		int x2 = ans2.intValue();
		
		list.add(x1);
		list.add(x2);

		return list;
	}

	private static void printList(ArrayList<Integer> list) {
		System.out.print(list.size() + " ");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}

	private static ArrayList<Integer> GO_TO_rekursia(ArrayList<Integer> list,
			ArrayList<Integer> extrenum, BigInteger[] bigSuummsExtrenum, int a,
			int b, int c, int d, int[] umnogitAt10) {
		for (int i = 0; i < extrenum.size() - 1; i++) {
			/*
			 * if(bigSuummsExtrenum[i+1]==BigInteger.ZERO){
			 * list.add(extrenum.get(i+1)); i++; continue; }
			 * if(bigSuummsExtrenum[i]==BigInteger.ZERO){
			 * list.add(extrenum.get(i)); i++; continue; }
			 */
			int x1 = bigSuummsExtrenum[i].compareTo(BigInteger.ZERO);
			int x2 = bigSuummsExtrenum[i + 1].compareTo(BigInteger.ZERO);
			if (x1 == x2)
				continue;
			int left = extrenum.get(i);
			int right = extrenum.get(i + 1);

			if (i != 0 & i != extrenum.size() - 1)
				left /= umnogitAt10[0];
			if (i + 1 != 0 & i + 1 != extrenum.size() - 1)
				right /= umnogitAt10[0];

			int midle = FindMiddle(left, right);
			if (left == 0) {
				BigInteger[] Big1 = new BigInteger[4];
				Big1 = ToNull(Big1, a, b, c, d);
				BigInteger BigSumma = BigInteger.valueOf(0);
				;

				BigSumma = Find_BigSumma(Big1, 0, BigInteger.valueOf(0));
				if (BigSumma == BigInteger.valueOf(0))
					list.add(0);

			}

			list = rekursia(list, bigSuummsExtrenum[i],
					bigSuummsExtrenum[i + 1], left, right, midle, a, b, c, d);
		}

		return list;
	}

	private static int FindMiddle(int left, int right) {
		BigInteger l = BigInteger.valueOf(left);
		BigInteger r = BigInteger.valueOf(right);
		BigInteger l_old = BigInteger.valueOf(left);

		l = l.subtract(l_old);
		r = r.subtract(l_old);
		r = r.multiply(BigInteger.valueOf(53));
		r = r.divide(BigInteger.valueOf(100));
		r = r.add(l_old);

		int ans = r.intValue();
		return ans;
		/*
		 * l=l.add(r); l=l.multiply(BigInteger.valueOf(53));
		 * l=l.divide(BigInteger.valueOf(100)); int ans=l.intValue();
		 * 
		 * 
		 * 
		 * return ans;
		 */

	}

	private static ArrayList<Integer> rekursia(ArrayList<Integer> list,
			BigInteger bigIntegerLeft, BigInteger bigIntegerRight, int left,
			int right, int midle, int a, int b, int c, int d) {
		BigInteger[] Big1 = new BigInteger[4];
		Big1 = ToNull(Big1, a, b, c, d);
		BigInteger BigSumma = BigInteger.valueOf(0);
		;

		BigSumma = Find_BigSumma(Big1, midle, BigInteger.valueOf(0));
		if (BigSumma == BigInteger.ZERO) {
			list.add(midle);
			return list;
		}
		BigInteger chek = BigInteger.valueOf(0);
		int x1 = bigIntegerLeft.compareTo(BigInteger.ZERO);
		/*
		 * chek=chek.add(bigIntegerRight); if(x1==1)
		 * chek=chek.add(BigInteger.valueOf(1)); if(x1==-1)
		 * //chek=chek.add((BigInteger) valueOf(-1));
		 * chek=chek.subtract(BigInteger.valueOf(1)); if(bigIntegerLeft==chek)
		 * return list;
		 */
		if (left == midle | right == midle)
			return list;

		int x = BigSumma.compareTo(BigInteger.ZERO);

		if (x1 == 1 & x == 1 | x1 == -1 & x == -1) {
			int newMmidle = FindMiddle(midle, right);

			list = rekursia(list, BigSumma, bigIntegerRight, midle, right,
					newMmidle, a, b, c, d);
		}

		if ((x1 == 1 & x == -1) | (x1 == -1 & x == 1)) {
			int newMmidle = FindMiddle(left, midle);
			list = rekursia(list, bigIntegerLeft, BigSumma, left, midle,
					newMmidle, a, b, c, d);

		}

		return list;
	}

	private static ArrayList<Integer> Find_new_Extrenum_without0(
			ArrayList<Integer> new_Extrenum_without0,
			ArrayList<Integer> extrenum, BigInteger[] bigSuummsExtrenum,
			ArrayList<Integer> list) {

		if (extrenum.size() == 3 & bigSuummsExtrenum[1] == BigInteger.ZERO) {
			list.add(extrenum.get(1));
			extrenum.remove(0);
			extrenum.remove(0);
			extrenum.remove(0);

			return list;
		}
		if (extrenum.size() == 4 & bigSuummsExtrenum[1] == BigInteger.ZERO) {
			list.add(extrenum.get(1));
			extrenum.remove(0);
			extrenum.remove(0);
			return list;
		}
		if (extrenum.size() == 4 & bigSuummsExtrenum[2] == BigInteger.ZERO) {
			list.add(extrenum.get(2));
			extrenum.remove(3);
			extrenum.remove(3);
			return list;
		}

		return list;
	}

	private static ArrayList<Integer> DoGood(ArrayList<Integer> list) {
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i++)
			if (list.get(i) == list.get(i + 1))
				list.remove(i);
		return list;
	}

	private static ArrayList<Integer> Find_extrenumPoint(
			ArrayList<Integer> extrenum, long a, long b, long c,
			int[] umnogitAt10) {
		extrenum.add(Integer.MIN_VALUE);
		extrenum.add(Integer.MAX_VALUE);
		if (a == 0 & b == 0)
			return extrenum;
		// extrenum.add(-300);
		// extrenum.add(300);
		BigInteger aa = BigInteger.valueOf(a);
		BigInteger bb = BigInteger.valueOf(b);
		BigInteger cc = BigInteger.valueOf(c);
		aa = aa.multiply(BigInteger.valueOf(3));
		bb = bb.multiply(BigInteger.valueOf(2));
		long aExtrenum = a * 3;
		long bExtrenum = b * 2;
		if (aExtrenum == 0) {
			extrenum.add(1, (int) (-c / bExtrenum));
			return extrenum;
		}

		// extrenum = Find_diskriminaint_Uravnenie(extrenum, aExtrenum,
		// bExtrenum, c,umnogitAt10);
		extrenum = Find_diskriminaint_Uravnenie(extrenum, aa, bb, cc,
				umnogitAt10);
		return extrenum;
	}

	private static ArrayList<Integer> Find_diskriminaint_Uravnenie(
			ArrayList<Integer> extrenum, BigInteger aa, BigInteger bb,
			BigInteger cc, int[] umnogitAt10) {

		BigInteger ans1 = BigInteger.valueOf(0);
		BigInteger ans2 = BigInteger.valueOf(0);
		BigInteger d1 = bb.pow(2);
		BigInteger d2 = aa.multiply(BigInteger.valueOf(4));
		d2 = d2.multiply(cc);
		BigInteger d3 = d1.subtract(d2);
		int x = d3.compareTo(BigInteger.valueOf(0));
		if (x == -1)
			return extrenum;
		if (d3 != BigInteger.ZERO)
			d3 = sqrt(d3, BigInteger.valueOf(2));
		ans1 = ans1.subtract(bb);
		ans1 = ans1.subtract(d3);
		//
		ans1 = ans1.multiply(BigInteger.TEN);
		ans1 = ans1.divide(aa);
		ans1 = ans1.divide(BigInteger.valueOf(2));
		double x11 = (double) (-bb.intValue() + d3.intValue())
				/ (aa.intValue());
		x11 /= 2;

		ans2 = ans2.subtract(bb);
		ans2 = ans2.add(d3);
		ans2 = ans2.multiply(BigInteger.TEN);
		ans2 = ans2.divide(aa);
		ans2 = ans2.divide(BigInteger.valueOf(2));
		double x22 = (double) (-bb.intValue() - d3.intValue())
				/ (aa.intValue());
		x22 /= 2;

		BigInteger ans11 = BigInteger.valueOf(0);
		ans11 = ans1.abs();
		int yes1 = ans11.compareTo(BigInteger.TEN);
		BigInteger ans22 = BigInteger.valueOf(0);
		ans22 = ans2.abs();
		int yes2 = ans22.compareTo(BigInteger.TEN);
		if ((yes1 == 1 | ans1 == BigInteger.ZERO)
				& (yes2 == 1 | ans2 == BigInteger.ZERO)) {
			umnogitAt10[0] = 1;
			ans1 = ans1.divide(BigInteger.TEN);
			ans2 = ans2.divide(BigInteger.TEN);
		}

		int x1 = ans1.intValue();
		;
		int x2 = ans2.intValue();
		;

		if (x1 != x2) {
			if (x1 > x2) {
				int q = x1;
				x1 = x2;
				x2 = q;
			}
			extrenum.add(1, x1);
			extrenum.add(2, x2);

		} else
			extrenum.add(1, x1);
		return extrenum;
	}

	private static ArrayList<Integer> ProverkaMoreLessNull(
			ArrayList<Integer> extrenum, int a, int b, int c, int d,
			BigInteger[] BigSuummsExtrenum, int[] umnogitAt10) {
		ArrayList<Integer> Point_Y = new ArrayList<>();

		for (int i = 0; i < extrenum.size(); i++) {
			BigInteger[] Big1 = new BigInteger[4];
			Big1 = ToNull(Big1, a, b, c, d);
			BigInteger BigSumma = BigInteger.valueOf(0);
			;
			int send = extrenum.get(i);
			if (i != 0 & i != extrenum.size() - 1)
				send /= umnogitAt10[0];
			BigSuummsExtrenum[i] = Find_BigSumma(Big1, send, BigSumma);

		}
		/*
		 * for (int i = BigSuummsExtrenum.length - 1; i > 0; i--) { BigInteger
		 * Big111 = BigInteger.valueOf(0); ; BigInteger Big222 =
		 * BigInteger.valueOf(0); Big111 = BigSuummsExtrenum[i].max(Big111);
		 * Big222 = BigSuummsExtrenum[i - 1].max(Big222);
		 * 
		 * BigInteger Big11111 = BigInteger.valueOf(0); ; BigInteger Big22222 =
		 * BigInteger.valueOf(0); Big11111 = BigSuummsExtrenum[i].min(Big11111);
		 * Big22222 = BigSuummsExtrenum[i - 1].min(Big22222); if
		 * ((BigSuummsExtrenum[i] != BigInteger.ZERO | BigSuummsExtrenum[i - 1]
		 * != BigInteger.ZERO)) continue; if ((Big11111 == Big22222 | Big111 ==
		 * Big111)) extrenum.remove(i); }
		 */

		return extrenum;
	}

	private static ArrayList<Integer> Find_diskriminaint_Uravnenie(
			ArrayList<Integer> extrenum, double aExtrenum, double bExtrenum,
			double c, int[] umnogitAt10) {
		double d = bExtrenum * bExtrenum - 4 * aExtrenum * c;
		double d1 = bExtrenum * bExtrenum;
		double d2 = 4 * aExtrenum * c;
		double d3 = d1 - d2;

		if (4 * aExtrenum * c > bExtrenum * bExtrenum)
			return extrenum;
		d = Math.sqrt(d);

		if ((-bExtrenum + d) > 0 & (-bExtrenum + d) < 1)
			umnogitAt10[0] = 10;
		if ((-bExtrenum + d) > -1 & (-bExtrenum + d) < 0)
			umnogitAt10[0] = 10;
		if ((-bExtrenum - d) > 0 & (-bExtrenum - d) < 1)
			umnogitAt10[0] = 10;
		if ((-bExtrenum - d) > -1 & (-bExtrenum - d) < 0)
			umnogitAt10[0] = 10;

		double x11 = (double) ((-bExtrenum + d) / (2 * aExtrenum));
		double x22 = (double) ((-bExtrenum - d) / (2 * aExtrenum));
		int x1 = (int) (x11 * 10);
		int x2 = (int) (x22 * 10);

		if (x1 != x2) {
			if (x1 > x2) {
				int q = x1;
				x1 = x2;
				x2 = q;
			}
			extrenum.add(1, x1);
			extrenum.add(2, x2);

		} else
			extrenum.add(1, x1);
		return extrenum;
	}

}
