import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
 
public class O_348 {
    public static void main(String[] args) {
        Scanner M = new Scanner(System.in);
 
        int x1 = M.nextInt();
        int y1 = M.nextInt();
        int x2 = M.nextInt();
        int y2 = M.nextInt();
 
        int x3 = M.nextInt();
        int y3 = M.nextInt();
        int x4 = M.nextInt();
        int y4 = M.nextInt();
        BB(x1, y1, x2, y2, x3, y3, x4, y4);
    }
 
    private static void BB(int x1, int y1, int x2, int y2, int x3, int y3,
            int x4, int y4) {
        int aX=x2-x1;
        int aY=y2-y1;
         
        int m1x=x3-x1;
        int m1y=y3-y1;
         
        int m2x=x4-x1;
        int m2y=y4-y1;
         
        B(x1, y1, x2, y2, x3, y3, x4, y4,aX,aY,m1x,m1y,m2x,m2y);
         
    }
 
    private static void B(int x1, int y1, int x2, int y2, int x3, int y3,
            int x4, int y4, int aX, int aY, int m1x, int m1y, int m2x, int m2y) {
 
 
        double sin1=FindSin(aX,aY,m1x,m1y);
        double sin2=FindSin(aX,aY,m2x,m2y);
        if(ChekZeroSinus(sin1)&ChekZeroSinus(sin2)){
    if(x1!=x2){
            ChekZera(x1,x2,x3,x4);
    }else
        ChekZera(y1,y2,y3,y4);
            return;
        }
     
        double max=Math.max(sin1, sin2);
        double min=Math.min(sin1, sin2);
        if(max>=0 &min<=0){
            ChekTwo(x1, y1, x2, y2, x3, y3, x4, y4);
        } else
            System.out.print("No");
         
 
         
    }
 
    private static void ChekTwo(int x1, int y1, int x2, int y2, int x3, int y3,
            int x4, int y4) {
        int aX=x4-x3;
        int aY=y4-y3;
         
        int m1x=x1-x3;
        int m1y=y1-y3;
         
        int m2x=x2-x3;
        int m2y=y2-y3;
        double sin1=FindSin(aX,aY,m1x,m1y);
        double sin2=FindSin(aX,aY,m2x,m2y);
        double max=Math.max(sin1, sin2);
        double min=Math.min(sin1, sin2);
        if(max>=0 &min<=0){
            System.out.print("Yes");
        } else
            System.out.print("No");
         
    }
 
    private static void ChekZera(int x1, int x2, int x3, int x4) {
     
        boolean f=FindF(x1,x2,x3,x4);
        if(!f)
        f=  FindF(x3,x4,x1,x2);
        if(f){
         
            System.out.print("Yes");
        } else
            System.out.print("No");
         
             
         
             
    }
 
    private static boolean FindF(int x1, int x2,int x3, int x4) {
        int min=Math.min(x3,x4);
        int max=Math.max(x3,x4);
        if((x1>=min&x1<=max)|(x2>=min&x2<=max)){
            return true;
        } 
        return false;
    }
 
    private static boolean ChekZeroSinus(double sin1) {
        sin1*=100000;
        sin1=   Math.floor(sin1) ;
String s=Double.toString(sin1);
String u="";
for(int i=0;i<s.length();i++){
    if(s.charAt(i)!='.'){
        u+=""+s.charAt(i);
    }else
        break;
}
 
 
BigInteger  w=new BigInteger (u);
if(w.compareTo(BigInteger.ZERO)==0)
    return true;
 
 
        return false;
    }
 
    private static double FindSin(double aX, double aY, double m1x, double m1y) {
        double ans=aX*m1y-m1x*aY;
 
         
         
        return ans;
    }
 
 
}