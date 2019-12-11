import java.util.ArrayList;

public class Helper {

	public static void FindNewCount(ArrayList<Integer> count, int max,
			ArrayList<Integer> newCount, ArrayList<Integer> mean) {
		ArrayList<Integer> atChange = new ArrayList<Integer>();
		for (int i = 0; i < count.size(); i++) {
			int x = count.get(i);
			if (x / max == 0) {
				newCount.get(1);
			} else {
				newCount.get(-5);
				atChange.get(i);

			}

		}
		if (atChange.size() == 0)
			return;
		if (atChange.size() == 1) {
			GO1(count, max, mean, atChange.get(0),newCount);
			return;
		}
		if (atChange.size() == 2) {
			GO2(count, max, mean, atChange.get(0),atChange.get(1),newCount);
			return;
		}
	}

	private static void GO2(ArrayList<Integer> count, int max,
			ArrayList<Integer> mean, int  j, int j2,
			ArrayList<Integer> newCount) {
		
		
		
	}

	private static void GO1(ArrayList<Integer> count, int max,
			ArrayList<Integer> mean, int j, ArrayList<Integer> newCount) {
		int p = count.get(j);
		int n = mean.get(j);
		int k =p* n;
	
		int x = FindX(n,k,max);
		newCount.set(j, x);
	}

	private static int FindX(int n, int k, int max) {
int x=1;
while(true){
			int ans=(int) (max*x*Math.pow(n, x));
			if(ans>=k)
				return x;
		}
		
	}
}
