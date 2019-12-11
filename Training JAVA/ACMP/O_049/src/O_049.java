import java.util.Arrays;
import java.util.Scanner;

public class O_049 {
	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		int a[]=new int [n+1];
		a[1]=a[0]=1; 
		for(int i=2;i<=n;i++)
			a[i]=a[i/2]+a[i-2]; 
		System.out.println(a[n]);
	}

}
