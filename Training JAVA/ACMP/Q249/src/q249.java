import java.util.Arrays;
import java.util.Scanner;

public class q249 {

	public static void main(String[] args) {
		Scanner M = new Scanner(System.in);
		String s = M.nextLine().trim();

		GO(s);
	}

	private static void GO(String s) {
		int n = s.length();
		String ss[][]=new String[n+1][n+1];
		ss=null;
		 ss=new String[n+1][n+1];
		int count[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++)
			Arrays.fill(count[i], 102);
		char ch[] = new char[n + 1];
		for (int i = 0; i < n; i++)
			ch[i] = s.charAt(i);

		for (int len = 1; len <= n; len++) {
			for (int left = 0; left + len - 1 < n; left++) {
				int right = left + len - 1;
				if (len == 1) {
					count[left][right] = 1;
					String ans=FindAns(left,right,ch);
				}
				if (len == 2) {
					if (YES(left, right, ch))
					
						count[left][right] = 0;
					else
						count[left][right] = 2;
				}
				if (len > 2) {
					if (YES(left, right, ch))
						count[left][right] = Math.min(	count[left][right],
								count[left + 1][right - 1]);
				
						for (int right1 = left; right1 < right; right1++) {
							int left2 = right1 + 1;
							count[left][right] = Math.min(	count[left][right] ,count[left ][right1]+		count[left2][right]);
						}

				}
		
			}

		}
		System.out.print(count[0][n - 1]);
	}

	private static String FindAns(int left, int right, char[] ch) {
		String ans="";
		for(int i=left;i<=right;i++){
			String a=FindChar(ch[i]);
		}
		return null;
	}

	private static String FindChar(char c) {
		if(c=='[' | c==']')
			return "[]";
		if(c=='(' | c==')')
			return "()";
		if(c=='{' | c=='}')
			return "{}";
		return "3";
	}

	private static boolean YES(int left, int right, char[] ch) {
		if (ch[left] == '(' & ch[right] == ')')
			return true;
		if (ch[left] == '{' & ch[right] == '}')
			return true;
		if (ch[left] == '[' & ch[right] == ']')
			return true;
		return false;
	}

}
