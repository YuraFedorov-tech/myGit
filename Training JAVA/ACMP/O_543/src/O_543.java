import java.util.Scanner;

public class O_543 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int w = my.nextInt();
		int d = my.nextInt();
		int p = my.nextInt();
		int nNew = w * ((n - 1) * n) / 2;
		int ans=0;
		if (nNew == p) {
			ans=n;;

		} else {
int nn=nNew-p;
 ans =nn/d;
			
			
		}
		System.out.println(ans);
	}

}
