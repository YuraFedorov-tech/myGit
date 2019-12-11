
import java.util.Scanner;

public class O_466 {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
	
		System.out.print(b(n.nextInt()));
	}

	public static int b(int n) {
		   
   	 if(n==0)return 0; 
   	 if(n==1)return 1; 
   	 if(n%2==0)return b(n/2); 
   	 return b(n/2)+b(n/2+1); 


   	 }
	
}

