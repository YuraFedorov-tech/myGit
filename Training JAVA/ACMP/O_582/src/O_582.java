import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class O_582 {
	public static void main(String[] args) {
		ArrayList<Integer> one = new ArrayList<>();
		ArrayList<Integer> two = new ArrayList<>();
		ArrayList<Integer> chek = new ArrayList<>();
		chek = Helper_582.DO_Chek(chek);
		one = Input_582.input(one, two);
		int ans[] = { -1 };
		for (int i = 0; i < 6; i++) {
			ArrayList<Integer> oneNew = new ArrayList<>();
			ArrayList<Integer> chekNew = new ArrayList<>();
			oneNew = Helper_582.FindeOneFrom6(i, one, oneNew);
			chekNew = Helper_582.FindeOneFrom6(i, chek, chekNew);
	//		Helper_582.prChekNew(chekNew);

			rekurs(two, oneNew, chekNew, ans);
			
		}
		if (ans[0] == -1)
			System.out.println("NO");
	}

	private static void rekurs(ArrayList<Integer> two, ArrayList<Integer> one,
			ArrayList<Integer> chek, int[] ans) {
		for (int i = 0; i < 4; i++) {
			ArrayList<Integer> oneNew = new ArrayList<>();
			ArrayList<Integer> chekNew = new ArrayList<>();
			oneNew = Helper_582.FindOneFromFour(one, i, oneNew);
			chekNew = Helper_582.FindOneFromFour(chek, i, chekNew);
	//		Helper_582.prChekNew(chekNew);
			if (LikeOrNo(oneNew,two)) {
				System.out.println("YES");
				ans[0] = 1;
			}
		}

	}

	private static boolean LikeOrNo(ArrayList<Integer> oneNew,
			ArrayList<Integer> two) {
		for(int i=0;i<6;i++)
			if(oneNew.get(i)!=two.get(i))
				return false;
		return true;
	}
}