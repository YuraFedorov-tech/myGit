import java.util.ArrayList;
import java.util.Scanner;

public class gorka {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int n = myScanner.nextInt(); // количество вершин
		int m = myScanner.nextInt(); // количество ребер обычных
		int u = myScanner.nextInt(); // количество ребер горка
		int k = myScanner.nextInt(); // количество ходов
		int[][] Rebra = new int[n][n];
		int[] myThrow = new int[k];
		for (int i = 0; i < m; i++) {
			int x1 = myScanner.nextInt();
			int x2 = myScanner.nextInt();
			Rebra[x1 - 1][x2 - 1] = 1;
		}
		for (int i = 0; i < u; i++) {
			int x1 = myScanner.nextInt();
			int x2 = myScanner.nextInt();
			Rebra[x1 - 1][x2 - 1] = 5;
		}
		for (int i = 0; i < k; i++) {
			myThrow[i] = myScanner.nextInt();
		}
		int[] Number = new int[2 * n];
		Number = numbers(Rebra, Number);
		print.printprint(Rebra);
		print.printprint2(myThrow);
		print.printprint3(Number);
		ArrayList<Integer> listing = new ArrayList();
		listing.add(0);
		// boolean []FindEnd= new boolean[2];
		boolean FindEnd = false;
		int Answear = -1;

		for (int i = 0; i < k; i++) { // бросаем кубик в i-ый раз
			listing = muvingFirstStage(Rebra, Number, myThrow[i], listing);
			listing = delete_alike(listing);

			FindEnd = chek_Listing_at_Last_Point(listing, n);
			if (FindEnd) {
				Answear = i + 1;
				break;
			}

			listing = moving_at_Gorka(listing, Number, n, Rebra);
			FindEnd = chek_Listing_at_Last_Point(listing, n);
		/*	if (FindEnd) {
				Answear = i + 2;
				break;
			}*/

		}
		System.out.println(Answear);
	}

	private static ArrayList moving_at_Gorka(ArrayList<Integer> listing, int[] number,
			int n, int[][] rebra) {
		for (int i = 0; i < listing.size(); i++) {
			int v =  listing.get(i);
			if (number[v + n] != 0) { // если в вершине горка ищем и мен€ем
				for (int i1 = 0; i1 < n; i1++) {
					if (rebra[v][i1] == 5) {
						// list.set(1, "ѕерсик");
						listing.set(i, i1);
						i1 = n;
					}
				}

			}
		}

		return listing;
	}

	private static ArrayList delete_alike(ArrayList<Integer> listing) {
		for (int i = 0; i < listing.size(); i++) {
			for (int j = i + 1; j < listing.size(); j++) {
				if ( listing.get(i) ==  listing.get(j)) {
					listing.remove(j);
					j--;
				}
			}

		}

		return listing;
	}

	private static boolean chek_Listing_at_Last_Point(ArrayList<Integer> listing, int n) {
		for (int i = 0; i < listing.size(); i++) {
			if ( listing.get(i) == n - 1)
				return true;
		}
		return false;
	}

	private static ArrayList muvingFirstStage(int[][] rebra, int[] number,
			int myThrow, ArrayList<Integer> listing) {
		for (int i = 0; i < myThrow; i++) { // ходим i-ый раз в рамках выпавшей
											// цифры на кубике
			listing = moving_at_1_Step(rebra, number, listing);

		}

		return listing;
	}

	private static ArrayList moving_at_1_Step(int[][] rebra, int[] number,
			ArrayList<Integer> listing) {
		int n = listing.size();
		for (int i = 0; i < n; i++) {
			int r =  listing.get(0);
			if (number[r] > 0) {
				for (int y = 0; y < rebra.length; y++) {
					if (rebra[r][y] == 1)
						listing.add(y);

				}
				listing.remove(0);
			}
		}

		return listing;
	}

	private static int[] numbers(int[][] rebra, int[] number) {
		for (int i = 0; i < rebra.length; i++) {
			int usuly = 0;
			int gorka = 0;
			for (int i1 = 0; i1 < rebra.length; i1++) {
				if (rebra[i][i1] == 1)
					++usuly;
				if (rebra[i][i1] == 5)
					++gorka;
			}
			number[i] = usuly;
			number[i + rebra.length] = gorka;
		}

		return number;
	}

}
