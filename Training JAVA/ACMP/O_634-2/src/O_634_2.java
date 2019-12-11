import java.util.ArrayList;
import java.util.Scanner;

public class O_634_2 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int k = my.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int i1 = 0; i1 < n; i1++) {
				a[i][i1] = my.nextInt();
			}
		}
		int[] krasota = new int[n];
		for (int i = 0; i < n; i++) {
			krasota[i] = my.nextInt();
		}
	//	print_A(a);
		a = Inside_krasota(a, krasota);
	//	print_A(a);
		// int []a_min=new int[k];
		int[]  a_min = new int [k+1];
		ArrayList<Integer> a_min_current = new ArrayList<Integer>();
		int l_Min_road = 0;
		l_Min_road = Find_Min_road(a, k, a_min, l_Min_road);
	//	System.out.println("l_Min_road= " + l_Min_road);
		int l_Min_road_current = 0;
		a_min[k]=l_Min_road=2000;
		boolean[] used = new boolean[n];
		int pred_City = 0;
		a_min = Rekursia_find_minRoad( a, a_min, k, 0,
				l_Min_road_current, a_min_current, used, pred_City);

	//	System.out.println("a_min[k]= " + a_min[k]);
		print_A_A(a_min);
		
	}

	

	private static int[] Rekursia_find_minRoad(int[][] a,
			int[] a_min, int k, int step, int l_Min_road_current,
			ArrayList<Integer> a_min_current, boolean[] used, int pred_City) {
		if (step == k )
			if (l_Min_road_current <= a_min[k]) {
			//	a_min.c;
				a_min = Perepis_a_min(a_min, a_min_current);
			//	l_Min_road = l_Min_road_current;
				a_min[k]=l_Min_road_current;
				return a_min;
			}
		for (int i = 0; i < a.length; i++) {
			if (used[i])
				continue;
			if (step == 0) {
				l_Min_road_current = a[i][i];
				pred_City=i;
			} else {
				l_Min_road_current += a[pred_City][i];
				
			}
			used[i]=true;
			a_min_current.add(i);
			a_min = Rekursia_find_minRoad( a, a_min, k, step+1,
					l_Min_road_current, a_min_current, used, i);
			a_min_current.remove(a_min_current.size()-1);
			used[i]=false;
			l_Min_road_current -= a[pred_City][i];
			if (step == 0)
				l_Min_road_current=0;
			
			
		}

		return a_min;
	}

	private static int[] Perepis_a_min(int[] a_min,
			ArrayList<Integer> a_min_current) {
		for (int i = 0; i < a_min_current.size(); i++) {
			a_min[i]=a_min_current.get(i);
		}

		return a_min;
	}

	private static int Find_Min_road(int[][] a, int k,
			int[] a_min, int l_Min_road) {
		for (int i = 0; i < k; i++) {
			l_Min_road += a[0][i];
			a_min[i]=i;
		}

		return l_Min_road;
	}

	private static void print_A(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int i1 = 0; i1 < a[0].length; i1++) {
				System.out.print(a[i][i1] + " ");
				if (a[i][i1] < 10)
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] Inside_krasota(int[][] a, int[] krasota) {
		for (int i = 0; i < a.length; i++) {
			for (int i1 = 0; i1 < a.length; i1++) {
				a[i1][i] += krasota[i];
			}

		}
		return a;
	}
	private static void print_A_A(int[] a_min) {
		System.out.println(a_min[a_min.length-1]);
		for (int i = 0; i < a_min.length-1; i++) {
			System.out.print(a_min[i] +1+ " ");
		}
		
	}
}
