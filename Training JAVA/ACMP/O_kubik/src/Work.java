import java.util.ArrayList;


public class Work {

	public static boolean MayAddInList(ArrayList<Integer> list, int pretendent, int i2) {
		for(int i:list)
			if(pretendent==i)
				return false;
		
		
		list.add(pretendent);
		return true;
	}

	public static int[][] ChangeXAndY(int[][] newK, int[][] oldK) {
for(int i =0;i<oldK.length;i++){
	newK[i][0]=oldK[i][1];
	newK[i][1]=oldK[i][0];
}

		
		return newK;
	}

	public static int[][] Sort(int[][] coordinate2) {
for(int i=0;i<coordinate2.length;i++)
	for(int j=0;j<coordinate2.length-1-i;j++){
		if(coordinate2[j][0]>coordinate2[j+1][0]){
			// если след число больше меняем местами
			int x=coordinate2[j][0];
			int y=coordinate2[j][1];
			
			coordinate2[j][0]=coordinate2[j+1][0];
			coordinate2[j][1]=coordinate2[j+1][1];
			
			coordinate2[j+1][0]=x;
			coordinate2[j+1][1]=y;
		}
	}
		
		return coordinate2;
	}

		
	

}
