import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class O_206 {
	public static void main(String[] args) throws IOException {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String s = stdin.readLine();
	
		String w[] = s.split(" ");
		// количество станций
		int n = Integer.parseInt(w[0]);
		// нужная станция
		int e = Integer.parseInt(w[1]);
		s = stdin.readLine();
		// количество электричек
		int m = Integer.parseInt(s);
		int[][] a = new int[m][n + 1];
		G(a);
	

		for (int i = 0; i < m; i++) {
			s = stdin.readLine();
			String q[] = s.split(" ");
			int u = Integer.parseInt(q[0]);

			a[i][n] = u;
			if (Integer.parseInt(q[1]) > Integer.parseInt(q[3]))
				a[i][n] = -u;
			// int first=Integer.parseInt(q[count])-1;

			for (int j = 1; j < q.length - 1; j += 2) {
				int g = Integer.parseInt(q[j]);
				a[i][g - 1] = Integer.parseInt(q[j + 1]);

			}

		}
		//Helper.pr(a);
		B(a, m, n, e);

	}

	private static void B(int[][] a, int m, int n, int e) {
		int A[] = { Integer.MAX_VALUE };
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<Integer> k = new ArrayList<>();


		

		l.add(0);
		k.add(0);
		
		boolean b[] = new boolean[n];
		while (l.size() != 0) {
			int s = l.get(0);
			l.remove(0);
			int v = k.get(0);
			k.remove(0);
			if (b[s]) {
				continue;
			}
			b[s] = true;
			ArrayList<Integer> j = new ArrayList<>();
			ArrayList<Integer> h = new ArrayList<>();
			Q(j, b, a, m, n,  s,  
					h, v);
			D(A,j,h,e-1);
			B(l, j, k, h);
			M(l,k);
			
		}

			if (A[0] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else
				System.out.println(A[0]);
			
		
	}

	private static void M(ArrayList<Integer> l,
			ArrayList<Integer> p) {

for(int i=0;i<l.size();i++){
	int x=l.get(i);
	for(int j=i+1;j<l.size();j++){
		int y=l.get(j);
		if(x==y){
			l.remove(j);
			p.remove(j);
			j=i;
		}
	}
}
		
		
	}

	private static void D(int[] ans, ArrayList<Integer> l,
			ArrayList<Integer> p, int e) {
for(int i=0;i<l.size();i++){
	int x=p.get(i);
	if(l.get(i)==e)
		if(x<ans[0])
			ans[0]=x;
}

		
		
	}

	private static void B(ArrayList<Integer> l,
			ArrayList<Integer> k, ArrayList<Integer> j,
			ArrayList<Integer> h) {

		for (int i = 0; i < k.size(); i++) {
			int x = h.get(0);
			int y = k.get(0);
			h.remove(0);
			k.remove(0);
			I(l, j, x, y);
i=-1;
		}

	}

	private static void I(ArrayList<Integer> l,
			ArrayList<Integer> k, int x, int y) {
		int i = 0;
		for (; i < k.size(); i++)
			if (k.get(i) > x)
				break;
		l.add(i, y);
		k.add(i, x);
		
	}

	private static void Q(ArrayList<Integer> l,
			boolean[] b, int[][] a, int m, int n,  int s,
			 ArrayList<Integer> k,
			int c) {

		for (int i = 0; i < m; i++) {
			if (a[i][s] == -1)
				continue;
			if (a[i][s] < c)
				continue;
			if (a[i][n] > 0) {
				W(l, b, a, s,  k,
						c, i);
			} else
				E(l, b, a, s, k,
						c, i);

		}

	}

	private static void E(ArrayList<Integer> l, boolean[] b,
			int[][] a, int s,  ArrayList<Integer> k,
			int c, int i) {
		for (int n = s - 1; n >= 0; n--) {
			if (a[i][n] == -1 | b[n])
				continue;
			l.add(n);
			k.add(a[i][n]);

		}

	}

	private static void W(ArrayList<Integer> l,
			boolean[] b, int[][] a, int s, 
			ArrayList<Integer> k, int c, int i) {
		for (int n = s + 1; n < a[0].length - 1; n++) {
			if (a[i][n] == -1 | b[n])
				continue;
			l.add(n);
			k.add(a[i][n]);

		}

	}



	public static void G(int[][] a) {
		for (int i = 0; i < a.length; i++) 
			Arrays.fill(a[i], -1);
		
	}


}