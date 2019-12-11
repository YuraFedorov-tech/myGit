public class print {

	public static int[][] insideBoard(int[][] baza) {
		
			for (int i1 = 0; i1 <baza[0].length; i1++) 
				baza[0][i1]=baza[baza.length-1][i1]=1;
	
			for (int i1 = 0; i1 <baza.length; i1++) 
				baza[i1][0]=baza[i1][baza[0].length-1]=1;
			
			

		return baza;
	}

	public static void pr(int[][] Baza) {
		for (int i = 0; i < Baza.length; i++) {
			for (int i1 = 0; i1 <Baza[0].length; i1++) {
				if(Baza[i][i1]==-1 |Baza[i][i1]==-2){
					System.out.print(Baza[i][i1]+" ");
					continue;
				}
				
				System.out.print(" "+Baza[i][i1]+" ");

			}
			System.out.println();
		}
		System.out.println();
		
		
	}

}
