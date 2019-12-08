package e011;

import java.util.Scanner;

public class e011 {
	static int ans;
	static int a[][];
	
	public e011() {
		a=new int[20][20];
		ans=0;
	}

	public static void main(String[] args) {
		e011 q = new e011();
		q.input();
		q.work();
		q.print();
	}
	
	private void print() {
		System.out.print(ans);
	}
	
	private void work() {
		int n=17;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				if(j<n) {
					int cur=FindGorizont(i,j);
			     	ans=Math.max(cur, ans);
				}
				if(i<n) {
					int cur=FindVertik(i,j);
			     	ans=Math.max(cur, ans);
				}
				if(i<n && j<n) {
					int cur=FindRightDown(i,j);
			     	ans=Math.max(cur, ans);
				}
				if(i<n && j>2) {
					int cur=FindLeftDown(i,j);
			     	ans=Math.max(cur, ans);
				}			
			}		
	}

	

	private int FindLeftDown(int i, int j) {
		int z=1;
		for(int c=0;c<4;c++)
			z*=a[i+c][j-c];
		return z;
	}

	private int FindRightDown(int i, int j) {
		int z=1;
		for(int c=0;c<4;c++)
			z*=a[i+c][j+c];
		return z;	
	}

	private int FindVertik(int i, int j) {
		int z=1;
		for(int c=i;c<i+4;c++)
			z*=a[c][j];
		return z;
	}

	private int FindGorizont(int i, int j) {
		int z=1;
		for(int c=j;c<j+4;c++)
			z*=a[i][c];
		return z;
	}

	private void input() {
		Scanner M=new Scanner(System.in);
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++)
				a[i][j]=M.nextInt();		
	}
}
/*
Largest product in a grid   
Problem 11
*/