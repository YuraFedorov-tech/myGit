import java.math.BigInteger;


public class Helper {

	public static BigInteger Chet(int n) {
		n/=2;
		BigInteger ans  = BigInteger.valueOf(0);
        ans=RekursChet(0,n,ans);
       return ans;
		
	}

	private static BigInteger RekursChet(int step, int blok, BigInteger ansPrevios) {
if(step==blok)
	return BigInteger.valueOf(1);
int stepen=blok-step;    
BigInteger ans  = BigInteger.valueOf(3);
     ans=ans.pow(stepen);
     
   // 	 ans= ans.add(BigInteger.valueOf(2));
     BigInteger newAans  = BigInteger.valueOf(0); 
     newAans=RekursChet(step+1,blok,ans);
     if(step!=0)
     newAans=newAans.multiply( BigInteger.valueOf(2) );
     ansPrevios=ansPrevios.add(newAans);
		return ansPrevios;
	}

}
