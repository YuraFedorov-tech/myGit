import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class O_280 {
	public static void main(String[] args) {
	Scanner y = new Scanner(System.in);
//	BigInteger aa  = BigInteger.valueOf(10);
	BigInteger a=y.nextBigInteger();
	ArrayList<Integer> list = new ArrayList<>();
	list.add(1);
	
	boolean buzy[]=new boolean [1001]; 
	buzy=Do_buzy(buzy,list,a);
buzy[1000]=true;
	list=findList(list,buzy,a);
//	pr(list);
//	System.out.println(list.size());
	ArrayList<Integer> list_new = new ArrayList<>();
	list_new=Find_list_new(list_new,list,a);
//	pr(list_new);
	ArrayList<Integer> list_Stepen = new ArrayList<>();
	list_Stepen=Find_list_Stepen(list_Stepen,list_new,a);
	
	//System.out.println(list_new);
//	System.out.println(list_Stepen);
	ArrayList<Integer> list_Mnogitel = new ArrayList<>();
	 int Mnogitel=Rekursia(list_Stepen);
	
	
//	System.out.println();
	
//	System.out.println(list_Mnogitel);
	System.out.println(Mnogitel);
}

	private static int Rekursia(
			ArrayList<Integer> list_Stepen) {

int t=1;
for(int i=0;i<list_Stepen.size();i++){
	int p=list_Stepen.get(i);
	t*=p;
}
		
		return t;
	}

	private static ArrayList<Integer> Find_list_Stepen(
			ArrayList<Integer> list_Stepen, ArrayList<Integer> list_new,
			BigInteger a) {
for(int i=0;i<list_new.size();i++){
 int stepen=FindStepen(list_new.get(i),a);
 list_Stepen.add(stepen);
}

		return list_Stepen;
	}

	private static int FindStepen(int i, BigInteger a) {
		int x=0;
		while(true){
			boolean g=SimpleDelitel(a,i);
			if(!g)
				break;
				x++;
				a=a.divide( BigInteger.valueOf(i));
			
		}
		return x;
	}

	private static ArrayList<Integer> Find_list_new(
			ArrayList<Integer> list_new, ArrayList<Integer> list, BigInteger a) {
		//list_new.add(1);
for(int i=1;i<list.size();i++){
	boolean g=SimpleDelitel(a,list.get(i));
			if(g)
				list_new.add(list.get(i));

}

		
		return list_new;
	}

	private static boolean[] Do_buzy(boolean[] buzy, ArrayList<Integer> list, BigInteger a) {
		for(int i=2;i<=1000;i++){
			if(buzy[i])
				continue;
	//		boolean g=SimpleDelitel(a,i);
	//		if(g){
			
				buzy=Find_new_Buzy(i,buzy);
	//		}
				
			
		}
		return buzy;
	}

	private static ArrayList<Integer> findList(ArrayList<Integer> list,
			boolean[] buzy, BigInteger a) {
		int end=1000;
		if(a.compareTo(BigInteger.valueOf(1000))==-1)
		end=a.intValue();
		for(int i=2;i<=end;i++){
			if(!buzy[i])
				list.add(i);
		}
		return list;
	}

	private static void pr(ArrayList<Integer> list) {
	for(int i=0;i<list.size();i++){
		System.out.println(list.get(i));
	}
		
	}

	private static boolean[] Find_new_Buzy(int j, boolean[] buzy) {
	for(int i=j*2;i<1000;i=i+j){
		
		buzy[i]=true;
	}
		return buzy;
	}

	private static boolean SimpleDelitel(BigInteger a, int i) {
		BigInteger b= BigInteger.valueOf(0);
b=a.divide( BigInteger.valueOf(i));
BigInteger c= BigInteger.valueOf(0);
	c=b.multiply( BigInteger.valueOf(i));
		if(a.compareTo(c)==0)
	return true;
	
	return false;
	}
}