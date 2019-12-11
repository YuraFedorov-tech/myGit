import java.util.Arrays;


public class Helper_368 {
	public static int[][] DO_ZaborMinus1(int[][] a) {
		Arrays.fill(a[0], -1);
		Arrays.fill(a[a.length-1], -1);
for(int i=0;i<a.length;i++){
	a[i][0]=a[i][a.length-1]=-1;
}


		
		
		return a;
	}
	
	
	public static void pr(int[][] a) {
		for(int i=0;i<a[0].length;i++){
			for(int j=0;j<a.length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}

		
		System.out.println();
	}


	public static int[][] Do_Helper_368(int[][] aPutForPrint, int[][] a,
			int[][] aDuble, boolean[][] buzy) {
		int len=a.length;
		int yOld=len-2;
		int xOld=len-3;
		int step=2;
	if((buzy[len-3][len-2]&buzy[yOld][xOld])){
		if(aDuble[len-3][len-2]<aDuble[yOld][xOld]){
			yOld--;
			xOld++;
		}
	}
if((buzy[len-3][len-2]&!buzy[yOld][xOld])){
	yOld--;
	xOld++;
}
	
	
	
	aPutForPrint[yOld][xOld]=2;
		aPutForPrint[len-2][len-2]=1;
		
while(true){
	step++;
	int [] yy={-1,0};
	int [] xx={0,-1};
	for(int i=0;i<2;i++){
		int x=xOld+xx[i];
		int y=yOld+yy[i];
	
	if(a[y][x]==-1)
		continue;
	if(aDuble[y][x]==aDuble[yOld][xOld]-a[yOld][xOld]){
		yOld=y;
		xOld=x;
		
		aPutForPrint[y][x]=step;
		break;
	}
	
	
	if(yOld==1 & xOld==1)
		return aPutForPrint;
	
	}
if(step==10000000)
break;
}

		
		return aPutForPrint;
	}


	public static void pr_aPutForPrint(int[][] aPutForPrint) {
		for (int i = 1; i < aPutForPrint[0].length-1; i++) {
			for (int j = 1; j < aPutForPrint[0].length-1; j++) {
				if(aPutForPrint[i][j]==0){
				System.out.print(".");
				}else
					System.out.print("#");
			}
			System.out.println();
		}

		
		
	}
}
