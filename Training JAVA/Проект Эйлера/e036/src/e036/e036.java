package e036;

public class e036 {

	private static int ans;
	private static int max;

	public e036(int i) {
		ans = 0;
		max = i;
	}

	public static void main(String[] args) {

		e036 d = new e036(1_000_000);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		for (int i = 0; i < max; i++)
			if (Poilind(i)) {
				ans += i;
			}
	}

	private boolean Poilind(int n) {
		if (Poli(Integer.toBinaryString(n)))
			if (Poli(Integer.toString(n)))
				return true;
		return false;
	}

	private boolean Poli(String s) {
		int j = s.length() - 1;
		for (int i = 0; i < s.length(); i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			if (j <= i)
				break;
		}
		return true;
	}

}

/*
 * Double-base palindromes Problem 36
 */
