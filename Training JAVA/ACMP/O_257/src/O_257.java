import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class O_257 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int a = my.nextInt();
		int b = my.nextInt();
		int c = my.nextInt();
		int d = my.nextInt();
		
		if (a == 0 & b == 0 & c == 0) {
			System.out.println(-1);
		}

		else {
int numberOfAnswear=0;
long timestart1=System.currentTimeMillis() ;
//for(int i =-20000;i<20000;i++){
list=FindList(list,a,b,c,d);
printList(list);

long timestart2=System.currentTimeMillis() ;		
			
System.out.println(timestart2-timestart1);	
		
		}
	}

	private static void printList(ArrayList<Integer> list) {
		System.out.print(list.size()+" ");
		for(int i=0;i<list.size();i++)
		System.out.print(list.get(i)+" ");
	}

	private static ArrayList<Integer> FindList(ArrayList<Integer> list, int a, int b, int c, int d) {
		for(int i =-200000;i<200000;i++){
	//	for(int i =Integer.MIN_VALUE;i<Integer.MAX_VALUE;i++){
			  BigInteger []Big1 = new BigInteger[4] ;
			  Big1=ToNull(Big1,a,b,c,d);
			  BigInteger BigSumma =BigInteger.valueOf(0);	 ;
			  BigSumma=Find_BigSumma(Big1,i,BigSumma);
		if(BigSumma==BigInteger.ZERO)
			list.add(i);
		}
		return list;
	}

	private static BigInteger Find_BigSumma(BigInteger[] big1, int i, BigInteger bigSumma) {
		  BigInteger []BigIII = new BigInteger[4] ;
		  BigIII[0]=BigInteger.valueOf(1);			
		  BigIII[1]=BigInteger.valueOf(1);			
		  BigIII[2]=BigInteger.valueOf(1);
		  BigIII[3]=BigInteger.valueOf(i);
		
		  BigIII[0]=Umnogit(BigIII[0],  BigIII[3],3) ;
		  BigIII[1]=Umnogit(BigIII[1],  BigIII[3],2) ;
		  BigIII[2]=Umnogit(BigIII[2],  BigIII[3],1) ;
		  bigSumma=Find_bigSumma(big1,bigSumma,BigIII);
		  
		  
		return bigSumma;
	}

	private static BigInteger Find_bigSumma(BigInteger[] big1, BigInteger bigSumma, BigInteger[] bigIII) {
		for(int i=0;i<3;i++)
			big1[i]=big1[i].multiply(bigIII[i]);
		
		for(int i=0;i<4;i++)
			bigSumma=bigSumma.add(big1[i]);
		return bigSumma;
	}

	private static BigInteger Umnogit(BigInteger bigInteger,
			BigInteger bigInIII, int i) {
	for(int j=0;j<i;j++){
		bigInteger=bigInteger.multiply(bigInIII);
		
	}
		return bigInteger;
	}

	private static BigInteger[] ToNull(BigInteger[] big1, int a, int b, int c, int d ) {
//for(int i=0;i<3;i++)
//	big1[i]=BigInteger.valueOf(0);
		big1[0]=BigInteger.valueOf(a);			
		big1[1]=BigInteger.valueOf(b);			
		big1[2]=BigInteger.valueOf(c);			
big1[3]=BigInteger.valueOf(d);	
		return big1;
	}
}