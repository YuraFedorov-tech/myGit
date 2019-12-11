import java.util.Scanner;

public class Kras {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String Str;

		Str = myScanner.nextLine();

		String Answear = "";
		boolean Kosyak = proverka(Str);
		if (Kosyak) {
			Answear = "";
			int[] Kod = { 5 }; // если Код = 0, значит перед этим была
			// точка и
			// нжно
			// начинать с Большой буквы
			String[] f = Str.split("\\.");

			for (int j = 0; j < f.length; j++) { // кол-во предложений
				// между
				// точками
				boolean Predl = findPredl(f[j]); // если в предложении
				// есть хоть
				// 1
				// буква
				if (!Predl) {
					continue;
				}

				if (Kod[0] != 5) {
					Kod[0] = 1;
				}

				String[] word = f[j].split(" ");

				for (int i = 0; i < word.length; i++) {// кол-во СЛОВ между
														// ПРОБЕЛАМИ
					boolean worda = findPredl(word[i]);
					if (!worda) {
						continue;
					}
					// word[i]+=" ";
					word[i] = working(word[i], Kod);
					Kod[0] = 0;
					Answear += word[i];
					if (i != word.length - 1) {
						Answear += " ";
					}
					/*
					 * if (j == f.length - 1 & i == word.length - 1) { Otvet =
					 * Otvet.substring(0, Otvet.length() - 1); }
					 */
				}
				Answear += ". ";
			}
			if (Answear.length() != 0) {
				Answear = Answear.substring(0, Answear.length() - 1);
			}
		}
		if (Answear.length() != 0) {
			System.out.println(Answear);
		}else{
			System.out.println(-1);
		}
	

	}

	private static boolean proverka(String str) {

		for (int j = 0; j < str.length(); j++) {
			boolean t = proverkaBukva(str.charAt(j));
			if (t | (str.charAt(j) == ' ' | str.charAt(j) == '.')) {
				continue;
			}
			return false;
		}

		return true;
	}

	private static String working(String world, int[] Kod) {
		while (true) {
			boolean t = proverkaBukva(world.charAt(0));
			if (t) {
				break;
			}
			world = world.substring(1, world.length());
		}
		while (true) {
			boolean t = proverkaBukva(world.charAt(world.length() - 1));
			if (t) {
				break;
			}
			world = world.substring(0, world.length() - 1);
		}
		int y = 0;
		if (Kod[0] == 1 | Kod[0] == 5) {
			y = 1;
		}

		world = world.substring(0, y).toUpperCase()
				+ world.substring(y).toLowerCase();

		return world;
	}

	private static boolean findPredl(String string) {
		for (int i = 0; i < string.length(); i++) {
			boolean bukva = proverkaBukva(string.charAt(i));
			if (bukva) {
				return true;
			}
		}

		return false;
	}

	private static boolean proverkaBukva(char charAt) {
		if (charAt >= 'a' & charAt <= 'z') {
			return true;
		}
		if (charAt >= 'A' & charAt <= 'Z') {
			return true;
		}

		return false;
	}

}
