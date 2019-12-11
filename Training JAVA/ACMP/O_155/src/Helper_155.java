import java.util.ArrayList;
import java.util.Arrays;

public class Helper_155 {

	public static int Rek_Find_TypeOfConect(int step, int n, int[] currensy,
			int[][] typeOfConect, int next, int[] previos) {
		if (step == n) {
			typeOfConect[next] = Arrays.copyOf(currensy, currensy.length);
			next++;
			return next;
		}
		for (int i = 0; i < 5; i++) {
			boolean[] may = { true };

			int[] new_previos = Arrays.copyOf(previos, previos.length);
			new_previos = Find_new_previos(new_previos, i, may,step,n);
			if (!may[0])
				continue;

			currensy[step] = i;
			currensy[0]++;
			int plus=1;
			if(i==5 | i==6)
				plus--;
			next = Rek_Find_TypeOfConect(step + plus, n, currensy, typeOfConect,
					next, new_previos);
			currensy[0]--;
		}

		return next;
	}

	/*
	 * private static int[] Find_new_previos(int[] new_previos, int i) { switch
	 * (new_previos[0]) { case 0: if (i == 0 | i == 1 | i == 2) return
	 * new_previos; new_previos[0] = i; return new_previos; case 3: if (i == 0)
	 * return new_previos; if (i == 1 | i == 2) { new_previos[0] = 31; return
	 * new_previos; } new_previos[1] =-1; return new_previos; case 4: if (i ==
	 * 0) return new_previos; if (i == 1 | i == 2) { new_previos[0] = 31; return
	 * new_previos; } new_previos[1] =-1; return new_previos; }
	 * 
	 * return null; }
	 */

	private static int[] Find_new_previos(int[] new_previos, int i,
			boolean[] may, int step, int n) {
		if(step==n-1  &( i==3 | i==4)){
			may[0]=false;
		return new_previos;
	}
		if(step==0  & (i>2)){
			may[0]=false;
		return new_previos;
	}
		switch (new_previos[0]) {
		case 0:
			new_previos=Work.Find_new_previosIf0(i,may,new_previos);
			break;
		case 3:
			new_previos=Work.Find_new_previosIf3(i,may,new_previos);
			break;
		case 4:
			new_previos=Work.Find_new_previosIf4(i,may,new_previos);
			break;
		case 31:
			new_previos=Work.Find_new_previosIf31(i,may,new_previos);
			break;
		case 41:
			new_previos=Work.Find_new_previosIf41(i,may,new_previos);
			break;
		}
		return new_previos;
	}

	public static void rekursia(int step, int n, double[] kondensator,
			boolean[] buzy, int[] ans, double answear, double answearMax,
			int max_typeOfConect, int[][] typeOfConect, int[] currensy) {
		if (step == n) {
			System.out.println(Arrays.toString(currensy));
			chek(typeOfConect, max_typeOfConect, currensy, kondensator, ans,
					answear, answearMax);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (buzy[i])
				continue;

			buzy[i] = true;

			currensy[step] = i;
			rekursia(step + 1, n, kondensator, buzy, ans, answear, answearMax,
					max_typeOfConect, typeOfConect, currensy);
			if (ans[0] == 1)
				return;
			buzy[i] = false;
		}

	}

	private static void chek(int[][] typeOfConect, int max_typeOfConect,
			int[] currensy, double[] kondensator, int[] ans, double answear,
			double answearMax) {
		for (int i = 1; i < max_typeOfConect; i++) {

			double r=Work._Find_r(typeOfConect[i], currensy, kondensator,
					answear, answearMax,0);
			
			
			/*		double r = kondensator[currensy[0]];
			int j = 0;
			boolean began = false;
			for (; j < kondensator.length; j++) {
				if (j == 0)
					continue;
				if (typeOfConect[i][j - 1] == 0) {
					if (!began) {
						r = kondensator[currensy[j]];
					}
					continue;
				}
				began = true;
				if (typeOfConect[i][j - 1] == 1) {
					r = FinfPosledovSoedinenie(r, kondensator, currensy[j]);

				}
				if (typeOfConect[i][j - 1] == 2) {
					r = r + kondensator[currensy[j]];

				}
				if (r > answearMax)
					break;

			}
			if (j != currensy.length)
				continue;
			double a = Math.abs(r - answear);
			int t = (int) (a * 10000);
			a = (double) t / 1000;
			if (t <= 100) {
				ans[0] = 1;
				System.out.println(i);
				return;
			}*/

		}

	}

	private static double FinfPosledovSoedinenie(double r,
			double[] kondensator, int i) {

		double y = kondensator[i];
		r = r * y / (r + y);

		return r;
	}

}
