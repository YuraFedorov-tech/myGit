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
			x1 = DoNiz0Point(x1, NomerNizKrasiv);
			System.out.println();
			ne.printKoordinat(x1, x11);
			// ne.printKoordinat(x1, x11);
			x1 = ChangeInNoll(x1, x11);
		//	xPolar = ChangeInPolar(x1, x11);
		//	xPolar = PoryzdokPoUglav(x11, xPolar);

		//	xVipukl = InDekart(xPolar);
			x1 = okruglit(x1);
			int [] line = new int[1];
			x1 = BildMnogougolnik(x1, x11,line);

			ne.printKoordinat(xVipukl, xVipukl[0].length);

		} else {
			xVipukl = x1;
		}
		ne.printKoordinat(xVipukl, xVipukl[0].length);
		System.out.println();

		if (y11 > 3) {
			int NomerNizKrasiv = findNizPoint(y1, y11);
			y1 = DoNiz0Point(y1, NomerNizKrasiv);

			System.out.println();
			ne.printKoordinat(y1, y11);

			// меняем на ноль

			// переводим все в полярные координаты

			// //////////
			y1 = ChangeInNoll(y1, y11);
			System.out.println();
			ne.printKoordinat(y1, y11);
			yPolar = ChangeInPolar(y1, y11);
			System.out.println();
			yPolar = PoryzdokPoUglav(y11, yPolar);
			int [] line = new int[1];
			yVipukl = BildMnogougolnik(yPolar, y11,line);
			yVipukl = InDekart(yVipukl);

		} else {
			yVipukl = y1;
		}

		ne.printKoordinat(yVipukl, yVipukl[0].length);
		System.out.println();

		// cтроим многоугольник

	}

	private static double[][] okruglit(double[][] xVipukl) {
		for (int i = 0; i < xVipukl[0].length; i++) {
		
		//    double newDouble = new BigDecimal(templateDouble).setScale(3, RoundingMode.UP).doubleValue();
			xVipukl[0][i]=new BigDecimal(xVipukl[0][i]).setScale(3, RoundingMode.UP).doubleValue();
			xVipukl[1][i]=new BigDecimal(xVipukl[1][i]).setScale(3, RoundingMode.UP).doubleValue();
			xVipukl[0][i]=(double)((int)xVipukl[0][i]);
			xVipukl[0][i]=(double)((int)xVipukl[0][i]);
		}

		return xVipukl;
	}

	private static double[][] InDekart(double[][] xVipukl) {
		for (int i = 1; i < xVipukl[0].length; i++) {
			double ugol = Math.toRadians(xVipukl[1][i]);
			double x = xVipukl[0][i] * Math.cos(ugol);
			double y = xVipukl[0][i] * Math.sin(ugol);
			xVipukl[0][i] = x;
			xVipukl[1][i] = y;
		}

		return xVipukl;
	}

	private static double[][] BildMnogougolnik(double[][] xPolar, int x11, int [] line) {
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
			int m=2;
			while(true){
			
			int q2=findQ2(xPolar,used,q0,q1);
			if(q2==0){
				line[0]=m-1;
				break;
			}
			used[q2]=true;
			q0=q1;
			q1=q2;
			xVipukly[0][m] = xPolar[0][q2];
			xVipukly[1][m] = xPolar[1][q2];
			m+=1;
			
			}
		
		}
		
		return xVipukly;
	}

	private static int findQ2(double[][] xPolar, boolean[] used,int q0, int q1) {

double [] A_Sin=new double [xPolar[0].length];
int q2=0;
for (int i = 2; i <= xPolar[0].length; i++) {
	if(i==xPolar[0].length){
		i=0;
	}
	q2=i;
	if(used[i] & i!=0){continue;}
	A_Sin[i]=ProverkaNaVipukl(xPolar[0][q0], xPolar[1][q0],		
			                 xPolar[0][q1], xPolar[1][q1],
		                     	xPolar[0][q2],		xPolar[1][q2]);
	
if (i==0){
	i=xPolar[0].length;
}
}
 q2=0;
double  A_sinMax=0;
for (int i = 0; i < xPolar[0].length; i++) {
	if (A_Sin[i]<A_sinMax){
		 q2=i;
		 A_sinMax=A_Sin[i];
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
		double q=Math.sqrt((x2 - x1)*(x2 - x1)+(y2 - y1)*(y2 - y1));
		double q1=Math.sqrt((y3 - y2)*(y3 - y2)+(x3 - x2)*(x3 - x2));		
		sinAlfa=sinAlfa/(q*q1);
		sinAlfa=Math.asin(sinAlfa);
	// sinAlfa=Math.toDegrees(sinAlfa);
	double	cosAlfa =(x2 - x1)*(x3 - x2)+(y3 - y2)*(y2 - y1);
	cosAlfa=cosAlfa/(q*q1);
	cosAlfa=Math.asin(cosAlfa);
	cosAlfa=Math.toDegrees(cosAlfa);
		
		if (sinAlfa == 0) { // не ясно, идем дальше
		
		if(cosAlfa==90){
			sinAlfa=-100;
		}
	
		}
		if (sinAlfa < 0) { 
			double b=line(x1,y1,x2,y2);
			double c=line(x2,y2,x3,y3);
			double a=line(x3,y3,x1,y1);
			double	cosg =(b*b+c*c-a*a)/(2*b*c);
			cosg=Math.acos(cosg);	System.out.print("угол в радианах="+ cosg);
			cosg=Math.toDegrees(cosg);	System.out.println("угол в градусах="+ cosg);
			sinAlfa=-cosg;
		}
		
		
		
		
		System.out.println("sinAlfa= " + sinAlfa + "  z= " + z);
		// System.out.println(" ");
		return sinAlfa;
	}

	private static double line(double x2, double y2, double x3, double y3) {
		double l =Math.sqrt((x3 - x2)*(x3 - x2)+(y3 - y2)*(y3 - y2));
		return l;
	}

	private static double[][] PoryzdokPoUglav(int x11, double[][] xPolar) {
		for (int i = 0; i < x11; i++) {
			for (int j = 0; j < x11 - i - 1; j++) {
				if (xPolar[1][j] > xPolar[1][j + 1]) {
					double q = xPolar[1][j];
					double w = xPolar[0][j];
					xPolar[1][j] = xPolar[1][j + 1];
					xPolar[0][j] = xPolar[0][j + 1];
					xPolar[1][j + 1] = q;
					xPolar[0][j + 1] = w;
				}

			}

		}

		return xPolar;
	}

	private static double[][] ChangeInPolar(double[][] x1, int x11) {
		double[][] R = new double[2][x11];
		for (int i = 0; i < x11; i++) {
			double[] rt = new double[2];
			rt = sendInPolarPoint(x1[0][i], x1[1][i]);
			R[0][i] = rt[0];
			R[1][i] = rt[1];

		}

		return R;
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
