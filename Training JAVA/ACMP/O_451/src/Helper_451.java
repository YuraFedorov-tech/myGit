import java.util.ArrayList;

public class Helper_451 {

	public static String DeleteSpace(String s) {
		String q = "";
		for (String i : s.split("\\ ", -1))
			q += i;
		return q;
	}

	static int Find_first_back_brace(String s) {
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == ')')
				return i;
		return -1;
	}

	public static int Find_first_video_brace(String s, int first_back_bracet) {
		for (int i = first_back_bracet; i >= 0; i--)
			if (s.charAt(i) == '(')
				return i;
		return -1;
	}

	public static double Chek_cos_or_sinus(String[] s1, double q) {
		String s = s1[0];
		int l = s.length() - 1;
		if (s.length() < 3)
			return q;
		if (s.charAt(l) == 'n')
			if (s.charAt(l - 1) == 'i')
				if (s.charAt(l - 2) == 's') {
					q = Math.sin(q);
					if (l == 2)
						s1[0] = "";
					s1[0] = s1[0].substring(0, l - 2);
					if (s1[0].length() != 0) {
						if (s1[0].charAt(s1[0].length() - 1) == '-' & s1[0].length()==1 ) {
							s1[0] = s1[0].substring(0, s1[0].length() - 1);
							q = -q;
						}
					}
					return q;
				}
		if (s.charAt(l) == 's')
			if (s.charAt(l - 1) == 'o')
				if (s.charAt(l - 2) == 'c') {
					q = Math.cos(q);
					if (l == 2)
						s1[0] = "";
					
					s1[0] = s1[0].substring(0, l - 2);
					if (s1[0].length() != 0) {
						if (s1[0].charAt(s1[0].length() - 1) == '-' & s1[0].length()==1 ) {
							s1[0] = s1[0].substring(0, s1[0].length() - 1);
							q = -q;
						}
					}
					return q;
				}

		return q;
	}

	public static int Find_number_of_polynomial(String breket) {
		String s = "";
		for (int i = 1; i < breket.length(); i++)
			s += "" + breket.charAt(i);
		return Integer.parseInt(s);
	}

	public static ArrayList<String> Delete_Plus_minus_multi_devide(
			ArrayList<String> listBreket, String breket,
			ArrayList<String> znakBreket) {
		breket=breket.trim();	
		if (breket.charAt(0) == '-') {
			breket = breket.substring(1, breket.length());
			znakBreket.add("-");
		} else
			znakBreket.add("+");
		
		if (breket.charAt(0) == '+') 
			breket = breket.substring(1, breket.length());
		
		while (true) {
			if (breket == "")
				break;
			int i = 0;
			for (; i < breket.length(); i++) {
				String g = "" + breket.charAt(i);
				// если 1 то значит нашли 1 из знаков -+ - * или /
				boolean FindZnak = Find_FindZnak(g, znakBreket);
				if (FindZnak)
					break;

			}
			String s1 = breket.substring(0, i);
			if (i != breket.length()) {
				breket = breket.substring(i + 1, breket.length());
			} else
				breket = "";
			listBreket.add(s1);

		}
		return listBreket;
	}

	private static boolean Find_FindZnak(String g, ArrayList<String> znakBreket) {
		switch (g) {
		case "*":
			znakBreket.add("*");
			return true;
		case "/":
			znakBreket.add("/");
			return true;
		case "+":
			znakBreket.add("+");
			return true;
		case "-":
			znakBreket.add("-");
			return true;

		}
		return false;
	}

	public static void DeletUnarnyeZnaki(ArrayList<String> listBreket,
			ArrayList<String> znakBreket, double[] ans) {
		String s=listBreket.get(0).trim();
		listBreket.set(0, s);
for(int i=0;i<listBreket.size();i++){
	 s=listBreket.get(i).trim();
	listBreket.set(i, s);
	if(s.equals("")){
		if(i==listBreket.size()-1){
			ans[0]=Double.MAX_VALUE;
			return ;
		}
			
		if(znakBreket.get(i).equals("+") |znakBreket.get(i).equals("-")){
			int x=znakBreket.get(i).equals("+")?1:-1;
			listBreket.remove(i);
			znakBreket.remove(i);
			if(x==-1){
				String  ww=znakBreket.get(i);
				if(ww.equals("+"))
					znakBreket.set(i, "-");
				if(ww.equals("-"))
					znakBreket.set(i, "+");
			}
			i--;
			continue;
		}

ans[0]=Double.MAX_VALUE;
return;
	}
		
	
}
		
		
		
	}

}
