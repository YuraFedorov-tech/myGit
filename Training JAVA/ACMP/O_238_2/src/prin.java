import java.util.ArrayList;


public class prin {

	public static void pr(int[][] baza) {
		System.out.println();
		for(int i=0;i<baza.length;i++){
			for(int i1=0;i1<baza[0].length;i1++){
				if(baza[i][i1]<0){
				System.out.print(baza[i][i1]+" ");
				continue;
				}
				System.out.print(" "+baza[i][i1]+" ");
			}
			System.out.println();	
			}
		
	}

	public static void pr(ArrayList<Integer> giper_Enter) {
		System.out.println();
		for(int i=0;i<giper_Enter.size();i++){
			System.out.print(giper_Enter.get(i)+" ");
		}
		
	}

}
