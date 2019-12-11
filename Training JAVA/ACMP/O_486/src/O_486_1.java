import java.util.Scanner;


public class O_486_1 { //Main

	public static void main(String[] args) {
Scanner my= new Scanner (System.in);
int n=my.nextInt();
int k=my.nextInt();
long ans=0;
boolean []back={false};
boolean[] find={false};
ans=Finf_Number(0,0,n,k,back,find,0);
System.out.print(ans);

	}

	private static long Finf_Number(int step,  long x , int n, int k, boolean []back, boolean[] find, int first) {

	if(step==n){
		find[0]=true;
	return x;
	
	}
	

	while(true){
	if(step==0){
	x=x+1;
	back[0]=false;
	if(n>8 &first==0){
		x=(long) (Math.pow(n-1, n-1)-500);
		first=1;	
	}
	}
boolean last=false;
if(step==n-1)
	 last=true;
		long t=In_Pow(x,n,k,last,back);
	if(back[0] & step!=0)
		return x;
	if(back[0] & step==0)
		continue;
	long standart =x;
	
		x=Finf_Number(step+1,t,n,k,back,find,first);
	
		if(step!=0 &( back[0]==true |find[0]==true))
			return x;
		if(step==0 & find[0]==true)
			break;
		if(step==0 & back[0]==true)
		x=standart;
	
		/*
		if(step==0){
			System.out.println(x);	
		}
	*/

	}
		return x;
	}

	private static long In_Pow(long x, int n, int k, boolean last, boolean[] back) {
x=x*n + k;
if(!last)
if(x%(n-1) !=0   ){
	back[0]=true;
	
	
}
	
	
if(!last)
x/=n-1;

		return x;
	}

}
