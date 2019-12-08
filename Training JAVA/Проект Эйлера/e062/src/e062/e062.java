package e062;
import java.math.BigInteger;

public class e062 {
	private static long ans;
	private static int n;
	private static int l;
	private static boolean find;

	public e062(int i, int j) {
		ans = 0;
		n = i;
		find = false;
		l = j;
	}

	public static void main(String[] args) {
		e062 d = new e062(5, 20_000);
		d.work();
		d.print();
	}

	private void work() {
		e062_2 r = new e062_2(l);
		r.DoCub();
		int i = 1;
		while (true) {
            r.Job(i);
			int d=r.FindListSize();
			if(d==n) {
				ans=i;
				return;
			}			
			i++;
		}
	}

	private void print() {		
		System.out.println((long)ans*ans*ans);
	}
	/*
	 * Cubic permutations  
     * Problem 62
	 */
}
