import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_673 { // Main

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		BigInteger max = BigInteger.valueOf(0);
		BigInteger min = BigInteger.valueOf(0);
		String s = "1";

		for (int i = 0; i < n; i++) {
			s += "1";
			if (i == n - 2)
				min = min.add(new BigInteger(s));

		}
		max = max.add(new BigInteger(s));
		if (n > 6) {

			max = min.add(BigInteger.valueOf(11111));
		}

		BigInteger amount_of_numbers[] = new BigInteger[1];
		BigInteger min_of_numbers[] = new BigInteger[1];

		amount_of_numbers[0] = BigInteger.valueOf(0);
		min_of_numbers[0] = BigInteger.valueOf(0);
		min_of_numbers[0] = max;
		int matches[][] = new int[7][10];
		int amount_of_matches[] = { 0 };

		began(max, amount_of_numbers, min_of_numbers, min, matches,
				amount_of_matches);
		if (n != 1) {
			Work_O_673.prin(matches,amount_of_matches,n);
			System.out.print(amount_of_numbers[0] + " " + min_of_numbers[0]);
		
		
		}
		if (n == 1)
			System.out.print(10 + " " + 0);
	}

	private static void began(BigInteger max, BigInteger[] amount_of_numbers,
			BigInteger[] min_of_numbers, BigInteger min, int[][] matches,
			int[] amount_of_matches) {

		BigInteger counter = min;

		while (true) {
			int x = counter.compareTo(max);
			if (x == 0)
				break;
			boolean curencNumeral = Find_curencNumeral(counter, min_of_numbers,matches,amount_of_matches);
			if (curencNumeral)
				amount_of_numbers[0] = amount_of_numbers[0].add(BigInteger.ONE);
			counter = counter.add(BigInteger.ONE);

		}

	}

	private static boolean Find_curencNumeral(BigInteger counter,
			BigInteger[] min_of_numbers, int[][] matches, int[] amount_of_matches) {
		ArrayList<Integer> list = new ArrayList<>();
		list = FindPoinFrom_counter(list, counter);
		boolean answear = FindRavnoOrNo(list, min_of_numbers, counter,matches,amount_of_matches);

		return answear;
	}

	private static boolean FindRavnoOrNo(ArrayList<Integer> list,
			BigInteger[] min_of_numbers, BigInteger counter, int[][] matches, int[] amount_of_matches) {
		BigInteger summa = BigInteger.valueOf(0);
		BigInteger multiplication = BigInteger.valueOf(1);
		summa = Find_summa(list, summa);
		multiplication = Find_multiplication(list, multiplication);
		int q = summa.compareTo(multiplication);

		if (q == 0) {
		Helper_O_673.DO(matches,amount_of_matches,counter);
			
			int x = counter.compareTo(min_of_numbers[0]);
			System.out.println(counter);

			if (x == -1)
				min_of_numbers[0] = counter;
			return true;
		}

		return false;
	}

	private static BigInteger Find_multiplication(ArrayList<Integer> list,
			BigInteger multiplication) {
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i);
			multiplication = multiplication.multiply(BigInteger.valueOf(x));

		}

		return multiplication;
	}

	private static BigInteger Find_summa(ArrayList<Integer> list,
			BigInteger summa) {
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i);
			summa = summa.add(BigInteger.valueOf(x));

		}
		return summa;
	}

	private static ArrayList<Integer> FindPoinFrom_counter(
			ArrayList<Integer> list, BigInteger counter) {
		String s = counter.toString();
		for (int i = 0; i < s.length(); i++)
			list.add(Integer.valueOf("" + s.charAt(i)));

		return list;
	}

}
