import java.util.Scanner;


public class O_012 {//Main

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int n = myScanner.nextInt();
double pointDesant[][]=new double[2][n];
double corner11[][]=new double[2][n];		
double corner22[][]=new double[2][n];
double corner33[][]=new double[2][n];	
double corner44[][]=new double[2][n];	
for(int i =0;i<n;i++){
	pointDesant[0][i]=myScanner.nextDouble();
	pointDesant[1][i]=myScanner.nextDouble();
	corner11[0][i]=myScanner.nextDouble();
	corner11[1][i]=myScanner.nextDouble();
	
	corner22[0][i]=myScanner.nextDouble();
	corner22[1][i]=myScanner.nextDouble();
	
	corner33[0][i]=myScanner.nextDouble();
	corner33[1][i]=myScanner.nextDouble();
	
	corner44[0][i]=myScanner.nextDouble();
	corner44[1][i]=myScanner.nextDouble();
}
int ans[]=new int[1];






for(int i=0;i<n;i++){
	double pointDesant0[]=new double[2];
	double corner1[]=new double[2];		
	double corner2[]=new double[2];
	double corner3[]=new double[2];	
	double corner4[]=new double[2];	
for(int y=0;y<2;y++){
	pointDesant0[y]=pointDesant[y][i];
	corner1[y]=corner11[y][i];
	corner2[y]=corner22[y][i];
	corner3[y]=corner33[y][i];
	corner4[y]=corner44[y][i];
}
ans=FindAns(pointDesant0,corner1,corner2,corner3,corner4,ans)	;




}


System.out.print(ans[0]);

	}

	private static int[] FindAns(double[] pointDesant0, double[] corner1,
			double[] corner2, double[] corner3, double[] corner4, int[] ans) {
		
		boolean yes =PointInCorner(pointDesant0,corner1,corner2,corner3,corner4,ans);
		if(yes){
			ans[0]+=1;	
			return ans;
		}
		
		
		
double q1 = FindVector(corner1[0],corner1[1],pointDesant0[0],pointDesant0[1],corner2[0],corner2[1]);
double q2 = FindVector(corner2[0],corner2[1],pointDesant0[0],pointDesant0[1],corner3[0],corner3[1]);
double q3 = FindVector(corner3[0],corner3[1],pointDesant0[0],pointDesant0[1],corner4[0],corner4[1]);
double q4 = FindVector(corner4[0],corner4[1],pointDesant0[0],pointDesant0[1],corner1[0],corner1[1]);
		
double q=q1+q2+q3+q4;	
if(q<0)
	q=-q;
if(q>359.9999 &q<360.00001)
	ans[0]+=1;



		return ans;
	}

	private static boolean PointInCorner(double[] pointDesant0,
			double[] corner1, double[] corner2, double[] corner3,
			double[] corner4, int[] ans) {
if(pointDesant0[0]==corner1[0] & pointDesant0[1]==corner1[1])
	return true;
if(pointDesant0[0]==corner2[0] & pointDesant0[1]==corner2[1])
	return true;
if(pointDesant0[0]==corner3[0] & pointDesant0[1]==corner3[1])
	return true;
if(pointDesant0[0]==corner4[0] & pointDesant0[1]==corner4[1])
	return true;	
		return false;
	}

	private static double FindVector(double x1, double y1, double x2, double y2,
			double x3, double y3) {

		double q=Findcorner1(x2-x1,y2-y1,x3-x2,y3-y2);
		
		
		
		return q;
	}

	private static double Findcorner1(double Ax, double Ay, double Bx, double By) {
double corner=(Ax*Bx+Ay*By);
double drob=Math.sqrt(Ax*Ax+Ay*Ay)*Math.sqrt(Bx*Bx+By*By);
corner/=drob;
corner=Math.acos(corner);

		
		return Math.toDegrees(corner);
	}

}
