import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input_2 {

	public static int[][] Input() {
		int a[][] = null;
		// 1b. Чтение стандартного ввода:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
	//	System.out.print("Enter a line:");
		try {

			String s = stdin.readLine();
			int n = Integer.valueOf(s);
			 a = new int[2][n];
for(int i=0;i<n;i++){
	s = stdin.readLine();
	String SSS[] = s.split(" ");
	a[0][i]=Integer.valueOf(SSS[0]);
	a[1][i]=Integer.valueOf(SSS[1]);	
}
//return a;	
			
		//	System.out.println(stdin.readLine());
		} catch (IOException ex) {
			System.out.println("Reading error");
		}

		return a;
	}

}
