package e015;

public class e015 {
	static int ans;
	static int max;	

	public e015( int m) {
	
		ans = 0;
		max = m;
	}

	public static void main(String[] args) {

		e015 d = new e015(9);
		d.work();
		d.print();

	}

	private void work() {
		rek(0, 0, 0);

	}

	private void rek(int step, int i, int j) {
		if (i == max || j == max)
			return;
		if (i == max - 1 && j == max - 1) {
			ans++;
			assert (ans > 0);
			return;
		}
		for (int p = 0; p < 2; p++) 
			if (p == 0)
				rek(step + 1, i, j + 1);
			else
				rek(step + 1, i + 1, j);
		
	}

	

	private void print() {
		System.out.print(ans);
	}
	/*
    	Lattice paths   
        Problem 15
	    Rekyrsia dor youself chek
	 */
}