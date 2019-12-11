import java.util.Arrays;
import java.util.Scanner;

public class O_400 {

	public static void main(String[] args) {
		int a[][] = new int[6][2];

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}
		boolean  sqwear=Findsqwear(a);
		
		
		boolean find[] = { false };
		int ans[][] = new int[3][2];
		boolean buzy[] = new boolean[6];

		// ans[0] = Arrays.copyOf(a[0], a[0].length);
		// buzy[0]=true;
		boolean finded = rekursia(0, buzy, a, ans, 0);
	//	System.out.println(finded);
		if (finded) {
			finded = false;
			finded = FindAnswear(ans);
		}
	if(finded | sqwear){
		System.out.print("POSSIBLE");
	}else
		System.out.print("IMPOSSIBLE");
}
	private static boolean Findsqwear(int[][] a) {
		int x=a[0][0];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) 
				if(x!=a[i][j])
					return false;
			
		}
		return true;
	}
	private static boolean FindAnswear(int[][] ans) {
		int x1 = ans[0][0];
		int y1 = ans[0][1];
		int x2 = ans[1][0];
		int y2 = ans[1][1];
		int x3 = ans[2][0];
		int y3 = ans[2][1];
		int[] chek = new int[3];
		boolean f = FindChek(ans, chek);
		if (!f){
		boolean chek24rymoAnd2Aqwear=Find_chek24rymoAnd2Aqwear(ans);
			
			return chek24rymoAnd2Aqwear;
		}
		boolean ans1 = Endeed(ans, chek);

		return ans1;
	}

	private static boolean Find_chek24rymoAnd2Aqwear(int[][] ans) {
DoNormal(ans);
boolean rymoAnd2Aqwear =Find_4_2 (ans);

		
		
		return rymoAnd2Aqwear;
	}
	private static boolean Find_4_2(int[][] ans) {
		int x1 = ans[0][0];
		int y1 = ans[0][1];
		int x2 = ans[1][0];
		int y2 = ans[1][1];
		int x3 = ans[2][0];
		int y3 = ans[2][1];
		if(x1==x2 & y1==y2)
			return true;
		if(x1==x3 & y1==y3)
			return true;
		if(x2==x3 & y2==y3)
			return true;
		
		return false;
	}
	private static void DoNormal(int[][] ans) {
		for(int i=0;i<3;i++)
			Arrays.sort(ans[i]);
		
	}
	private static boolean Endeed(int[][] ans, int[] chek) {
		int x = ans[0][0];
		int y = ans[0][1];
		int number = FindNubmer(ans, x);
		int answear[][] = new int[3][2];
		answear = Find_answear(answear, ans, number);
boolean b=Find(answear);
		
		
		
		
		return b;
	}

	private static boolean Find(int[][] answear) {
		int x1 = answear[0][0];int y1 = answear[0][1];
		
		int x2 = answear[1][0];int y2 = answear[1][1];
		
		int x3 = answear[2][0];int y3 = answear[2][1];
if(y1==x3 & y2==y3 & x1==x2)
	return true;

if(y1==y3 & y2==x3 & x1==x2)
	return true;

		return false;
	}

	private static int[][] Find_answear(int[][] answear, int[][] ans, int number) {
		
		
		answear[0] = Arrays.copyOf(ans[0], ans[0].length);
		switch (number) {
		case 0:
			answear[1] = Arrays.copyOf(ans[1], ans[1].length);
			answear[2] = Arrays.copyOf(ans[2], ans[1].length);
			return answear;
		case 1:
			answear[1][0] =ans[1][1];
			answear[1][1]= ans[1][0];
			answear[2] = Arrays.copyOf(ans[2], ans[1].length);
			return answear;
		case 2:
			answear[1] = Arrays.copyOf(ans[2], ans[1].length);
			answear[2] = Arrays.copyOf(ans[1], ans[1].length);
			return answear;
		
	    case 3:
		answear[1][0] =ans[2][1];
		answear[1][1]= ans[2][0];
		answear[2] = Arrays.copyOf(ans[1], ans[1].length);
		return answear;
		}
		
		return answear;
	}

	private static int FindNubmer(int[][] ans, int x) {
		if (ans[1][0] == x)
			return 0;
		if (ans[1][1] == x)
			return 1;
		if (ans[2][0] == x)
			return 2;
		if (ans[2][1] == x)
			return 3;

		return -10;
	}

	private static boolean FindChek(int[][] ans, int[] chek) {

		int x = chek[0] = ans[0][0];
		int y = chek[1] = ans[0][1];
		int g = 0;
		for (int i = 1; i < 3; i++)
			for (int j = 0; j < 2; j++) {
				int k = ans[i][j];
				if (k != x & k != y) {
					if(chek[2]==k)
						continue;
					g++;
					chek[2] = k;
				}

			}
		if (g == 1)
			return true;

		return false;
	}

	private static boolean rekursia(int step, boolean[] buzy, int[][] a,
			int[][] ans, int pokozatel) {
		if (step == 3)
			return true;

		for (int i = 0; i < 6; i++) {
			if (buzy[i])
				continue;
			if (pokozatel == 0) { // это мы нашли новую сторону
				buzy[i] = true;
				ans[step] = Arrays.copyOf(a[i], a[i].length);
				boolean finded = rekursia(step, buzy, a, ans, 1);
				return finded;
			}

			boolean truNow = FindTrueOrNo(ans[step], a[i]);
			if (truNow) {
				buzy[i] = true;
				boolean finded = rekursia(step + 1, buzy, a, ans, 0);
				return finded;
			}

		}

		return false;
	}

	private static boolean FindTrueOrNo(int[] ans, int[] a) {
		int x = ans[0];
		int y = ans[1];
		int xx = a[0];
		int yy = a[1];

		if (x == xx & y == yy)
			return true;

		if (x == yy & y == xx)
			return true;

		return false;
	}

}
