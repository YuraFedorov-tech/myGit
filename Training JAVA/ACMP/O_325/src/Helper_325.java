import java.util.Arrays;

public class Helper_325 {
	public static int[][] DO_ZaborMinus1(int[][] a) {
		Arrays.fill(a[0], -1);
		Arrays.fill(a[1], -1);
		Arrays.fill(a[a.length - 1], -1);
		Arrays.fill(a[a.length - 2], -1);

		for (int i = 0; i < a.length; i++) {
			a[i][0] = a[i][1] = a[i][a.length - 1] = a[i][a.length - 2] = -1;
		}

		return a;
	}

	public static int FindIntFromLetter(String string) {
switch(string){
case "a":   return 0;
case "b":   return 1;
case "c":   return 2;
case "d":   return 3;
case "e":   return 4;
case "f":   return 5;
case "g":   return 6;
case "h":   return 7;


}

		
		return 10000;
	}

/*
        int len=a.length;
		int yOld=p/len;
		int xOld=p-yOld*len;
		int [] yy={-2,-1,1,2, 2, 1,-1,-2};
		int [] xx={ 1, 2,2,1,-1,-2,-2,-1};
 */
}