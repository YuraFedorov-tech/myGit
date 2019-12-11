import java.math.BigInteger;


public class O_3_2 {
	public static void main(String[] args) {
		int ans[]={0};
		
		for(int i=1;i<=12148 ;i++){
			
			First(0,BigInteger.valueOf(i),ans);
			
			
		}
		System.out.println(ans[0]);
}

	private static void First(int step, BigInteger i, int[] ans) {
	if(step==50){
		ans[0]++;
		return;
	}
		
	BigInteger p=FindPerevorot(i);
	BigInteger x=p.add(i);
		if(yes(x))
			return;
		First(step+1,x,ans);
		
		
	}

	private static boolean yes(BigInteger x) {
		String s = x.toString();
		String g="";
        for(int i=s.length()-1;i>=0;i--)
		g+=""+s.charAt(i);
	if(s.equals(g))
		 return true;
        
        return false;
	}

	private static BigInteger FindPerevorot(BigInteger j) {
		String s = j.toString();
		String g="";
for(int i=s.length()-1;i>=0;i--)
		g+=""+s.charAt(i);
BigInteger an=new BigInteger(g);
		return an;
	}
}