package e024;

public class e024 {

	private static int ans;
	private static int max;
	private static boolean buzy[];
	private static int[] cur;

	public e024(int i) {

		max = i;
		buzy = new boolean[i];
		cur = new int[i];
	}

	public static void main(String[] args) {

		e024 q = new e024(10);
		q.work();

	}

	private void print() {
		for (int i = 0; i < 10; i++)
			System.out.print(cur[i]);
	}

	private void work() {
		rek(0);
	}

	private void rek(int step) {

		if (step == max) {
			ans++;
			if (ans == 1_000_000)
				print();
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (buzy[i])
				continue;
			buzy[i] = true;
			cur[step] = i;
			rek(step + 1);
			buzy[i] = false;
		}
	}
}
/*
 * Lexicographic permutations Problem 24
 */