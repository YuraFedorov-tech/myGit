package e028;

public class e028 {
	private static int a[][];
	private static int max;
	private static int y;
	private static int x;
	private static int direct;
	static int ans;

	public e028(int m) {
		a = new int[m][m];
		max = m;
		ans = 0;
		direct = 1;
		y = x = (max - 1) / 2 ;
	}

	public static void main(String[] args) {

		e028 q = new e028(1001);
		q.work();
		q.print();
	}

	private void print() {
		System.out.print(ans);
	}

	private void work() {
		insideOne();
		fullA();
		Count();
	}

	private void Count() {
		for(int i=0;i<max;i++)
			ans+=a[i][i];	
		for(int i=0;i<max;i++)
			if(i!=(max-1)/2)
			ans+=a[i][max-1-i];
		
	}

	private void fullA() {
		for (int i = 2; i <= max * max; i++) {
			switch (direct) {
			case 0:
				UP(i);
				break;
			case 1:
				Right(i);
				break;
			case 2:
				Down(i);
				break;
			case 3:
				Left(i);
				break;
			default:
				System.out.print(ans / 0);
			}
		}

	}

	private void UP(int i) {
		y--;
		a[y][x] = i;
		if (y == 0 || a[y ][x+1] == 0)
			direct++;
	}

	private void Left(int i) {
		x--;
		a[y][x] = i;
		if (x == 0 || a[y-1][x] == 0)
			direct=0;
	}

	private void Down(int i) {
		y++;
		a[y][x] = i;
		if (y == max - 1 || a[y ][x-1] == 0)
			direct++;
	}

	private void Right(int i) {
		x++;
		a[y][x] = i;
		if (x == max - 1 || a[y+1][x ] == 0)
			direct++;
	}

	private void insideOne() {
		a[y][x] = 1;
	}

}
/*
 * Number spiral diagonals
 * Problem 28
 */