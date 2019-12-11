import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class O_153 {
	public static void main(String[] args) throws IOException {
	    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		Scanner myScanner = new Scanner(System.in);
String s=stdin.readLine();

String q[]=s.split(" ");
int b= Integer.valueOf(q[0]);
int n= Integer.valueOf(q[1]);
//	int nMaatric = myScanner.nextInt();
	//	int n = myScanner.nextInt();
s=stdin.readLine();	

String w[]=s.split(" ");
int y= Integer.valueOf(w[0])-1;
int x= Integer.valueOf(w[1])-1;
	//	int y = myScanner.nextInt() - 1;
	//	int x = myScanner.nextInt() - 1;
s=stdin.readLine();	
		int p = Integer.valueOf(s);
		s=stdin.readLine();			
		
		int a[][][] = new int[b][n][n];
		for (int t = 0; t < b; t++) {
			
			for (int i = 0; i < n; i++) {
				s=stdin.readLine();
			
				String m[]=s.split(" ");
				for (int j = 0; j < n; j++) {
					a[t][i][j] = Integer.valueOf(m[j]);
				}

			}
			if(t!=b-1)
			s=stdin.readLine();	
		}

		int[][] A = B(a, n, b, p, y, x);
		System.out.println(A[y][x]);

	}

	private static int[][] B(int[][][] a, int n, int z, int p,
			int yy, int xx) {
		// answear=Work.InsideFirstMatrica(answear,a,n,0);
		int x[][] = new int[n][n];
		int y[][] = new int[n][n];

		int l[][] = new int[n][n];
		x = F(x, a, n, 0, yy, xx);
		for (int i = 1; i < z; i++) {
			l = F(l, a, n, i, yy, xx);
			if (i % 2 == 1) {
				y = M(x, l, n, p, yy, xx);
	
			} else {
				x = M(y, l, n, p, yy, xx);
			
			}

		}

		if ((z - 1) % 2 == 1)
			return y;
		return x;
	}



	private static int[][] M(int[][] x, int[][] e, int n, int p,
			int yy, int xx) {
		int[][] A = new int[n][n];


		

			for (int j = 0; j < n; j++) {
				
				int q = X(x, e, n, p, yy, j);
				A[yy][j] = q;

			}

		

		return A;
	}

	private static int X(int[][] a, int[][] b, int n, int p, int i,
			int j) {
		int s = 0;
		for (int k = 0; k < n; k++) {
			int q = a[i][k] * b[k][j];
			s += q;
		}
		if (s >= p)
			s = s % p;
		return s;
	}

	public static int[][] F(int[][] A, int[][][] a,
			int n, int j, int yy, int xx) {
	
			for(int i=0;i<n;i++){
				A[i] = Arrays.copyOf(a[j][i], n);
			}
			
			
		return A;
	}

}