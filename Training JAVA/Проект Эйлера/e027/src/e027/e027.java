package e027;
public class e027 {
	private static boolean erot[];
	private static int max;
	private static int cur;
	private static int mi;
	private static int ma;
	static long ans;

	public e027(int m, int i, int j) {
		erot = new boolean[m];
		max = m;
		ans = 0;
		mi=i;
		ma=j;
		cur=0;
	}

	public static void main(String[] args) {
		int m = 4_000_001;

		e027 q = new e027(m,-1000,1000);
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
		for(int i=mi;i<=ma;i++) {
			Go(i);
		}
		
	}

	private void Go(int a) {
		for(int i=mi;i<=ma;i++) {
			Go(a,i);
		}
		
		
	}



	private void Go(int a, int b) {
		int z=FindZ(a,b);
		if(cur<z) {
			cur=z;
			ans=a*b;		
		}		
	}

	private int FindZ(int a, int b) {
		int x=0;
		while(true) {
			int w=x*x+a*x+b;
			if(w<2)
				break;
			if (erot[w])
				break;
			x++;
		}
		return x;
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
Quadratic primes   
Problem 27
*/