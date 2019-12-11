import java.util.ArrayList;
import java.util.Arrays;

public class Helper_2 {

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
		for (int i = 0; i < coordinat2[0].length; i++) {
			coordinat[0][i] = coordinat2[1][i];
			coordinat[1][i] = coordinat2[0][i];

		}
		return coordinat;
	}

	private static boolean Finnd_needOrNO_Perevorot(int[][] coordinat2) {
		// если правда то надо менять местами X и Y
		int x = Find_Different_X(coordinat2, 0);
		int y = Find_Different_X(coordinat2, 1);
		if (x >= y)
			return false;

		return true;
	}

	private static int Find_Different_X(int[][] coordinat2, int n) {
		int x = 0;
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < coordinat2[0].length; i++) {
			boolean j = Have_Number_or_no(list, coordinat2[n][i]);
			if (j)
				list.add(coordinat2[n][i]);

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
		for (int i = 0; i < coordinat[0].length - 1; i++)
			for (int j = 0; j < coordinat[0].length - 1; j++) {
				if (coordinat[0][j + 1] < coordinat[0][j]) {
					int x = coordinat[0][j + 1];
					int y = coordinat[1][j + 1];

					coordinat[0][j + 1] = coordinat[0][j];
					coordinat[1][j + 1] = coordinat[1][j];

					coordinat[0][j] = x;
					coordinat[1][j] = y;
					
				}

			}

		return coordinat;
	}

	public static int[][] Do_newCoordinat(int n0, int n1, int n2, int[][] coordinat, int[] time) {
int n=n2-n0-1;
int koord[][]=new int [2][n];
int x=coordinat[1][n1];

coordinat[1][n1]=-20000;

long  input0 = System.currentTimeMillis();
System.arraycopy(coordinat[0], n0+1, koord[0], 0, n);
System.arraycopy(coordinat[1], n0+1, koord[1], 0, n);
long  input1 = System.currentTimeMillis();
time[3]+=input1-input0;
coordinat[1][n1]=x;

if(n>1)	{	
	
	 input0 = System.currentTimeMillis();
	koord=doSort(0,koord[0].length-1,koord);	
	  input1 = System.currentTimeMillis();
	time[4]+=input1-input0;
}

return koord;
	}

	static int FindBegan1(int[][] koord, int y1, int y2, int y3) {
int yMin=Math.min(y1, y2);
 yMin=Math.min(yMin, y3);
for(int i=0;i<koord.length-1;i++){
	if(yMin<koord[1][i]){

		return i;
	}
}
		
		return 0;
	}

	private static int[][] Sort_y(int[][] koord) {

		
			for (int i = 0; i < koord[0].length - 1; i++)
				for (int j = 0; j < koord[0].length - 1; j++) {
					if (koord[1][j + 1] < koord[1][j]) {
						int x = koord[0][j + 1];
						int y = koord[1][j + 1];

						koord[0][j + 1]= koord[0][j];
						koord[1][j + 1] = koord[1][j];

						koord[0][j] = x;
						koord[1][j] = y;
						
					}

				}

			return koord;
		}
	
	
	private static int [][] doSort(int start, int end,int [][]array) {
        if (start >= end)
            return array;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[1][i] <= array[1][cur])) {
                i++;
            }
            while (j > cur && (array[1][cur] <= array[1][j])) {
                j--;
            }
            if (i < j) {
                int temp = array[1][i];
                array[1][i] = array[1][j];
                array[1][j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur,array);
        doSort(cur+1, end,array);
        return array;
    }
}
