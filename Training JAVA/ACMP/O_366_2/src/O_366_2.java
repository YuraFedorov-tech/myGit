import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class O_366_2 {
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
			
				if(j!=0 ){
					String s=znak[j]==1?"+":"-";
					System.out.print(s);
				}
				System.out.print(a[j]);
				
			}
			System.out.print("="+s2);
		
		
	}

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		int n = my.nextInt();
		long s = my.nextLong();
		int[] aOld = new int[n ];
		int[] znakFinality = new int[n ];
		int[] znak = new int[n ];
for(int i=0;i<n;i++)
	aOld[i]=my.nextInt();
int []a = Arrays.copyOf(aOld, aOld.length);
//int []a=Helper_366.DoA(aOld);

//System.out.println(Arrays.toString(a));
ArrayList<Integer> list = new ArrayList<>();

//list=Helper_366.Do_List(aOld,a,list);
//System.out.println(list);
int ans[]={-1};
	rekursia(0,a,s,0,ans,n,znak,znakFinality,list);
	if(ans[0]==1){	
		PrAnswear(aOld,a,list,znak,s);
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
	if(step==0 & i==1)
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
