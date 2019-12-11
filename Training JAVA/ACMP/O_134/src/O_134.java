import java.util.ArrayList;
import java.util.Scanner;

public class O_134 {
	public static void main(String[] args) {
		Scanner o = new Scanner(System.in);
		int n = o.nextInt();
		int s = o.nextInt()-1;
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = o.nextInt();
			}

		}
Began(a,s,n);
		
		
		
	}

	private static void Began(int[][] a, int s, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(s);
		int []ans={0};
		boolean buzy[]=new boolean[n];
		buzy[s]=true;
		while(list.size()!=0){
			go(a,n,list,buzy,ans);
			
		}
		System.out.print(ans[0]);
	}

	private static void go(int[][] a, int n, ArrayList<Integer> list,
			boolean[] buzy, int[] ans) {
		int ver=list.get(0);
		list.remove(0);
		for(int i=0;i<n;i++){
			if(a[ver][i]==0 | buzy[i])
				continue;
			buzy[i]=true;
			list.add(i);
			ans[0]++;
		}
		
		
	}
}
