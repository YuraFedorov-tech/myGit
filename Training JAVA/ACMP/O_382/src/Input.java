import java.util.Arrays;
import java.util.Scanner;

public class Input {

	public static int[][] input() {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int[][] a = new int[n+2][n+2];
		
		a=fulling_a(a);String s1 = my.nextLine();
		for (int i = 1; i < n+1; i++) {
			String s = my.nextLine();
			char[] chArray = s.toCharArray();
			for (int j = 0; j < n; j++) {
				if (chArray[j] == '.')
					a[i][j+1] = 0;
				if (chArray[j] == '#')
					a[i][j+1] = -1;
			}

		}
		return a;
	}

	private static int[][] fulling_a(int[][] a) {
		Arrays.fill(a[0], -1);  //можно и часть
		Arrays.fill(a[a.length-1], -1);  //можно и часть
		for(int i=0;i<a.length;i++){
			a[i][0]=a[i][a.length-1]=-1;
			
		}
		return a;
	}

}
