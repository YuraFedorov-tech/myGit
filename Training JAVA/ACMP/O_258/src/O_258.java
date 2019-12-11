import java.util.Scanner;


public class O_258 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int k1 =M.nextInt();
		int m =M.nextInt();
		int k2 =M.nextInt();
		int p2 =M.nextInt();
		int n2 =M.nextInt();
		

		
		
		
		B(k1,m,k2,p2,n2);
	}

	private static void B(int k1, int m, int k2, int p2, int n2) {
		if(n2>m){
			System.out.println(-1 +" "+ -1);
			return;
		}
if(p2==1 &n2==1){
	go(k1,m,k2,p2,n2);
	return;
}

		int x=FindX(m,k2,p2,n2);
		if(x==-1){
			System.out.println(-1 +" "+ -1);
			return;
		}
		if(x==-10){
		int p1=	goNoFlooer(k1,m,k2,p2,n2);
		System.out.println(p1 +" "+ 0);
			return;
		}
		
		
		int p1=(k1/(m*x));
		if(k1%m*x!=0)
			p1++;
		int y=k1-(p1-1)*m*x;
		int n1=y/x;
		if(y%x!=0)
			n1++;
		System.out.println(p1+" "+ n1);
		
		
	}



	private static int goNoFlooer(int k1, int m, int k2, int p2, int n2) {
if(k1<=m)
	return 1;

		
		return 0;
	}

	private static void go(int k1, int m, int k2, int p2, int n2) {
		// TODO Auto-generated method stub
		if(m>1){
			System.out.println(0+" "+ 0);
			return;
		}
		System.out.println(0+" "+ 1);	
		
	}

	private static int FindX(int m, int k2, int p2, int n2) {
		int k=m*(p2-1)+n2;
		int x=k2/k;
		if(k2%k!=0)
			x++;
		int nNew=k2-(m*(p2-1))*x;
		nNew/=x;
		if(nNew%x!=0)
			nNew++;
		if(nNew!=n2)
			return -1;
	
		int n_plusrOne=Find_n22MorOne(m,k2,p2,n2,x+1);
		int n_minusOne=Find_n22MorOne(m,k2,p2,n2,x-1);
		if(n2==n_plusrOne|n2==n_minusOne)
			return -10;
		
		
		
		return x;
	}

	private static int Find_n22MorOne(int m, int k2, int p2, int n2, int x) {
		int nNew=k2-(m*(p2-1))*x;
		nNew/=x;
		if(nNew%x!=0)
			nNew++;

		
		return nNew;
	}
}
