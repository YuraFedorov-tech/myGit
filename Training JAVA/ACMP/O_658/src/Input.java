import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	public static int[][] Input() {
		int a[][] = null;
		// 1b. Чтение стандартного ввода:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
	//	System.out.print("Enter a line:");
		try {

			String s = stdin.readLine();
			int n = Integer.valueOf(s);
			 a = new int[n][2];
for(int i=0;i<n;i++){
	s = stdin.readLine();
	String SSS[] = s.split(" ");
	a[i][0]=Integer.valueOf(SSS[0]);
	a[i][1]=Integer.valueOf(SSS[1]);	
}
//return a;	
			
		//	System.out.println(stdin.readLine());
		} catch (IOException ex) {
			System.out.println("Reading error");
		}

		return a;
	}

}
