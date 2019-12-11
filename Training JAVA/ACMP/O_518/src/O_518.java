import java.util.Scanner;

public class O_518 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		int k = M.nextInt();
		int a[][]=new int[n][n];
		String s=M.nextLine();
		for(int i=0;i<n;i++){
			 s=M.nextLine();
			for(int j=0;j<n;j++)
				a[i][j]=Integer.parseInt(""+s.charAt(j));
		}
		int c[][]=new int[n][n];
		int e[][]=new int[n][n];
		 int[][] d=G(n);
		 e[0][0]=1;
		 for(int i=0;i<k;i++){
			 if(i%2==0){
				 D(c,e,d,a,n,i);
				 e=new int[n][n];
		//		 pr(chet,n);
			 }else{
				 D(e,c,d,a,n,i);
				 c=new int[n][n];
			//	 pr(nechet,n);
			 }
			 
			 
		 }
		 if((k-1)%2==0){
				System.out.println(c[n-1][n-1]);
		 }else
				System.out.println(e[n-1][n-1]);	
		
		
			
	}




	private static void D(int[][] c, int[][] e, int[][] d,
			int[][] a, int n, int s) {
    
    	for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				if(d[i][j]!=s%2  | a[i][j]==1 |e[i][j]==0)
					continue;
			
				C(i,j,c,n,e[i][j],a);
			}

    	
		
	}

    private static  void C(int Y, int X, int[][] c, int n, int e, int[][] a) {
     
 
        int YY[] = { -1, 0, 1, 0 };
        int XX[] = { 0, 1, 0, -1 };
 
        for (int i = 0; i < 4; i++) {
            int y = Y + YY[i];
            int x = X + XX[i];
 
            if (y < 0 | y > n - 1 | x < 0 | x > n - 1)
                continue;
            if (a[y][x]==1)
                continue;
            c[y][x]+=e;
            
        }
       
    }

	private static int[][] G(int n) {
        int [][]p=new int[n][n];
        for (int i = 0; i < n; i++) {
           
            for (int j = 0; j < n; j++) {
                if((i%2==0 &j%2==1)|(i%2==1 &j%2==0))                    
                        p[i][j]=1;
            
            }
                 
            }
        return p;
    }
}