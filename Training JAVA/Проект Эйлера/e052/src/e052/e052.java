package e052;

public class e052 {
	private static int ans;	
	private static boolean find;
	static boolean[] a;

	public e052(int i) {		
		find = false;
		a = new boolean[10];
	}

	public static void main(String[] args) {
		e052 d = new e052(3);
		d.work();
		d.print();

	}

	private void work() {
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			a = new boolean[10];
			Find_A(i, a);
			e052_2 w = new e052_2(a, i);
			w.job();
			boolean f = w.getFind();
			if(f) {
				ans=i;
				return;
			}
		}

	}

	static void Find_A(long j, boolean[] a2) {
		String s = Long.toString(j);
		for (int i = 0; i < s.length(); i++)
			a2[Integer.parseInt("" + s.charAt(i))] = true;

	}

	private void print() {
		System.out.println(ans);
	}
	/*
	 * Permuted multiples   
     * Problem 52
	 */
}
