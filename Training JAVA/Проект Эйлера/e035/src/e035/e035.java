package e035;



public class e035 {
	private static boolean erot[];
	private static int max;
	private static int mi;
	private static int ma;
	static long ans;

	public e035(int m, int i, int j) {
		erot = new boolean[m];
		max = m;
		ans = 0;
		mi=i;
		ma=j;
		
	}

	public static void main(String[] args) {
		int m = 4_000_001;
		e035 q = new e035(m,2,1_000_000);
		q.work();
		q.print();

	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		DoErot();
		Count();
	}


	private void Count() {
	for(int i=mi;i<ma;i++) {
		if(erot[i])
			continue;
		if(Chek(i)) {
			ans++;
		}
	}		
	}
	private boolean Chek(int n) {
		String s=Integer.toString(n);
		for(int i=0;i<s.length();i++) {
			s=""+s.charAt(s.length()-1)+s.substring(0,s.length()-1);
			int v=Integer.parseInt(s);
			if(erot[v])
				return false;
		}
		return true;
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
 * Circular primes   
 * Problem 35
 */