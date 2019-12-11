import java.util.Scanner;

public class O_031 {
	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int k = my.nextInt();

		
	
		int a = 0;
		int z[] = { 0 };
		boolean b[]=new boolean[n];
		rekursia(0, n, k, z, a,b);
		System.out.println(z[0]);
	}

	private static void rekursia(int step,  int n, int k,
		 int[] z, int a, boolean[] b) {
		
		
		if (step == n) {
			if (a == k)
				z[0]++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if(b[i])
				continue;
			
			int c = a;
if(step==i){
	c++;
	if(c>k)
		continue;
}
b[i]=true;	

rekursia(step+1, n, k, z, c,b);

b[i]=false;
		}

	}



}
