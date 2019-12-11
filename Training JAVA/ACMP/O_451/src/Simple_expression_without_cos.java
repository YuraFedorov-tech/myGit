import java.util.ArrayList;

public class Simple_expression_without_cos {

	public static double began(String breket, ArrayList<Double> polynomial,
			double[] ans) {
		if (breket.length() == 0){
			ans[0] = Double.MAX_VALUE;
			return 1;
		}
			
		ArrayList<String> ListBreket = new ArrayList<>();
		ArrayList<Double> polynomialBreket = new ArrayList<>();
		ArrayList<String> znakBreket = new ArrayList<>();
		ListBreket = Helper_451.Delete_Plus_minus_multi_devide(ListBreket,
				breket, znakBreket);
		Helper_451.DeletUnarnyeZnaki(ListBreket,znakBreket,ans);
		if (ans[0] == Double.MAX_VALUE)
			return 1;
		ChekListBreket(ListBreket, ans);
		if (ans[0] == Double.MAX_VALUE)
			return 1;

		for (int i = 0; i < ListBreket.size(); i++) {
			double q = findNumber(ListBreket.get(i), polynomial);
			polynomialBreket.add(q);
		}
		double answear = FindEnd(polynomialBreket, znakBreket);

		return answear;
	}

	private static double FindEnd(ArrayList<Double> polynomialBreket,
			ArrayList<String> znakBreket) {
		double ans = polynomialBreket.get(0);
		if (znakBreket.get(0).equals("-"))
			polynomialBreket.set(0, ans * -1);
		boolean buzy[] = new boolean[polynomialBreket.size()];
		ans = 1;
		while (true) {
			// i-идет по знакас а не по числам

			int i = 1;
			for (; i < polynomialBreket.size(); i++) {

				if (znakBreket.get(i).equals("*")) {
					double x = polynomialBreket.get(i - 1);
					double y = polynomialBreket.get(i);
					polynomialBreket.set(i - 1, x * y);
					polynomialBreket.remove(i);
					znakBreket.remove(i);
					i=0;
				}
				if (polynomialBreket.size() == 1)
					break;
				
				if (znakBreket.get(i).equals("/")) {
					double x = polynomialBreket.get(i - 1);
					double y = polynomialBreket.get(i);
					polynomialBreket.set(i - 1, x / y);
					polynomialBreket.remove(i);
					znakBreket.remove(i);
					i=0;
				}
				if (polynomialBreket.size() == 1)
					break;
			
			}
			if (polynomialBreket.size() == i)
				break;

		}
		while (true) {
			// i-идет по знакас а не по числам

			int i = 1;
			for (; i < polynomialBreket.size(); i++) {

				if (znakBreket.get(i).equals("+")) {
					double x = polynomialBreket.get(i - 1);
					double y = polynomialBreket.get(i);
					polynomialBreket.set(i - 1, x+ y);
					polynomialBreket.remove(i);
					znakBreket.remove(i);
					i=0;
				}
				if (polynomialBreket.size() == 1)
					break;
				if (znakBreket.get(i).equals("-")) {
					double x = polynomialBreket.get(i - 1);
					double y = polynomialBreket.get(i);
					polynomialBreket.set(i - 1, x - y);
					polynomialBreket.remove(i);
					znakBreket.remove(i);
					i=0;
				}
			}
			if (polynomialBreket.size() == 1)
				break;

		}
		return polynomialBreket.get(0);
	}

	private static boolean allFull(boolean[] buzy) {
		for (boolean i : buzy)
			if (!i)
				return false;
		return true;
	}

	private static void ChekListBreket(ArrayList<String> listBreket,
			double[] ans) {
		for (int i =0;i<listBreket.size();i++){
		String ss=listBreket.get(i).trim();
		listBreket.set(i, ss);
			// если правда то все нормально ничего косячного нет
			if (!chek(ss, ans)) {
				ans[0] = Double.MAX_VALUE;
				return;
			}
		}
	}

	private static boolean chek(String s, double[] ans) {
		// если правда то все нормально ничего косячного нет
		String str[] = s.split("\\.", -1);
		if (str.length > 2)
			return false;
		for (int i = 0; i < str.length; i++)
			for (int j = 0; j < str[i].length(); j++) {
				char t = str[i].charAt(j);
				if (t == '0' | t == '1' | t == '2' | t == '3' | t == '4'
						| t == '5' | t == '6' | t == '7' | t == '8' | t == '9')
					continue;
				if (t == '!' & j == 0)
					continue;
				return false;
			}

		return true;
	}

	private static double findNumber(String string, ArrayList<Double> polynomial) {
		if (string.charAt(0) == '!') {
			int x = Helper_451.Find_number_of_polynomial(string);
			return polynomial.get(x);
		}

		return Double.parseDouble(string);
	}

}
