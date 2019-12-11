import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class O_335 {
	private static void chek(boolean[] buzy, int j, int n) {
		int e=j*j;
		if(e<0)
			return;
		int f=(int) Math.sqrt(n);
		f=1000;
		for(int i=j*2;i<f;i+=j)
			buzy[i]=true;
		
		
	}
	private static void FindSimpleNumber(int n, ArrayList<Integer> list) {
		
		
		boolean buzy[]=new boolean[100000];
		int e=1000;
		for(int i=3;i<e;i+=2){
		if(!buzy[i])
			chek(buzy,i,n);
				
		}
		Inside(buzy,list,1000);	
		
	}
	private static void Inside(boolean[] buzy, ArrayList<Integer> list, int n) {
		list.add(2);
int e=n;
		for(int i=1;i<e;i+=2)
			if(!buzy[i])
				list.add(i);
		
	}
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		FindSimpleNumber(1000,list);
		int h=143;
			while(list.get(0)<100){
				list.remove(0);
			}
				
			int a[]=new int[h];
		for(int i=0;i<h;i++){
			a[i]=list.get(i);
		//	System.out.println(a[i]);
		}
		B(a,n,h);
		
}
	private static void B(int[] a, int n, int h) {
		int twoNumberLast[]=new int[h];
		find_twoNumber(twoNumberLast,a,h);
	
		int twoNumberFirst[]=new int[h];
		find_twoNumberFirst(twoNumberFirst,a,h);
	/*	for(int i=0;i<143;i++){			
			System.out.println(a[i]+"\t"+twoNumberLast[i]+"\t"+twoNumberFirst[i]);
		}*/
		int [][]aFull=new int[144][9];
		Find_aFull(aFull,twoNumberFirst,twoNumberLast);
//		for(int i=0;i<143;i++){	
		//	System.out.print(a[i]+"\t");
	//		for(int j=0;j<=aFull[i][0];j++)
			//	System.out.print(aFull[i][j]+"\t");
		//	System.out.println();
	//	}
		Work(aFull,n,144,a);
		
		
	}
	private static void Work(int[][] aFull, int n, int m, int[] a) {
		BigInteger  []chet=new BigInteger [m];
	Fiil(chet,1);
		BigInteger  []nechet=new BigInteger [m];
		for(int i=3;i<n;i++){
			if(i%2==1){
				GO(chet,nechet,aFull,a);
			}else
				GO(nechet,chet,aFull,a);
		}
		
	if(n%2==1){
		prin(chet);
	}else
		prin(nechet);
	}

	private static void prin(BigInteger[] chet) {
		BigInteger sum  = BigInteger.valueOf(0);
		BigInteger k  =new BigInteger("1000000009");
		for(int i=0;i<143;i++)
			sum=sum.add(chet[i]);
		sum=sum.mod(k);
		System.out.println(sum);
		
	}
	private static void GO(BigInteger[] chet, BigInteger[] nechet, int[][] aFull, int[] a) {
		Fiil(nechet,0);
		for(int i=0;i<143;i++){
	if(aFull[i][0]==0)
		continue;
//	System.out.print(a[i]+);
	for(int j=1;j<=aFull[i][0];j++){
		int z=aFull[i][j];
		nechet[aFull[i][j]]=nechet[aFull[i][j]].add(chet[i]);
		//System.out.print(a[i]+""+(a[z]-(a[z]/10)*10)+"\t");
	}
//	System.out.println();	
		
		
		}

		
	}
	private static void Fiil(BigInteger[] chet, int j) {
		for(int i=0;i<143;i++)
			chet[i]=BigInteger.valueOf(j);
		
	}
	private static void Find_aFull(int[][] aFull, int[] twoNumberFirst,
			int[] twoNumberLast) {
		for(int i=0;i<143;i++){
			FindAfullOne(aFull[i],twoNumberLast[i],twoNumberFirst,i);
		}
		
	}
	private static void FindAfullOne(int[] aFull, int j, int[] twoNumberFirst, int iLast) {
		for(int i=0;i<143;i++){
			if(i==iLast)
				continue;
			if(j==twoNumberFirst[i]){
				aFull[0]++;
				aFull[aFull[0]]=i;
			}
		}
		
	}
	private static void find_twoNumberFirst(int[] twoNumberFirst, int[] a, int j) {
		for(int i=0;i<143;i++){
			twoNumberFirst[i]=(a[i]/10);
			if((twoNumberFirst[i]/10)*10==twoNumberFirst[i])
				twoNumberFirst[i]=-1;
		}
		
	}
	private static void find_twoNumber(int[] twoNumber, int[] a, int j) {
		for(int i=0;i<143;i++){
			twoNumber[i]=a[i]-(a[i]/100)*100;
			if(twoNumber[i]<11)
				twoNumber[i]=0;
		}
		
	}
	
}