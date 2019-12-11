import java.util.Scanner;

public class O_623 {// Main

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int n = myScanner.nextInt();
//		if (n != 0) {
			if (n > 1) {

				rekur(n);
			} else {
				System.out.println(1);
			}
		/*}else{
			System.out.println(0);
		}*/
	}

	private static void rekur(int n) {
		int step = 1;
		int first = 1;
		int second = 2;

		while (step++ != n - 1) {
			int suma = first + second;
			first = second;
			second = suma;
			first=Minus(first);
			second=Minus(second);
			
		}
 
		System.out.println(second);
	 /*  String str = Integer.toString(second);
		   System.out.println(str);  
		   System.out.println(""+str.charAt(str.length()-1));*/
		   
		   
	}

	private static int Minus(int first) {
		if(first>9)
			return first-10;
		return first;
	}
}
