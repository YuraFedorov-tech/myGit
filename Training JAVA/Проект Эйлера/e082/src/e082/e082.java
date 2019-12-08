package e082;

import java.util.ArrayList;
import java.util.Scanner;

public class e082 {

	private static int ans;
	private static int m;
	private static int[][] a;
	private static int[][] mean;
	private static ArrayList<Integer> list;

	public e082(int i) {
		list = new ArrayList<>();
		m = i;
		a = new int[i][i];
		mean = new int[i][i];
		ans=Integer.MAX_VALUE;
	}

	public static void main(String[] args) {

		e082 d = new e082(80);
		d.Input();
		d.work();
		d.print();
	}

	private void Input() {
		Scanner M = new Scanner(System.in);
		for (int i = 0; i < m; i++) {
			String[] s = M.nextLine().trim().split(",");
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(s[j]);
			}
		}
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		for(int i=0;i<m;i++) {
		mean = new int[m][m];
		list.add(i);
		list.add(0);
		list.add(a[i][0]);
		mean[i][0] = 1;
		GO();
		}
	}

	private void GO() {
		while (list.size() != 0) {
			int l = list.size() / 3;
			for (int i = 0; i < l; i++) {
				Ins(l);
			}
		}
	}

	private void Ins(int l) {
		int y = list.get(0);
		int x = list.get(1);
		int z = list.get(2);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		int[] Y = { -1, 0, 1};
		int[] X = { 0, 1, 0 };
		for (int i = 0; i < 3; i++) {
			int yy = y + Y[i];
			int xx = x + X[i];
			if (xx >= m | xx < 0 || yy >= m || yy < 0)
				continue;
			if (mean[yy][xx] != 0)
				continue;
			added(yy, xx, z + a[yy][xx]);
			if(xx==m-1) {
				int c=z+a[yy][xx];
				if(c<ans)
					ans=c;				
			}
			mean[yy][xx]=1;
		}
	}

	private void added(int yy, int xx, int zNew) {
		int i = 2;
		for (; i < list.size(); i += 3) {
			int e = list.get(i);
			if (e > zNew)
				break;
		}
		if (i >= list.size() | list.size()==0) {
			list.add(yy);
			list.add(xx);
			list.add(zNew);
		} else {			
			list.add(i-2,zNew);
			list.add(i-2,xx);
			list.add(i-2,yy);
		}
	}

}
/*
 * Path sum: three ways   
 * Problem 82
 */