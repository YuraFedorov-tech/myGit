package e072;

public class e072 {
	private long ans;
	private int max;
	private int a[];
	private static boolean erot[];
	
	public e072(int m) {
		max = m;
		a = new int[m+1];
		erot = new boolean[m];
	}

	public static void main(String[] args) {
		e072 d = new e072(1_000_000);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		DoErot();
		rek();
		count();
	}

	private void count() {
		for(int i:a)
			ans+=i;		
	}

	private void rek() {
		a[2] = 1;
		a[3] = 2;
		for(int i=4;i<=max;i++) {
			if(i%2==0) {
				int w=i/2;
				if(w%2==0)
				a[i]=2*a[i/2];
				else
					a[i]=a[i/2];
			}else if(!erot[i]) {
				a[i]=i-1;
			}
			else a[i]=FI(i);			
		}
	}

	private int FI(int n) {
		int r = n;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				while ((n % i == 0))
					n /= i;
				r = r - r / i;
				}
		}
		if (n > 1)
			r = r - r / n;
		return r;
	}
	private void DoErot() {
		for (int i = 2; i < max; i++) {
			if (!erot[i])
				changErot(i);
		}
	}

	private void changErot(int i) {
		int j = i * 2;
		while (j < max) {
			erot[j] = true;
			j += i;
		}
	}
}

/*
 * Counting fractions Problem 72
 */