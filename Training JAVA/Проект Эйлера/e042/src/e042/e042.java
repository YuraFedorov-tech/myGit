package e042;

import java.util.Scanner;

public class e042 {
	private static long ans;
	private  int max;
	private String[] s;
	private boolean [] tr;

	
	public e042(int i) {		
		ans = 0;
		tr=new boolean[i];
		max=i;
	}

	public static void main(String[] args) {

		e042 d = new e042(1000);
		d.Input();
		d.work();
		d.print();
	}

	private void Input() {
		Scanner M = new Scanner(System.in);
		String ss = M.nextLine();
		s = ss.split(",", -1);
	}

	private void work() {
		FindTrian();
		Count();
	}

	
	private void Count() {
		for(int i=0;i<s.length;i++) {
			int w=FindW(s[i]);
			if(tr[w])
				ans++;
		}		
	}

	private int FindW(String s) {
		int w=0;
		for(int i=1;i<s.length()-1;i++) {
			w+=s.charAt(i)-'A'+1;			
		}
		return w;
	}

	private void FindTrian() {
		for(int i=0;i<max;i++) {
			int n=(i+1)*i/2;
			if(n>=max)
				return;
			tr[n]=true;
		}
		
	}

	private void print() {
		System.out.println(ans);
	}
	/*
	 * Coded triangle numbers 
     * Problem 42
	 */
}