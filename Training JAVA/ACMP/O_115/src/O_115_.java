import java.util.Scanner;

public class O_115_ {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int y = my.nextInt();
		int x = my.nextInt();
		int a[][] = new int[y][x];
		for (int i = 0; i < y; i++)
			for (int j = 0; j < x; j++)
				a[i][j] = my.nextInt();

		int[][] newA = FindNaoborot(a);
	//	pr(a);
	//	pr(newA);

int ans=FindAns(newA);
System.out.println(ans);		
		
		
		
		
	}

	private static int FindAns(int[][] newA) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < newA.length; i++)
			for (int i1 = i; i1 < newA.length; i1++)
			for (int j = 0; j < newA[0].length; j++)
				for (int j1 = j; j1 < newA[0].length; j1++){
					int n=FindSumma(i,j,i1,j1,newA);
					max=Math.max(max,n);
			//		System.out.println (i+"\t"+j+"\t"+i1+"\t"+j1+"\t"+max);
					
				}
		
		
		return max;
	}

	private static int FindSumma(int yL, int xL, int yR, int xR, int[][] newA) {
if(yR==0 & xR==0)
	return newA[yL][xL];
if(xL==0 &yL==0)
	return newA[yR][xR];

if(yL==0 )
	return newA[yR][xR]-newA[yR][xL-1];
if(xL==0 )
	return newA[yR][xR]-newA[yR-1][xL];	
		int n=newA[yR][xR]-newA[yR][xL-1]-newA[yL-1][xR]+newA[yL-1][xL-1];
		return n;
	}

	private static void pr(int[][] a) {
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[0].length; j++)

				System.out.print(a[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] FindNaoborot(int[][] a) {
		int[][] newA = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[0].length; j++) {
				newA[i][j] = Find1Nubber(i, j, a, newA);
			}

		return newA;
	}

	private static int Find1Nubber(int i, int j, int[][] a, int[][] newA) {
		if (i == 0 & j == 0)
			return a[i][j];
		if (i == 0)
			return a[i][j] + newA[i][j - 1];
		if (j == 0)
			return a[i][j] + newA[i - 1][j];

		return a[i][j] + newA[i - 1][j] + newA[i][j - 1] - newA[i - 1][j - 1];
	}

}