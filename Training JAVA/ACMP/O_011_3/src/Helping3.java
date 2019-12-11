import java.math.BigInteger;
import java.util.ArrayList;


public class Helping3 {

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

