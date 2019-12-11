import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class O_373_2 {
	public static void main(String[] args) throws IOException {
		long timestart1 = System.currentTimeMillis();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String f[] = stdin.readLine().trim().split(" ");
		int n = Integer.parseInt(f[0]);
		int k = Integer.parseInt(f[1]);
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] ff = stdin.readLine().trim().split("\\ ", -1);
			for (int j = 0; j < n; j++)
				a[i][j] = Integer.parseInt(ff[j]);
		}
		long timestart2 = System.currentTimeMillis();
		B(a, n, k);
		long timestart3 = System.currentTimeMillis();
		System.out.println(timestart2 - timestart1);
		System.out.println(timestart3 - timestart2);
		System.out.println(timestart3 - timestart1);
	}

	private static void B(int[][] a, int n, int k) {
		int[][] chet = new int[n][n];
		boolean[][] buzy = new boolean[n][n];
		chet[0][0] = a[0][0];

		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(0);
		list.add(0);
		int g = 1;
		int plus[][] = FindPlus(a, n);
		int step = 0;
		int[][] doska=DO_DOSKA(n);
	//	buzy[0][0]=true;
		while (g != 0) {
			plusit(buzy, a, n, plus, chet, step,doska);
	//		pr(chet,n);
			for (int i = 0; i < g; i++) {
				GO(list, a, n, k, chet, buzy, step);
	//			pr(chet,n);
			}
	//		pr(chet,n);
			g = list.size() / 2;
			step++;
		}
		pr(chet,n);
		int ans= FindAns1(plus, step, k, chet, a,n);
		 System.out.println(ans);
	}
	private static int FindAns1(int[][] plus, int i, int k, int[][] chet,
			int[][] a, int n) {
		int yy[][]=new int[n][n];
		int rest = (k - 2 - i) / 2 +1;
		for (int jj = 0; jj< n; jj++)
			for (int j = 0; j < n; j++) {
				yy[jj][j] = plus[jj][j] * rest + chet[jj][j];
				if ((k -2 - i) % 2 ==0)
					yy[jj][j] -= a[jj][j];
			}

		return prin(yy, n);
	}
	private static int prin(int[][] chet, int n) {
		int max = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (max < chet[i][j])
					max = chet[i][j];

		// System.out.println(max);
		return max;
	}
	private static int[][] DO_DOSKA(int n) {
		int [][]p=new int[n][n];
		for (int i = 0; i < n; i++) {
			int ii=i%2;
			for (int j = 0; j < n; j++) {
				if(ii==0){
					if(j%2==1)
						p[i][j]=1;
				}
				if(ii==1){
					if(j%2==0)
						p[i][j]=1;
				}
			}
				
			}
		return p;
	}

	private static void pr(int[][] chet, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(chet[i][j]+"\t");
			}
			System.out.println();
			}
		System.out.println();
	}

	private static void plusit(boolean[][] buzy, int[][] a, int n,
			int[][] plus, int[][] chet, int step, int[][] doska) {
int qStep=1-step%2;
	
for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x = i * n + j;
				if (!buzy[i][j])
					break;
			if(doska[i][j]==qStep)
				chet[i][j]+=plus[i][j];
			}
		}
	}

	private static void GO(ArrayList<Integer> list, int[][] a, int n, int k,
			int[][] chet, boolean[][] buzy, int step) {
		int yOld = list.get(0);
		int xOld = list.get(1);
		buzy[yOld][xOld]=true;
		int priceOld = chet[yOld][xOld];
		list.remove(0);
		list.remove(0);
		// price.remove(0);
		int Y[] = { -1, 0, 1, 0 };
		int X[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {

			int y = yOld + Y[i];
			int x = xOld + X[i];
			if (y > n - 1 | y < 0 | x > n - 1 | x < 0 )
				continue;
			if(buzy[y][x])
				continue;
			int newPrice = priceOld + a[y][x];
			if (chet[y][x] <newPrice) {
				
				if(buzy[y][x] |(!buzy[y][x] &chet[y][x]==0) ){
					list.add(y);
						list.add(x);
			//			buzy[y][x]=false;;
					
					}
				chet[y][x] =newPrice;
			}	
				//chet[y][x] =newPrice;
		
		

		}

	}

	private static int[][] FindPlus(int[][] a, int n) {
		int ans[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				ans[i][j] = FindONE_element(i, j, a, n);

		return ans;
	}

	private static int FindONE_element(int Y, int X, int[][] a, int n) {
		int max = -5;

		int YY[] = { -1, 0, 1, 0 };
		int XX[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int y = Y + YY[i];
			int x = X + XX[i];

			if (y < 0 | y > n - 1 | x < 0 | x > n - 1)
				continue;
			if (max < a[y][x])
				max = a[y][x];
		}
		return max + a[Y][X];
	}

}
