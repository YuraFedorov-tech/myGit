import java.util.Scanner;


public class O_189 {
    public static void main(String[] args) {
    Scanner M = new Scanner(System.in);
    int n = M.nextInt();
    int k = M.nextInt()-1;
     
    B(n,k);
}
 
    private static void B(int n, int k) {
        int[] a=new int[n];
        int f=Fac(n);
        boolean []b=new boolean[n];
        R(0,n,k,f,a,b);
         
        for(int i=0;i<n;i++)
        System.out.print(a[i]+1+" ");
    }
 
    private static void R(int step, int n, int k, int f, int[] a, boolean[] b) {
    if(step==n)
        return;
    int newF=Fac(n-step-1);
    int g=0;
        for(int i=0;i<n;i++){
            if(b[i])
                continue;
            g++;
            int h=k-(newF*(g));
            if(h>=0)
                continue;
            a[step]=i;
            b[i]=true;
            R(step+1,n,k-(g-1)*newF,g,a,b);
        }
     
     
     
    }
 
    private static int Fac(int k) {
     
        int t=1;
    for(int i=1;i<=k;i++)
        t*=i;
        return t;
    }
}