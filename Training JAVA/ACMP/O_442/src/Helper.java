import java.util.ArrayList;


public class Helper {

	public static void FindSimple(ArrayList<Integer> list, boolean[] buz) {
	//	boolean[] buz=new boolean[13442];
		for(int i=3;i<13442;i+=2){
			if(buz[i])
				continue;
			DoBuz(buz,i);
		}
		FindListSimple(buz,list);
		//
	}

	private static void FindListSimple(boolean[] buz, ArrayList<Integer> list) {
		list.add(2);
		for(int i=3;i<=13441;i+=2){
			if(!buz[i])
				list.add(i);
		}

	}

	private static void DoBuz(boolean[] buz, int j) {
		for(int i=j*2;i<13442;i+=j){
			buz[i]=true;
		}
		
	}

	public static void prepearToRekur(int i, ArrayList<Integer> list, int mean,
			int[] ans) {
		int minus=i-5;
		mean-=minus*2;
		int yy[] = new int[5];
O_4_2.Rekur(0, 5, list, mean, 0, ans, yy);
		
	}

}
