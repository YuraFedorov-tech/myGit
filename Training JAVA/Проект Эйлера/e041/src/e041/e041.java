package e041;

public class e041 {

	private static long ans;
	private static int a[];
	private static boolean buzy[];

	public e041() {
		ans = 0;
		buzy = new boolean[10];

	}

	public static void main(String[] args) {

		e041 q = new e041();
		q.work();
		q.print();
	}

	private void print() {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}

	private void work() {
		for (int i = 9; i > 2; i--) {
			a = new int[i];
			Rek(0, i);
			if (ans == 1)
				break;
		}

	}

	private void Rek(int step, int max) {
		if (step == max) {
			if (chekSimple(max))
				ans = 1;
			return;
		}
		for (int i = max; i > 0; i--) {
			if (buzy[i])
				continue;
			buzy[i] = true;
			a[step] = i;
			Rek(step + 1, max);
			buzy[i] = false;
			if (ans == 1)
				return;
		}
	}

	private boolean chekSimple(int max) {
		long cur = FindCur(max);
		return Simple(cur);
	}

	private boolean Simple(long cur) {
		long t = cur / 2;
		for (int i = 2; i < t; i++)
			if (cur % i == 0)
				return false;
		return true;
	}

	private long FindCur(int max) {
		long an = 0;
		for (int i = 0; i < max; i++)
			an = an * 10 + a[i];
		return an;
	}

}
/*
 * Pandigital prime 
 * Problem 41
 */