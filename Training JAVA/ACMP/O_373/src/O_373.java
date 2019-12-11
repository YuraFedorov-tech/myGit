import java.util.Scanner;


public class O_373 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		int minimal[]=new int[n];
		int k = M.nextInt();
		String S=M.nextLine();
		S=M.nextLine();
		char ch[]=S.toCharArray();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		a[i]=ch[i];
		
		B(a,n,k,minimal);
		
		
	}

	private static void B(int[] a, int n, int k, int[] minimal) {
		int []answear=new int[n];
		for(int i=1;i<n;i++){
			int start=Math.max(0, i-k);
			answear[i]=a[start]==a[i]?answear[start]:answear[start]+1;
		//	if(answear[i]==0)
		//		continue;
			for(int j=start;j<i;j++){
				int pretendent=a[j]==a[i]?answear[j]:answear[j]+1;
				if(answear[i]>pretendent)
					answear[i]=pretendent;
				if(answear[i]==minimal[i])
					break;
			}
			
			if(i-k>0){
				Find_minimal(i,k,minimal,answear);
			}else minimal[i]=answear[i];
			
		}
		System.out.println(answear[n-1]);
	}

	private static void Find_minimal(int i, int k, int[] minimal, int[] a) {
	int min=a[i-k];
	for(int j=i-k+1;j<k;j++){
		min=Math.min(min, a[j]);
		if(min==a[i-k-1])
			break;
	}
	minimal[i]=min;
	}


}
