import java.util.ArrayList;
import java.util.Scanner;

public class O_018 {
	private static void pr(int[][] a, int n, int m) {
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int t=1000*1800;
		Scanner M = new Scanner(System.in);
		int k = M.nextInt();
		int n = M.nextInt();
		int m = M.nextInt();
		int a[][] = new int[n][m];
		int Ystart=0;
		int Xstart=0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++){
				a[i][j] = M.nextInt();
				if(a[i][j]==0)
					a[i][j]=-5;
				if(a[i][j]==3)
					a[i][j]=-3;
				if(a[i][j]==1)
					a[i][j]=-1;
				if(a[i][j]==2){
					a[i][j]=-2;
					 Ystart=i;
					 Xstart=j;
				}
			}
				

	//	pr(a, n, m);
		B(a, n, m, k,Ystart,Xstart);
	}

	private static void B(int[][] a, int n, int m, int k, int ystart, int xstart) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(ystart);
		list.add(xstart);
		list.add(k);
		list.add(0);
		int begin=0;
		int []ans={0};
		int step=0;
		int [][][]vizited=new int[500][4][500];
		while(list.size()!=0 &ans[0]==0){
			int siz=list.size();
			for(int i=0;i<siz/4;i++){
				GO(begin,list,a,n,m,vizited,ans,step);
				begin=1;
	//			pr(a, n, m);
			}
			step++;
			
		}
		if(ans[0]==0){
			System.out.println(-1);
		}else
			System.out.println(step);
		
	}

	private static void GO(int begin, ArrayList<Integer> list, int[][] a,
			int n, int m, int[][][] vizited, int[] ans, int step) {
	int yOld=list.get(0);
	int xOld=list.get(1);
	int kCur=list.get(2);
	int from=list.get(3);
	for(int i=0;i<4;i++)
		list.remove(0);
	
	int Y[]={-1,0,1,0 ,-1,0,1,0};
	int X[]={0,1,0,-1, 0,1,0,-1};
int 	i=from;
for(;i<from+4;i++){
	
	int y=yOld+Y[i];
	int x=xOld+X[i];
	if(y<0|y>n-1 |x<0|x>m-1)
		continue;
	if(a[y][x]==-1 |a[y][x]==-2)
		continue;
	if(a[y][x]==-3){
		ans[0]=1;
	//	return;
	}
	int direkt=i%4;
	if(from==(direkt+2)%4)
		continue;
	int l=y*m+x;
	if(vizited[l][direkt][kCur]==1)
		continue;
//	vizited[l][direkt][kCur]=1;
int kKKKKforInside=kCur;
if(i==from+1 &begin==1){
	if(kCur==0)
		continue;
	kKKKKforInside--;
}
vizited[l][direkt][kKKKKforInside]=1;
a[y][x]=step;
	list.add(y);
	list.add(x);
	list.add(kKKKKforInside);
	list.add(direkt);
	
	
}

	
	
	}

}
