package e071;

public class e071 {

	private static int max;
	private static int p;
	private static int q;
	private static int pMin;
	private static int qMin;

	public e071(int i, int j, int k) {
		qMin = 1;
		max = k;
		p=i;
		q=j;
	}

	public static void main(String[] args) {

		e071 d = new e071(3, 7, 1_000_000);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(pMin+" "+qMin);

	}

	private void work() {
		for (int i = 1; i <= max; i++) {
			if(i%10000==0)
			System.out.println(i);
			Go(i);
	}
	}
	private void Go(int pPr) {
		for(int i=2*pPr+1;i<=max;i++) {
			int qPr=i;
			if(less(pPr,qPr,p,q))
				if(less(pMin,qMin,pPr,qPr)) {
					pMin=pPr;
					qMin=qPr;
				}else
					return;
		}
			
		
	}

	private boolean less(int pPr, int qPr, int p2, int q2) {
		int q=q2*pPr-p2*qPr;
		return q<0;
	}


}

/*
 * Ordered fractions Problem 71
 */