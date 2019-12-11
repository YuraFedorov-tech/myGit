import java.util.Arrays;
import java.util.Scanner;


public class O_351 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt();



B(n);
		
		
	}

	private static void B(int n) {
	int a[][] = {
	        { 4,  6 },
			{ 8,  6 },
			{ 7,9 },
			{ 4, 8 },
			{ 0,3,9 },
			{ },
			{ 0,1,7},
			{ 2,  6 },
			{ 1,3 },
			{ 2,4 },
	};
	long chet[]=new long[10];
	long nechet[]={0,1,1,1,1,1,1,1,0,1};
	for(int i=2;i<=n;i++){
		if(i%2==0){
		GOONE(chet,nechet,a,n);
		nechet=new long[10];
		}else{
			GOONE(nechet,chet,a,n);
			chet=new long[10];
		}
	}
	if(n%2==0){
		pr(chet);
	}else
	pr(nechet);
	
	
	}

	private static void pr(long[] nechet) {
		long z=0;
		for(int i=0;i<10;i++)
			z+=nechet[i];
		System.out.println(z);
	}

	private static void GOONE(long[] chet, long[] nechet, int[][] a, int n) {
	
for(int i=0;i<10;i++){
	long number=nechet[i];

	for(int j=0;j<a[i].length;j++){
		chet[a[i][j]]+=nechet[i];
	}
	
}

		
		
	}






}
