package e023;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class e023 {
	private static int ans;
	private static int max;
	private static boolean[] buzy;
	ArrayList<Integer> list;

	public e023(int m) {
		ans = 0;
		list = new ArrayList<Integer>();
		max = m;
		buzy = new boolean[max];
	}

	public static void main(String[] args) {

		e023 d = new e023(28124);
		d.work();
		d.print();

	}

	private void work() {
		FindList();
		FindIzbitok();
		CountAns();
	}

	private void CountAns() {
		for(int i=0;i<max;i++)
			if(!buzy[i])
				ans+=i;
		
	}

	private void FindIzbitok() {
		int n=list.size();
		for(int i=0;i<n;i++)
			for(int j=i;j<n;j++) {
				int q=list.get(i)+list.get(j);
				if(q>=max)
					continue;
				buzy[q]=true;
			}
		
	}

	private void FindList() {
		for (int i = 12; i < max; i++) {
			int first = FindDivider(i);
			if (first > i) 
				list.add(i);
			
		}

	}

	private int FindDivider(int n) {
		int a = 0;
		int max = n / 2 + 1;
		if (max > n)
			max = n - 1;
		for (int i = 1; i <= max; i++)
			if (n % i == 0)
				a += i;
		return a;
	}

	private void print() {
		System.out.print(ans);
	}
	/*
	 * Non-abundant sums   
     * Problem 23
	 */
}