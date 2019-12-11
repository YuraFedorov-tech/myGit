import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class O_601 {
	public static void main(String[] args) throws IOException {
		
		B();

	}

	private static void B() throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		String s = stdin.readLine();
		s = s.trim();
		String f[] = s.split(" ");
		int n = Integer.parseInt(f[0]);

		int m = Integer.parseInt(f[1]);
		String a[][] = new String[n][n];
		for(int i=0;i<n;i++)
			Arrays.fill(a[i], "");
		for (int i = 0; i < m; i++) {
			s = stdin.readLine();
			s = s.trim();
			f = s.split(" ");

			int y = Integer.parseInt(f[0]) - 1;
			int x = Integer.parseInt(f[1]) - 1;
		if(a[x][y].equals("")){
			a[x][y]=a[y][x] = f[2];
		}else
			a[x][y]=a[y][x] =a[y][x]+" "+f[2];;
		}
		s = stdin.readLine();
		s = s.trim();

		int k = Integer.parseInt(s);
		if (k == 0) {
			System.out.println(1);
			return;
		}
		int put[] = new int[k];
		s = stdin.readLine();
		s = s.trim();
		f = s.split(" ");
		for (int i = 0; i < k; i++) {
			put[i] = Integer.parseInt(f[i]);
		}

	//	 System.out.println(Arrays.deepToString(a));
	//	 System.out.println(Arrays.toString(put));

		Began(put, a, n, m, k);

	}

	private static void Began(int[] put, String[][] a, int n, int m, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> listNew = new ArrayList<Integer>();
			int color = put[i];
			while (list.size() != 0) {
				go(list, listNew, color, a, n);

			}
			list.addAll(listNew);
		}
		if (list.size() == 0) {
			System.out.println("INCORRECT");
		} else
			System.out.println(list.get(0) + 1);
	}

	private static void go(ArrayList<Integer> list, ArrayList<Integer> listNew,
			int color, String[][] a, int n) {
		int ver = list.get(0);
		list.remove(0);
		for (int i = 0; i < n; i++) {
			if(a[ver][i].equals(""))
				continue;
			boolean may=FindMay(a[ver][i],color);
		
			
			
			
			if(may){
			Inside(listNew, i);
			return;
			}
		
		}
	}

	private static boolean FindMay(String s, int color) {
		String []f = s.split(" ");
int e=f.length;
for(int i=0;i<e;i++)
	if(color==Integer.parseInt(f[i]))
		return true;

	
		return false;
	}

	private static void Inside(ArrayList<Integer> listNew, int i) {
		for (int j : listNew)
			if (j == i)
				return;
		listNew.add(i);

	}
}