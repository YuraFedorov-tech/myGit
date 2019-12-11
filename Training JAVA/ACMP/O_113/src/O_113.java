import java.util.Scanner;

public class O_113 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int y = my.nextInt();

		int a[][] = new int[y][y];
		String s = my.nextLine();
		for (int i = 0; i < y; i++) {
		 s = my.nextLine();
			char[] chArray = s.toCharArray();
			for (int j = 0; j < y; j++) {
			
				a[i][j] = Integer.parseInt(""+chArray[j]); 
			}
		}

		int tabl[][] = new int[y+1][y+1];

	//	 pr(a);
	//	 pr(newA);

		int ans = FindAns(a,tabl);
		System.out.println(ans*ans);

	}

	private static int FindAns(int[][] a, int[][] tabl) {
int max=0;
for(int y=0;y<a.length;y++){
	int yT=y+1;
	for(int x=0;x<a.length;x++){
		int xT=x+1;
	if(a[y][x]!=0){
		tabl[yT][xT]=Math.min(tabl[yT-1][xT], tabl[yT][xT-1]);
		tabl[yT][xT]=Math.min(tabl[yT][xT],tabl[yT-1][xT-1]);
		tabl[yT][xT]+=1;
	}
	max=Math.max(max, tabl[yT][xT]);
	}
	
}


//pr(tabl);

		return max;
	}

	private static void pr(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)

				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}
}

	

	

	


