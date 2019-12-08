package e061;

import java.util.ArrayList;

public class e061 {
	private  int ans;
	protected static ArrayList<Integer> list3 = new ArrayList<Integer>();
	protected static ArrayList<Integer> list4 = new ArrayList<Integer>();
	protected static ArrayList<Integer> list5 = new ArrayList<Integer>();
	protected static ArrayList<Integer> list6 = new ArrayList<Integer>();
	protected static ArrayList<Integer> list7 = new ArrayList<Integer>();
	protected static ArrayList<Integer> list8 = new ArrayList<Integer>();
	protected static ArrayList<Integer> list = new ArrayList<Integer>();
	private static boolean find;
	
	private  int first;
	public e061() {

	}

	public static void main(String[] args) {
		e061 d = new e061();
		d.work();
		d.print();
		d.CountAns();
	}

	private void work() {
		DoList();
		GO();		
	}

	private void CountAns() {
	for(int i=0;i<list.size();i++) {
		ans+=list.get(i);
	}		
	}

	private void GO() {
	for(int i=10;i<100;i++) {
		ans=0;
		first=i;
		e061_2 w=new e061_2();
		rek(0,first,w);
		if(find)
			return;
	}		
	}

	private void rek(int step, int fir, e061_2 w) {
		if(step==6) {
			if(w.AllPoint()) {
				find=true;
				CountAns();
			}
			return;
		}
		for(int i=10;i<100;i++) {
			int next=fir*100+i;
			if(step==5) {
				i=100;
				next=fir*100+first;
			}
			if(!e061_2.Chek(step,next))
				continue;
			list.add(next);
			
			rek( step+1, i,w);
			if(find)
				return;
		w.DeleteA(step);
			list.remove(list.size()-1);		
		}		
	}

	private void DoList() {
		DO3();
		DO4();
		DO5();
		DO6();
		DO7();
		DO8();	
	}

	private void DO8() {
		int x=1;
		while(true) {
			int a=x*(3*x-2);
			if(a>10_000)
				return;
			list8.add(a);
			x++;
		}
	}


	private void DO7() {
		int x=1;
		while(true) {
			int a=x*(5*x-3)/2;
			if(a>10_000)
				return;
			list7.add(a);
			x++;
		}
	}

	private void DO6() {
		int x=1;
		while(true) {
			int a=x*(2*x-1);
			if(a>10_000)
				return;
			list6.add(a);
			x++;
		}		
	}

	private void DO5() {
		int x=1;
		while(true) {
			int a=x*(3*x-1)/2;
			if(a>10_000)
				return;
			list5.add(a);
			x++;
		}
	}

	private void DO4() {
		int x=1;
		while(true) {
			int a=x*(x);
			if(a>10_000)
				return;
			list4.add(a);
			x++;
		}		
	}

	private void DO3() {
		int x=1;
		while(true) {
			int a=x*(x+1)/2;
			if(a>10_000)
				return;
			list3.add(a);
			x++;
		}
	}

	private void print() {	
		System.out.println(ans);
	}
	/*
	 * Cyclical figurate numbers   
     * Problem 61
	 */
}
