import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_365_2 {  //Main

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		byte[] currensyPointes = new byte[n - 1];
		 long timestart1=System.currentTimeMillis() ;
		byte[][] answear = new byte[40000][n - 1];
		int[] numberAnswear = { 0 };
		// ArrayList<Integer> answear = new ArrayList<>();
		rekursia(0, currensyPointes, answear, n, numberAnswear);
		 long timestart2=System.currentTimeMillis() ;
		// for (String i : answear)
		// System.out.println(i);
		// printing(answear);
		printingByte(answear, numberAnswear);
		 long timestart3=System.currentTimeMillis() ;
		System.out.println("общее количество - "+numberAnswear[0]);
		System.out.println(timestart2-timestart1);
		System.out.println(timestart3-timestart1);
	}

	private static void printingByte(byte[][] answear, int[] numberAnswear) {
		for (int i = 0; i < numberAnswear[0]; i++) {
			boolean began = false;
			for (int j = 0; j < answear[0].length; j++) {
				int n = answear[i][j];
				for (int g = 0; g < n; g++) {

					if (!began) {
						System.out.print(j + 1);
						began = true;
						continue;
					}
					System.out.print("+" + (j + 1));
				}
			}

			System.out.println();
		}

	}

	private static void rekursia(int summa, byte[] currensyPointes,
			byte[][] answear, int n, int[] numberAnswear) {
		if (summa > n)
			return;
		if (summa == n) {
			Find_plusToAnswear(currensyPointes, answear, numberAnswear);
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if((summa + i + 1)>n)
			return;
			currensyPointes[i]++;
			rekursia(summa + i + 1, currensyPointes, answear, n, numberAnswear);
			currensyPointes[i]--;
		}

	
	}

	public static void Find_plusToAnswear(byte[] currensyPointes,
			byte[][] answear, int[] numberAnswear) {
	
	//int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);
	
		for (int i = 0; i < numberAnswear[0]; i++) {
			if (Arrays.equals(currensyPointes, answear[i]))
				return;

		}

		// int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers,
		// luckyNumbers.length);

		answear[numberAnswear[0]] = Arrays.copyOf(currensyPointes,
				currensyPointes.length);
		
		numberAnswear[0]++;
		return;
	}

}
