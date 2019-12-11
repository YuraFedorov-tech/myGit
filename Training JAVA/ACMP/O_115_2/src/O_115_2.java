import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class O_115_2 { //Main

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		int y = myScanner.nextInt();
		int x = myScanner.nextInt();
		int[][] a = new int[y][x];
		for (int i = 0; i < y; i++)
			for (int j = 0; j < x; j++)
				a[i][j] = myScanner.nextInt();
	//Printing.Pr(a);
		
		int[]count = new int[x+1];
	//	Printing.Pr(a);
		Helping H=new Helping(a);
		int ans[]=new int[2];
	    ans=Helping.Find_SummaMax(0,0,y-1,x-1,ans,a);// если ans[0]=1ж то все элементы больше
	    ArrayList<Integer> listBigRectangle = new ArrayList<Integer>();
	    listBigRectangle=Helping.DoBeganList(listBigRectangle);
	    listBigRectangle.add(-100000);
	    int avswear=-1000000000;
	    ans[0]=-1000000000;
	    if(true)    {                                       	// или равны 0
	    	for (int i = 0; i <y; i++)
				for (int j = 0; j <x; j++){
					ans=Helping.BeganK(listBigRectangle,i,j,ans,count,a);
					if(ans[0]>avswear)
						avswear=ans[0];
				}
	    	 
	    	 
	     }
	//    System.out.println(listBigRectangle);
	//    System.out.println(ans[0]);
	    System.out.println(avswear);

	}
}