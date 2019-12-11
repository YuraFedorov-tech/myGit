import java.util.ArrayList;
import java.util.Scanner;

public class O_218 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		String q0=myScanner.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String str = myScanner.nextLine();
			str = str.trim();
			list.add(str);

		}
		String a[][] = new String[10][10];
		a = startt.Fill_Befor_Start(a);
		a = startt.DoStart(a);
		startt.printA(a);
		
	//	System.out.println();
		for (int i = 0; i < n; i++){
			a = steping(a, list.get(i));
			startt.printA(a);
		}
	a=ToStandart(a);
		
	startt.printA(a);
		
	
	
	}

	private static String[][] ToStandart(String[][] a) {

		for (int i = 8; i >0; i--) {
			for (int j = 1; j < 9; j++) {
			if(a[i][j].equals("*"))
				a[i][j]="-";
			}
		}
		
		
		return a;
	}

	private static String[][] steping(String[][] a, String str) {
		// смотрим рубка или обычный ход
		int n = 0;
		for (int i = 2; i < str.length(); i++) {
			if (str.charAt(i) == ':')
				n++;
		}
if(n==0){    //если ход обычный
	a=Steps.SimplStep(a,str);
}else{ //если ход -рубка
	a=StepRUBKA.Rubka(a,str,n);
	
	
	
}
		
		
		
		
		return a;
	}

}
