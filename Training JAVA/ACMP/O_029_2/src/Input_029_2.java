import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input_029_2 {

	public static ArrayList<Integer> Input(ArrayList<Integer> list) {
		int a[][] = null;
		// 1b. Чтение стандартного ввода:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		// System.out.print("Enter a line:");
		try {
			String s = null;
			int y;
			while (true) {
				s = stdin.readLine();
				s = s.trim();
				if (!s.equals(""))
					break;
			}
			y = Integer.valueOf(s);
			s = stdin.readLine();
			String S[] = s.split(" ");
			for (int i = 0; i < S.length; i++) {
				int n = Integer.valueOf(S[i]);
				list.add(Integer.valueOf(S[i]));

			}
			// return a;

			// System.out.println(stdin.readLine());
		} catch (IOException ex) {
			System.out.println("Reading error");
		}

		return list;
	}

}