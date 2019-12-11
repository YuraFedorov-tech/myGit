
public class Print {

	
	
	
	Print(){
		
	}
	
	static void printKoordinat(double [][]xxx, int n){
		for (int i =0; i < n; i++) {
			System.out.println( xxx[0][i] +" " +xxx[1][i] );
			
			
		}
		
		
		
	}
	static void printKoordinatPolar(double [][]xxx, int n, double [][] polar){
		for (int i =0; i < n; i++) {
			System.out.println( xxx[0][i] +" " +xxx[1][i]+" " +polar[0][i] +" " +polar[1][i] );
			
			
		}
		
		
		
	}
}
