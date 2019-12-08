package e075;

import java.util.ArrayList;

public class e075 {
	private long ans;
	private boolean zMax;
	private int max;
	private int a[];
	private ArrayList<Integer> list;

	public e075(int m) {
		max = m;
		a = new int[m];
	}

	public static void main(String[] args) {
		e075 d = new e075(1_500_001);
		d.work();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		job();
		countAns();
		print();
	}

	private void countAns() {
	for(int i=0;i<max;i++)
		if(a[i]==1)
			ans++;
		
	}

	private void job() {
		for (int m = 0; m < max; m++) 
			job(m);
	}

	private void job(int m) {
		zMax=false;
		for (int n = 1; n < m; n++) {
			if((m-n)%2==0)
				continue;
			if((long)m*n>400_000l)
				return;
			if (gsd(m, n) != 1)
				continue;
			inSide(m, n);
			if(zMax)
				return;
		}

	}

	private void inSide(long m, long n) {
		long x = m * m - n * n;
		long y = 2 * m * n;
		long z = m * m + n * n;
		if(z>750_000 |x>750_000 |y>750_000 ) {
			zMax=true;
			return;
		}
		assert (z > 0);
		inSider(x, y, z);
	}

	private void inSider(long x, long y, long z) {
		int i = 1;
		while (true) {
			long xx = x * i;
			long yy = y * i;
			long zz = z * i;
			long q = xx + yy + zz;		
			if (q > (long)max)
				return;
			assert (teoria(xx,yy,zz));
			a[(int) q]++;
			i++;
		}
	}

	private boolean teoria(long xx, long yy, long zz) {
		long t=xx*xx+yy*yy;
		t=(long) Math.sqrt(t);		
		return t==zz;
	}
	private int gsd(int a, int b) {
		while (a != 0 & b != 0)
			if (a > b)
				a %= b;
			else
				b %= a;
		return a + b;
	}
}

/*
 * Digit factorial chains Problem 74
 */