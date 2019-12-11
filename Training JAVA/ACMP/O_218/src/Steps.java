public class Steps {

	public static String[][] SimplStep(String[][] a, String str) { // //если ход
																	// обычный
		int StartLetter = 0;
		int StartNumber = 0;
		int EndLetter = 0;
		int EndNumber = 0;
		String u="]]]]";
		for (int i = 0; i <4; i +=3) {
			String q = "" + str.charAt(i);
			String w = "" + str.charAt(i + 1);
			if (i == 0) {
				StartNumber = Integer.parseInt(w);
				StartLetter = FindNumber(q);
			}
			if (i == 3) {
				EndNumber = Integer.parseInt(w);
				EndLetter = FindNumber(q);
			}
	
			
			
		}
		 u=a[StartNumber][StartLetter];
		a[StartNumber][StartLetter]="*";
	
	if((u.equals("w") & EndNumber==8)|(u.equals("b") & EndNumber==1))
		u=u.toUpperCase();
	
	a[EndNumber][EndLetter]=u;
		return a;
	}

	static int FindNumber(String q) {
		int y = -5;
		switch (q) {
		case "a":
			y = 1;
			break;
		case "b":
			y = 2;
			break;
		case "c":
			y = 3;
			break;
		case "d":
			y = 4;
			break;

		case "e":
			y = 5;
			break;
		case "f":
			y = 6;
			break;
		case "g":
			y = 7;
			break;
		case "h":
			y = 8;
			break;
		}

		return y;
	}

}
