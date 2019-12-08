package e039;

import java.util.Arrays;

public class e039 {
	private static int a[][];
	private static boolean find;
	static int[] p;

	public e039(int i) {
		a =new int[i][i];		
		p = new int[i];
	}

	public static void main(String[] args) {
		e039 d = new e039(1001);
		d.work();
		d.print();
	}

	private void work() {
		Count();
	Done();
	}

	private void Done() {
		int max=0;
		for(int i=0;i<1000;i++)
			if(p[i]>max) {
				max=p[i];
				p[0]=i;
			}		
	}

	private void Count() {
		for (int i = 1; i < 5000; i++) {
			FindN(i);
		}
	}

	private void FindN(int m) {
		for (int i = 1; i < m; i++) {
			if (gsd(m, i) == 1)
				Pifagor(m, i);		
		}
	}

	private void Pifagor(int m, int n) {	
		int xx=m*m-n*n;
		int yy=2*m*n;
		int zz=m*m+n*n;
		int i=0;
		int t=xx+yy+zz;
		if(t>1000)
			return;
		while(true) {
			i++;
		int	x=xx*i;
		int	y=yy*i;
		int	z=zz*i;
			 t=x+y+z;
			if(t>1000)
				return;		
			if(a[y][x]==1)
				continue;	
			a[y][x]=a[x][y]=1;
			p[t]++;					
		}	
	}

	private int gsd(int a, int b) {
		while (a != 0 && b != 0) {
			if (a > b) {
			a %= b;
			} else {
			b %= a;
			}
			
		}
		return a+b;}


	private void print() {
		System.out.println(p[0]);
	}
	/*
	 * Integer right triangles  
     * Problem 39
	 */
}
