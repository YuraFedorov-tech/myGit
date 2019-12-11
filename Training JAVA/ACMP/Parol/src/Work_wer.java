
public class Work_wer {
	 static double FindSqwear(int x1, int y1, int x2, int y2, int x3,
				int y3) {

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

		private static double FindLength(int x1, int y1, int x2, int y2) {
			double x = x2 - x1;
			x *= x;
			double y = y2 - y1;
			y *= y;

			return Math.sqrt(x + y);
		}
}
