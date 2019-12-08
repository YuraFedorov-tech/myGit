package e043;

public class e043 {

	private static long ans;
	private static int a[]= {-1,2,3,5,7,11,13,17};
	private static boolean buzy[];


	public e043() {
		ans =  0;
		buzy = new boolean[10];
	}

	public static void main(String[] args) {

		e043 q = new e043();
		q.work();
		q.print();
	}

	private void print() {		
			System.out.println(ans);
	}

	private void work() {		
			Rek(0, 10,0);
	}

	private void Rek(int step, int max, long cur) {	
		if (step == max) {
			if(chek(cur))
			  plus(cur);			
			return;
		}
		for (int i = 0; i <10; i++) {
			if(step==0 &i==0)
				continue;
			if (buzy[i])
				continue;
			buzy[i] = true;		
			Rek(step + 1, max, cur*10+i);
			buzy[i] = false;		
		}
	}

	private void plus(long cur) {		
	ans+=cur;		
	}

	private boolean chek(long cur) {
		for(int i=2;i<9;i++) {
			if(!Cheking(i-1,Long.toString(cur)))
				return false;
		}
	return true;		
	}

	private boolean Cheking(int j, String s) {
		int an=0;
		for(int i=j;i<j+3;i++) {
			int w=Integer.parseInt(""+s.charAt(i));
			an=an*10+w;
		}		
		return an%a[j]==0;
	}
}
/*
 * Sub-string divisibility   
 * Problem 43
 */