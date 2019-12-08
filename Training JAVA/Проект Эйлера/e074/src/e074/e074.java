package e074;

import java.util.ArrayList;

public class e074 {
	private long ans;
	private int max;
	private int n;
	private int f[];
	private ArrayList<Integer> list;

	public e074(int m, int i) {
		max = m;
		f = new int[10];
		n = i;
	}

	public static void main(String[] args) {
		e074 d = new e074(1_000_000, 60);
		d.work();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		doF();
		go();
		print();
	}

	private void go() {
		for (int i = 169; i < max; i++) {
			list = new ArrayList<Integer>();
			rek(i);
		}
	}

	private void rek(int q) {	
		if (isHave(q)) {
			if (list.size() == n) 
				ans++;		
			return;
		}
		if(list.size() > n)
			return;
		list.add(q);
		int newq = FindNewQ(q);
		assert (newq > 0);
		rek(newq);
	}

	private int FindNewQ(int q) {
		int w = 0;
		String s = Integer.toString(q);
		for (int i = 0; i < s.length(); i++) {
			int z = Integer.parseInt("" + s.charAt(i));
			w += f[z];
		}
		return w;
	}

	private boolean isHave(Integer q) {
		int e = list.indexOf(q);
		return e != -1;
	}

	private void doF() {
		f[0] = f[1] = 1;
		for (int i = 2; i < 10; i++)
			f[i] = i * f[i - 1];
	}
}

/*
 * Digit factorial chains   
 * Problem 74
 */