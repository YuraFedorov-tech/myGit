
import java.util.ArrayList;
import java.util.Scanner;

public class O_049_2 {
	private static void À(int[] began, int[] end, char c) {
		if (c == '?') {
			began[0] = 0;
			end[0] = 9;
			return;
		}
		if (c >= 'a' & c <= 'g') {
			began[0] = 0;
			end[0] = 3;

			int t = FindT(c);
			began[0] += t;
			end[0] += t;
			return;
		}
		if (c >= '0' & c <= '9') {
			began[0] = end[0] = Integer.parseInt("" + c);
			return;
		}

	}
	private static int FindT(char c) {
		switch (c) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;

		}
		return 100;

	}
	public static void main(String[] args) throws IOException {
		Scanner t=new Scanner(System.in);

		String s1 = t.nextLine();
		String s2 = t.nextLine();
		int n = s1.length();
		ArrayList<Integer> s = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int a[] = new int[10];
			s.add(FindA(s1.charAt(i), s2.charAt(i), a));

		}
		int f=1;
		for(int i: s)
		f*=i;
		System.out.println(f);
		

	}



	private static Integer FindA(char x, char y, int[] a) {
		FIndAAA(x, y, a);
		int an=0;
		for(int i=0;i<10;i++)
		if(a[i]==2)
			an++;
		return an;

		
	}

	private static void FIndAAA(char x, char y, int[] a) {
		int[] began = { 0 };
		int[] end = { 0 };
		À(began, end, x);

		for (int i = began[0]; i <= end[0]; i++)
			a[i]++;
		began[0] = 0;
		end[0] = 0;
		À(began, end, y);
		for (int i = began[0]; i <= end[0]; i++)
			a[i]++;

	
		
	}

	

	


}
