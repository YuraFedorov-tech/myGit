import java.util.Scanner;

public class Vas {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);


		int y = myScanner.nextInt();
		y = y + 2;
		int x = myScanner.nextInt();
		x = x + 2;
		int k = myScanner.nextInt();
		int[][] xy;int[][] Vremyanka;
		int[][] Otvet;
		xy = new int[y][x];	Vremyanka = new int[y][x];
		Otvet = new int[y][x];
		for (int i = 1; i < y - 1; i++) {
			for (int j = 1; j < x - 1; j++) {
				xy[i][j] = myScanner.nextInt();
			}
		}

		for (int i1 = 0; i1 < k; i1++) {

			for (int i = 1; i < y-1; i++) {
				for (int j = 1; j < x-1; j++) {
					int l = izm(x, y, xy, Otvet, i, j);
					if (xy[i][j] != l) {
						Otvet[i][j] += 1;
						
					}
					Vremyanka[i][j] = l;
				}
			}
			for (int i = 1; i < y-1; i++) {
				for (int j = 1; j < x-1; j++) {
					
				
					xy[i][j]=Vremyanka[i][j] ;
					Vremyanka[i][j]=0;
				}
			}
		
		
		}



		
		for (int i = 1; i < y-1; i++) {
			for (int j = 1; j < x-1; j++) {
				
				System.out.print(Otvet[i][j]+" ");


			}
		
		}
		
		
		
	}

	private static int izm(int x, int y, int[][] xy, int[][] otvet, int i, int j) {
		int yy[] = { 1, 0, -1, 0 };
		int xx[] = { 0, 1, 0, -1 };
		int Stab2 = 0;
		int Akt2Or3 = 0;
		for (int p = 0; p < 4; p++) {
			if (xy[yy[p]+i][xx[p]+j] == 2) {
				Stab2 = Stab2 + 1;
				Akt2Or3 = Akt2Or3 + 1;
			}
			if (xy[yy[p]+i][xx[p]+j] == 3) {
				Akt2Or3 = Akt2Or3 + 1;
			}

		}

		if (Stab2 >= 2) {
			return 2;
		}
		if (Akt2Or3 >= 1) {
			return 3;
		}

		return 1;
	}

}
