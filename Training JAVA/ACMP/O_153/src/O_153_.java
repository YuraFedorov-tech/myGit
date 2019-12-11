import java.util.Scanner;

public class O_153_ { //Main
	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int m = my.nextInt();
		long[] a = new long[m];
		for (int i = 0; i < m; i++) {

			a[i] = my.nextLong();
		}
//		pr.pr(a);
		a = Sort(a);
	//	pr.pr(a);
		int[] count = new int[3];
		int []finaly=new int [1];
long max_summa=Find_Max_summa(a);
	if(max_summa>=n){

count = rekur(0, count, a, n,finaly);
//		pr.pr(count);
		if(count[1]==1)
			System.out.print(finaly[0]);
		if(count[1]==0)
			System.out.print(0);
	}else
		System.out.print(-1);
	}

	private static long Find_Max_summa(long[] a) {
		long n=0;
		for(int i=0;i<a.length;i++){
		n+=2*a[i];
	}
		return n;
	}

	private static int[] rekur(int step, int[] count, long[] a, int summa, int[] finaly) {
		if (count[0] == summa) {
			count[1] = 1;
			finaly[0]=count[2];
			return count;
		}
		if (step == a.length)
			return count;
		
		for (int i = 0; i < 3; i++) {
			int n = 0;
			long summa_now = 0;
			switch (i) {
			case 0:
			
				n = 2;
				break;
			case 1:
				
				n = 1;
				break;
			case 2:
				
				n = 0;
				break;
			}
			summa_now = a[step] * n;
			if (count[0] + summa_now > summa)
				continue;
			if(count[1]==1 & count[2]+n>= finaly[0])
				continue;
			count[0] += summa_now;
			count[2]+=n;
			count = rekur(step + 1, count, a, summa,finaly);
	
			count[2]-=n;
			count[0] -= summa_now;
		}

		return count;
	}

	private static long[] Sort(long[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int i1 = 0; i1 < a.length - i - 1; i1++) {
				if (a[i1] > a[i1 + 1])
					continue;
				long t = a[i1];
				a[i1] = a[i1 + 1];
				a[i1 + 1] = t;
			}
		}
		return a;
	}
}
