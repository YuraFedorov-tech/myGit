package e034;

public class e034 {

	private static boolean find;
	static int[] f;
	private static int ans;
	private static int max;

	public e034(int i) {
		max = i;
		f = new int[10];
		ans = 0;
	}

	public static void main(String[] args) {
		e034 d = new e034(100_000);
		d.work();
		d.print();
	}

	private void work() {
		DO_F();
		for (int i = 3; i < max; i++) {
			GO(i);
			
		}

	}



	private void GO(int n) {
		String s=Integer.toString(n);
		long w=0;
		for(int i=0;i<s.length();i++) {
			long w1=FindW1(s.charAt(i));
			w+=w1;
			if(w>n)
				return;		
		}
		if(w==n) 
			ans+=w;		
	}
	private long FindW1(char charAt) {
		int w=charAt-'0';
		int an=f[w];
		return an;
	}

	private void DO_F() {
		f[0]=1;
		for(int i=1;i<10;i++)
			f[i]=i*f[i-1];
		
	}
	private void print() {
		System.out.println(ans);
	}
	/*
	 * IDigit factorials   
     * Problem 34
	 */
}
