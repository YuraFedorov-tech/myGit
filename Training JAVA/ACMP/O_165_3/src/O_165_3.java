import java.math.BigInteger;
import java.util.ArrayList;


public class O_165_3 {
	public static void main(String[] args) {
		int coordinat[][] = Input_165.Input();
		int y=coordinat.length;
		int x=coordinat[0].length;
		//int [] ans={0};
		int[][] NumberOfSteps=new int [y][x];
		ArrayList<Integer> list = new ArrayList<>(); // шаги
		list.add(0);
		int[][] MatricaSmegnosti=new int [y*x][140];
		coordinat[y-1][x-1]=555;
		prin_165.prinUsulyMassiv(coordinat);
		MatricaSmegnosti=Work_165.Find_MatricaSmegnosti(MatricaSmegnosti,list,NumberOfSteps,coordinat);
	
	//	prin_165.prinUsulyMassiv(coordinat);
		prin_165.prinUsulyMassiv(NumberOfSteps);
		prin_165.prinUsulyRebra(MatricaSmegnosti);
		BigInteger sum  = BigInteger.valueOf(0);
		sum=Helper_165.Rekursia(sum,MatricaSmegnosti,(y-1)*x+x-1,0);
		
		System.out.println(sum);
	}
}
