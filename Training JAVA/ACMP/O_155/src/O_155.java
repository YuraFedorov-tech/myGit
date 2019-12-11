import java.util.Scanner;

public class O_155 {
	public static void main(String[] args) {
		Scanner y = new Scanner(System.in);
	//	int n = y.nextInt();
	//	double answear = y.nextDouble();
		String s=y.nextLine();
		String[]	ss=s.split(" ");
		ss[0]=ss[0].trim();
		ss[1]=ss[1].trim();
		int n = Integer.valueOf(ss[0]);
		double answear=Double.valueOf(ss[1]);
		
		
		double kondensator[] = new double[n];
		boolean buzy[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			kondensator[i] = y.nextDouble();
		}
		int typeOfConect[][] = new int[5000][n - 1];
		int currensy[] = new int[n - 1+7];
		int[]	new_previos={0,0};
		
		
		int o = Helper_155.Rek_Find_TypeOfConect(0, n - 1, currensy,
				typeOfConect, 0,new_previos);
		Prin.pr(typeOfConect,o);
		int ans[] = { -1 };
		currensy = null;
		currensy = new int[n];
	
		Helper_155.rekursia(0, n, kondensator, buzy, ans, answear,
				answear * 1.05, o, typeOfConect, currensy);

		switch (ans[0]) {
		case -1:
			System.out.println("NO");
			break;
		case 1:
			System.out.println("YES");
			break;
		default: System.out.println("фигня");
		}

	}
}