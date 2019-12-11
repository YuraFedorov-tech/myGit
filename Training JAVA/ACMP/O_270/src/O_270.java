import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class O_270 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		String s = stdin.readLine();
		
	
		B(s);
		
	}

	private static void B(String s) {
		String	t = s.trim();
		if(!t.equals(s)){
			System.out.println("Error!");
			return;
		}
		int a[]=new int[3];
		int n=s.length();
		FindUpper(s,a);
		FistSImbol(a,s.charAt(0));
		lastSimbol(a,s.charAt(s.length()-1));
		chekAllatOne(a,s,n);
		
		System.out.println(Arrays.toString(a));
	}

	private static void chekAllatOne(int[] a, String s, int n) {
for(int i=0;i<n;i++){
	Chek(s.charAt(i),a);
}

		
		
	}

	private static void Chek(char charAt, int[] a) {
		if((charAt>='a' &charAt<='z')|(charAt>='A' &charAt<='Z'))
			return;
		if( charAt=='_'  )
			return;
		a[2]++;
	}

	private static void lastSimbol(int[] a, char charAt) {
		if((charAt>='a' &charAt<='z')|(charAt>='A' &charAt<='Z'))
			return;
		a[2]=1;
	}

	private static void FistSImbol(int[] a, char charAt) {
		if(charAt<'a' | charAt>'z')
			a[2]++;
		
	}

	private static void FindUpper(String s, int[] a) {
		String	t = s;
		t=t.toLowerCase();
		if(!t.equals(s))
			a[0]++;
		
	}
	
	
}
