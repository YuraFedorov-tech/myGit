import java.util.ArrayList;
import java.util.Scanner;


public class O_695 {
	public static void main(String[] args) {
		Scanner j = new Scanner(System.in);

		int y[] = new int[2];
		int x[] = new int[2];
		String s = j.nextLine();
		s=s.trim();
String t[]=s.split(" ");
		for (int i = 0; i < 2; i++) {
			
			y[i] =8- Integer.parseInt("" + t[i].charAt(1))+1;
			x[i] = W("" + t[i].charAt(0));
		}

		Began(y, x);
}

	private static void Began(int[] y, int[] x) {
		ArrayList<Integer> list = new ArrayList<Integer>();
list.add(y[0]*9+x[0]);

int an=y[1]*9+x[1];
if(an==list.get(0)){
	System.out.println(0);
	return;
}
	
int a[][]=new int[9][9];
a[y[0]][x[0]]=1;
a[y[1]][x[1]]=-1;
int ans[]={-1,an};
		int step=0;
		while(list.size()!=0 & ans[0]==-1){
			step++;
			int o=list.size();
			ArrayList<Integer> listNew = new ArrayList<Integer>();
			for(int i=0;i<o;i++){
				go1(listNew,list,a,ans);
			
			}
			list.addAll(listNew);
	
		}
		
		if(ans[0]==1){
		System.out.println(step);
		}else
			System.out.println(-1);




	}

	private static boolean findAns(ArrayList<Integer> list, int an) {
		for(int i:list)
			if(i==an)
				return true;
		return false;
	}

	private static void go1(ArrayList<Integer> listNew, ArrayList<Integer> list,
			int[][] a, int[] ans) {
		int n=list.get(0);
		list.remove(0);
		
		// если правда то ходит как слон
		if((n%2==0)){
			goSlon(n,listNew,a,ans);
		}else{
			goHorse(n,listNew,a,ans);
		}
		
	}



	private static void goHorse(int n, ArrayList<Integer> listNew, int[][] a, int[] ans) {
		int yOld=n/9;
		int xOld=n-yOld*9;
		
		int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
for(int i=0;i<8;i++){
	
	int y = yOld + Y[i];
	int x = xOld + X[i];
	if (y > 8 | y < 0 | x > 8 | x < 0  )
		continue;
	if(a[y][x]!=0 & a[y][x]!=-1)
		continue;
	a[y][x]=1;
	Insid(listNew,y,x,ans);	

}	
	}

	private static void goSlon(int n, ArrayList<Integer> listNew, int[][] a, int[] ans) {
		int yOld=n/9;
		int xOld=n-yOld*9;
	//	chek(yOld,xOld,a,ans);
		
		for(int i=1;i<9;i++){
			int y=yOld+i;
			int x=xOld+i;
			if(y<0 | x<0 |y>8 |x>8)
			break;
			
		if(a[y][x]!=0 & a[y][x]!=-1)
			continue;
			a[y][x]=1;
			Insid(listNew,y,x,ans);			
		}
		for(int i=1;i<9;i++){
			int y=yOld+i;
			int x=xOld-i;
			if(y<0 | x<0 |y>8 |x>8)
			break;
			if(a[y][x]!=0 & a[y][x]!=-1)
			continue;
			a[y][x]=1;
			Insid(listNew,y,x,ans);			
		}
		
		for(int i=1;i<9;i++){
			int y=yOld-i;
			int x=xOld+i;
			if(y<0 | x<0 |y>8 |x>8)
			break;
			if(a[y][x]!=0 & a[y][x]!=-1)
			continue;
			a[y][x]=1;
			Insid(listNew,y,x,ans);			
		}
		for(int i=1;i<9;i++){
			int y=yOld-i;
			int x=xOld-i;
			if(y<0 | x<0 |y>8 |x>8)
			break;
			if(a[y][x]!=0 & a[y][x]!=-1)
			continue;
			a[y][x]=1;
			Insid(listNew,y,x,ans);			
		}
		
	}

	private static void chek(int yOld, int xOld, int[][] a, int[] ans) {
		int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	int n=yOld*9+xOld;
	if(n%2==0)
		return;

		for(int i=0;i<8;i++){
	
	int y = yOld + Y[i];
	int x = xOld + X[i];
	if (y > 8 | y < 0 | x > 8 | x < 0  )
		continue;
	
	
	if( a[y][x]==-1 )
		ans[0]=1;
	
}
		
	}

	private static void Insid(ArrayList<Integer> listNew, int y, int x, int[] ans) {
		int n=y*9+x;

		if(ans[1]==n)
			ans[0]=1;
		
		for(int i:listNew)
		if(i==n)
			return;
	listNew.add(n);
		
	}

	public static int W(String string) {
		switch(string){
		case "I": return  8;
		case "H": return  7;
		case "G": return  6;
		case "F": return  5;
		case "E": return  4;
		case "D": return  3;
		case "C": return  2;
		case "B": return  1;
		case "A": return  0;
		
		}
	
		
		
		return 9;
	}
}