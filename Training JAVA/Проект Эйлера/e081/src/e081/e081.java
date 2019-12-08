package e081;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class e081 {

	private static int ans;
	private static int m;
	private static int n;
	private static int[][] a;
	private static int [][]mean;
	private static  Queue<Integer> list ;

	public e081(int i ) {
		list=new   LinkedList<>();
		m=n=i;
		a=new int[i][i];
		mean=new int[i][i];
	}

	public static void main(String[] args) {

		e081 d = new e081(80);
		d.Input();
		d.work();
		d.print();
	}

	private void Input() {
		Scanner M=new Scanner(System.in);
		for(int i=0;i<m;i++) {
			String []s=M.nextLine().trim().split(",");
			for(int j=0;j<m;j++) {
				a[i][j]=Integer.parseInt(s[j]);
			}
		}
	}

	private void print() {
		System.out.print(mean[m-1][n-1]);

	}

	private void work() {
		list.offer(0);
		list.offer(0);
		mean[0][0]=a[0][0];
		GO();
		
	}

	private void GO() {
		while(list.size()!=0) {
			int l=list.size()/2;
			for(int i=0;i<l;i++) {
				Ins(l);
			}	
		}		
	}
	private void Ins(int l) {
		int y=list.remove();
		int x=list.remove();
		int z=mean[y][x];
		int[] Y= {0,1};
		int[] X= {1,0};
		for(int i=0;i<2;i++) {
			int yy=y+Y[i];
			int xx=x+X[i];
			if(xx==m |xx<0 || yy==m||y<0)
				continue;
			if(mean[yy][xx]==0) {
				list.offer(yy);
				list.offer(xx);
				mean[yy][xx]+=a[yy][xx]+z;				
			}
			
			if(mean[yy][xx]>(a[yy][xx]+z))
				mean[yy][xx]=a[yy][xx]+z;			
		}		
	}

	
}
/*
 * Path sum: two ways   
 * Problem 81
 */