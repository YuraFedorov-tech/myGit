import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class O_171 {
	public static void main(String[] args) {
	Scanner y = new Scanner(System.in);

	BigInteger a=y.nextBigInteger();
	ArrayList<Integer> l = new ArrayList<>();
	l.add(1);
	
	boolean b[]=new boolean [1001]; 
	b=D(b,a);
b[1000]=true;
	l=F(l,b,a);

	ArrayList<Integer> z = new ArrayList<>();
	z=T(z,l,a);

	ArrayList<Integer> list_Stepen = new ArrayList<>();
	list_Stepen=Find_list_Stepen(list_Stepen,z,a);
	

	 int M=R(list_Stepen);
	

	System.out.println(M);
}

	private static int R(
			ArrayList<Integer> l) {

int t=1;
for(int i=0;i<l.size();i++){
	int p=l.get(i);
	t*=p;
}
		
		return t;
	}

	private static ArrayList<Integer> Find_list_Stepen(
			ArrayList<Integer> list_Stepen, ArrayList<Integer> list_new,
			BigInteger a) {
for(int i=0;i<list_new.size();i++){
 int stepen=V(list_new.get(i),a);
 list_Stepen.add(stepen);
}

		return list_Stepen;
	}

	private static int V(int i, BigInteger a) {
		int x=0;
		while(true){
			boolean g=S(a,i);
			if(!g)
				break;
				x++;
				a=a.divide( BigInteger.valueOf(i));
			
		}
		return x;
	}

	private static ArrayList<Integer> T(
			ArrayList<Integer> l, ArrayList<Integer> p, BigInteger a) {
		//list_new.add(1);
for(int i=1;i<p.size();i++){
	boolean g=S(a,p.get(i));
			if(g)
				l.add(p.get(i));

}

		
		return l;
	}

	private static boolean[] D(boolean[] b,  BigInteger a) {
		for(int i=2;i<=1000;i++){
			if(b[i])
				continue;

			
				b=Q(i,b);
	
				
			
		}
		return b;
	}

	private static ArrayList<Integer> F(ArrayList<Integer> l,
			boolean[] b, BigInteger a) {
		int e=1000;
		if(a.compareTo(BigInteger.valueOf(1000))==-1)
		e=a.intValue();
		for(int i=2;i<=e;i++){
			if(!b[i])
				l.add(i);
		}
		return l;
	}


		
	

	private static boolean[] Q(int j, boolean[] b) {
	for(int i=j*2;i<1000;i=i+j){
		
		b[i]=true;
	}
		return b;
	}

	private static boolean S(BigInteger a, int i) {
	
		if(a.compareTo(a.divide( BigInteger.valueOf(i)).multiply( BigInteger.valueOf(i)))==0)
	return true;
	
	return false;
	}
}