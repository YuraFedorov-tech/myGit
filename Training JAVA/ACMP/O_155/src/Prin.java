
public class Prin {

	public static void pr(int[][] typeOfConect, int o) {
	for(int i=0;i<o+5;i++){
		for(int j=0;j<typeOfConect[0].length;j++){
			System.out.print(typeOfConect[i][j]+"\t");
		}
		
	System.out.println( "--"+i);
	}
	}
}
