public class print {
	static void printprint2(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	static void printprint(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int i1 = 0; i1 < a.length; i1++) {
				System.out.print(a[i][i1] + " ");
			}
			System.out.println();
		}

	}

	static void printprint3(int[] number) {
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
			if ((2 * i + 2) == number.length)
				System.out.println();

		}
		System.out.println();
	}
}
