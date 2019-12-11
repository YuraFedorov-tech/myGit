import java.util.ArrayList;

public class Helper_029_2 {

	public static ArrayList<Integer> DolistSuper(ArrayList<Integer> list,
			ArrayList<Integer> listSuper0Or1, ArrayList<Integer> listSuper) {

		for (int i = 0; i < list.size() - 2; i++) {
			int x1 = list.get(i);
			int x2 = list.get(i + 1);
			int x3 = list.get(i + 2);
			int usully = Math.abs(x2 - x1) + Math.abs(x3 - x2);
			int superJamp = 3 * Math.abs(x3 - x1);

			if (superJamp < usully) {
				listSuper0Or1.add(1);
				listSuper.add(superJamp);
			} else {
				listSuper0Or1.add(0);
				listSuper.add(Math.abs(x2 - x1));
			}
		}

		listSuper0Or1.add(0);
		listSuper0Or1.add(0);

		return listSuper;
	}

	public static ArrayList<Integer> InsideInAnswear(
			ArrayList<Integer> answear, ArrayList<Integer> answear0Or1,
			ArrayList<Integer> list, ArrayList<Integer> listSuper,
			ArrayList<Integer> chet, ArrayList<Integer> chet0Or1,
			ArrayList<Integer> neChet, ArrayList<Integer> neChet0Or1, int[] iteraciaMassiv) {

		long cheting = FinfLine(list, listSuper, chet, chet0Or1);
		long neCheting = FinfLine(list, listSuper, neChet, neChet0Or1);
		if (cheting < neCheting) {
			answear = DoPlusAnswear(answear, answear0Or1, chet, chet0Or1);
			iteraciaMassiv[0]=FindIteraciaMassiv(chet0Or1);
		} else{
			answear = DoPlusAnswear(answear, answear0Or1, neChet, neChet0Or1);
			iteraciaMassiv[0]=FindIteraciaMassiv(neChet0Or1);
		}
		
		return answear;
	}

	private static int FindIteraciaMassiv(ArrayList<Integer> chet0Or1) {
		int ans=0;
		for(int i=0;i<chet0Or1.size();i++){
			if(i==chet0Or1.size()-1)
				if(chet0Or1.get(chet0Or1.size()-1)==0)
					return ans;
			if(chet0Or1.get(i)==0)
				ans++;
			if(chet0Or1.get(i)==1)
				ans+=2;;
			
		}
		return ans;
	}

	private static ArrayList<Integer> DoPlusAnswear(ArrayList<Integer> answear,
			ArrayList<Integer> answear0Or1, ArrayList<Integer> chet,
			ArrayList<Integer> chet0Or1) {
		for (int i = 0; i < chet.size(); i++) {
			if (i ==  chet.size()-1)
				if (chet0Or1.get(i) == 0)
					continue;
			answear.add(chet.get(i));

		}

		for (int i = 0; i < chet.size(); i++) {
			if (i ==  chet.size()-1)
				if (chet0Or1.get(i) == 0)
					continue;
			answear0Or1.add(chet0Or1.get(i));

		}

		return answear;
	}

	static long FinfLine(ArrayList<Integer> list, ArrayList<Integer> listSuper,
			ArrayList<Integer> chet, ArrayList<Integer> chet0Or1) {
		long ans = 0;
		for (int i = 0; i < chet.size(); i++) {
			int n=chet.get(i);
			if (chet0Or1.get(i) == 0)
				ans += Math.abs(list.get(n+1)-list.get(n)) ;
			if (chet0Or1.get(i) == 1)
				ans += listSuper.get(n);

		}

		return ans;
	}

}
