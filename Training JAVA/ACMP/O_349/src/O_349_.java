import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_349_ {  //Main

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int m = my.nextInt();
		ArrayList<Integer> simple_number = new ArrayList<Integer>();
		simple_number = Find_simple_number(n,m, simple_number);
pr_simple_number(simple_number,n);
if(simple_number.size()==0)
	System.out.println("Absent");
	}
	
	
	private static void pr_simple_number(ArrayList<Integer> simple_number, int n) {
		for(int i=0;i<simple_number.size();i++){
			
			System.out.println(simple_number.get(i));
			
		}
		
	}


	private static ArrayList<Integer> Find_simple_number(int n,int m,
			ArrayList<Integer> simple_number) {
		
		int end = (int) Math.sqrt(m);
		boolean[] used = new boolean[m+1];
	
		for (int i = 2; i <=m ; i++) {

			if (!used[i]) {
				
				used = deleteFromUsed(used, i);
			if(i>=n)
				simple_number.add(i);
			}

		}

		return simple_number;
	}

	private static boolean[] deleteFromUsed(boolean[] used, int i) {
		int step = 1;
		while (true) {
			int y = step++ * i;
			if (y > used.length - 1)
				break;
			used[y] = true;
		}
		return used;
	}

}
