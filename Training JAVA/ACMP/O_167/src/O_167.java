import java.util.Scanner;

public class O_167 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		int []summa=new int[20];
			summa = Kolichestvo(summa, n,0);

		for(int i=summa[0];i>0;i--){
			
			System.out.print(summa[i]);
		}

	}

	private static int [] Kolichestvo(int [] summa, int n, int step) {
while(true){
	step++;
		if (step== n+1)
			break;
		// int up=0;
		long up = Count_up(n, step);
		long down = Count_down(n, step);
		summa=Dlin_Arifm(summa,up,down);
		
//	summa = Kolichestvo(summa , n, step);
		
}
return summa;
	
	}

	private static int[] Dlin_Arifm(int[] summa, long up, long down) {
		summa=Dlin_Arifm_2_Number(summa,up);
		summa=Dlin_Arifm_2_Number(summa,down);
		
		return summa;
	}

	private static int[] Dlin_Arifm_2_Number(int[] summa, long up) {
		if(up==0)
			return summa;
			
String string=Long.toString(up);
int n=string.length()>=summa[0]?string.length():summa[0];
int  length=string.length();
summa[0]=n;
int next=0;

for(int i=1;i<n+3;i++){
	
	int r=i>length?0:string.charAt(length-i)-'0';
	int f=summa[i]+r;
	if (f>9){
		summa[i+1]+=1;
		summa[i]=f-10;continue;
	}
	
	summa[i]=f;
	if(summa[summa[0]+1]!=0)	
		summa[0]++;
}



		
		return summa;
	}

	private static long Count_down(int n, int step) {

		if (step < 4)
			return step - 1;
		int summa_All = step - 1;
		boolean chet = false;
		if (summa_All % 2 == 0)
			chet = true;
		;
		long Ans = 0;
		if (!chet) {
			Ans = Find_NE_chet(summa_All, n, step);
		} else {
			Ans = Find_chet(summa_All, n, step);
		}

		// int each=(n-step+1);

		return Ans;
	}

	private static long Find_chet(int summa_All, int n, int step) {
		long Answear ;
		long down = ((step + 1) / 2) ;
		down=step-down;
		Answear=(down+1)*down;

		
		/*
		int Answear = 0;
		int down = ((step + 1) / 2) - 1;
		while (true) {
			if (summa_All == 2)
				break;
			summa_All -= 2;
			Answear += (down) * 2;
			down--;
		}
*/
		return Answear;
	}

	private static long Find_NE_chet(int summa_All, int n, int step) {
		long down = (step) / 2;
		
		long Answear = down;
		down--;
		Answear+=(down+1)*down;

		/*
		summa_All -= 1;

		int down = (step) / 2;
		int Answear = down;
		while (true) {
			down--;
			if (summa_All == 2)
				break;
			summa_All -= 2;
			Answear += (down) * 2;

		}
*/
		return Answear ;
	}

	private static long Count_up(int n, int step) {
		long each = (n - step + 1);
		return each * step;
	}

}
