
import java.util.Arrays;
import java.util.Scanner;

public class O_180 {  //Main
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
	
		int k = p.nextInt();
		if(k==1){
			System.out.println(1);
			return;
		}
		if(k==0){
			System.out.println(10);
			return;
		}	
		int a[] = { 2, 3, 5, 7 };
		int b[] = new int[4];
		int l = k;
		for (int i = 0; i < 4; i++) {
			int d = a[i];
			while (true) {
				if (l % d == 0) {
					l /= d;
					b[i]++;
					continue;
				}
				break;
			}

		}
		if (l > 9) {
			System.out.println("-1");
			return;
		}


		String s = "";
		while (b[1] + b[0] >= 2) {
			if (b[0] > 2) {
				b[0] -= 3;
				s += "8";
				continue;
			}
			if (b[1] > 1) {
				b[1] -= 2;
				s += "9";
				continue;
			}
			if (b[1] > 0 & b[0] > 0) {
				s += "6";
				b[1]--;
				b[0]--;
				continue;
			}

			
			if (b[0] > 1) {
				b[0] -= 2;
				s += "4";
				continue;
			}

		
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < b[i]; j++) {
				s += a[i];
			}
		}
		String t="";
		char f[]=s.toCharArray();
		Arrays.sort(f);
		for(int i=0;i<f.length;i++)
			t += "" + f[i];

		System.out.println(t);

	}






}
