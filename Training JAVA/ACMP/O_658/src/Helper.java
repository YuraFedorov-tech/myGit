import java.util.ArrayList;
import java.util.Arrays;

public class Helper {

	public static int[][] ChangeCoordinat(int[][] coordinat, int[][] coordinat2) {
		boolean needOrNO_Perevorot = Finnd_needOrNO_Perevorot(coordinat2);
		// если правда то надо менять местами X и Y
		if (!needOrNO_Perevorot) {
			coordinat = Arrays.copyOf(coordinat2, coordinat2.length);
			return coordinat;
		}
		coordinat = Change_X_and_y_place(coordinat, coordinat2);

		return coordinat;
	}

	private static int[][] Change_X_and_y_place(int[][] coordinat,
			int[][] coordinat2) {
		for (int i = 0; i < coordinat2.length; i++) {
			coordinat[i][0] = coordinat2[i][1];
			coordinat[i][1] = coordinat2[i][0];

		}
		return coordinat;
	}

	private static boolean Finnd_needOrNO_Perevorot(int[][] coordinat2) {
		// если правда то надо менять местами X и Y
		int x = Find_Different_X(coordinat2, 0);
		int y = Find_Different_X(coordinat2, 0);
		if (x >= y)
			return false;

		return true;
	}

	private static int Find_Different_X(int[][] coordinat2, int n) {
		int x = 0;
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < coordinat2.length; i++) {
			boolean j = Have_Number_or_no(list, coordinat2[i][n]);
			if (j)
				list.add(coordinat2[i][n]);

			// если правда то в список вносим
		}
		return list.size();
	}

	private static boolean Have_Number_or_no(ArrayList<Integer> list, int j) {
		for (int i : list)
			if (i == j)
				return false;

		return true;
		// если правда то в список вносим
	}

	public static int[][] Sort(int[][] coordinat) {
		for (int i = 0; i < coordinat.length - 1; i++)
			for (int j = 0; j < coordinat.length - 1; j++) {
				if (coordinat[j + 1][0] < coordinat[j][0]) {
					int x = coordinat[j + 1][0];
					int y = coordinat[j + 1][1];

					coordinat[j + 1][0] = coordinat[j][0];
					coordinat[j + 1][1] = coordinat[j][1];

					coordinat[j][0] = x;
					coordinat[j][1] = y;
					
				}

			}

		return coordinat;
	}

}
