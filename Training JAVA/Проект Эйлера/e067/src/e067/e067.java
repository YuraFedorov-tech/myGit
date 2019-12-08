package e067;



import java.util.Scanner;

public class e067 {
	static int ans;
	static int a[];
	static int b[];

	public e067(int i) {
		ans = 0;
		a = new int[1];
	}

	public static void main(String[] args) {
		e067 d = new e067(0);
		d.work();
		d.print();
	}

	private void work() {
		Scanner M = new Scanner(System.in);
		a[0] = M.nextInt();
		for (int i = 0; i < 99; i++) {
			b = new int[a.length + 1];	
			Input(M);
			Count();
			a = b;
		}
		CountAns();
	}

	private void CountAns() {
		for (int i = 0; i < b.length; i++)
			if (ans < b[i])
				ans = b[i];
	}

	private void Count() {
		for (int i = 0; i < a.length - 1; i++) {
			int l = Math.max(a[i], a[i + 1]);
			b[i + 1] += l;
		}
		b[0] += a[0];
		b[b.length - 1] += a[a.length - 1];
	}

	private void Input(Scanner M) {
		for (int i = 0; i < b.length; i++)
			b[i] = M.nextInt();
	}

	private void print() {
		System.out.print(ans);
	}
}
/*
Maximum path sum II   
Problem 67
*/