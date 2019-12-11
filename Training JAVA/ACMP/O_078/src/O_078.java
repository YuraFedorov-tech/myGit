import java.util.Scanner;

public class O_078 {
	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);

		int f = M.nextInt();
		int p = M.nextInt();
		int s=f;
		int d=0;
	
		for(int i=0;i<4;i++){
		int o=	(s-f)/p;

			d=s-++o*p;
			s=o*f+d;	
		}
		
		System.out.print(s);
	}
}