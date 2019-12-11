import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helping {
	public static void main(String[] args) {
		// 1b. Чтение стандартного ввода:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Enter a line:");
		try {

			String s = stdin.readLine();
			String[] chArray = s.split(" ");
			int y = Integer.parseInt(chArray[0]);
			int x = Integer.parseInt(chArray[1]);
			int n = Integer.parseInt(chArray[2]);
			chArray = null;
			int[][] price = new int[y][x]; // цена участков
			int query[][] = new int[4][n]; // запрос

			for (int i = 0; i < y; i++) {
				s = stdin.readLine();
				chArray = s.split(" ");

				for (int j = 0; j < x; j++) {
					price[i][j] = Integer.parseInt(chArray[j]);
				}

			}
			chArray=null;
			for (int i = 0; i <n; i++) {
				s = stdin.readLine();
				chArray = s.split(" ");

				for (int j = 0; j < 4; j++) {
					query[j][i] = Integer.parseInt(chArray[j])-1;
				}
					
				}
			
			
			
			
			System.out.println();
		} catch (IOException ex) {
			System.out.println("Reading error");
		}
	}
}
