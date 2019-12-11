import java.util.ArrayList;


public class work_381 {

	public static void beganAnswear(int[][] a, int[] end,
			ArrayList<Integer> list, int[] ans) {
		int step=1;
while(true){
	step++;
	if(list.size()==0)
		return;
	int n=list.size();
	for(int i=0;i<n;i++){
		list=FindLikeFourPoint(list,list.get(0),end,a,step,ans);
		if(ans[0]!=-1)
			return;
		list.remove(0);
	}
	
	
}

		
		
	}

	private static ArrayList<Integer> FindLikeFourPoint(
			ArrayList<Integer> list, int p, int[] end, int[][] a, int step, int[] ans) {
		int len=a.length;
int yOld=p/len;
int xOld=p-yOld*len;

int [] yy={-1,0,1,0};
int [] xx={0,1,0,-1};
for(int i=0;i<4;i++){
	int x=xOld+xx[i];
	int y=yOld+yy[i];
	if(y==end[0] & x==end[1]){
		ans[0]=step-1;
		return list;
	}
	if(a[y][x]==0){
		a[y][x]=step;
		list.add( y*len+x  );
	}
	
	
}

		
		
		return list;
	}

	

}
