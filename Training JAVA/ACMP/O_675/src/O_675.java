import java.util.Arrays;
import java.util.Scanner;


public class O_675 {
	public static void main(String[] args) {
	Scanner y = new Scanner(System.in);
	int n = y.nextInt();
	int m = y.nextInt();
	int p[]=new int [n];
	String s=y.nextLine();
	for(int i=0;i<n;i++){

		char c[]=y.nextLine().toCharArray();
		for(int j=0;j<m;j++){
			if(c[j]=='A')
				p[i]=0;
			if(c[j]=='.')
				p[i]++;
			if(c[j]=='B')
				break;
		}
	}
	
	Arrays.sort(p);
	System.out.print(p[0]);
	
}
}