public class startt {

	public static String[][] DoStart(String[][] a) {
		for (int i = 1; i < 9; i++)
			for (int j = 1; j < 9; j++) {
				if ((i == 1 | i == 3) & j % 2 != 0) // если фишки белые
					a[i][j] = "w";
				if (i == 2 & j % 2 == 0) // если фишки белые
					a[i][j] = "w";
				if ((i == 6 | i == 8) & j % 2 == 0) // если фишки черныен
					a[i][j] = "b";
				if (i == 7 & j % 2 != 0) // если фишки черныен
					a[i][j] = "b";
				if ((i == 4) & j % 2 == 0) // если field черныен
					a[i][j] = "*";
				if ((i == 5) & j % 2 != 0) // если field черныен
					a[i][j] = "*";
			}

		return a;
	}

	public static void printA(String[][] a) {
		for (int i = 8; i >0; i--) {
			for (int j = 1; j < 9; j++) {
				System.out.print(a[i][j] );
				System.out.print("\t");
			}
		System.out.println();
			System.out.println();
	
		}
		System.out.println("-------------------------------------------------------------------------------------------------");
	}

	public static String[][] Fill_Befor_Start(String[][] a) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j]=".";
			}

		}
		return a;
	}

}
