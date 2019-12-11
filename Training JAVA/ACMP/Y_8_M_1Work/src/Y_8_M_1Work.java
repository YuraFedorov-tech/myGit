import java.util.Arrays;
import java.util.Scanner;


public class Y_8_M_1Work {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
	
		myScanner.close();
		int y=1;
		for(int i=1;i<=n;i++){
	y*=i;
}
	int[] []Ans=new int [y][n];
	
	for(int i=0;i<n;i++){
		Ans[0][i]=i+1;
	}
	
//	Ans=rekur(Ans, 0 , n);
	
	
	
	
	for(int i=1;i<y;i++){
		Ans[i]=Arrays.copyOf(Ans[i-1],n);
		int fir=i%n;
		int sec=(i+1)%n;
		int r=Ans[i][fir];
		Ans[i][fir]=Ans[i][sec];
		Ans[i][sec]=r;
		System.out.println(Arrays.toString(Ans[i]));
	}
		for(int i=0;i<n;i++){
			
			System.out.print(" ");
			
		}
		System.out.println(Arrays.toString(Ans));
		

	
}

	private static int[][] rekur(int[][] ans, int i, int n) {
if (i==n-1){
	
}

		
		return null;
	}

}
