import java.util.ArrayList;


public class StepRUBKA {

	public static String[][] Rubka(String[][] a, String str, int n) {
		int start[]=new int[2];  //0 -первый указатель по цифрам, 1-второй указатель по цифрам		
		int end[]=new int[2];
//		int between[][]=new int[2][20];
		String[] words=str.split("\\:");
		start =FindNumberHere(words[0],start);
		String old=a[start[0]][start[1]];
		a[start[0]][start[1]]="*";
		
for(int i=0;i<n;i++){
	
	start =FindNumberHere(words[i],start);
	end =FindNumberHere(words[i+1],end);
	old=MaybeInDamka(end,old);
	
	if(i==n-1)
		a[end[0]][end[1]]=old;

a=FindBetweenWichEning(start[0],start[1],end[0],end[1],a);
startt.printA(a);
	
}

		
		return a;
	}

	private static String MaybeInDamka(int[] end, String old) {
if((old.equals("w") & end[0]==8)|(old.equals("b") & end[0]==1))
	old=old.toUpperCase();

		
		return old;
	}

	private static  String[][] FindBetweenWichEning(int y0, int x0, int y1, int x1, String[][] a) {
		ArrayList<Integer> listWork = new ArrayList<Integer>();
int plus=FindPlusMinus( y0, x0, y1,  x1);
	if(plus==0){
		int yyy=5/0;
	}
	int xxx=1;
	int yyy=1;
	if(plus==3 | plus==2)
		xxx=-1;
	if(plus==3 | plus==4)
		yyy=-1;
	int n=x1-x0;
	if(n<0)
		n=-n;
	for(int i=1;i<n;i++){
		x0+=xxx;
	y0+=yyy;
		a[y0][x0]="*";
	
	}
		
		
		
return a;
	}


	private static int FindPlusMinus(int y0, int x0, int y1, int x1) {
if(x1>x0 &y1>y0)
return 1;

if(x1<x0 &y1>y0)
return 2;
		
if(x1<x0 &y1<y0)
return 3;	

if(x1>x0 &y1<y0)
return 4;	
		return 0;
	}

	private static int[] FindNumberHere(String string, int[] start) {
		start[0] = Integer.parseInt(""+string.charAt(1));
		start[1] = Steps.FindNumber(""+string.charAt(0));
		
		

		
		return start;
	}

}
