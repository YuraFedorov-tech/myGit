import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class O_076 {
	public static void FindA(int[][] a, int[] aDubl, String s, int j) {
		String f[]=s.split(" ");
		for(int i=0;i<2;i++){
			String t[]=f[i].split(":");
			a[j][i]=60*Integer.parseInt(t[0])+Integer.parseInt(t[1]);;
		}
		aDubl[j]=a[j][0];
	}

	public static void FindQWUEE_A(int[][] a, int[] aDubl, int[][] aFirst, int n) {
	 Arrays.sort(aDubl);
	 boolean []bu=new boolean [n];
	 for(int i=0;i<n;i++){
		 int j=FindJ(aDubl[i],bu,aFirst,n);
		 a[i]=Arrays.copyOf(aFirst[j], 2);
	 }
		
	}

	private static int FindJ(int x, boolean[] bu, int[][] aFirst, int n) {
		 for(int i=0;i<n;i++)
			 if(aFirst[i][0]==x & !bu[i]){
				 bu[i]=true;
				 return i;
			 }
		 
		return -5;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		String s = stdin.readLine().trim();
		int n = Integer.parseInt(s);
		int aFirst[][] = new int[n][2];
		int aDubl[] = new int[n];
		for (int i = 0; i < n; i++) {
			s = stdin.readLine();
			FindA(aFirst, aDubl, s, i);
		}
		int[][] a = new int[n][2];
		FindQWUEE_A(a, aDubl, aFirst, n);
	//	System.out.println(Arrays.deepToString(aFirst));
	//	System.out.println(Arrays.deepToString(a));
		B(a, n);

	}

	private static void B(int[][] a, int n) {
		ArrayList<Integer> listMax = new ArrayList<Integer>();
		listMax.add(a[0][1]);
		listMax.add(1);
		int[] lastMax = { a[0][1] };
		int[] count = new int[n];

		for (int i = 1; i < n; i++)
			ChangeALeftAndInside(i, a, count, listMax, lastMax);

//		System.out.println(Arrays.toString(count));
	/*	for (int i = 0; i < n-1; i++)

			ChangeARightAndInside(i, a, count,n);
*/
//		System.out.println(Arrays.toString(count));
		Arrays.sort(count);
		System.out.println(count[n-1]);
	}

	private static void ChangeARightAndInside(int j, int[][] a, int[] count, int n) {
	int time1=a[j][0];
	int time2=a[j][1];
		for(int i=j+1;i<n;i++){
			int x=a[i][0];
			if(time2<a[i][0])
				return;
			count[i]++;
		}

	}

	private static void ChangeALeftAndInside(int j, int[][] a, int[] count,
			ArrayList<Integer> listMax, int[] lastMax) {
		int y = ChekMax(a, lastMax, listMax, j);
		int timeEnter = a[j][0];
		for (int i = y; i <= j; i++)
			if (timeEnter <= a[i][1])
				count[i]++;

	}

	private static int ChekMax(int[][] a, int[] lastMax,
			ArrayList<Integer> listMax, int j) {
		int time1 = a[j][0];
		int time2 = a[j][1];
		if (time2 > listMax.get(listMax.size() - 1)) {
			listMax.add(time2);
			listMax.add(j);
		}

		for (int i = 0; i < listMax.size(); i++) {
			if (listMax.get(0) >= time1)
				return listMax.get(1);
			listMax.remove(0);
			listMax.remove(0);
		}

		return -5;

	}
}
