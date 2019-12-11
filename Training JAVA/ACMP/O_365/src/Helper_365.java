import java.util.ArrayList;

public class Helper_365 {

	public static void Find_plusToAnswear(int[] currensyPointes,
			ArrayList<String> answear) {
		String currensy = "";
		for (int i = 0; i < currensyPointes.length; i++) {
			String str = Integer.toString(currensyPointes[i]);
			if(i!=currensyPointes.length-1)
				str+="n";
			currensy += str;
		}
		for (String i : answear)
			if (i.equals(currensy))
				return;

		answear.add(currensy);
		
		return ;
	}

}
