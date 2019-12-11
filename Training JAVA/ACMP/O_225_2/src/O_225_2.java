import java.util.ArrayList;
import java.util.Scanner;

public class O_225_2 {// Main

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int a[][] = new int[3][n];
		for (int i = 0; i < n; i++) {
			for (int i1 = 0; i1 < 3; i1++) {
				a[i1][i] = myScanner.nextInt();
			}

		}
		int step = 0;
		int count = 0;
		int ans[] = new int[1];
		ans[0] = -1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listFinality = new ArrayList<Integer>();
		ans = rekursia(step, count, a, ans, n,list,listFinality);
		System.out.println(ans[0]);
		
		
	//	printList(listFinality);
		
		
	}
	private static void printList(ArrayList<Integer> listFinality) {
	for(int i=0;i<listFinality.size();i++)
		System.out.print(listFinality.get(i)+" ");
	}
	
	
	private static int[] rekursia(int step, int count, int[][] a, int[] ans,
			int n, ArrayList<Integer> list, ArrayList<Integer> listFinality) {
		if (count >= ans[0] & ans[0] != -1)
			return ans;
		if (step > n)
			return ans;
		if (step == n) {
			if (ans[0] == -1 | ans[0] > count){
				ans[0] = count;
				listFinality.clear();
				listFinality.addAll(list);
			}
			return ans;
		}
		int j = 0;
		int new3 = 2;
		if (n - step > 12) {
			int AnsSmoll[] = new int[3];
			AnsSmoll[0] = -1;

			AnsSmoll = rekurSmoll(step, 0, a, AnsSmoll, step + 12);

			
			j = AnsSmoll[2];
			new3 = j;
		}

		for (; j <= new3; j++) {
			int newStep = step + j + 1;
			if (newStep > n)
				continue;
			
			
			list.add(j);
			ans = rekursia(newStep, count + a[j][step], a, ans, n,list,listFinality);
			list.remove(list.size()-1);
		}

		// }

		return ans;
	}

	private static int[] rekurSmoll(int step, int count, int[][] a,
			int[] ansSmoll, int n) {
		if (count >= ansSmoll[0] & ansSmoll[0] != -1)
			return ansSmoll;
		if (step > n)
			return ansSmoll;
		if (step == n) {
			if (ansSmoll[0] == -1 | ansSmoll[0] > count) {
				ansSmoll[0] = count;
				ansSmoll[2] = ansSmoll[1];
			}
			return ansSmoll;
		}

		for (int j = 0; j < 3; j++) {
			if (n - step == 12) {
				ansSmoll[1] = j;
			}

			int newStep = step + j + 1;
			if (newStep > n)
				break;
			ansSmoll = rekurSmoll(newStep, count + a[j][step], a, ansSmoll, n);

		}

		return ansSmoll;
	}

}
