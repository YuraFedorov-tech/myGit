import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class O_169 {
	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
		int n = u.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		a[i]=u.nextInt();
	
		B(a,n);
	
	}

	private static void B(int[] a, int n) {
		int b[][]=new int[n][3];
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(a[0]>=0)
			list.add(0);
		b[0][0]=a[0];
		b[0][2]=Math.max(a[0], 0);
	//if(a[0]<a[0]+a[1])
		list.add(1);
		b[1][0]=Math.max(a[0]+a[1], a[1]);
		b[1][1]=Math.max(a[1], 0);
        b[1][2]=Math.max(b[1][0],b[1][1]);
		
	
		for(int i=2;i<n;i++){
			b[i][0]=b[i-1][2]+a[i];
			b[i][1]=b[i-2][2]+a[i];
			b[i][2]=Math.max(b[i][0],b[i][1]);
			
			
		
		}
		System.out.println(b[n-1][2]);
		for(int i=0;i<list.size();i++)
			System.out.print((list.get(i)+1)+" ");
	}

	


}
