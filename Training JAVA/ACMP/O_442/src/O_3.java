
public class O_3 {
	public static void main(String[] args) {
		int ans[]={0};
		
		for(int i=47;i<470;i++){
			
			First(0,i,ans);
			
			
		}
		System.out.println(ans[0]);
}

	private static void First(int step, int i, int[] ans) {
	if(step==1){
		ans[0]++;
		return;
	}
		
		int p=FindPerevorot(i);
		int x=p+i;
		if(yes(x))
			return;
		First(step+1,x,ans);
		
		
	}

	private static boolean yes(int x) {
		String s = Integer.toString(x);
		String g="";
        for(int i=s.length()-1;i>=0;i--)
		g+=""+s.charAt(i);
	if(s.equals(g))
		 return true;
        
        return false;
	}

	private static int FindPerevorot(int j) {
		String s = Integer.toString(j);
		String g="";
for(int i=s.length()-1;i>=0;i--)
		g+=""+s.charAt(i);
int an=Integer.parseInt(g);
		return an;
	}
}