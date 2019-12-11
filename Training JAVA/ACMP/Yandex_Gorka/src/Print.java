
public class Print {

	
	Print(){
		
	}
	
	static void PrintMassiv2 (int [][] x){
		for(int i = 0; i<x.length; i++){
			for(int j = 0; j<x.length; j++){
				System.out.print(x[i][j]+ " ");
				
				
				
			}
			System.out.println();
		}
	}
		static void PrintMassiv1 (int [] x){
			for(int i = 0; i<x.length; i++){
				System.out.print(x[i]+ " ");
			}
			
		
	}

		public void PrintMassiv3(int[][] smeg,  int[] countUsually,
				int[] countGorki) {
			for(int i = 0; i<smeg.length; i++){
				for(int j = 0; j<smeg.length; j++){
					System.out.print(smeg[i][j]+ " ");
					if (j==smeg.length-1){
						System.out.println("    " +countUsually[i]+"  "+countGorki[i]+"  ");
					}
					
					
				}
			
			}

			
			
		}
	
	
}
