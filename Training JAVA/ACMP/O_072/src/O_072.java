import java.util.Arrays;
import java.util.Scanner;


public class O_072 {
	public static void main(String[] args) {
		/*
char ch='a';
//char g='c';
int x=ch;
//int y=g;
char gg=(char) x;
//System.out.println(x+" "+y);
//System.out.println(ch+" "+g);
System.out.println(gg);*/



		Scanner M = new Scanner(System.in);
		String s=M.next();
		int n = s.length();
		int []a=new int[n];
	char ch[]=new char[n];
	
		for(int i=0;i<n;i++){
			char rr=s.charAt(i);
			ch[i]=rr;
			a[i]= rr;
		}
		boolean d=R(a,n);
		if(d){
			for (int i = n - 1; i >= 0; i--)
				System.out.print(a[i] + " ");
		}else{
			int x=1;
			int A=-1;
//			System.out.println(Arrays.toString(a));
		while(true){
			int v=n-1-x;
			int z=a[v];

					for(int p=n-1;  p>v;p--){
					int j=p;
						if(z<a[p]){
							A=1;
							int b[]=new int [n];
							for(int i=v+1;i<n;i++){
								if(i==j)
									continue;
								b[i]=a[i];
							}
//							System.out.println(Arrays.toString(b));
							
							b[j]=a[v];
							Arrays.sort(b);

//							System.out.println(Arrays.toString(b));
							b[v]=a[j];

						for(int i=0;i<v;i++){
							b[i]=a[i];
						}

								
						for(int i=0;i<n;i++){
							char f=(char) b[i];
							System.out.print(f);		
						}		
						break;
						}
					}


			
			x++;
			
			if(A==1)
				break;
			
		}
		}
		
	}

	

	
	private static boolean R(int[] a, int n) {
	for(int i=0;i<n-1;i++)
		if(a[i]<a[i+1])
		return false;
	return true;
	}
}

