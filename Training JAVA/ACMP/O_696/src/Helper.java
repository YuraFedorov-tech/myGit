import java.util.Arrays;


public class Helper {

	public static void Find_keyses(int[] keyPrice, String[] keyString, int[] k) {


		
	}

	public static void Find_keyString(String[] keyString) {
		keyString[0]="R";
		keyString[1]="G";
		keyString[2]="B";
		keyString[3]="Y";
		
	}

	public static int Inside(char ch) {
		switch(ch){
		case 'R': return 0;
		case 'G': return 1;
		case 'B': return 2;
		case 'Y': return 3;
		}
		return 0;
	}
	public static void pr(int[][] a, int m, int n) {
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]==-1){
					System.out.print(-1+ "\t");
				}else
				System.out.print(a[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int rekur(int step, int[][] keyProper, int n, int[] currensy) {
	if(step==4){
		keyProper[n]=Arrays.copyOf(currensy, 4)	;
		n++;	
		System.out.println(Arrays.toString(currensy));
		return n;
	}
		for(int i=0;i<2;i++){
			currensy[3-step]=i;
		n=rekur(step+1,keyProper,n,currensy);
		}
	
	return n;
	}

	public static int[][] Do_newa(int[][] a, int n, int m) {
		int aaa[][]=new int[n][m];
		for(int i=0;i<n;i++)
			aaa[i]=Arrays.copyOf(a[i], m);
		return aaa;
	}

	public static int Find_min(int[] ans, int[][] keyProper, int[] key) {
	int t=0;
		for(int i:ans)
			t+=i;
		if(t==0)
			return -1;

int y=0;
for(int i:key)
	y+=i;
	for(int i=0;i<24;i++)
		if(ans[i]==1){
			int pret=FindPret(keyProper[i],key);
			if(y>pret)
				y=pret;
		}

		
		return y;
	}

	private static int FindPret(int[] keyProper, int[] key) {
		int a=0;
		for(int i=0;i<4;i++)
			a+=keyProper[i]*key[i];
		return a;
	}
}
