import java.util.ArrayList;


public class pr {

	public static ArrayList<Integer> prin(ArrayList<Integer> ans, int a_Better) {


	
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

}
