import java.util.ArrayList;
import java.util.Scanner;

public class O_355 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		String s = my.nextLine();
		int n = s.length();
		ArrayList<String> list = new ArrayList<>();
		// удаление 1 символа
		// s=s.substring(0, s.length()-1);
		// System.out.println(s);

		char myChar[] = s.toCharArray();
		boolean buzy[] = new boolean[n];
		char[] currencySqwear = new char[n];
		String curensy = "";
		long timestart1=System.currentTimeMillis() ;
		rekursia(0, buzy, curensy, myChar, list);
		long timestart2=System.currentTimeMillis() ;
		System.out.println(timestart2-timestart1);
		
	}

	private static void rekursia(int step, boolean[] buzy, String curensy,
			char[] myChar, ArrayList<String> list) {
		if (step == myChar.length) {
			boolean chek = ChekChek(curensy, list);
			if (chek){
		//		System.out.println(curensy);
				list.add(curensy);
			}
			return;
		}

		for(int i=0;i<myChar.length;i++){
			if(buzy[i])
				continue;
			buzy[i]=true;
			curensy+=""+myChar[i];
			rekursia(step+1, buzy, curensy, myChar, list);
			curensy=curensy.substring(0, curensy.length()-1);
			buzy[i]=false;
			
			
		}
		
		
		
		
		
	}

	private static boolean ChekChek(String curensy, ArrayList<String> list) {
		for (String i : list)
			if (i.equals(curensy))
				return false;
		return true;
	}

}
