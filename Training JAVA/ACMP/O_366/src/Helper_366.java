import java.util.ArrayList;
import java.util.Arrays;


public class Helper_366 {

	public static int[] DoA(int[] aOld) {
int []a=new int[aOld.length];
Arrays.sort(aOld);
		for(int i=a.length-1;i>=0;i--)
			a[a.length-1-i]=aOld[i];
			
		return a;
	}

	public static boolean ChekGOfarOrNo(int[] a, int step, long s, long currensy) {
		long far=0;
for(int i=step;i<a.length;i++)
	far+=Math.abs(a[i]);
currensy=Math.abs(currensy);
s=Math.abs(s);
if(far>=s-currensy)
	return true;;
		
		return false;
	}

	public static ArrayList<Integer> Do_List(int[] aOld, int[] a, ArrayList<Integer> list) {
		
		boolean buzy[]=new boolean[a.length];
for(int i=0;i<a.length;i++)
	for(int j=0;j<a.length;j++){
		if(!buzy[j] & aOld[i] ==a[j]){
			buzy[j]=true;
			list.add(j);
			continue;
		
		}
		
	}
		return list;
	}

	public static void PrAnswear(int[] aOld, int[] a, ArrayList<Integer> list,
			int[] znak, long s2) {
		boolean buzy[]=new boolean[a.length];
		
			for(int j=0;j<a.length;j++){
				int y=list.get(j);
				if(j!=0 | znak[y]==-1){
					String s=znak[y]==1?"+":"-";
					System.out.print(s);
				}
				System.out.print(a[y]);
				
			}
			System.out.print("="+s2);
		
		
	}

}
