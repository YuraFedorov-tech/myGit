import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_187 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int k =Integer.parseInt(M.nextLine().trim());

		for (int i = 0; i < k; i++) {
			B(M.nextLine());

		}

	}

	private static void B(String s) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(); 
	 FindA(s,list);
	 if(list.get(0)==0){
		 System.out.println("Accepted");
		 return ;
	 }
//	 System.out.println(list);
	 int[][] a=FindAA(list);
//	 System.out.println(Arrays.deepToString(a));
	int [] security=Find_security(a);
	 boolean truTH=FindTruth(security);
	 if(!truTH){
		 System.out.println("Wrong Answer");
		 return;
	 }
	 truTH=FindHaveOnly2(security);
	 if(!truTH){
		 System.out.println("Wrong Answer");
		 return;
	 }
	 
	 
	 truTH=FindDeletANDNOsecuryty(security,a);

	 if(truTH){
		 System.out.println("Accepted");
	 }else
		 System.out.println("Wrong Answer");
	 
	}





	private static boolean FindHaveOnly2(int[] security) {
		for(int i=1;i<10001;i++)
			if(security[i]<2)
				return true;
		return false;
	}

	private static boolean FindDeletANDNOsecuryty(int[] security, int[][] a ) {
		// если правда то удаление охраника приведет к 
		//неохраняему промежктку времени
		// и это приведет к Accetped
	
		for(int i=0;i<a.length;i++ ){
	boolean deletOne=F_deletOne(security,a[i]);
		if(deletOne){
			// ! ne accepted
			return false;
		}
			
		}
		
		
		return true;
	}

	



	private static boolean F_deletOne(int[] security, int[] is) {
		for(int i=is[0];i<=is[1];i++)
			if(security[i]<2)
				return false;
		return true;
	}

	private static boolean FindTruth(int[] security) {
		/// если неправда значит не во все время работают охранника и 
		// надо выписывать ошибку
		for(int i=1;i<10001;i++)
			if(security[i]==0)
				return false;
		
		return true;
	}

	private static int[] Find_security(int[][] a) {
		int [] security=new int[10001];
		int n=a.length;
for(int i=0;i<n;i++){
	security=Find_ONE_security(security,a[i]);
}
		
		return security;
	}

	private static int[] Find_ONE_security(int[] security, int[] is) {
		for(int i=is[0];i<=is[1];i++)
			security[i]++;
		return security;
	}

	private static int[][] FindAA(ArrayList<Integer> list) {
		int n=list.get(0);
int [][]a=new int[n][2];
for(int i=1;i<n*2+1;i+=2){
	a[i/2][0]=list.get(i);
	a[i/2][1]=list.get(i+1);
}
	
		return a;
	}

	private static void FindA(String s, ArrayList<Integer> list) {
		s=Change(s);
		String[] q = s.split(" ");
		for (int i = 0; i < q.length; i++) {
	if(q[i].equals(""))
		continue;
		
		list.add(Integer.parseInt(q[i]));
			

		}
		
	}

	private static String Change(String s) {
	int cur=0;
		while(true){
		int number=FindNumber(cur,s);
		if(number==s.length())
			break;
		String f=s.substring(cur,number);
		String e=s.substring(number+2,s.length());
		s=f+" "+e;
		cur+=number;
	}
		return s;
	}

	private static int FindNumber(int cur, String s) {
		int q=s.length();
		int i=0;
		for(; i<q;i++)
			if(s.charAt(i)=='n')
			return i-1;
		return i;
	}

	

}