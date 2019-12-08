package e076_2Rek;

import java.util.ArrayList;
import java.util.Arrays;


public class e076_2Rek {
	private long ans;
	private boolean zMax;
	private int max;
	private int a[];
	private ArrayList<Integer> list;

	public e076_2Rek(int m) {
		max = m+1;
		a = new int[m+1];
	}

	public static void main(String[] args) {
		e076_2Rek d = new e076_2Rek(20);
		d.work();
	}

	private void print() {
		System.out.print(a[max-1]-1);
	}

	private void work() {	
		job();	
		print();
	}

	private void job() {
		for(int i=1;i<max;i++) {
			
			list=new ArrayList<Integer>();		
			rek(0,i,i);
			System.out.print(i+"  -  ");
			System.out.println(a[i]);
			System.out.println();
		}
	}

	private void rek( int cur, int stop, int j) {
		if(cur>stop)
			return;
		if(cur==stop) {		
			a[stop]++;
			Integer z=1;
			Integer z2=2;
			if(list.indexOf(z)==-1)
				if(list.indexOf(z2)==-1)
			System.out.println(list);			
			return;
		}
		for(int i=j;i>0;i--) {
	//		if(i==stop)
	//			continue;
			list.add(i);
			rek(cur+i,stop,i);
			list.remove(list.size()-1);
		}
	}




}

/*
 * Digit factorial chains Problem 74
 */