import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class O_210 {
	public static void main(String[] args) {
	Scanner jj = new Scanner(System.in);
	String s = jj.nextLine();
	s=s.trim();
	int n = Integer.parseInt(s); 
	B(n);
	
	
	
}

	private static void B(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		FindSimpleNumber(n,list);
	//	System.out.println(list);
		ArrayList<Integer> mean = new ArrayList<Integer>(); 
		ArrayList<Integer> count = new ArrayList<Integer>();
		Find(mean,count,list,n);
		FindLastNumber(mean,count);
		
	}

	private static void FindLastNumber(ArrayList<Integer> mean,
			ArrayList<Integer> count) {
int max=FindMax(mean);
ArrayList<Integer> newCount = new ArrayList<Integer>();
	Helper.FindNewCount(count,max,newCount,mean);	
		prin(mean,newCount);
	}

	private static void prin(ArrayList<Integer> mean,
			ArrayList<Integer> newCount) {
		ArrayList<Integer> number = new ArrayList<Integer>();
		for(int i=0;i<mean.size();i++){
			int x=mean.get(i);
			int t=(int) Math.pow(x, newCount.get(i));
			number.add(t);
		}
		BigInteger sum  = BigInteger.valueOf(1);
		sum=FindSum(sum,number);
		System.out.println(sum);
	}

	private static BigInteger FindSum(BigInteger sum, ArrayList<Integer> number) {
		for(int i=0;i<number.size();i++)
			sum=sum.multiply(BigInteger.valueOf(number.get(i)));
		

		return sum;
	}

	private static void FindNewCount(ArrayList<Integer> count, int max,
			ArrayList<Integer> newCount) {
		for(int i=0;i<count.size();i++){
			int x=count.get(i);
			int t=	FindT(x,max);
			
			newCount.add(t);
		}
		
	}

	private static int FindT(int x, int max) {
	while(true){
		if(x%2==0 & max%2==0){
			x/=2;
		//	max/=2;
		}
	break;
	}
	while(true){
		if(x%2==3 & max%2==3){
			x/=3;
		//	max/=2;
		}
	break;
	}
	while(true){
		if(x%2==5 & max%2==5){
			x/=5;
			//max/=2;
		}
	break;
	}
		int t=x/max;
		if(x%max!=0)
		t++;
		return t;
	}

	private static int FindMax(ArrayList<Integer> mean) {
	int ans=1;
		for(int i=0;i<mean.size();i++){
			ans*=mean.get(i);
	}
		return ans;
	}

	private static void Find(ArrayList<Integer> mean, ArrayList<Integer> count,
			ArrayList<Integer> list, int n) {
		for(int i=0;i<list.size();i++){
			int x=list.get(i);
			if(n%x!=0)
				continue;
			mean.add(x);
			int c=0;
			while(true){
				if(n%x!=0)
					break;
			n/=x;
			c++;				
			}
			count.add(c);
		}
		mean.add(n);
		count.add(1);
	}

	private static void FindSimpleNumber(int n, ArrayList<Integer> list) {
	
	
		boolean buzy[]=new boolean[100000];
		int e=(int) Math.sqrt(n);
		for(int i=3;i<e;i+=2){
		if(!buzy[i])
			chek(buzy,i,n);
				
		}
		Inside(buzy,list,n);	
		
	}

	private static void Inside(boolean[] buzy, ArrayList<Integer> list, int n) {
		list.add(2);
int e=(int) Math.sqrt(n);
		for(int i=3;i<e;i+=2)
			if(!buzy[i])
				list.add(i);
		
	}

	private static void chek(boolean[] buzy, int j, int n) {
		int e=j*j;
		if(e<0)
			return;
		int f=(int) Math.sqrt(n);
		for(int i=j*2;i<f;i+=j)
			buzy[i]=true;
		
		
	}


}