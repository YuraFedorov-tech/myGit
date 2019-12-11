import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main { // Main

	public static void main(String[] args) {

		// 1b. Чтение стандартного ввода:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		// System.out.print("Enter a line:");
		try {
			String s = stdin.readLine();

			int n = Integer.valueOf(s);

			int coordinate[][] = new int[n][2];
			int coordinate2[][] = new int[n][2];
			long input = System.currentTimeMillis();
			System.out.println(input);
			for (int i = 0; i < n; i++) {
				s = stdin.readLine();

				String s1[] = s.split(" ");

				coordinate[i][0] = Integer.valueOf(s1[0]);
				coordinate[i][1] = Integer.valueOf(s1[1]);
			}
			long inputEnd = System.currentTimeMillis();
			System.out.println(inputEnd - input);

			// fyhjkdgk
			coordinate2 = DoNormal_coordinate(coordinate, coordinate2);
			long q = System.currentTimeMillis();
			System.out.println(q - inputEnd);
			coordinate2 = Work.Sort(coordinate2);
			long w = System.currentTimeMillis();
			System.out.println(w - q);
			// сортировка происходит по координате х
			long ans[] = new long[1];
			int[][] triangle = new int[3][2];
			// /////////////////////////////////////////////////////////////
			// ////////////////////////////////////////////////////////////////
			// ////////////////////////////////////////////////////////////
			boolean buzy[] = new boolean[n];
			for (int i = 0; i < n - 2; i++) {
				buzy[i]=true;
				for (int i1 = i + 1; i1 < n - 1; i1++) {
					buzy[i1]=true;
					for (int i11 = i1 + 1; i11 < n; i11++) {
						buzy[i11]=true;
						triangle[0] = coordinate2[i];
						triangle[1] = coordinate2[i1];
						triangle[2] = coordinate2[i11];

						int newAns = FindNumber(triangle[0][0], triangle[0][1],
								triangle[1][0], triangle[1][1], triangle[2][0],
								triangle[2][1], coordinate2,buzy);
						 System.out.println(newAns);
						ans[0] += newAns;
						System.out.println(i + "\t" + i1 + "\t" + i11 + "\t"
								+ newAns);
						buzy[i11]=false;;
					}
					buzy[i1]=false;
				}
				buzy[i]=false;
			}
			// /////////////////////////////////////////////////////////
			// ////////////////////////////////////
			System.out.println(ans[0]);
			long qq = System.currentTimeMillis();
			System.out.println(qq - w);

		} catch (IOException ex) {
			System.out.println("Reading error");
		}

	}

	private static int[][] DoNormal_coordinate(int[][] oldK, int[][] newK) {
		boolean xMore = FindLireXOrY(oldK);
		// ЕСЛИ ПРАВДА ЗНАИТ КОЛ-ВО Х-ОВ БОЛЬШЕ И НЕ МЕНЯЕМ ИХ МЕСТАМИ
		if (!xMore) {
			newK = Work.ChangeXAndY(newK, oldK);
		} else
			newK = Arrays.copyOf(oldK, oldK.length);

		return newK;
	}

	private static boolean FindLireXOrY(int[][] oldK) {
		// ЕСЛИ ПРАВДА ЗНАИТ КОЛ-ВО Х-ОВ БОЛЬШЕ И НЕ МЕНЯЕМ ИХ МЕСТАМИ
		int x = FindKol_Vo_x(0, oldK);
		int y = FindKol_Vo_x(1, oldK);
		if (x >= y)
			return true;
		return false;
	}

	private static int FindKol_Vo_x(int n, int[][] oldK) {
		ArrayList<Integer> list = new ArrayList<>();

		int x = oldK.length;
		for (int i = 0; i < x; i++) {
			boolean may = Work.MayAddInList(list, oldK[i][n], i);
		}

		return list.size();
	}



	private static int FindNumber(int x1, int y1, int x2, int y2, int x3,
			int y3, int[][] coordinate, boolean[] buzy) {
		// if(coordinate.length==3)
		// return 1;
		int ans = 0;
		double l1 = FindLength(x1, y1, x2, y2);
		double l2 = FindLength(x2, y2, x3, y3);
		double l3 = FindLength(x1, y1, x3, y3);
		
		
		double sTriangle = FindSqwear(l1,l2,l3);
		for (int i = 0; i < coordinate.length; i++) {
if(buzy[i])
	continue;
			if (coordinate[i][0] < x1)
				continue;
			if (coordinate[i][0] >= x3)
				break;

			int tt = PointInsidTriangle(x1, y1, x2, y2, x3, y3,
					coordinate[i][0], coordinate[i][1],l1,l2,l3,sTriangle);
			if (tt == 0) {
				return ans;
			}
		}
		ans += 1;

		return ans;
	}

	private static int PointInsidTriangle(int x1, int y1, int x2, int y2,
			int x3, int y3, int xTree, int yTree, double l1, double l2, double l3, double sTriangle) {
		boolean outside = FindOutsid(y1, y2, y3, yTree);// если
														// правда
														// то
														// дерево
														// возможно
														// в
														// треугольнике
		if (!outside)
			return 1;

		outside = GoodSite(x1, y1, x2, y2, x3, y3, xTree, yTree,sTriangle,l1,l2,l3); // если
																	// участок
																	// хороший,
																	// если тру
																	// то дерево
																	// за
																	// пределами
																	// треугольника
		if (outside)
			return 1;

		return 0;
	}

	private static boolean GoodSite(int x1, int y1, int x2, int y2, int x3,
			int y3, int xTree, int yTree, double sTriangle, double l1, double l2, double l3) {
		
		
		
		double a = FindSqwear(x1, y1, xTree, yTree, x2, y2,l1);
	//	if (a > sTriangle)
	//		return true;
		double b = FindSqwear(x2, y2, xTree, yTree, x3, y3,l2); // если участок
	//	if (a + b > sTriangle)
	//		return true; // хороший, если
		// тру то дерево
		// за пределами
		// треугольника
		double c = FindSqwear(x3, y3, xTree, yTree, x1, y1,l3);
	    double a1=FindSqwearIn_sqwear(x1, y1, x2, y2);
		double b1=FindSqwearIn_sqwear(x2, y2,x3,y3);
		double c1=FindSqwearIn_sqwear(x3,y3,x1,y1);
	
			
		double summa1 = a1 + b1 + c1;
		if(summa1<0)
			summa1=-summa1;
		double summa = a + b + c;
		findDelta(summa1,summa,x1, y1, x2, y2,x3,y3, xTree, yTree);
		
		double delta = sTriangle - summa;
		if (delta < 0)
			delta = -delta;
		delta *= 100_000;
		int y = (int) Math.round(delta);

		if (y == 0)
			return false;
		return true;
	}

	private static void findDelta(double d, double c, int x1, int y1, int x2, int y2, int x3, int y3, int xTree, int yTree) {
int y=(int) (((d-c)*1000));
		if(y!=0){
			while(true){
			System.out.println("mistake");
			System.out.println(x1+"\t"+x2+"\t"+x3+"\t"+xTree+"\t");
			}
		}
	}

	private static double FindSqwearIn_sqwear(double x1, double y1, double x2, double y2) {
double sqwear=0;
y1+=20000;
y2+=20000;

sqwear=(x2-x1)*y1+((x2-x1)*(y2-y1)/2);

		
		
		return sqwear;
	}

	private static double FindSqwear(int x1, int y1, int x2, int y2, int x3,
			int y3, double c) {

		double a = FindLength(x1, y1, x2, y2);
		double b = FindLength(x2, y2, x3, y3);
	 c = FindLength(x1, y1, x3, y3);

		double sqwear = FindSqwear(a, b, c);

		return sqwear;
	}

	private static double FindSqwear(double a, double b, double c) {
		double p = (a + b + c) / 2;

		double sqwear = p * (p - a) * (p - b) * (p - c);
		sqwear = Math.sqrt(sqwear);

		return sqwear;
	}

	private static double FindLength(int x1, int y1, int x2, int y2) {
		double x = x2 - x1;
		x *= x;
		double y = y2 - y1;
		y *= y;

		return Math.sqrt(x + y);
	}

	private static boolean FindOutsid(int y1, int y2, int y3, int yTree) {
		// если правда то дерево djpvk;yj в треугольнике
		// int xMin = FindXMIN(x1, x2, x3);
		int yMin = FindXMIN(y1, y2, y3);

		// int xMax = FindXMax(x1, x2, x3);
		int yMax = FindXMax(y1, y2, y3);

		if (yTree >= yMin & yTree <= yMax)
			return true;

		return false;
	}

	private static int FindXMax(int x1, int x2, int x3) {
		int xMax = Math.max(x1, x2);
		xMax = Math.max(xMax, x3);
		return xMax;
	}

	private static int FindXMIN(int x1, int x2, int x3) {
		int xMin = Math.min(x1, x2);
		xMin = Math.min(xMin, x3);
		return xMin;
	}

}
