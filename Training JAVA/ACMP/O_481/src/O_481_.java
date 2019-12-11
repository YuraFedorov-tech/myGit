import java.util.ArrayList;
import java.util.Scanner;

public class O_481_ {// Main
	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		String a = my.nextLine();
		long []asdf=new long[1];
	String n=ManachersAlgorithm.findLongestPalindrome(a,asdf);
	System.out.println(asdf[0]);
		
		ArrayList<String> l = new ArrayList<String>();
		// l_a = From_a(l_a, a);
	//	System.out.println(l);
		int[] ans = new int[1];
		ans = Solution(0, l, a.length(), ans, a);
		System.out.print(ans[0]);
	}

	private static int[] Solution(int step, ArrayList<String> list_ans,
			int maxLine, int[] ans, String a) {
		if (step == maxLine)
			return ans;
		if (Polinrom_began(a, ans, list_ans));

		String standart = a;

		int line_List = a.length();
		for (int i = 0; i < line_List; i++) {
			if (a.charAt(i) == '0')
				continue;
			a = standart;
			a = minus_i_simvol(a, i);
			ans = Solution(step + 1, list_ans, maxLine, ans, a);

		}

		return ans;
	}

	private static boolean Polinrom_began(String a, int[] ans,
			ArrayList<String> list_ans) {
		String aa = Delete_0(a);
		if (!Polinrom(aa))
			return false;
		if (chek_has_in_list_ans(a, list_ans,ans))
			return true;

		return false;
	}

	private static boolean chek_has_in_list_ans(String a,
			ArrayList<String> list_ans, int[] ans) {
for(int i=0;i<list_ans.size();i++)
if(a.equals(list_ans.get(i)))
	return true;
list_ans.add(a);
ans[0]+=1;
	
	
		return false;
	}

	private static String Delete_0(String a) {
		String[] f = a.split("0");
		String ans = "";
		for (int i = 0; i < f.length; i++) {
			ans += f[i];
		}

		return ans;
	}

	private static boolean Polinrom(String a) {
		for (int i = 0; i < a.length() - 1; i++) {

			if (a.charAt(i) == a.charAt(a.length() - 1 - i))
				continue;
			return false;

		}

		return true;
	}

	private static String minus_i_simvol(String a, int i) {
		
		return a.substring(0, i) + "0" + a.substring(i+1);
	}

	private static ArrayList<String> From_a(ArrayList<String> l_a, String a) {
		for (int i = 0; i < a.length(); i++) {
			char as = a.charAt(i);
			String s = String.valueOf(as);
			l_a.add(s);
		}
		return l_a;
	}
}
