import java.util.ArrayList;
import java.util.Scanner;


public class O_309 {// Main

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int k = myScanner.nextInt();
		//System.out.print(ans[0]);
		//	ArrayList<String> list = new ArrayList<String>();
		int ans[]=new int[1];		
		for(int i=1;i<k;i++){
		  Integer norm=i;
		  Integer turn=TernNorm(norm);
		if(norm+turn==k)	
			ans[0]+=1;
			
		}
		System.out.print(ans[0]);
		
		
		
		

	}

	private static Integer TernNorm(Integer norm) {
		Integer turn;
		String str = Integer.toString(norm);
		String turnStr=DoStr(str);
		turn=Integer.parseInt(turnStr); 
		
		return turn;
	}

	private static String DoStr(String str) {
		String turnSt="";
boolean start =true;
		for(int i=0;i<str.length();i++){
	int y=str.length()-1-i;
	if(str.charAt(y)=='0' & start)
		continue;
	start=false;
	turnSt+=""+str.charAt(y);
	
}
		
		
		return turnSt;
	}

}
