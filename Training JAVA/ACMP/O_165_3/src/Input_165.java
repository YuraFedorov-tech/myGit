import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input_165 {

	public static int[][] Input() {
		int a[][] = null;
		// 1b. Чтение стандартного ввода:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		// System.out.print("Enter a line:");
		try {

			String s = stdin.readLine();
			String SSS[] = s.split(" ");
			int y = Integer.valueOf(SSS[0]);
			int x = Integer.valueOf(SSS[1]);
			a = new int[y][x];
			for (int i = 0; i <y; i++) {
				s = stdin.readLine();
				String S[] = s.split(" ");
				for (int j = 0;j < x;j++) {
				
					a[i][j] = Integer.valueOf(S[j]);
					
				}
			}
			// return a;

			// System.out.println(stdin.readLine());
		} catch (IOException ex) {
			System.out.println("Reading error");
		}

		return a;
	}

}
