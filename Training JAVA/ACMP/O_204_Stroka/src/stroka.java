import java.util.Scanner;

public class stroka {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String Str = myScanner.nextLine();
		boolean Answear = false;
		int AnsInt = Str.length();
		int[] MaxLine = new int[1];
		for (int i = 1; i < Str.length(); i++) {
			Answear = check(i, Str, MaxLine);

			if (Answear) {
				AnsInt = i;
				i = Str.length();

				continue;
			}
			if(MaxLine[0]>0){
				MaxLine[0]-=1;
			}
			i += MaxLine[0];
		}

		// System.out.println(Answear);
		System.out.println(AnsInt);

	}

	private static boolean check(int n, String str, int[] maxLine) {
		String World = findStartWorld(n, str);
		maxLine[0] = 0;
		int d[] = new int[str.length()];
		boolean have = false;
		for (int i = n; i < str.length(); i ++) {
			have = true;
			String Prov = "";
		
				int t = i % World.length();
				if (World.charAt(t) == str.charAt(i)) {
					maxLine[0] += 1;
					continue;
				}else{
					return false;

			
			}

		}

		return true;
	}

	private static boolean proverks(String world, String prov) {
		String WorldNew = world.substring(0, prov.length());
		if (WorldNew.equals(prov)) {
			return true;
		}

		return false;
	}

	private static String findStartWorld(int i, String str) {
		String world = "";
		for (int i1 = 0; i1 < i; i1++) {
			world += str.charAt(i1);
		}

		return world;
	}

}
