import java.util.Scanner;

public class O_213 {
	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
		int m = u.nextInt();
		int s[]=new int [m];
		for(int i=0;i<m;i++)
			s[i] = u.nextInt();
		int d= u.nextInt();
		int n=u.nextInt();
		
		int [][]a=new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			a[i][j] = u.nextInt();
		
		int z=0;
		for(int j=0;j<n;j++){
			int A=0;
			boolean k=true;
			for(int i=0;i<m;i++){
				if(a[j][i]==0){
					k=false;
				}else{
					A+=s[i]*a[j][i];
				}
			}
			A-=j*2;
			if(k)
				A+=d;
			
			
			
			
			
			if(A>z)
				z=A;
			System.out.println(z);
		}
	}




}