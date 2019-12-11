import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class O_300 {
	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
//		int n = u.nextInt();
		int a[][] = new int[4][4];
		double[] t = new double[4];
		for (int i = 0; i < 4; i++) {
			a[i][0] = u.nextInt();
			a[i][1] = u.nextInt();
		}
		int timeTern = u.nextInt();
		int l = u.nextInt();
		for (int i = 0; i < 4; i++) {
			t[i] = a[i][0] + (double) l / a[i][1];
		//	t[i] = new BigDecimal(t[i]).setScale(8, RoundingMode.UP)
		//			.doubleValue();
		}
		int m=0;
	
		B(t, timeTern,a);
	
	}

	private static void B(double[] t, int timeTern, int[][] a) {
	
		
		boolean[] buzy = new boolean[4];
		boolean[] buzyBeganen = new boolean[4];
		int ans = 0;
		int previos = 0;
		double[] tN = Arrays.copyOf(t, 4);
		Arrays.sort(tN);
		for (int i = 0; i < 4; i++) {
			boolean rest=FinfRestVravno_0(a,buzyBeganen);
			if(rest){
				ans=4;
				break;
			}
			int	newI=	FindI(t,tN[i],buzyBeganen);	
			boolean noDifferent=FInd(newI,t);
		//	int number = FindI(buzy, tN);
			if (i == 0) {
				buzy[i]=true;
				ans++;
	//int	newI=	FindI(t,tN[i],buzyBeganen);
				previos =newI;
				if(noDifferent)
					break;
				continue;
			}
			int turn = 1;
				
			if ((previos % 2 == 0 & newI % 2 == 0)
					| (previos % 2 == 1 & newI % 2 == 1))
				turn = 2;
			
			int time = turn * timeTern;

			if (time + t[previos] <= t[newI]) {
				ans++;
				previos =newI;
if(noDifferent)
	break;
			} else {	
				if(noDifferent)
					ans++;
				break;
			}

		}
if(ans==4){
	System.out.println("ALIVE");
}else
	System.out.println(ans);
	}

	private static boolean FinfRestVravno_0(int[][] a, boolean[] buzyBeganen) {
		for(int i=0;i<4;i++){
			if(buzyBeganen[i])
				continue;
			if(a[i][1]!=0)
				return false;
		}
		return true;
	}

	private static boolean FInd(int newI, double[] t) {
		double  s=t[newI];
		for(int i=0;i<4;i++){
			if(i==newI)
				continue;
			int r=(int) (((s-t[i])/s)*1000);
			if(r==0)
				return true;
		}
		return false;
	}

	private static int FindI(double[] t, double d, boolean[] buzyBeganen) {
		for(int i=0;i<4;i++){
			if(d==t[i] & !buzyBeganen[i]){
				buzyBeganen[i]=true;
				return i;
			}
		}
		return -1;
	}

	private static int FindI(boolean[] buzy, double[] t) {
		
		int i = 0;
		for (; i < 4; i++)
			if (!buzy[i]) 
				//buzy[i] = true;
				break;
			
		return -5;
	}

}
