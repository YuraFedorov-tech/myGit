import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class O_470_1 { // Main
	public static void main(String[] args) {

		// 1b. „тение стандартного ввода:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		// System.out.print("Enter a line:");
		try {

			String s = stdin.readLine();
			String[] chArray = s.split(" ");
			int y = Integer.parseInt(chArray[0]);
			int x = Integer.parseInt(chArray[1]);
			int n = Integer.parseInt(chArray[2]);
			chArray = null;
			int[][] price = new int[y][x]; // цена участков
	//		int query[][] = new int[4][n]; // запрос

			for (int i = 0; i < y; i++) {
				s = stdin.readLine();
				chArray = s.split(" ");

				for (int j = 0; j < x; j++) {
					price[i][j] = Integer.parseInt(chArray[j]);
				}

			}
			chArray = null;

			int[][] PartPrice = new int[y][x];
			PartPrice = DoPartSumma( price);

			for (int i = 0; i < n; i++) {
				s = stdin.readLine();
				chArray = s.split(" ");
				int q1[] = new int[4];
				for (int j = 0; j < 4; j++) {
		//			query[j][i] = Integer.parseInt(chArray[j]) - 1;
		//			q1[j][0] = query[j][i];
					q1[j]=Integer.parseInt(chArray[j]) - 1;
				}


			//	int answear = FindAnswear(PartPrice, q1[0], q1[1],q1[2], q1[3]);
						
				System.out.println( FindAnswear(PartPrice, q1[0], q1[1],q1[2], q1[3]));
			}

			System.out.println();
		} catch (IOException ex) {
			System.out.println("Reading error");
		}
		// Print.pr(price);
		// Print.pr(query);

	}

	public static void DoWork(int x, int y, int n, int[][] price,
			int[][] query, int[][] partPrice) {

		// Print.pr(PartPrice);
		// int [][]PartPrice2=new int[y][x];
		// PartPrice2=Print1.precomputeMatrix(price);
		// Print1.pr(PartPrice2);




	}

	public static int[][] DoPartSumma( int[][] price) {
		int[][] partPrice=new int[price.length][price[0].length];
		for (int i = 0; i < price.length; i++)
			for (int j = 0; j < price[0].length; j++) {
				if (i == 0 & j == 0) {
					partPrice[i][j] = price[i][j];
					continue;
				}

				if (i == 0) { // если первый столбец
					partPrice[i][j] = price[i][j] + partPrice[i][j - 1];
					continue;
				}

				if (j == 0) { // // если перва€ строка
					partPrice[i][j] = price[i][j] + partPrice[i - 1][j];
					continue;
				}

				partPrice[i][j] = price[i][j] + partPrice[i][j - 1]
						+ partPrice[i - 1][j] - partPrice[i - 1][j - 1];

			}

		return partPrice;
	}

	public static int FindAnswear(int[][] PartPrice, int yL, int xL, int yR,
			int xR) {
		if (yL == 0 & xL == 0)
			return PartPrice[yR][xR];
		if (yL == 0) // если перва€ колонка
			return PartPrice[yR][xR] - PartPrice[yR][xL - 1];

		if (xL == 0) // если первый р€д
			return PartPrice[yR][xR] - PartPrice[yL - 1][xR];
		
		return PartPrice[yR][xR]-PartPrice[yR][xL - 1]-PartPrice[yL - 1][xR]+PartPrice[yL - 1][xL - 1];
	}
}
