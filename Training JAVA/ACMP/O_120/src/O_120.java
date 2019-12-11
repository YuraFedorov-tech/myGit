import java.util.ArrayList;
import java.util.Scanner;


public class O_120 {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int m = myScanner.nextInt();
		int costStep[][]=new int[n+2][m+2];
		int price[][]=new int[n+2][m+2];
		costStep=Helping.DoNew(costStep);
		price=Helping.DoNewMinus1(price);
	
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(price[0].length+1);
	//	ArrayList<Integer> listSumma = new ArrayList<Integer>();
		
		
	//	System.out.println(	);
	 //   Printing.pr1(costStep);
		
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<m+1;j++)
				costStep[i][j]=myScanner.nextInt();
	//	System.out.println(	);
	//	Printing.pr1(costStep);
		price[1][1]=costStep[1][1];
	//	Printing.pr2(price);
		price=Work.FindSumma(costStep,price,list);
	//	Printing.pr2(price);
		
		System.out.print(	price[n][m]);
		
	}

}
