import java.util.ArrayList;
import java.util.Scanner;

public class o497 {

	public static void main(String[] args) {

		Scanner my = new Scanner(System.in);
		int N_Cifr = my.nextInt();
		int min = my.nextInt();
		int max = min;
		int[] a =         { 6,  2,  5,  5, 4, 5, 6, 3, 7, 6 };
		int[] aMaksimum = { -1, 2, -1, -1, 4, 5, -1, 3, 7, 6 };
		int[] aMinimum =   { 6, 2, 5, -1, 4, -1, 6, 3, 7, -1 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> finality = new ArrayList<Integer>();
		finality.add(-1);
		// list.add(0);
		boolean[] b = { false };
		list = FindMin(aMinimum, list, min, N_Cifr, 0, b);

	//	System.out.println(list.toString());
		finality = (ArrayList<Integer>) list.clone();
		list.clear();
		b[0] = false;
		list = FindMax(aMaksimum, list, max, N_Cifr, 0, b);
	//	System.out.println(list.toString());
if(list.size()==0 |finality.size()==0){
	System.out.println("NO SOLUTION");
}else{
	int n=find(finality);
	System.out.println();
	int nn=find(list);
	//System.out.println(n);
//	System.out.println(nn);
	
}
	}

	private static int find(ArrayList<Integer> finality) {
		int s=0;
		for(int i=0;i<finality.size();i++){
			System.out.print(finality.get(i));
	//		s=s*10+finality.get(i);
		}
		return s;
	}

	private static ArrayList<Integer> FindMax(int[] aMaksimum,
			ArrayList<Integer> list, int min, 
			int n_Cifr, int j, boolean[] b) {
		int min222 = (n_Cifr - j ) *2;
		if (min222 > min)
			return list;
		int max = (n_Cifr - j ) * 7;
		if (max < min)
			return list;
		if (j == n_Cifr) {
			if (min == 0) {
				b[0] = true;			
				
				

			}

			return list;

		}
		j++;
		for (int i = aMaksimum.length - 1; i >= 0; i--) {
			if (((i == 0 & j== 1) | aMaksimum[i] == -1)
					| min - aMaksimum[i] < 0)
				continue;
			min -= aMaksimum[i];
		//	int n = list.get(0) * 10 + i;
			list.add(i);
	//		list.set(0, n);
			list = FindMax(aMaksimum, list, min,  n_Cifr, j, b);
			if (b[0])
				return list;
			list.remove(list.size() - 1);
			min += aMaksimum[i];
	//		list.set(0, n / 10);
		}

		return list;
	}

	// /////////////////////////////////////////////////////////////////////////
	private static ArrayList<Integer> FindMin(int[] aMinimum,
			ArrayList<Integer> list, int min, int n_Cifr, int j, boolean[] b) {
		j++;
		int min222 = (n_Cifr - j + 1) *2;
		if (min222 > min)
			return list;
		int max = (n_Cifr - j + 1) * 7;
		if (max < min)
			return list;
		if (j == n_Cifr + 1) {
			if (min == 0) {
				b[0] = true;
				// if (finality.get(0) == -1 | finality.get(0) > list.get(0))

				return list;

			}

			return list;

		}

		for (int i = 0; i < aMinimum.length; i++) {
			if (((i == 0 & j == 1) | aMinimum[i] == -1) | min - aMinimum[i] < 0)
				continue;
			min -= aMinimum[i];
			// int n = list.get(0) * 10 + i;
			list.add(i);
			// list.set(0, n);
			list = FindMin(aMinimum, list, min, n_Cifr, j, b);
			if (b[0])
				return list;
			list.remove(list.size() - 1);
			min += aMinimum[i];
			// list.set(0, n / 10);
		}

		return list;
	}

}