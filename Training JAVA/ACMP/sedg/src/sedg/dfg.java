package sedg;

import java.util.Scanner;

public class dfg {

	public static void main(String[] args) {
		 long input=System.currentTimeMillis() ;
			Scanner my = new Scanner(System.in);
			double x1 = my.nextInt();
			double y1 = my.nextInt();


			
			double x2 = my.nextInt();
			double y2 = my.nextInt();
			
			
			double x3 = my.nextInt();
			double y3 = my.nextInt();
			
			
			double xTree = my.nextInt();
			double yTree = my.nextInt();
			
		double a = FindSqwear(x1, y1, xTree, yTree, x2, y2);
		double b = FindSqwear(x2, y2, xTree, yTree, x3, y3); // если участок																
		double c = FindSqwear(x3, y3, xTree, yTree, x1, y1);
		double summa = a + b + c;
		 System.out.println(a+"\t"+b+"\t"+c+"\t"+summa+"\t"+FindSqwear(x3, y3, x2, y2, x1, y1));
		
		
	}

	private static double FindSqwear(double x1, double y1, double x2, double y2, double x3,
			double y3) {

		double a = FindLength(x1, y1, x2, y2);
		double b = FindLength(x2, y2, x3, y3);
		double c = FindLength(x1, y1, x3, y3);

		double sqwear = FindSqwear(a, b, c);

		return sqwear;
	}

	private static double FindSqwear(double a, double b, double c) {
		double p = (a + b + c) / 2;

		double sqwear = p * (p - a) * (p - b) * (p - c);
		sqwear = Math.sqrt(sqwear);

		return sqwear;
	}
	private static double FindLength(double x1, double y1, double x2, double y2) {
		double x = x2 - x1;
		x *= x;
		double y = y2 - y1;
		y *= y;

		return Math.sqrt(x + y);
	}
	
}
