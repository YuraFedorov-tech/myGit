import java.util.ArrayDeque;

public class e015_2BDF {	
	static int max;
	static long[][] grid;
	static ArrayDeque<Integer> list = new ArrayDeque<Integer>();

	public e015_2BDF(int m) {
		grid = new long[m][m];
		grid[0][0] = 1;	
		max = m;
		list.add(0);
		list.add(0);
	}

	public static void main(String[] args) {

		e015_2BDF d = new e015_2BDF(21);
		d.work();
		d.print();

	}

	private void work() {
		while (list.size() != 0) {
			int l = list.size() / 2;
			for (int i = 0; i < l; i++) {
				GO();
			}
		}

	}

	private void GO() {
		int yOld = list.pop();
		int xOld = list.pop();
		long mean = grid[yOld][xOld];
		int[] Y = { 0, 1 };
		int[] X = { 1, 0 };
		for (int i = 0; i < 2; i++) {
			int x = xOld + X[i];
			int y = yOld + Y[i];
			if (x == max | y == max)
				continue;
			if (grid[y][x] == 0) {
				list.addLast(y);
				list.addLast(x);
			}
			grid[y][x] += mean;
		}

	}

	private void print() {
		System.out.print(grid[max - 1][max - 1]);
	}
	/*
	 * Lattice paths 
	 * Problem 15
	 */
}