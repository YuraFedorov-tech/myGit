
class urav {
	private double x;
	private double y;

	urav(double t) {
		x = t;
	}

	void count() {
		y = x * x * x - 3 * x * x - x * Math.sin(x) * Math.sin(x) - 2;
	}

	double getY() {
		return y;
	}
}

public class r4_1 {

	public static void main(String[] args) {
		double ans = 0;
		double q = -5;
		double w = 5;
		int z = 0;
		while (true) {
			double mid = q + (w - q) / 2;
			urav qq = new urav(mid);
			qq.count();
			double ans2 = qq.getY();
			double as = Math.abs(ans - ans2);
			if (Math.abs(ans - ans2) < 0.001)
				break;
			System.out.println((ans + " " + ans2));
			ans = ans2;
			if (ans > 0)
				q = mid;
			else
				w = mid;
			z++;

		}
		System.out.print(z);

	}
}