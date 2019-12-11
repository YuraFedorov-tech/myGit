import java.util.ArrayList;

public class work_368 {
	public static void beganAnswear(int[][] a, ArrayList<Integer> list,
			int[] ans, int[][] aDuble, ArrayList<Integer> listLineRoad, boolean[][] buzy) {
		int step = 1;

		while (true) {
			step++;
			if (list.size() == 0)
				return;
	///		int n = list.size();
	//		for (int i = 0; i < n; i++) {
				list = FindLikeFourPoint(list, list.get(0), a, step, ans,aDuble,listLineRoad,buzy);
				if (ans[0] != -1)
					return;
				list.remove(0);
				listLineRoad.remove(0);
	//	        Helper_368.pr(aDuble);
	//		}

		}
	}

	private static ArrayList<Integer> FindLikeFourPoint(
			ArrayList<Integer> list, int p, int[][] a, int step,
			int[] ans, int[][] aDuble, ArrayList<Integer> listLineRoad, boolean [][] buzy) {
		int len=a.length;
		int yOld=p/len;
		int xOld=p-yOld*len;

		int [] yy={1,0};
		int [] xx={0,1};
		for(int i=0;i<2;i++){
			int x=xOld+xx[i];
			int y=yOld+yy[i];
	if(a[y][x]==-1 |aDuble[y][x]!=0 | buzy[y][x] )
		continue;
	if(y==len-2 &  x==y){
		ans[0]=step-1;
		return list;
	}
	buzy[y][x]=true;
	aDuble[y][x]=aDuble[yOld][xOld]+a[y][x];	
	list=InsidePointInlistAndlistLineRoad(list,listLineRoad,x,y,a,aDuble[y][x]);


			
		}
		
		
		
		return list;
	}

	private static ArrayList<Integer> InsidePointInlistAndlistLineRoad(
			ArrayList<Integer> list, ArrayList<Integer> listLineRoad, int x,
			int y, int[][] a, int newRoad) {
		int i=1;	
for(;i<listLineRoad.size();i++)
	if(listLineRoad.get(i)>=newRoad)
	break;
int r=y*a.length+x;
list.add(i,r);
listLineRoad.add(i,newRoad);
		
		return list;
	}




}
