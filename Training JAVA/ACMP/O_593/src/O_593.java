import java.util.ArrayList;
import java.util.Scanner;

public class O_593 {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		double[][] a = new double[2][n]; // [0]- это х, [1]-это y
		double[][] a_Naoborot = new double[2][n]; // [0]- это х, [1]-это y
		for (int i = 0; i < n; i++) {
			a[0][i] = myScanner.nextInt();
			a[1][i] = myScanner.nextInt();
			a_Naoborot[1][n - 1 - i] = a[1][i];

		}
		for (int i = 0; i < n; i++) {
			a_Naoborot[0][n - 1 - i] = a[0][n - 1] - a[0][i];
		}

		double[][][] urav = new double[2][n][n];
		urav = find_urav(a, urav);
		double[][][] urav_Naoborot = new double[2][n][n];
		urav_Naoborot = find_urav(a_Naoborot, urav_Naoborot);
		double[] Extrenum = new double[n];
		Extrenum = find_Exrenum(Extrenum, urav);
		double[] Extrenum_Naoborot = new double[n];
		Extrenum_Naoborot = find_Exrenum(Extrenum_Naoborot, urav_Naoborot);

	//	print.pr(a);
	//	print.pr(urav);
	//	print.pr(a_Naoborot);
	//	print.pr(urav_Naoborot);
	//	print.pr(Extrenum);
	//	print.pr(Extrenum_Naoborot);

		int[] Ans = new int[n];
		for (int i = 0; i < n; i++) {
			Ans[i] = count(i, a, urav, Extrenum, a_Naoborot, urav_Naoborot,
					Extrenum_Naoborot);
		}

	//	print.pr(Ans);
		for (int i = 0; i < n; i++) {
			System.out.println(Ans[i] );

		}

	
	}

	private static int count(int i, double[][] a, double[][][] urav,
			double[] extrenum, double[][] a_Naoborot,
			double[][][] urav_Naoborot, double[] extrenum_Naoborot) {
int o=extrenum.length-i-1;
		int Right = find_Right(i, i + 1, a, urav, extrenum, 0);
		int Left = find_Right(o, o + 1, a_Naoborot, urav_Naoborot, extrenum_Naoborot, 0);

		return Right + Left;
	}

	private static int find_Right(int V0, int V_Next, double[][] a,
			double[][][] urav, double[] extrenum, int Summa) {
	while(true){
		if (V0 == extrenum.length - 1)
			return 0;
		if (V0 == extrenum.length - 2)
			return 1;
		if (V_Next == extrenum.length-1)
			return Summa;
		if (V_Next == extrenum.length)
			return Summa;
		int []V_Next_Next=new int[1];
		int add_Summa = find_kolichestvo(V0, V_Next, a, urav, extrenum,V_Next_Next);
		Summa+=add_Summa;
		V_Next=V_Next_Next[0];
		//Summa=find_Right(V0,V_Next_Next[0],a,urav,extrenum,Summa+add_Summa);
	}
		
	}

	private static int find_kolichestvo(int v0, int v_Next, double[][] a,
			double[][][] urav, double[] extrenum, int[] v_Next_Next) {
		int kolichestvo = 0;
		boolean has_more_then_0 = false;
		
			has_more_then_0 = has_more_then(v0, v_Next, urav[0][v0][v_Next],
					urav[1][v0][v_Next], extrenum, a);
		if (!has_more_then_0){
			v_Next_Next[0]=a[0].length;
			if(v0+1==v_Next)
				return 1;
			return 0;
		}
			
		int Step = v_Next+1;
		
			kolichestvo=find_have_how_mach_point(v0, v_Next, urav[0][v0][v_Next],
					urav[1][v0][v_Next],v_Next_Next,a);
			
			
		

		return kolichestvo;

	}

	

	private static int find_have_how_mach_point(int v0, int v_Next, double k,
			double x, int[] v_Next_Next, double[][] a) {
		int kolichestvo = 0;
	
		
		
		if(k>=0){ // если прямая наша уходит вверх
			kolichestvo=count_at_vverx(v0, v_Next,k,x,v_Next_Next,a);
			return kolichestvo;
}
		// если прямая наша уходит вниз
		kolichestvo=count_at_vniz(v0, v_Next,k,x,v_Next_Next,a);
		
		
		return kolichestvo;
	}

	private static boolean ugol_0_gradusov(double k_minus1, double k) {
		// TODO Auto-generated method stub
		return false;
	}

	private static int count_at_vniz(int v0, int v_Next, double k, double x,
			int[] v_Next_Next, double[][] a) {
		for(int i=v_Next+1;i<a[0].length;i++){
			boolean m=extr_have(k,x,a[0][i],a[1][i]);
			if(m){
				v_Next_Next[0]=i;
				if(v0+1==v_Next)
					return 2;
				return 1;
			}
		
		}
		
		
		
		return 0;
	}

	private static int count_at_vverx(int v0, int v_Next, double k, double x,
			int[] v_Next_Next, double[][] a) {
		int kolichestvo = 1;
		for(int i=v_Next+1;i<a[0].length;i++){
	boolean m=extr_have(k,x,a[0][i],a[1][i]);
	//		private static boolean extr_have(double k, double b, double x, double y) {
	//	boolean an = y > k * x + b ? true : false;
if(m){
	v_Next_Next[0]=i;
	if(v0+1==v_Next)
		return 2;
	return 1;
}
}

		
		return 0;
	}

	private static boolean has_more_then(int v0, int v_Next, double k,
			double b, double[] extrenum, double[][] a) {
		for (int i = v_Next + 1; i < extrenum.length; i++) {
			if (extrenum[i] == 1) {
				boolean t = extr_have(k, b, a[0][i], a[1][i]);
				if (t)
					return true;
			}
		}

		return false;
	}

	private static boolean extr_have(double k, double b, double x, double y) {
		boolean an = y >= k * x + b ? true : false;
		return an;
	}

	private static double[] find_Exrenum(double[] extrenum, double[][][] urav) {
		extrenum[extrenum.length - 1] = 1;
		for (int i = 0; i < extrenum.length - 2; i++) {
			if (urav[0][i][i + 1] > 0 & urav[0][i + 1][i + 2] < 0)
				extrenum[i + 1] = 1;
		}

		return extrenum;
	}

	private static double[][][] find_urav(double[][] a, double[][][] urav) {
		for (int j = 0; j < urav[0].length; j++) {
			for (int i = 0; i < urav[0].length; i++) {
				if (j == i)
					continue;
				urav[0][j][i] = urav[0][i][j] = find_K(a[1][i], a[1][j],
						a[0][i], a[0][j]);
				urav[1][j][i] = urav[1][i][j] = find_B(a[1][i], urav[0][j][i],
						a[0][i]);

			}

		}

		return urav;
	}

	private static double find_B(double y, double k, double x) {

		return y - k * x;
	}

	private static double find_K(double y2, double y1, double x2, double x1) {

		return (y2 - y1) / (x2 - x1);
	}

}
