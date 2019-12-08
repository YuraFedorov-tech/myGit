package e058;

public class e058 {
	private int ans;	
	private int max;

	public e058(int m) {
		max = m;
	}

	public static void main(String[] args) {
		e058 d = new e058(1_000_0000);
		d.work();
		d.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {		
		ans = 3;
	int	next = 9;
		int all = 9;
		int l = 4;
		while (true) {
			for (int i = 0; i < 4; i++) {
				next += l;
				if (Simple(next)) {
					ans++;
				}
			}			
			if ((long)ans * 100 / all < 10) {				
				ans = l+1;
				break;
			}
			all +=4;
			l+=2;			
		}
	}
	private boolean Simple(int n) {
		int m=(int) (Math.sqrt(n)+3);
		if(m>n)
			m=n;
		for(int i=2;i<m;i++)
			if(n%i==0)
		return false;
		return true;
	}
}
/*
 * Counting fractions Problem 72
 */