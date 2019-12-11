import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class O_366 {

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		long s = my.nextLong();
		int[] aOld = new int[n ];
		int[] znakFinality = new int[n ];
		int[] znak = new int[n ];
for(int i=0;i<n;i++)
	aOld[i]=my.nextInt();
int []a=Helper_366.DoA(aOld);

System.out.println(Arrays.toString(a));
ArrayList<Integer> list = new ArrayList<>();

list=Helper_366.Do_List(aOld,a,list);
System.out.println(list);
int ans[]={-1};
	rekursia(0,a,s,0,ans,n,znak,znakFinality,list);
	if(ans[0]==1){	
		Helper_366.PrAnswear(aOld,a,list,znak,s);
		}else
			System.out.println("No solution");
		


		}
	


	

	private static void rekursia(int step, int[] a, long s, long currensy, int[] ans, int n, int[] znak, int[] znakFinality, ArrayList<Integer> list) {
		if(step==n){
			if(currensy==s){
				znakFinality=Arrays.copyOf(znak, znak.length);
				ans[0]=1;
			}
		return;
		}
/*	boolean chek=Helper_366.ChekGOfarOrNo(a,step,s,currensy);
	if(!chek)
		return;*/

for(int i=0;i<2;i++){
	if(list.get(step)==0 & i==1)
		continue;
	int x=i==0? 1:-1;
	znak[step]=x;
	rekursia(step+1,a,s,currensy+x*a[step],ans,n,znak,znakFinality,list);
if(ans[0]==1)
	return;
}
//	rekursia(0,a,s,0,ans,n,znak,znakFinality);
		
		
	}

}
