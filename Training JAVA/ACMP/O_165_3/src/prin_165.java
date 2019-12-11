
public class prin_165 {

	public static void prinUsulyMassiv(int[][] coordinat) {
		for(int i=0;i<coordinat.length;i++){
			for(int j=0;j<coordinat[0].length;j++){
				System.out.print(coordinat[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void prinUsulyRebra(int[][] matricaSmegnosti) {
		for(int i=0;i<matricaSmegnosti.length;i++){
			if(matricaSmegnosti[i][0]==0)
				continue;
			System.out.print(i +":");
			for(int j=1;j<=matricaSmegnosti[i][0];j++){
				System.out.print(matricaSmegnosti[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
		
	}


