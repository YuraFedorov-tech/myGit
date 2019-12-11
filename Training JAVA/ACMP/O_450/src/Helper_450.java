import java.util.ArrayList;

public class Helper_450 {

	public static void pr(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	
	
	}

	public static void pr1(int[] a) {
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]+"\t");
		}
		System.out.println();

		
		
	}

	public static ArrayList<Integer> Find_list_Best(int[][] a, int[] max, ArrayList<Integer> list_Best) {
		ArrayList<Integer> value = new ArrayList<>();
		ArrayList<Integer> index = new ArrayList<>();
		for(int i=0;i<a.length;i++)
			index=Finf1Massiv_volue_andIndex(value,index,i,max,a);
		list_Best=Find_best_number(value,index,list_Best);
		
		return list_Best;
	}

	private static ArrayList<Integer> Find_best_number(
			ArrayList<Integer> value, ArrayList<Integer> index,
			ArrayList<Integer> list_Best) {
int max=value.get(0);
int indexOfmax=0;

for(int i=1;i<value.size();i++){
	if(max<value.get(i)){
		max=value.get(i);
		indexOfmax=i;
	}
	
}
list_Best.add(index.get(indexOfmax));
list_Best.add(indexOfmax);


		return list_Best;
	}

	private static ArrayList<Integer> Finf1Massiv_volue_andIndex(
			ArrayList<Integer> value, ArrayList<Integer> index, int ind, int[] max, int[][] a) {
		int Max_element=a[0][ind];
		int indexOf_Max_element=0;
for(int i=1;i<a.length;i++){
	if(Max_element<a[i][ind]){
		Max_element=a[i][ind];
		indexOf_Max_element=i;
	}
}
value.add(max[ind]-Max_element);
index.add(indexOf_Max_element)	;
		return index;
	}

	public static int[][] Do_aShlyapa(int[][] aShlyapa, Integer vertikal) {
for(int i=0;i<aShlyapa.length;i++)
	aShlyapa[i][vertikal]=0;

		
		return aShlyapa;
	}
}
