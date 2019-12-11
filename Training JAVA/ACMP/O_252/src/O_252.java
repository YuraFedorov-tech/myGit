import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class O_252 {
	public static void main(String[] args) {
	int []last={1};
	BigInteger sum = (new BigInteger("1121121121122111112111211111212122112"));
	BigInteger sum2 = (new BigInteger("17179869184"));
	BigInteger sum3 = (new BigInteger("1"));
	sum3 = sum.remainder(sum2);
//	System.out.println(sum3);
//	System.out.println(sum);
	for(int i=0;i<=300;i++){
			int ans[]={-1};
			
			
			
			BigInteger x  = BigInteger.valueOf(2);
			x=x.pow(i);
			String q[]={""};
			while(true){
				rekur(x,"",  last[0], 0, ans,q);
				if(ans[0]!=-1){
					System.out.println(i+"\t"+x+"\t"+q[0]);
					break;
				}
				last[0]++;	
			}
			
		}
	}

	private static void rekur(BigInteger x, String s, int max, int step,
			int[] ans, String[] q) {
		if (step == max){
		
				BigInteger sum = (new BigInteger(s));
				sum = sum.remainder(x);
				if (sum.compareTo(BigInteger.ZERO) == 0) {
				q[0]=s;
					ans[0] = 1;
				}
			return;
		}

		for (int i = 0; i < 2; i++) {
			if (i == 0)
				rekur(x, s + "1", max, step + 1, ans,q);
			if (i == 0)
				rekur(x, s + "2", max, step + 1, ans,q);
			if (ans[0] == 1)
				return;
		}
		
		
		
	}
}