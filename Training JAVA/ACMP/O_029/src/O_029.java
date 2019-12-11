
import java.util.Scanner;

public class O_029 {

	

	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
		int n = u.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = u.nextInt();

         int c[][] = new int[n][2];
		 for (int i = 0; i < n - 1; i++) {
			c[i][0] = Math.abs(a[i + 1] - a[i]);
			if (i != n - 2)
				c[i][1] = 3 * Math.abs(a[i + 2] - a[i]);
		}

int []p=new int[n];
p[1]=c[0][0];
for(int i=2;i<n;i++){
	int x=p[i-1]+c[i-1][0];
	int y=p[i-2]+c[i-2][1];
	p[i]=x<y?x:y;

	
}
System.out.println(p[n-1]);	
		
	}



	



}