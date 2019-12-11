import java.util.ArrayList;
import java.util.Scanner;

public class O_372 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] a = new int[n];
		a = full_5(a);
		a = nahodim_befor_Polovina(a, list, 0);

	}

	private static int[] nahodim_befor_Polovina(int[] a,
			ArrayList<Integer> list, int step) {
		if (step == a.length) {
			Pechat(a);
			return a;
		}
		if (list.size() > a.length - step )
			return a;
		ArrayList<Integer> copy = new ArrayList<Integer>();
		copy = Copy(list, copy);
		for (int i = 0; i < 4; i++) {
			if (step == 0)
				if (i == 2 | i == 3)
					continue;
			if((step==a.length - 1)& (i==0 |i==1))
				continue;
			boolean is_i_good = Find_is_i_good(i, list);
		
			if (!is_i_good)
				continue;
			if (i == 0 | i == 1)
				list.add(i);
			if (i == 2 | i == 3)
				list.remove(list.size() - 1);
			a[step] = i;
			a = nahodim_befor_Polovina(a, list, step + 1);
			a[step] = 5;
			list = Copy( copy ,list);
		}
		return a;
	}

	private static boolean Find_is_i_good(int i, ArrayList<Integer> list) {
		if (i == 0 | i == 1)
			return true;
		if(list.size()==0 &(i==2 |i==3))
			return false;
		
		if ((i == 2 & list.get(list.size() - 1) == 0)
				| (i == 3 & list.get(list.size() - 1) == 1))
			return true;

		return false;
	}

	private static ArrayList<Integer> Copy(ArrayList<Integer> list,
			ArrayList<Integer> copy) {
		copy.clear();
		for (int i = 0; i < list.size(); i++)
			copy.add(list.get(i));
		return copy;
	}

	private static void Pechat(int[] a) {
		for(int i=0; i<a.length;i++){
			System.out.print(Swit(a[i]));
			
		}
		System.out.println();
	}

	private static String Swit(int i) {
switch(i){
case 0: 
	return "(";
case 1: 
	return "[";	
case 2: 
	return ")";
case 3: 
	return "]";	
	
}

		
		return null;
	}

	private static int[] full_5(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = 5;
		}
		return a;
	}
}
