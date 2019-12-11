import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_507 {
	
	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		int n = m.nextInt();
		int[][] a = new int[n][n];
		int[] u = new int[n];
		int c = 0;
		for (int j = 0; j < n; j++) {
			u[j] = m.nextInt();
			c += u[j];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = m.nextInt();

			}

		}

		int l[] = { 0 };
	
		Began(a, u, n, c, l);
		
	}

	private static void Began(int[][] a, int[] u, int n, int c,
			int[] h) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> k = new ArrayList<Integer>();
		W(l, a, n, k);
		int[][] A = new int[1000][n];

		R(a, u, n, c, l, k, A, h);
		Q(A, h, n);
	}

	static void R(int[][] a, int[] u, int n, int c,
			ArrayList<Integer> l, ArrayList<Integer> m,
			int[][] A, int[] t) {
		
		  if(c==1){ 
			  T(A,t,u,a);
		  return; }
		 
		for (int i1 = 0; i1 < l.size(); i1++) {
			int p = l.get(i1);
			int i = p / n;
			int j = p - i * n;

			int v = m.get(i1);
			if (v == 0) {
				for (int r = 0; r < 2; r++) {
					if (r == 0) {
					
						if (u[i] < 1 | u[j] < 1)
							continue;

						u[i]--;
						R(a, u, n, c - 1, l, m,
								A, t);
						u[i]++;
					}
					if (r == 1) {
						

						if (u[i] < 1 | u[j] < 1)
							continue;

						u[j]--;
						R(a, u, n, c - 1, l, m,
								A, t);
						u[j]++;
					}
				}
			}
			if (v == 1) {
			
				if (u[j] < 1 | u[j] < 1)
					continue;
				u[j]--;
				R(a, u, n, c - 1, l, m, A,
						t);
				u[j]++;
			}
			if (v == 2) {
			
				if (u[i] < 2)
					continue;
				u[i]--;
				R(a, u, n, c - 1, l, m, A,
						t);
				u[i]++;
			}

		}

		Find_find(A, t, u, a);


	}

	private static void T(int[][] A, int[] c,
			int[] u, int[][] a) {
		for (int i = 0; i < c[0]; i++) {
			if (Arrays.equals(A[i], u))
				return;
		}
		
		
		A[c[0]] = Arrays.copyOf(u, u.length);
		c[0]++;
		return;
		
	}

	static void Find_find(int[][] A, int[] c, int[] u,
			int[][] a) {
		// если правда значит такого решения мы еще не находили
		for (int i = 0; i < c[0]; i++) {
			if (Arrays.equals(A[i], u))
				return;
		}
		boolean b = E(u, a);
		// если правда то добавляем ответ, а если ложь то нет
		
		
		if (!b)
			return;
		A[c[0]] = Arrays.copyOf(u, u.length);
		c[0]++;
	}

	private static boolean E(int[] u, int[][] a) {
		// если правда то добавляем ответ, а если ложь то нет
		int n = u.length;
		for (int i = 0; i < n; i++) {
			if (u[i] == 0)
				continue;
			for (int j = i; j < n; j++) {
				if (u[j] == 0)
					continue;
				if (i == j) {
					if (a[i][j] == 1 & u[i] > 1)
						return false;
				} else {
					if (a[i][j] == 1 | a[j][i] == 1)
						return false;
				}

			}

		}

		return true;
	}

	private static void W(ArrayList<Integer> l, int[][] a, int n,
			ArrayList<Integer> m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0)
					continue;

				if (a[j][i] == 1) {
					if (i > j)
						continue;

					if (i == j) {
						l.add(i * n + j);
						m.add(2);
						continue;
					}
					m.add(0);
				} else
					m.add(1);
				l.add(i * n + j);
			}

		}

	}
	
static void Q(int[][] A, int[] c, int n) {
		System.out.println(c[0]);
		for(int i=0;i<c[0];i++){
			for(int j=0;j<n;j++){
				System.out.print(A[i][j]);
				if(j!=n-1)
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}