import java.util.Arrays;
import java.util.Scanner;

public class Kubok {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int k = myScanner.nextInt();
		int[][] rib = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int i1 = 0; i1 < n; i1++) {
				rib[i][i1] = myScanner.nextInt();
			}
		}
		int[] TimeInCity = new int[n];
		for (int i = 0; i < n; i++) {
			TimeInCity[i] = myScanner.nextInt();
		}
		// print.pr(rib);
		int[] Answear = new int[n + 1];
		rib = plus(rib, TimeInCity);
	if(k!=1){	
     int z=n==k? k-1:k;
		Answear = plusMinRoad(rib, Answear, z, TimeInCity[0],k);
		int MinPut=Answear[Answear.length - 1];
		print.pr(rib);
		int line = Answear[Answear.length - 1]; // длина пути из нулевого города
	//	System.out.println(Answear[Answear.length - 1]);
		int [][] put=new int [n][k];
		int [] Line_put=new int[n];
for(int i=0;i<n;i++){
	Answear[Answear.length - 1]=MinPut;

		int[] Curent_pont = new int[k];
		int[] Best_pont = new int[k];

		boolean[] used = new boolean[n];
		int Start_Vershina = i;
		Best_pont = do_road_from_0(Best_pont, Start_Vershina, k);
		Answear = rekur(Answear, rib, n, k, line, 0, used, Start_Vershina,Curent_pont,Best_pont);
		put[i]=Arrays.copyOf(Best_pont, Best_pont.length);
		Line_put[i]=Answear[Answear.length - 1];

}
int[] Best_pont = new int[k];

int y=Minimum_Number_Point(Line_put);
System.out.println(Line_put[y]);

for(int i=0;i<k;i++){
System.out.print(put[y][i]+1);
if(i!=k-1)
System.out.print(" ");
}



}else{
	int D=rib[0][0];
	int dd=0;
	for(int i=0;i<rib.length;i++){
	if (D>rib[i][i]){
		D=rib[i][i];
		dd=i;
	}
	}
	System.out.println(D);
	System.out.println(dd+1);
}
	


	}


	

	private static int Minimum_Number_Point(int[] line_put) {
		int y=0;
		for(int i=0;i<line_put.length;i++){
			if(line_put[y]>line_put[i])
				y=i;
		}
		return y;
	}

	private static int[] rekur(int[] answear, int[][] rib, int n, int k,
			int line, int Step, boolean[] used, int V, int[] Curent_pont, int[] Best_pont) {
		Step++;
		if (Step == k-1 ) {
			int lineLast = 0;
		
				lineLast = findLast(rib, V, used,Curent_pont,Step);

			if(k==2){
				line = rib[V][V];
				used[V] = true;
				Curent_pont[0]=V;
			}
				
			line += lineLast;
			if(line<=answear[answear.length - 1]){
				answear[answear.length - 1]=line;
				Best_pont=do_Best_road(Curent_pont,Best_pont);
				
			}
		

			return answear;
		}
		if (Step == 1) {
			line = rib[V][V];
			used[V] = true;
			Curent_pont[0]=V;
		}
		for (int i = 0; i < n; i++) {
			if (!used[i] & V != i) {
				int New_V = i;
				line += rib[V][i];
				Curent_pont[Step]=New_V;
				used[New_V] = true;
				answear = rekur(answear, rib, n, k, line, Step, used, New_V,Curent_pont,Best_pont);
				line -= rib[V][i];
				used[New_V] = false;
			}

		}

		return answear;
	}

	

	private static int findLast(int[][] rib, int v, boolean[] used, int[] Curent_pont, int step) {
		int put = 0;
		Curent_pont[step]=0;
		for (int i = 0; i < used.length; i++) {
			if (!used[i] & v != i) {
				put = rib[v][i];
				Curent_pont[step]=i;
				break;
			}
		}
		for (int i = 0; i < used.length - 1; i++) {
			if (!used[i] & v != i) {
				if (put > rib[v][i])
					put = rib[v][i];
			}
		}

		return put;
	}

	private static int[] plusMinRoad(int[][] rib, int[] answear, int k,
			int timeInCity, int k2) {
		answear[answear.length - 1] += timeInCity;
		for (int i = 0; i < k; i++) {
			answear[answear.length - 1] += rib[i][i + 1];
		}
		return answear;
	}

	private static int[][] plus(int[][] rib, int[] timeInCity) {
		for (int i = 0; i < rib.length; i++) {
			for (int i1 = 0; i1 < rib.length; i1++) {

				rib[i1][i] += timeInCity[i];
			}

		}

		return rib;
	}

	private static int[] do_road_from_0(int[] Best_pont, int start_Vershina,
			int k) {

		for (int i = 0; i < k; i++) {
			Best_pont[i] = i;
		}

		return Best_pont;
	}
	private static int[] do_Best_road(int[] curent_pont, int[] best_pont) {
		for (int i = 0; i <curent_pont.length; i++) {
			best_pont[i]=curent_pont[i];
		}
		return best_pont;
	}
}
