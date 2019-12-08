package e044;

public class e044 {	
	private static long ans;
	private static long D;
	private static long P;
	private static long[] Lis;
	private static int max;
	

	public e044(int i) {			
		ans = Long.MAX_VALUE;
		max = i;
		Lis = new long[i];
	}

	public static void main(String[] args) {
		e044 d = new e044(3000);
		d.work();
		d.print();
	}

	private void work() {
		doTn();
		GO();
	}

	private void GO() {
		for (int i = 1; i < max; i++) 
			Find(i);			
	}

	private void Find(int j) {
		long cur = Lis[j];
		for (int i = j - 1; i >= 0; i--) {
			long w = Lis[i];
			P = cur + w;
			D = cur - w;
			if (Have(0, max-1, P))
				if (Have(0, max-1, D))
					if (ans > D) 
						ans=D;					
		}

	}

	private boolean Have(int le, int re, long d) {
		if (le == re)
			return Lis[le] == d;
		int mid = le + (re - le) / 2;
		if (d > Lis[mid])
			return Have(mid + 1, re, d);
		else
			return Have(le, mid, d);
	}
	private void doTn() {
		for (int i = 1; i <= max; i++) {
			long w = (long) i * (3 * i - 1) / 2;		
			Lis[i-1] = w;
		}
	}

	private void print() {
		System.out.println(ans);
	}
	/*
	 * Pentagon numbers   
     * Problem 44
	 */
}
