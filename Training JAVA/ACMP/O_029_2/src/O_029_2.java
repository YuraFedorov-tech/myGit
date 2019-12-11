import java.util.ArrayList;

public class O_029_2 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list = Input_029_2.Input(list);
		ArrayList<Integer> listSuper = new ArrayList<>();
		ArrayList<Integer> listSuper0Or1 = new ArrayList<>();
		listSuper = Helper_029_2.DolistSuper(list, listSuper0Or1, listSuper);

		System.out.println(list);
		System.out.println(listSuper);
		System.out.println(listSuper0Or1);
		ArrayList<Integer> answear = new ArrayList<>();
		ArrayList<Integer> answear0Or1 = new ArrayList<>();
		answear = FindAnswear(list, listSuper, listSuper0Or1, answear,
				answear0Or1);
		System.out.println(answear);
		System.out.println(answear0Or1);
		long realy_ans = Helper_029_2.FinfLine(list, listSuper, answear,
				answear0Or1);
		System.out.println(realy_ans);
		int iteraciaEnd=Find_iteraciaEnd(answear0Or1);
		if(list.size()>2){
		realy_ans=FindLast(iteraciaEnd,list,realy_ans);
		System.out.println(realy_ans);
		}else{
			if(list.size()==1)
				System.out.println(0);
			if(list.size()==2)
				System.out.println(Math.abs( list.get(1)-list.get(0)   ));
			
		}
	}



	private static long FindLast(int iteraciaEnd, ArrayList<Integer> list, long realy_ans) {
int max=list.size();

int x1=list.get(list.size()-3);
int x2=list.get(list.size()-2);
int x3=list.get(list.size()-1);
		if(iteraciaEnd==max-2){
			int next=Math.abs(x3-x2);
			realy_ans+=next;
		}
		if(iteraciaEnd==max-3){
			int next=Math.abs(x3-x2)+Math.abs(x2-x1);
			realy_ans+=next;
		}
		
		return realy_ans;
	}



	private static int Find_iteraciaEnd(ArrayList<Integer> answear0Or1) {
	int ans=0;
		for(int i:answear0Or1){
			if(i==0)
				ans++;
			if(i==1)
				ans+=2;
			
		}
		return ans;
	}

	private static ArrayList<Integer> FindAnswear(ArrayList<Integer> list,
			ArrayList<Integer> listSuper, ArrayList<Integer> listSuper0Or1,
			ArrayList<Integer> answear, ArrayList<Integer> answear0Or1) {
		for (int i = 0; i < listSuper.size(); i++) {
			int iteraciaPlus = FindAnswearOne(list, listSuper, listSuper0Or1,
					answear, answear0Or1, i);
i+=iteraciaPlus;
		}

		return answear;
	}

	private static int FindAnswearOne(ArrayList<Integer> list,
			ArrayList<Integer> listSuper, ArrayList<Integer> listSuper0Or1,
			ArrayList<Integer> answear, ArrayList<Integer> answear0Or1, int n) {
		if (listSuper0Or1.get(n) == 0) {
			answear.add(n);
			answear0Or1.add(0);
			return 0;
		}
		if ((listSuper0Or1.get(n) == 1 & listSuper0Or1.get(n + 1) == 0)
				) {
			answear.add(n);
			answear0Or1.add(1);
			return 1;
		}

		ArrayList<Integer> chet = new ArrayList<>();
		ArrayList<Integer> chet0Or1 = new ArrayList<>();
		ArrayList<Integer> neChet = new ArrayList<>();
		ArrayList<Integer> neChet0Or1 = new ArrayList<>();

		
		for (int i = n; i < listSuper.size(); i++) {
			if (i % 2 == 0) {
				if(i==n){
					neChet.add(i);
					neChet0Or1.add(0);					
				}
				chet.add(i);
				chet0Or1.add(1);
				if (listSuper0Or1.get(i + 1) == 0) {
					neChet.add(i + 1);
					neChet0Or1.add(0);					
					break;
				}

			}
			if (i % 2 == 1) {
				if(i==n){
					chet.add(i);
					chet0Or1.add(0);					
				}
				neChet.add(i);
				neChet0Or1.add(1);
				if (listSuper0Or1.get(i + 1) == 0) {
					chet.add(i + 1);
					chet0Or1.add(0);		
					break;
				}

			}

		}
		int iteraciaMassiv[] ={0};
		answear = Helper_029_2.InsideInAnswear(answear, answear0Or1, list,
				listSuper, chet, chet0Or1, neChet, neChet0Or1,iteraciaMassiv);

		return iteraciaMassiv[0]-1;
	}
}
