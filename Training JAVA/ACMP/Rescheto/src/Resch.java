import java.util.Scanner;

public class Resch {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.println("число ?");
		final int k = myScanner.nextInt();
		int[] a;
		a = new int[k];
		boolean[] used;
		used = new boolean[k];

		for (int i = 3
				; i * i < k; i++) {
			if(i%2==0){continue;}
			if (!used[i]) {
				a[i] = 1;
				for (int j = i ; j < k; j += i) {
					used[j] = true;

				}

			}

		}
		
		a[1]=a[2]=1;
		for (int i = 0;  i < k; i++) {
			if(i%2==0  & i!=2 ){continue;}
			if (a[i]==1 |!used[i] ){
				System.out.println(i +"  ");
			}
	
		}
		
		
		
	
	}

}
