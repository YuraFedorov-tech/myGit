import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_469 {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int n = e.nextInt();
		int m = e.nextInt();
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = e.nextInt();

	
		
		 F(a, n, m);

	}

	private static void F(int[][] a, int n, int m) {
		int[][] r = new int[n][m];
		r = D(r, n);
		r[0][0] = a[0][0];
		boolean b[] = new boolean[n * m];
		ArrayList<Integer> l = new ArrayList<>();
		l.add(0);
		while (l.size() != 0) {
			int p = l.get(0);
			if (b[p]){
				l.remove(0);
				continue;
			}
			b[p] = true;
			l.remove(0);
			ArrayList<Integer> k = new ArrayList<>();
			k = Q(k, p, a, r, n, m,  b);
			l = P(l, k, r, m);
		}
		
			System.out.println(r[n - 1][m - 1] );

		
	}

	private static ArrayList<Integer> P(
			ArrayList<Integer> l, ArrayList<Integer> o,
			int[][] p, int m) {

		for (int i : o)
			l = E(l, i, p, m);

		return l;
	}

	private static ArrayList<Integer> E(ArrayList<Integer> l, int j, int[][] v, int m) {
		int d=j/m;
		int t=j-d*m;
		int i=0;
		for(;i<l.size();i++){
			int li=l.get(i);
	     	int	y=li/m;
			int x=li-y*m;
		if(v[y][x]>v[d][t])	
			break;
		}
		l.add(i,j);
		
		return l;
	}

	private static ArrayList<Integer> Q(ArrayList<Integer> l,
			int p, int[][] a, int[][] j, int n, int m, 
			boolean[] b) {
		int q = p / m;
		int w = p - q * m;

		int YY[] = { -1, 0, 1, 0 };
		int XX[] = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			int y = q + YY[i];
			int x = w + XX[i];
			if (y > n - 1 | x > m - 1 | y < 0 | x < 0)
				continue;
			int c = j[q][w] + a[y][x];
			if (j[y][x] < c)
				continue;

			int g = y * m + x;
			if (b[g])
				continue;
			j[y][x] = c;
			if (y == n - 1 & x == m - 1) {
			
				continue;
			}

			l.add(g);

		}

		return l;
	}

	private static int[][] D(int[][] p, int n) {
		for (int i = 0; i < n; i++)
			Arrays.fill(p[i], Integer.MAX_VALUE);

		return p;
	}

}