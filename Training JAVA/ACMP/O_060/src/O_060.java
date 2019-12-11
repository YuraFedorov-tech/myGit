import java.util.Scanner;

public class O_060 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int n = p.nextInt();

		int a[] = new int[20000000];

		B(a);
		int y= a[n];
		System.out.println(a[y]);
	}

	private static void B(int[] a) {
		boolean buzy[] = new boolean[200000];
		a[1] = 2;
		
		int max = 1000;
		int count = 2;
		for (int i = 3; i < max; i += 2) {
			if (buzy[i])
				continue;
			DoBuzy(buzy, i);

		}
		count=FindA(a,count,buzy);
		
	}

	private static int FindA(int[] a, int count, boolean[] buzy) {
	for (int i = 3; i < 200000; i += 2){
		if(!buzy[i]){
			a[count]=i;
			count++;
		}
	}
		return count;
	}

	private static void DoBuzy(boolean[] buzy, int j) {

		for (int i = j * j; i < 200000; i += j){
			buzy[(int) i] = true;
		}
	}
}
