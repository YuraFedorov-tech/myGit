import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class O_573 {
	public static void main(String[] args) throws IOException {
		BufferedReader o = new BufferedReader(new InputStreamReader(System.in));
		String s = o.readLine();
		String g[] = s.split(" ");
		int n = Integer.parseInt(g[0]);
		int v = Integer.parseInt(g[1]);
		int coor[][] = new int[n][2];
		int time[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			s = o.readLine();
			String t[] = s.split(" ");
			time[i] = FindFirstTime(t[0]);
			coor[i][0] = Integer.parseInt(t[1]);
			coor[i][1] = Integer.parseInt(t[2]);
		}
	//	System.out.println(Arrays.toString(time));
	//	System.out.println(Arrays.deepToString(coor));
		double pogreshnost=0.999999;
	
	//	System.out.println(Arrays.deepToString(a));
	/*	int[] dop_time=Arrays.copyOf(time, n);
		int [][]coorNew=Massiv(coor, dop_time, n,time);
		double[][] a = FindA(coorNew, n,pogreshnost);*/
	//	System.out.println(Arrays.toString(dop_time));
	//	System.out.println(Arrays.deepToString(coorNew));
	//	System.out.println(Arrays.deepToString(a));
	/*	Began(n,a,dop_time,v);*/
		double[][] a = FindA(coor, n,pogreshnost);
		Began(n,a,time,v);
	}

	private static void Began(int n, double[][] a, int[] time, int v) {
int []ans={-1,-1};
int number=FindNumber(a,time[n-1]-time[0],n,v,time);

while(ans[0]==-1){

	int[][] nlo=new int[number][n+1];
	rekurs(0,nlo,a,time,v,number,ans,n);
	number++;
}
		
System.out.println(ans[0]);	
	}

	private static int FindNumber(double[][] a, int time, int n, int v, int[] time2) {
	int odinakovTime=Find_odinakovTime(n,time2);
	//if(odinakovTime>0)
	//	return odinakovTime;
		double l=0;
		for(int i=0;i<n-1;i++)
			l+=a[i][i+1];
		//double t=l*60/v;
		double lmax=time/(v*60);
		if(lmax==0)
			return 1;
	double how=l/lmax;
	how=	Math.ceil(how);
	int h=(int) how;	
	if(h>odinakovTime)
	return h;
	return odinakovTime;
	}

	private static int Find_odinakovTime( int n, int[] time) {
		boolean[] buzy=new boolean [n];
		int ans=0;
		for(int i=0;i<n;i++){
		int	x=time[i];
			for(int j=i+1;j<n;j++){
				if(buzy[j])
					continue;
				if(x==time[j]){
					buzy[j]=true;
					ans++;
				}
			}
		}
		if(ans==1)
			return 2;
		return ans;
	}

	private static void rekurs(int step, int[][] nlo, double[][] a, int[] time,
			int v, int number, int[] ans, int n) {
		if(step==n){
			ans[0]=ans[1]=number;
			return;
		}
		
		for(int i=0;i<number;i++){
			if(nlo[i][0]==0){
				if(i!=0)
					if(nlo[i-1][0]==0)
						break;
				
				
			}else{
				
				if(!FindMay(nlo,i,step,a,v,time))
					continue;					
			}
			nlo[i][0]++;
			nlo[i][nlo[i][0]]=step;
			rekurs(step+1,nlo,a,time,v,number,ans,n);
			if(ans[0]!=-1)
				return;
			nlo[i][nlo[i][0]]=0;
			nlo[i][0]--;
		}
		
	}

	private static boolean FindMay(int[][] nlo, int i, int step, double[][] a, int v, int[] time) {

		int first=nlo[i][nlo[i][0]];

		double time_count=a[first][step]*60/(v);
		double time_Fact=Math.abs(time[step]-time[first]);
	 if(time_count<time_Fact)
		 return true;;
		return false;
	}

	private static double[][] FindA(int[][] c, int n, double pogreshnost) {
		double a[][] = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) 
					continue;
                      a[i][j]=Findline(c[i][0],c[i][1],c[j][0],c[j][1],pogreshnost);
				
			}

		}

		return a;
	}

	 static double Findline(int y, int x, int yy, int xx, double pogreshnost) {
double	an=(y-yy)*(y-yy)+(x-xx)*(x-xx);;
an=Math.sqrt(an);
		return an*pogreshnost;

	}

	private static int FindFirstTime(String s) {
		String g[] = s.split(":");
		return Integer.parseInt(g[0]) * 60 + Integer.parseInt(g[1]);
	}

	public static int[][] Massiv(int[][] coor, int[] dop_time, int n, int[] time) {
		Arrays.sort(dop_time);
		int[][] coorNew = new int[n][2];
		boolean buzy[] = new boolean[n];
		for (int i = 0; i < n; i++)
			coorNew[i] = Arrays.copyOf(coor[FindI(dop_time[i], buzy,  n,time)], 2);
		
		
		return coorNew;
	}
	private static int FindI(int j, boolean[] buzy,  int n, int[] time) {
	
		for(int i=0;i<n;i++){
			if(time[i]==j & !buzy[i]){
				buzy[i]=true;
				return i;
			}
		}
		
		return -5;
	}
}