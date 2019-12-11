
public class Work_Geron {

	 static double FindSqwear(int x1, int y1, int x2, int y2, int x3,
				int y3) {

			double a = FindSqwearIn_sqwear(x1, y1, x2, y2);
			double b = FindSqwearIn_sqwear(x2, y2, x3, y3);
			double c = FindSqwearIn_sqwear(x3, y3, x1, y1);

			double sqwear = a+b+c;
			if(sqwear<0)
				sqwear=-sqwear;
			return sqwear;
		}

	
	
	private static double FindSqwearIn_sqwear(double x1, double y1, double x2, double y2) {
double sqwear=0;
//y1+=20000;
//y2+=20000;

sqwear=(x2-x1)*(y2+y1)/2;

		
		
		return sqwear;
	}
	
	
}
