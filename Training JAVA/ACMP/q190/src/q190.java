import java.util.Scanner;
  
  
public class q190 {
    public static void main(String[] args) {
    Scanner M = new Scanner(System.in);
    int n = M.nextInt();
    int k = M.nextInt();
     int a[]=new int[k];
     for(int i=0;i<k;i++)
         a[i]=M.nextInt()-1;
    B(n,k,a);
}
  
    private static void B(int n, int k, int[] a) {
 
      
        boolean []b=new boolean[n];
      int ans=  R(0,n,0,a,b, k);
          
    
        System.out.print(ans+1);
    }
  
    private static int R(int step, int n, int ans,  int[] a, boolean[] b, int k) {
    if(step==k)
        return ans;
    
  
    int newF=FinnnewF(n-step,k-step);
   
     
    int g=0;
    for(int i=0;i<n;i++){
        if(b[i])
            continue;
     
        if(i==a[step])
            break;
        g++;
         
    }
     
    b[a[step]]=true;
            
            int h=(g)*newF;
      
        ans=    R(step+1,n,ans+h,a,b,k);
        
        return ans;
         
      
      
      
    }
  
    private static int FinnnewF(int n, int m) {
         
        return (Fac(n)/Fac(n-m))/n;
    }
 
    private static int Fac(int step ) {
      
      int t=1;
    for(int i=1;i<=step;i++)
        t*=i;
        return t;
    }
}