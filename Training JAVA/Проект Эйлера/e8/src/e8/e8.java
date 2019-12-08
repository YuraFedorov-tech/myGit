package e8;

import java.util.ArrayList;
import java.util.Scanner;

public class e8 {
	private static String s;
	private static long ans;
	private static ArrayList<Integer> a;

	public e8() {
		s = "";
		ans = 0;
		a = new ArrayList<Integer> ();

	}

	public static void main(String[] args) {
		e8 q = new e8();
		q.input();
		q.count();
		q.print();
	}

	private void print() {
		System.out.println(ans);
		
	}

	private void count() {
		for (int i = 0; i < 1000 - 13; i++) {
			long z=1;
			for (int j = i; j < i +13; j++) {
				z*=a.get(j);
				
			}
		if(ans<z) 	
			ans=z;
	
		
		}

	}

	private void input() {
		Scanner M = new Scanner(System.in);
		for (int i = 0; i < 20; i++) {
			s = M.nextLine().trim();
			InputInArray();
		}

	}

	private void InputInArray() {
		for (int i = 0; i < 50; i++)
			a.add(Integer.parseInt("" + s.charAt(i)));
			

	}
}
