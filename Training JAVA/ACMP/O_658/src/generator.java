import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class generator {  //Main

	public static void main(String[] args) {
		ArrayList<Integer> listInput = new ArrayList<Integer>();
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int a[][]=new int[n][2];
		for (int i = 0; i < n; i++) {
			while(true){
				a[i][0]= (int) (Math.random()*30);
				a[i][1]= (int) (Math.random()*30 );
				boolean q=Find(a,i);
				if(!q)
					break;
				
			}
			}
			
		for(int i=0;i<a.length;i++)
			System.out.println(a[i][0] + " "+a[i][1]);
			
			
		}
	
	private static boolean Find(int[][] a, int n) {
int x=a[n][0];
int y=a[n][1];
for(int i=0;i<n;i++){
	if(x==a[i][0] &y==a[i][1])
		return true;
	
	
}
	
	
	
		
	return false;
}
	}




