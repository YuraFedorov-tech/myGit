package e045;


public class e045 {
	private static long ans;
	private static long[] Tn;
	private static long[] Pn;
	private static long[] Hn;
	private static int max;

	public e045(int i) {
		ans = Long.MAX_VALUE;
		max = i;
		Tn = new long[i];
		Pn = new long[i];
		Hn = new long[i];
	}

	public static void main(String[] args) {
		e045 d = new e045(100000);
		d.work();
		d.print();
	}

	private void work() {
		doTn();
		Find();
	}

	

	private void Find() {
		
		for (int i = 143; i <max; i++) {
			long cur= Hn[i];		
			if (Have(Tn,0, max - 1, cur))
				if (Have(Pn,0, max - 1, cur)){
					ans=cur;
					return;
				}
		}
	}

	private boolean Have(long[] tn2, int le, int re, long d) {
		if (le == re)
			return tn2[le] == d;
		int mid = le + (re - le) / 2;
		if (d > tn2[mid])
			return Have(tn2,mid + 1, re, d);
		else
			return Have(tn2,le, mid, d);
	}

	private void doTn() {
		for (int i = 1; i <= max; i++) {
			long wTn = (long) i * ( i + 1) / 2;
			long wPn = (long) i * (3 * i - 1) / 2;
			long wHn = (long) i * (2* i - 1) ;
			Tn[i - 1] = wTn;
			Pn[i - 1] = wPn;
			Hn[i - 1] = wHn;
		}
	}

	private void print() {
		System.out.println(ans);
	}
}
/*
 * Pentagon numbers Problem 45
 */
