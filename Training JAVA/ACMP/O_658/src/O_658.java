import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_658 { // Main

	public static void main(String[] args) {
		long input1 = System.currentTimeMillis();
		int coordinat2[][] = Input.Input();
		long input2 = System.currentTimeMillis();
		// System.out.print(input2-input1+"\t");
		int coordinat[][] = new int[coordinat2.length][2];
		coordinat = Helper.ChangeCoordinat(coordinat, coordinat2);
		coordinat2 = null;
		coordinat = Helper.Sort(coordinat);
		int ans[] = new int[1];
		boolean[] buzy = new boolean[coordinat.length];

		ArrayList<Integer> list = new ArrayList<>();
		int[][] trangle = new int[3][2];
		long input3 = System.currentTimeMillis();
		// System.out.print(input3-input2+"\t");
		ans = FindFirstPoint(ans, buzy, coordinat, list, trangle);
		long input4 = System.currentTimeMillis();
		System.out.println(input4 - input3 + "\t");
		System.out.println(ans[0]);

	}

	private static int[] FindFirstPoint(int[] ans, boolean[] buzy,
			int[][] coordinat, ArrayList<Integer> list, int[][] trangle) {
		for (int i = 0; i < coordinat.length - 2; i++) {
			// list.add(i);
			buzy[i] = true;
			trangle[0][0] = coordinat[i][0];
			trangle[0][1] = coordinat[i][1];
			// ans=FindSecondPoint(ans,buzy,coordinat,i,list,trangle);
			ans = FindSecondPoint(ans, buzy, coordinat, i, trangle);
			buzy[i] = false;
			// list.remove(list.size()-1);
		}
		return ans;
	}

	// private static int[] FindSecondPoint(int[] ans, boolean[] buzy, int[][]
	// coordinat, int previos, ArrayList<Integer> list, int[][] trangle) {
	private static int[] FindSecondPoint(int[] ans, boolean[] buzy,
			int[][] coordinat, int previos, int[][] trangle) {
		for (int i = previos + 1; i < coordinat.length - 1; i++) {
			// list.add(i);
			buzy[i] = true;
			trangle[1][0] = coordinat[i][0];
			trangle[1][1] = coordinat[i][1];
			// ans=FindTherdPoint(ans,buzy,coordinat,i,list,trangle);
			ans=FindTherdPoint(ans,buzy,coordinat,i,trangle,previos);
			buzy[i] = false;
			// list.remove(list.size()-1);
		}

		return ans;
	}
	//private static int[] FindTherdPoint(int[] ans, boolean[] buzy,	int[][] coordinat, int previos, ArrayList<Integer> list,int[][] trangle) {
	private static int[] FindTherdPoint(int[] ans, boolean[] buzy,	int[][] coordinat,
			int previos, int[][] trangle, int first) {
		long input3 = 0;
		long input4=0;
		for (int i = previos+1; i < coordinat.length; i++) {

			//list.add(i);
			buzy[i] = true;
			trangle[2][0] = coordinat[i][0];
			trangle[2][1] = coordinat[i][1];
			// если правда то тругольник хороший и в нем деревьев нет
		/*	if(i-first==240)
				 input3 = System.currentTimeMillis();*/
			boolean Googtriangle_orNo = Work_658.FIND_Googtriangle_orNo(
					trangle[0][0], trangle[0][1], trangle[1][0], trangle[1][1],
					trangle[2][0], trangle[2][1], coordinat, buzy,first);
			
	/*		 if(i-first==240){
				 input4 = System.currentTimeMillis();
				 System.out.println(i-first+"\t"+(input4-input3)+"\t");
				}*/
			
			// System.out.print(list +"\t");
			if (Googtriangle_orNo) {
				ans[0] += 1;

			}
			// System.out.println(+ans[0]);
			buzy[i] = false;
//		 System.out.println();
	//		list.remove(list.size() - 1);

		}
		return ans;
	}

}
