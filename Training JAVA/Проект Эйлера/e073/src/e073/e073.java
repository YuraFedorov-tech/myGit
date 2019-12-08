package e073;

public class e073 {
	private static int ans;
	private static int max;
	private static int p;
	private static int q;


	public e073(int i, int j, int m) {
		p =i;
		q=j;
		max = m;
	
	}

	public static void main(String[] args) {

		e073 d = new e073(1, 3, 12000);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		for (int i = 1; i <= max; i++) {
			Go(i);
		}
	}

	private void Go(int pPr) {
		for (int i = 2 * pPr + 1; i <= max; i++) {
			int qPr = i;
			if(gsd(pPr,qPr)!=1)
				continue;
			if (less(p,q,pPr, qPr)) {
				ans++;
				} else
					return;
		}
	}

	private int gsd(int a, int b) {
		while(b!=0 && a!=0) {
			if(a>b)
				a%=b;
			else
				b%=a;
		}
		return a+b;
	}

	private boolean less(int pPr, int qPr, int p2, int q2) {		
		return q2 * pPr - p2 * qPr < 0;
	}
}

/*
 * Counting fractions in a range   
 * Problem 73
 */