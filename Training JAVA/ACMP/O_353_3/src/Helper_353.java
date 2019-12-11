public class Helper_353 {

	public static double Do_X(double newDouble, double d) {
		boolean notNeed = Find_notNeed(newDouble, d);
		// если правда то ничего делать не надо все и так работает. 
				// тк при окуруглении ничего не добавляем
		if (notNeed)
			return 0;
		boolean need_plus = Do_need_minus(d);
		if (need_plus)
			return 0.001;

		return 0;
	}

	private static boolean Do_need_minus(double d) {
		d = d - (int) d;
		String str = Double.toString(d);
		// если правда то 
		// то округляем в большую сторону и прибавляем 0,001
		
		int x = 5;
		for (int i = 5; i < str.length(); i++) {
		
			int s = Integer.valueOf("" + str.charAt(i));
			if(s>4)
				return true;
			if(s<4)
				return false;
		
		}

		return false;
	}

	private static boolean Find_notNeed(double newDouble, double d) {
		String str = Double.toString(d);
		// если правда то ничего делать не надо все и так работает. 
		// тк при окуруглении ничего не добавляем
		boolean point = false;
		int x = 5;
		for (int i = 0; i < str.length(); i++) {
			x--;
		//	System.out.print(str.charAt(i));
			if (str.charAt(i) == '.') {
				x = 3;
				point = true;
			}
			if (point & x == -1) {
				int s = Integer.valueOf("" + str.charAt(i));
				if (s < 4)
					return true;
				return false;
			}
		}
		if (x >= 0)
			return true;

		return false;
	}

}
