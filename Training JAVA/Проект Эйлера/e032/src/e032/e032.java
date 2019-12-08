package e032;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class e032 {

	private static int ans;	
	private static Set<Integer> list;
	private static int ansList[] ;
	private static boolean buzy[] ;

	public e032(int i) {
		ans = 0;
		list = new  HashSet<Integer>();
		ansList=new int[9];
		buzy=new boolean[10];
	}

	public static void main(String[] args) {

		e032 q = new e032(200);
		q.work();
		q.print();
	}

	private void print() {
		System.out.println(ans);
	}

	private void work() {
		rek(0);
		Count();
	}

	private void Count() {
		Integer[] myArray= {};
	    myArray = list.toArray(new Integer[list.size()]);
		for(int i=0;i<list.size();i++)
			ans+=myArray[i];
		
	}

	private void rek(int step) {
		
		if (step == 9) {
			TWO.Count(list,ansList);
		}
		for (int i = 1; i <10; i++) {
			if(buzy[i])
				continue;
			buzy[i]=true;
			ansList[step]=i;
			rek(step+1);
			buzy[i]=false;
			
		}
			
	}
}
/*
 * Pandigital products   
 * Problem 32
 */