import java.util.ArrayList;


public class work_218 {

	public static void beganAnswear(int[][] a, ArrayList<Integer> list,
			int[] ans) {
		
		int step=1;
while(true){
	step++;
	if(list.size()==0)
		return;
	int n=list.size();
	for(int i=0;i<n;i++){
		list=FindLikeFourPoint(list,list.get(0),a,step,ans);
		if(ans[0]!=-1)
			return;
		list.remove(0);
	}
	
	
}

		
		
	}

	private static ArrayList<Integer> FindLikeFourPoint(
			ArrayList<Integer> list, int  p, int[][] a, int step,
			int[] ans) {
		int len=a.length;
		int yOld=p/len;
		int xOld=p-yOld*len;
		int [] yy={-2,-1,1,2, 2, 1,-1,-2};
		int [] xx={ 1, 2,2,1,-1,-2,-2,-1};
		
		for(int i=0;i<8;i++){
			int x=xOld+xx[i];
			int y=yOld+yy[i];
			if(a[y][x]==-5){
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
