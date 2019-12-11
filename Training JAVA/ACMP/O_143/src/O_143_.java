import java.util.ArrayList;
import java.util.Scanner;





public class O_143_ {  //Main

	public static void main(String[] args) {
		Scanner my= new Scanner (System.in);
		String aa=my.nextLine();
		String bb=my.nextLine();
		aa=aa.trim();
		bb=bb.trim();
		
		 ArrayList<Integer> a = new ArrayList<Integer>();
		 ArrayList<Integer> b = new ArrayList<Integer>();
		 ArrayList<Integer> ans = new ArrayList<Integer>();
		a=do_List(a,aa);
		b=do_List(b,bb);
		boolean []aaa=new boolean [1];
		boolean A_More_than_B=A_More_than_B__(a,b,aaa);
int a_Better=1;
if(!A_More_than_B)
	a_Better=-1;
if(!aaa[0]){
	
			ans=Find_Ans(a,b,ans,A_More_than_B);	
		//	System.out.println(ans);
			ans=prprin(ans,a_Better);
}else{
	System.out.println(0);
}
//System.out.println(A_More_than_B);	
		
		
	}

	private static ArrayList<Integer> prprin(ArrayList<Integer> ans,
			int a_Better) {

		while(true){
			if(ans.get(ans.size()-1)==0){
				ans.remove(ans.size()-1);
				continue;
			}
		break;		
		}
		int n=ans.get(ans.size()-1);
		n*=a_Better;
		ans.set(ans.size()-1, n);
		
		for(int i=ans.size()-1;i>-1;i--){
			System.out.print(ans.get(i));
		}
	//	System.out.println();
	//	System.out.println("ALL");
		return ans;
	}

	private static ArrayList<Integer> Find_Ans(ArrayList<Integer> a,
			ArrayList<Integer> b, ArrayList<Integer> ans, boolean a_More_than_B) {
if(a_More_than_B)
	ans=Finding_Ans(a,b,ans);
if(!a_More_than_B)
	ans=Finding_Ans(b,a,ans);
		
		return ans;
	}

	private static ArrayList<Integer> Finding_Ans(ArrayList<Integer> a,
			ArrayList<Integer> b, ArrayList<Integer> ans) {
int max=b.size();
if(a.size()==b.size())
	max-=1;
int pred=0;
for(int i=0;i<a.size();i++){
	int qurent=a.get(i)-pred;
	if(i<b.size())
		qurent-=b.get(i);
	pred=0;
	if(qurent<0){
		pred=1;
		qurent+=10;
	}
ans.add(qurent);
}

		
		return ans;
	}

	private static boolean A_More_than_B__(ArrayList<Integer> a,
			ArrayList<Integer> b, boolean[] aaa) {
if(a.size()>b.size())
	return true;

if(a.size()<b.size())
	return false;
for(int i=a.size()-1;i>-1;i--){
	if(a.get(i)>b.get(i))
		return true;
	if(a.get(i)<b.get(i))
		return false;
}
aaa[0]=true;

		return false;
	}

	private static ArrayList<Integer> do_List(ArrayList<Integer> a, String aa) {
for(int i=aa.length()-1;i>=0;i--){
	char ch=aa.charAt(i);
	a.add(ch-'0');
}

		
		return a;
	}

}
