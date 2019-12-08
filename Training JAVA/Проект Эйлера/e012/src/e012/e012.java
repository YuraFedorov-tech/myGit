package e012;

import java.util.ArrayList;

public class e012 {
	static int an;
	static long ans;
	static long treug;
	static ArrayList<Integer> mean;
	static ArrayList<Integer> n;

	public e012(int max) {
		an = 0;
		ans = 0;
		treug=0;
	}

	public static void main(String[] args) {
		int max = 1000000;
		e012 q = new e012(max);
		q.work();
		q.print();

	}

	private void work() {
		for (long i = 1; i < 1000_000; i++) {
			treug+=i;
			Find(treug);
			if (ans != 0)
				return;
		}

	}

	private void Find(long treug) {
		mean = new ArrayList<Integer>();
		n = new ArrayList<Integer>();
		FindArray(treug);
		an = FindAns();
		if (an > 500) {
			ans = treug;
			return;
		}

	}

	private int FindAns() {
		int w = 1;
		for (int i = 0; i < n.size(); i++)
			w *= (n.get(i) + 1);
		return w;
	}

	private void FindArray(long j) {
		long max = (long) Math.sqrt(j) + 3;
		if (max > j)
			max = j;
		for (int i = 2; i < max; i++) {
			int z = 0;
			while (j % i == 0) {
				z++;
				j /= i;
			}
			if (z != 0) {
				mean.add(i);
				n.add(z);
			}
		}

	}

	private void print() {
		System.out.print(ans);
	}
}


/*
Highly divisible triangular number   
Problem 12
*/