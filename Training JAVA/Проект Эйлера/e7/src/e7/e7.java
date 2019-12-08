package e7;

public class e7 {
	private static boolean erot[];
	private static int max;

	public e7(int i) {
		erot = new boolean[i];
		max = i;
	}

	public static void main(String[] args) {
		int m = 1_000_001;
		e7 q = new e7(m);
		q.work();

	}

	private void work() {
		DoErot();
		FindN();

	}

	private void FindN() {
		int count=0;
		for(int i=2;i<max;i++)
			if(!erot[i]) {
				count++;
			
				if(count==10_001) {
					System.out.println(i);
					return;
				}
			}
		
	}

	private void DoErot() {
		for (int i = 2; i < max; i++) {
			if (!erot[i])
				changErot(i);
		}

	}

	private void changErot(int i) {
		int j = i*2;
		while (j < max) {
			erot[j] = true;
			j += i;
		}
	}
}
