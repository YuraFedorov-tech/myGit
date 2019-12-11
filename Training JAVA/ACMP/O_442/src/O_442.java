import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class O_442 {
	public static void main(String[] args) {


int[] ans={-1};
for(int i=1  ;i<Integer.MAX_VALUE;i++){
	
	if(i%10000==0)
		System.out.println(i);
	     int x22=i*2;
	     int x44=i*4;
	b(i,x22,x44,ans);
	if(ans[0]==1)
		break;
	
	
	
}
		
		
		
	}

	private static void b(int i, int x22, int x44, int[] ans) {
if(Integer.toString(i).length()!=Integer.toString(x44).length())
	return;
if(Integer.toString(i).length()!=Integer.toString(x22).length())
	return;
	        int y[]=find(i);
			int x2[]=find(i*2);
			int x4[]=find(i*4);
			if(Arrays.equals(y, x2)){
				if(Arrays.equals(y, x4)){
					System.out.println(i);
					ans[0]=1;
					return;
				}
			}
		
	}

	private static  int[] find( int j) {
		String str = Integer.toString(j);
		int e=str.length();
		int y[]=new int [10];
for(int i=0;i<e;i++)
	y[Integer.parseInt(""+str.charAt(i))]++;

return y;

		
	}	
}