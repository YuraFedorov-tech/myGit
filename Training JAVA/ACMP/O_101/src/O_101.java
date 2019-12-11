import java.util.Arrays;
import java.util.Scanner;


public class O_101 {
	public static void main(String[] args) {
	Scanner y = new Scanner(System.in);
		int n = y.nextInt();
		int k=y.nextInt();
		int a[][]=new int [n][n];
		int ans[]={0};
		boolean[] g=new boolean[n];
	
		 int p[][]=new int [n][2];
		began(ans,n,k,0,a,-1,g,p);
	
		System.out.println(ans[0]);
	
}

	private static void began(int[] ans, int n, int k, int c, int[][] a, int last_I, boolean[] g, int[][] p) {
if(c==k){
	ans[0]++;
	return;
}

for(int i=last_I+1;i<n;i++){
	for(int j=0;j<n;j++){
		if(g[j]|a[i][j]!=0)
			continue;
		boolean newElefant=F(p,i,j,c);
		if(!newElefant){
			continue;
		}
		
		p[c][0]=i;
		p[c][1]=j;
			c++;
			
	
			
			b(a, i, j, n);

			g[j]=true;
			began(ans,n,k,c,a,i,g,p);
			c--;
			a=m(a,i,j,n);
			g[j]=false;
	
		
	}
	
	
}



		
	}



	static void b(int[][] newA, int i, int j, int n) {
		int[] yy = { 1, 2, 2, 1, };
		int[] xx = { 2, 1, -1, -2, };
		for (int t = 0; t < 4; t++) {
			int y = i + yy[t];
			int x = j + xx[t];
			if (y > n - 1 | x < 0 | x > n - 1)
				continue;
			newA[y][x]++;
		}

	}






	public static int[][] m(int[][] a, int i, int j, int n) {

		int[] yy = { 1, 2, 2, 1, };
		int[] xx = { 2, 1, -1, -2, };
		for (int t = 0; t < 4; t++) {
			int y = i + yy[t];
			int x = j + xx[t];
			if (y > n - 1 | x < 0 | x > n - 1)
				continue;
			a[y][x]--;

		}
		return a;
	}

	public static boolean F(int[][] pointMagarage, int i, int j,
			int count) {
		for (int i1 = 0; i1 < count; i1++) {
			int y = pointMagarage[i1][0];
			int x = pointMagarage[i1][1];
			int raz = i - y;
			if (x - raz == j | x + raz == j)
				return false;
		}

		return true;
	}
}