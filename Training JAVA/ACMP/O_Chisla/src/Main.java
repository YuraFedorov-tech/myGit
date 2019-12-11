import java.io.*;
import java.util.*;
 
public class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
 
    int n = in.nextInt();
    long nEnd=0;
for (int i=0; i<n;i++){
	nEnd+= Math.pow(10, i)*9;
}
int nStart=(int) Math.pow(10, n-1);
  if(n==1){
	  nStart=0;  
  }
    

    
    
    
    int Number=0;
    int Answear=0;
 for(int i=nStart; i<=nEnd;i++){
	
	 int u=chek(i,n);
	 if (u==1){
		 if(Number==0){
			 Answear=i;
		 }
		 Number+=1;
	 }
 }
    
 out.println(Number+" "+Answear);
 
    
    
    
    out.flush();
  }

private static int chek(int t, int n) {
	int[]a=new int [n];
	int y=0;
	for(int i=0; i<n;i++){
		a[i]=  (int) ((t-y)/Math.pow(10, n-1-i));
		if(n!=1  & a[i]==0){
			return 0;
		}
		
		y+=a[i]*Math.pow(10, n-1-i);
	 }
	int sum=0;
	int umnog=1;
	for(int i=0; i<n;i++){
		sum+=a[i];
		umnog*=a[i];
	}
	if(sum==umnog){
		return 1 ;
	}
	
	return 0;
}
}