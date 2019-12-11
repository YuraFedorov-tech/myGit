import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Nebo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[][] x1 = new double[2][n]; // красивые звезды i=1
		double[][] y1 = new double[2][n];
		// double [][]y1 = null;// некрасивые звезды i=2
		int x11 = 0;
		int y11 = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (z == 1) {
				x1[0][x11] = x;
				x1[1][x11] = y;
				x11 += 1;
				continue;
			}
			y1[0][y11] = x;
			y1[1][y11] = y;
			y11 += 1;

		}
		// ищем нижнюю точку

		double[][] xPolar = null;
		double[][] xVipukl = null;
		double[][] yPolar;
		double[][] yVipukl;
		Print ne = new Print();

		if (x11 > 3) {
			int NomerNizKrasiv = findNizPoint(x1, x11);
			double x = x1[0][NomerNizKrasiv];
			double y = x1[1][NomerNizKrasiv];
			x1 = DoNiz0Point(x1, NomerNizKrasiv);
			System.out.println();

			ne.printKoordinat(x1, x11);
			// ne.printKoordinat(x1, x11);
			x1 = ChangeInNoll(x1, x11);

			x1 = okruglit(x1);

			int[] line = new int[1];
			x1 = find_Point2(x1);
			x1 = BildMnogougolnik(x1, x11, line);
			x1 = okruglit(x1);
			ne.printKoordinat(x1, x1[0].length);
			x1 = vozvratIn1Dekart(x1, x, y);
			x11 = x1[0].length;
		} else {
			x1 = okruglitLessThen3(x1, x11);

		}

		ne.printKoordinat(x1, x1[0].length);
		if (y11 > 3) {
			int NomerNizKrasiv = findNizPoint(y1, y11);
			double x = y1[0][NomerNizKrasiv];
			double y = y1[1][NomerNizKrasiv];
			y1 = DoNiz0Point(y1, NomerNizKrasiv);
			System.out.println();

			ne.printKoordinat(y1, y11);
			// ne.printKoordinat(x1, x11);
			y1 = ChangeInNoll(y1, y11);

			y1 = okruglit(y1);

			int[] line = new int[1];
			y1 = find_Point2(y1);
			y1 = BildMnogougolnik(y1, y11, line);
			y1 = okruglit(y1);
			ne.printKoordinat(y1, y1[0].length);
			y1 = vozvratIn1Dekart(y1, x, y);
			y11 = y1[0].length;

		} else {
			y1 = okruglitLessThen3(y1, y11);

		}

		ne.printKoordinat(y1, y1[0].length);

		if (x11 == 3) {
			x1 = proverkaNa1LineAllPointes(x1);
			x11 = x1[0].length;
		}
		if (y11 == 3) {
			y1 = proverkaNa1LineAllPointes(y1);
			y11 = y1[0].length;
		}
		boolean Line = false;
		while (true) {
			if (x11 > 2 & y11 > 2) { // если как минимум 2 треугольника
				Line = oneInOne(x1, x11, y1, y11);
				if (Line) {
					break;
				}
				Line = oneInOne(y1, y11, x1, x11);
				if (Line) {
					break;
				}
			}

			if (x11 > 2 | y11 > 2) {
				double[][] XX;
				double[][] YY;
				XX = x1;
				YY = y1;
				if (x11 <= 2) {
					YY = x1;
					XX = y1;
				}
				Line = oneInOne(XX, XX[0].length, YY, YY[0].length);
				break;
			}
			if ((x11 == 1 & y11 == 1) | (x11 == 0 | y11 == 0)) {
				Line = true;
				break;
			}
			if (x11 == 2 & y11 == 2) {
				Line = twoAndtwo(x1, y1);

				break;
			}
			double[][] XX;
			double[][] YY;
			XX = x1;
			YY = y1;
			if (y11 == 2) {
				YY = x1;
				XX = y1;
			}
			Line=OneAndTwo(XX,YY);
			break;
			
		}
		System.out.println("Line="+!Line);
	}

	private static boolean OneAndTwo(double[][] x1, double[][] y1) {
		double Kx = (x1[1][1] - x1[1][0]) / (x1[0][1] - x1[0][0]);
		double Bx = x1[1][1] - Kx * x1[0][1];
		double X=y1[0][0];
		double Y = y1[1][0];
		if(x1[0][0] !=x1[0][1] ){
			 Y=Kx*X+Bx;
		}else{
			if((Y >= x1[1][0] &Y < x1[1][1]) | (Y<= x1[1][0] & Y > x1[1][1])) {
				return true;
			}
		}
		
		if ((X >= x1[0][0] & X < x1[0][1]) | (X <= x1[0][0] & X > x1[0][1])|
				(Y >= x1[1][0] &Y < x1[1][1]) | (Y<= x1[1][0] & Y > x1[1][1])) {

		} else {
			return false;
		}
		
		Y = new BigDecimal(Y).setScale(4, RoundingMode.UP)
				.doubleValue();
Y=(Y-y1[1][0])/y1[1][0];
Y*=1000;
Y=(int) Y;
Y/=1000;
if(Y==0){
	return true;
}
		
		return false;
	}

	private static boolean twoAndtwo(double[][] x1, double[][] y1) {
		double Kx = (x1[1][1] - x1[1][0]) / (x1[0][1] - x1[0][0]);
		double Bx = x1[1][1] - Kx * x1[0][1];
		double Ky = (y1[1][1] - y1[1][0]) / (y1[0][1] - y1[0][0]);
		double By = y1[1][1] - Ky * y1[0][1];

		double X = (By - Bx) / (Kx - Ky);
		double Yx = Ky * X + By;
		double Xx = Kx * X + Bx;
		double r = (Yx - Xx) / Xx;
		r = r * 10000;
		r = (int) r;
		r /= 10000;

		if ((X > x1[0][0] & X < x1[0][1]) | (X < x1[0][0] & X > x1[0][1])) {

		} else {
			return false;
		}
		if ((X > y1[0][0] & X < y1[0][1]) | (X < y1[0][0] & X > y1[0][1])) {

		} else {
			return false;
		}

		if (r == 0) {
			return true;
		}
		return false;
	}

	private static boolean oneInOne(double[][] x1, int x11, double[][] y1,
			int y11) {
		boolean Inside = false;
		for (int i = 0; i < y11; i++) { // берем по очереди каждубю вершину у1 и
										// проверяем угол в ногоугольнике х1
			int q1 = i;
			double cosin = 0;
			for (int j = 0; j < x11; j++) {
				int q0 = j;
				int q2 = j + 1;
				if (q2 == x11) {
					q2 = 0;
				}
				double cosinI = ProverkaNaVipuklPoint2(x1[0][q0], x1[1][q0],
						y1[0][i], y1[1][i], x1[0][q2], x1[1][q2]);
				// private static double ProverkaNaVipuklPoint2(double x1,
				// double y1,
				// double x2, double y2, double x3, double y3) {
				cosin += cosinI;

			}
			cosin = new BigDecimal(cosin).setScale(3, RoundingMode.UP)
					.doubleValue();
			if (cosin == 360) {
				Inside = true;
				i = y11;

			}

		}

		return Inside;
	}

	private static double[][] proverkaNa1LineAllPointes(double[][] x1) {
		int x11 = 3;
		double k = (x1[1][1] - x1[1][0]) / (x1[0][1] - x1[0][0]);
		double b = x1[1][0] - k * x1[0][0];
		double y3 = k * x1[0][2] + b;
		y3 = (y3 - x1[0][2]) / y3;
		double tt = new BigDecimal(y3).setScale(3, RoundingMode.UP)
				.doubleValue();
		if (y3 == 0) {
			double x000 = x1[0][0];
			double y000 = x1[0][0];
			double x111 = x1[0][1];
			double y111 = x1[0][1];
			double x222 = x1[0][2];
			double y222 = x1[0][2];
			int t = find_min(x000, x111, x222);
			int ttt = find_max(x000, x111, x222);
			double[][] otvet = new double[2][2];
			otvet[0][0] = x1[0][t];
			otvet[1][0] = x1[1][t];
			otvet[0][1] = x1[0][ttt];
			otvet[1][1] = x1[1][ttt];

			return otvet;
		}

		return x1;
	}

	private static int find_max(double x000, double x111, double x222) {
		if (x000 >= x111 & x000 >= x222) {
			return 0;
		}
		if (x111 > x000 & x111 > x222) {
			return 1;
		}

		return 2;
	}

	private static int find_min(double x000, double x111, double x222) {
		if (x000 <= x111 & x000 <= x222) {
			return 0;
		}
		if (x111 < x000 & x111 < x222) {
			return 1;
		}

		return 2;
	}

	private static double[][] vozvratIn1Dekart(double[][] x1, double x, double y) {
		for (int i = 0; i < x1[0].length; i++) {

			x1[0][i] += x;
			x1[1][i] += y;
		}

		return x1;
	}

	private static double[][] okruglitLessThen3(double[][] x1, int x11) {
		double[][] a = new double[2][x11];
		for (int i = 0; i < x11; i++) {
			a[0][i] = new BigDecimal(x1[0][i]).setScale(3, RoundingMode.UP)
					.doubleValue();
			a[1][i] = new BigDecimal(x1[1][i]).setScale(3, RoundingMode.UP)
					.doubleValue();

		}

		return a;
	}

	private static double[][] find_Point2(double[][] x1) {
		double[] A_Sin = new double[x1[0].length];

		for (int i = 1; i < x1[0].length; i++) {
			if (x1[0][i] == 0 & x1[1][i] == 0) {
				continue;
			}
			A_Sin[i] = ProverkaNaVipuklPoint2(x1[0][i], x1[1][i], x1[0][0],
					x1[1][0], 100000, 0);

			double t = A_Sin[i];
			double tt = new BigDecimal(t).setScale(3, RoundingMode.UP)
					.doubleValue();
			A_Sin[i] = tt;
		}
		double MinA = A_Sin[1];
		int m = 1;
		for (int i = 2; i < x1[0].length; i++) {
			if (A_Sin[i] < MinA) {
				MinA = A_Sin[i];
				m = i;
			}

		}

		double x = x1[0][m];
		double y = x1[1][m];
		x1[0][m] = x1[0][1];
		x1[1][m] = x1[1][1];
		x1[0][1] = x;
		x1[1][1] = y;

		return x1;
	}

	private static double ProverkaNaVipuklPoint2(double x1, double y1,
			double x2, double y2, double x3, double y3) {

		double b = line(x1, y1, x2, y2);
		double c = line(x2, y2, x3, y3);
		double a = line(x3, y3, x1, y1);
		double cosg = (b * b + c * c - a * a) / (2 * b * c);
		cosg = Math.acos(cosg);
		System.out.print("угол в радианах=" + cosg);
		cosg = Math.toDegrees(cosg);
		System.out.println("угол в градусах=" + cosg);

		return cosg;
	}

	private static double[][] okruglit(double[][] xVipukl) {
		int m = 1;
		xVipukl[0][0] = new BigDecimal(xVipukl[0][0]).setScale(3,
				RoundingMode.UP).doubleValue();
		xVipukl[1][0] = new BigDecimal(xVipukl[1][0]).setScale(3,
				RoundingMode.UP).doubleValue();
		for (int i = 1; i < xVipukl[0].length; i++) {

			// double newDouble = new BigDecimal(templateDouble).setScale(3,
			// RoundingMode.UP).doubleValue();
			xVipukl[0][i] = new BigDecimal(xVipukl[0][i]).setScale(3,
					RoundingMode.UP).doubleValue();
			xVipukl[1][i] = new BigDecimal(xVipukl[1][i]).setScale(3,
					RoundingMode.UP).doubleValue();
			xVipukl[0][i] = (double) ((int) xVipukl[0][i]);
			xVipukl[0][i] = (double) ((int) xVipukl[0][i]);
			if (xVipukl[1][i] == 0 & xVipukl[0][i] == 0) {

			} else {
				m += 1;
			}

		}
		double[][] Otvet = new double[2][m];
		for (int i = 0; i < m; i++) {
			Otvet[0][i] = xVipukl[0][i];
			Otvet[1][i] = xVipukl[1][i];

		}

		return Otvet;
	}

	private static double[][] BildMnogougolnik(double[][] xPolar, int x11,
			int[] line) {
		double[][] xVipukly = new double[2][xPolar[0].length];
		int t = xPolar[0].length;
		boolean[] used = new boolean[t];
		int KolVershin = 2;
		if (xPolar[0].length >= 3) {
			xVipukly[0][0] = xPolar[0][0];
			xVipukly[1][0] = xPolar[1][0];
			xVipukly[0][1] = xPolar[0][1];
			xVipukly[1][1] = xPolar[1][1];
			int z = 0;

			used[0] = used[1] = true;
			int q0 = 0;
			int q1 = 1;
			int m = 2;
			while (true) {

				int q2 = findQ2(xPolar, used, q0, q1);
				if (q2 == 0) {
					line[0] = m - 1;
					break;
				}
				used[q2] = true;
				q0 = q1;
				q1 = q2;
				xVipukly[0][m] = xPolar[0][q2];
				xVipukly[1][m] = xPolar[1][q2];
				m += 1;

			}

		}

		return xVipukly;
	}

	private static int findQ2(double[][] xPolar, boolean[] used, int q0, int q1) {

		double[] A_Sin = new double[xPolar[0].length];
		int q2 = 0;
		for (int i = 2; i <= xPolar[0].length; i++) {
			if (i == xPolar[0].length) {
				i = 0;
			}
			q2 = i;
			if (used[i] & i != 0) {
				continue;
			}
			A_Sin[i] = ProverkaNaVipukl(xPolar[0][q0], xPolar[1][q0],
					xPolar[0][q1], xPolar[1][q1], xPolar[0][q2], xPolar[1][q2]);

			if (i == 0) {
				i = xPolar[0].length;
			}
		}
		q2 = 0;
		double A_sinMax = 0;
		for (int i = 0; i < xPolar[0].length; i++) {
			if (A_Sin[i] < A_sinMax) {
				q2 = i;
				A_sinMax = A_Sin[i];
			}

		}

		return q2;
	}

	static double ProverkaNaVipukl(double x1, double y1, double x2, double y2,
			double x3, double y3) {
		int z = -1; // true - это ,больше или равно нуля
		double sinAlfa = (-(x2 - x1) * (y3 - y2) + (x3 - x2) * (y2 - y1));
		// double sinAlfa2=Math.sqrt(((x2-x1)(x2-x1)+));
		// double sinAlfa=sinAlfa1/sinAlfa2;
		double q = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		double q1 = Math.sqrt((y3 - y2) * (y3 - y2) + (x3 - x2) * (x3 - x2));
		sinAlfa = sinAlfa / (q * q1);
		sinAlfa = Math.asin(sinAlfa);
		// sinAlfa=Math.toDegrees(sinAlfa);
		double cosAlfa = (x2 - x1) * (x3 - x2) + (y3 - y2) * (y2 - y1);
		cosAlfa = cosAlfa / (q * q1);
		cosAlfa = Math.asin(cosAlfa);
		cosAlfa = Math.toDegrees(cosAlfa);

		if (sinAlfa == 0) { // не ясно, идем дальше

			if (cosAlfa == 90) {
				sinAlfa = -100;
			}

		}
		if (sinAlfa < 0) {
			double b = line(x1, y1, x2, y2);
			double c = line(x2, y2, x3, y3);
			double a = line(x3, y3, x1, y1);
			double cosg = (b * b + c * c - a * a) / (2 * b * c);
			cosg = Math.acos(cosg);
			System.out.print("угол в радианах=" + cosg);
			cosg = Math.toDegrees(cosg);
			System.out.println("угол в градусах=" + cosg);
			sinAlfa = -cosg;
		}

		System.out.println("sinAlfa= " + sinAlfa + "  z= " + z);
		// System.out.println(" ");
		return sinAlfa;
	}

	private static double line(double x2, double y2, double x3, double y3) {
		double l = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
		return l;
	}

	private static double[] sendInPolarPoint(double x, double y) {
		double[] Ry = new double[2];
		Ry[0] = Math.sqrt(x * x + y * y);

		if ((int) (x * 1000) != 0) {
			Ry[1] = Math.toDegrees(Math.atan(y / x));
			if (x > 0 & y >= 0) {
				return Ry;
			}
			if (x > 0 & y < 0) {
				Ry[1] += 360;
				return Ry;
			}
			if (x < 0) {
				Ry[1] += 180;
				return Ry;
			}
		}
		if (y > 0) {
			Ry[1] = 90;
		}
		if (y < 0) {
			Ry[1] = 270;
		}

		return Ry;
	}

	private static double[][] ChangeInNoll(double[][] x1, int x11) {
		double x = x1[0][0];
		double y = x1[1][0];

		for (int i = 0; i < x11; i++) {
			x1[0][i] -= x;
			x1[1][i] -= y;
		}

		return x1;
	}

	private static double[][] DoNiz0Point(double[][] x1, int nomerNizKrasiv) {
		double x = x1[0][0];
		double y = x1[1][0];
		x1[0][0] = x1[0][nomerNizKrasiv];
		x1[1][0] = x1[1][nomerNizKrasiv];
		x1[0][nomerNizKrasiv] = x;
		x1[1][nomerNizKrasiv] = y;

		return x1;
	}

	private static int findNizPoint(double[][] x1, int x11) {
		// int n=x1[0].length;
		// System.out.println(n);
		int n = 0;
		double y = x1[1][0];
		for (int i = 0; i < x11; i++) {
			if (y > x1[1][i]) {
				n = i;
				y = x1[1][i];
			}

		}

		return n;
	}

}
