import java.util.ArrayList;
import java.util.Arrays;

public class O_4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] buz = new boolean[13442];
		Helper.FindSimple(list, buz);

		System.out.println(list);
		System.out.println(list.size());
		int n = 13441;
		 long timestart1=System.currentTimeMillis() ;
		B(list, n);
		 long timestart2=System.currentTimeMillis() ;
			System.out.println(timestart2-timestart1);
	}

	private static void B(ArrayList<Integer> list, int n) {
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			int g = FindI(i, n, list);
			ans += g;
		}
		System.out.println("ans=" + ans);
	}

	private static int FindI(int j, int n, ArrayList<Integer> list) {
		int answear = 0;
j=13441;
		for (int i = 1; i <= n; i++) {
			if (i * 2 > j)
				break;
			int yy[] = new int[i];
			int ans[] = { -1, -1 };
			if (i > 10) {
				Helper.prepearToRekur(i, list, j, ans);
			} else
		
				Rekur(0, i, list, j, 0, ans, yy);
		
			if (ans[0] == 1) {
				answear++;
			}
		//		System.out.println(j + "\t" +j + "\t" + i+"\t"+ answear+"это плюс");
		//	}else 
			//	System.out.println(j + "\t" + i);
				
		}

	
		if(j==n)
		System.out.println(j + "\t" + answear+"это плюс оющий");
		return answear;
	}

	static void Rekur(int step, int max, ArrayList<Integer> list,
			int mean, int curensy, int[] ans, int[] yyPoint) {
		if (step == max) {
			if (curensy == mean) {
				ans[0] = 1;
	//			System.out.println(Arrays.toString(yyPoint));
			}
			return;
		}
		for (int i = 0; i < 1593; i++) {
		int li=list.get(i);
			int Newcurensy = curensy + li;
	//		if (li > mean)
		if (Newcurensy > mean | li > mean)
				return;
		//	yyPoint[step] = list.get(i);
			Rekur(step + 1, max, list, mean, Newcurensy, ans, yyPoint);
			if (ans[0] == 1)
				return;
		}

		return;
	}
}
