import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_658_2 { // Main

	public static void main(String[] args) {
		long input1 = System.currentTimeMillis();
		int coordinat2[][] = Input_2.Input();
		long input2 = System.currentTimeMillis();
		// System.out.print(input2-input1+"\t");
		int coordinat[][] = new int[2][coordinat2[0].length];
		coordinat = Helper_2.ChangeCoordinat(coordinat, coordinat2);
		coordinat2 = null;
		coordinat = Helper_2.Sort(coordinat);
		int time[]=new int[5];
		int ans[] = new int[1];
		boolean[] buzy = new boolean[coordinat[0].length];

		ArrayList<Integer> list = new ArrayList<>();
		int[][] trangle = new int[2][3];
		long input3 = System.currentTimeMillis();
		// System.out.print(input3-input2+"\t");
		ans = FindFirstPoint(ans, buzy, coordinat, list, trangle,time);
		long input4 = System.currentTimeMillis();
		System.out.println(input4 - input3 + "\t");
		System.out.println(ans[0]);
		System.out.println("       tim[0]=  "+time[0]+"       tim[1]=  "+time[1]+"       tim[2]=  "+time[2]+"    "
				+ "   tim[3]=  "+time[3]+"       tim[4]=  "+time[4]);

	}

	private static int[] FindFirstPoint(int[] ans, boolean[] buzy,
			int[][] coordinat, ArrayList<Integer> list, int[][] trangle, int[] time) {
		for (int i = 0; i < coordinat[0].length - 2; i++) {
			 list.add(i);
			buzy[i] = true;
			trangle[0][0] = coordinat[0][i];
			trangle[1][0] = coordinat[1][i];
			
			// ans=FindSecondPoint(ans,buzy,coordinat,i,list,trangle);
			ans = FindSecondPoint(ans, buzy, coordinat, i, trangle,list,time);
		
			buzy[i] = false;
			 list.remove(list.size()-1);
		}
		return ans;
	}

	// private static int[] FindSecondPoint(int[] ans, boolean[] buzy, int[][]
	// coordinat, int previos, ArrayList<Integer> list, int[][] trangle) {
	private static int[] FindSecondPoint(int[] ans, boolean[] buzy,
			int[][] coordinat, int previos, int[][] trangle, ArrayList<Integer> list, int[] time) {
		
		for (int i = previos + 1; i < coordinat[0].length - 1; i++) {
	
			list.add(i);
			buzy[i] = true;
			trangle[0][1] = coordinat[0][i];
			trangle[1][1] = coordinat[1][i];
			// ans=FindTherdPoint(ans,buzy,coordinat,i,list,trangle);
			ans=FindTherdPoint(ans,buzy,coordinat,i,trangle,previos,list,time);
			buzy[i] = false;
			list.remove(list.size()-1);
		}
		
		

		return ans;
	}
	//private static int[] FindTherdPoint(int[] ans, boolean[] buzy,	int[][] coordinat, int previos, ArrayList<Integer> list,int[][] trangle) {
	private static int[] FindTherdPoint(int[] ans, boolean[] buzy,	int[][] coordinat,
			int previos, int[][] trangle, int first, ArrayList<Integer> list, int[] time) {
		long input3 = 0;
		long input4=0;
		for (int i = previos + 1; i < coordinat[0].length; i++) {

			list.add(i);
			buzy[i] = true;
			trangle[0][2] = coordinat[0][i];
			trangle[1][2] = coordinat[1][i];
			// если правда то тругольник хороший и в нем деревьев нет
			boolean Googtriangle_orNo=false;
	if(i-list.get(0)>100){
		/*				if(i-list.get(0)==240)
					 input3 = System.currentTimeMillis();*/
			 Googtriangle_orNo = Work_658_2.FIND_Googtriangle_orNo(
					trangle[0][0], trangle[1][0], trangle[0][1], trangle[1][1],
					trangle[0][2], trangle[1][2], coordinat, buzy,list,time);
	/*		 if(i-list.get(0)==240){
				 input4 = System.currentTimeMillis();
				 System.out.println(i-list.get(0)+"\t"+(input4-input3)+"\t"+list);
				}*/
			}else{
			//	if(i-list.get(0)==149)
					 input3 = System.currentTimeMillis();
				 Googtriangle_orNo = Work_ForNewDone.FIND_Googtriangle_orNo(
						 trangle[0][0], trangle[1][0], trangle[0][1], trangle[1][1],
							trangle[0][2], trangle[1][2], coordinat, buzy,first);
		//		 if(i-list.get(0)==149){
						 input4 = System.currentTimeMillis();
				//		 System.out.println(i-list.get(0)+"\t"+(input4-input3));
				//	}
							time[2]+=input4-input3;
			}
			// System.out.print(list +"\t");
			if (Googtriangle_orNo) {
				ans[0] += 1;

			}
	//
	//		System.out.print(list+"\t");
	//		 System.out.println(+ans[0]);
			buzy[i] = false;
	//	 System.out.println();
		list.remove(list.size() - 1);

		}
		
		return ans;
	}

}
