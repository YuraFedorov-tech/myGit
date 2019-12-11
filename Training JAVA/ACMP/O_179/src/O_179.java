import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_179 {
	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
		int n = u.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = u.nextInt();
		}
		int b[][] = new int[n][3];
		

		
		b[0][0] = a[0];
		b[0][2] = Math.max(a[0], 0);
	
		b[1][0] = Math.max(a[0] + a[1], a[1]);
		b[1][1] = a[1];
		b[1][2] = Math.max(b[1][0], b[1][1]);

		for (int i = 2; i < n; i++) {
			 b[i][0] = b[i - 1][2] + a[i];
			 b[i][1] = b[i - 2][2] + a[i];
		if(i==2)
			 b[i][1] = b[i - 2][0] + a[i];
		
			b[i][2] = Math.max(b[i][0], b[i][1]);
		

		}
		System.out.println(b[n - 1][2]);
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(n-1);
		for (int i = n-1; i >0; i--) {
			if(b[i][2]==b[i][1]){
		
				l.add(0,i-2);
				i--;
				continue;
			}
			l.add(0,i-1);
		
		}

		for (int i = 0; i < l.size(); i++){
			int x=l.get(i);
		if(x!=-1)
			System.out.print((x + 1) + " ");
		}

	}

	



}
