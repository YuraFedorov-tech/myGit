import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class O_011_3 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int k = myScanner.nextInt();
		int n = myScanner.nextInt();
		ArrayList<Integer> road = new ArrayList<Integer>();
		boolean[] findNumberBoolean = new boolean[n + 1];
		BigInteger[] findNumberInt = new BigInteger[n + 1];
		BigInteger[] CounrForNewInt = new BigInteger [n + 1];
	for(int i=0;i<n+1;i++)
		findNumberInt[i]=CounrForNewInt[i]=BigInteger.valueOf(0);
		BigInteger ans = BigInteger.valueOf(0);
		 ans = Rekursia(n, k, ans, road, 0, findNumberBoolean, findNumberInt,
				CounrForNewInt);
	//	System.out.println(road);
		System.out.println(ans);

	}

	private static BigInteger Rekursia(int n, int k, BigInteger ans, ArrayList<Integer> road,
			int count, boolean[] findNumberBoolean, BigInteger[] findNumberInt,
			BigInteger[] counrForNewInt) {

		if (count == n) {
			counrForNewInt=Helping3.plus_counrForNewInt_on_road(counrForNewInt,road,1,1);
			// System.out.print( road);
			//System.out.println( ans + 1);
			ans=ans.add(BigInteger.valueOf(1));
			
			return ans ;

		}

		for (int i = 0; i < k; i++) {
			int newCount = count + i + 1;
			if (newCount > n)
				break;
			
			if (findNumberBoolean[newCount]) {
				counrForNewInt=Helping3.plus_counrForNewInt_on_road(counrForNewInt,road,0,findNumberInt[newCount]);
				ans = ans.add(findNumberInt[newCount]);
				continue;
			}
			road.add(i + 1);
		//	int[] copiedCounrForNewInt = Arrays.copyOf(counrForNewInt,				counrForNewInt.length);
			// counrForNewInt=Helping.Plus1toall(counrForNewInt,road);
			

			ans = Rekursia(n, k, ans, road, newCount, findNumberBoolean,
					findNumberInt, counrForNewInt);
			road.remove(road.size() - 1);
			// counrForNewInt=null;
			// counrForNewInt = Arrays.copyOf(copiedCounrForNewInt,
			// copiedCounrForNewInt.length);
			
		}
	//	int n1 = Helping.FindNumber(road);
		if (!findNumberBoolean[count]) {

		//	int y = ans - counrForNewInt[n1]+plusInt[n1];
			findNumberInt[count] =counrForNewInt[count];
			findNumberBoolean[count] = true;

		}
		return ans;
	}

	public static int[] Plus1toall(int[] counrForNewInt, ArrayList<Integer> road) {
		// TODO Auto-generated method stub
		return counrForNewInt;
	}

	public static int FindNumber(ArrayList<Integer> road) {
		int n=0;
for(int x: road)
n+=x;
		return n;
	}

	public static BigInteger[] plus_counrForNewInt_on_road(BigInteger[] counrForNewInt,
			ArrayList<Integer> road, int n, int findNumberInt) {    // если n=0, значит прибавляем по всей дороге
for(int i=1;i<road.size()-n+1;i++)                               	// tckb n=1 , то последнюю точку не смотрим
			counrForNewInt[i]=counrForNewInt[i].add(BigInteger.valueOf(1));

		return counrForNewInt;
	}

	public static BigInteger[] plus_counrForNewInt_on_road(
			BigInteger[] counrForNewInt, ArrayList<Integer> road, int n,
			BigInteger bigInteger) {

		for(int i=1;i<road.size()-n+1;i++)   
			counrForNewInt[i]=counrForNewInt[i].add(bigInteger);
		
		
		return counrForNewInt;
	}

}



