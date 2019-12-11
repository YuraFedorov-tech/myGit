import java.util.ArrayList;
import java.util.Scanner;

public class O_350 {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		String world = myScanner.nextLine();

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> listWork = new ArrayList<Integer>();
		ArrayList<Integer> buzy = new ArrayList<Integer>();
		 list=FindList(world,list);
	

	//q	System.out.println();
		int ans[] = new int[1];
		int max = list.size();
		ans = rekursia(0, list, listWork, buzy, ans, max);
	//	System.out.println(ans[0]);
		
		
		
	}

	private static ArrayList<Integer> FindListInt(ArrayList<Integer> list,
			int world) {
		for (int i = 1; i <= world; i++)
			list.add(i);
		return list;
	}

	private static int[] rekursia(int step, ArrayList<String> list,
			ArrayList<Integer> listWork, ArrayList<Integer> buzy, int[] ans,
			int max) {
		
		if (step++ == max){
			printlistWork(listWork,list);
		//	ans[0]+=1;
			return ans;
		}
		
	//	ArrayList<Integer> buzyThis = new ArrayList<Integer>();
	//	buzyThis.addAll(buzy);
	//	ArrayList<Integer> listWorkThis = new ArrayList<Integer>();
	//	listWorkThis.addAll(listWork);

		for (int i = 0; i < max; i++) {
			boolean yes = FindBoolean(i, listWork);
			if (yes)
				continue;
			listWork.add(i);
			ans =rekursia(step,list, listWork, buzy, ans, max);
			listWork.remove(listWork.size()-1);	
			
			
		}

		return ans;
	}

	private static void printlistWork(ArrayList<Integer> listWork, ArrayList<String> list) {
	for(int i=0;i<listWork.size();i++)
	    System.out.print(list.get(listWork.get(i)));
	System.out.println();
		
	}

	private static boolean FindBoolean(int number, ArrayList<Integer> listWork) {
		for (int i = 0; i < listWork.size(); i++)
			if (number == listWork.get(i))
				return true;
		return false;
	}

	private static ArrayList<String> FindList(String world,
			ArrayList<String> list) {
		for (int i = 0; i < world.length(); i++)
			list.add("" + world.charAt(i));

		return list;
	}

}
