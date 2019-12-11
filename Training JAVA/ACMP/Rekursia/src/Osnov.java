import java.util.Scanner;


public class Osnov {

	public static void main(String[] args) {
		Scanner myScanner=new Scanner(System.in);
		System.out.print("введите длину лабиринта  х и у =");
		int x=myScanner.nextInt()+4;
		int y=myScanner.nextInt()+4;
		
		System.out.print("введите точку входа  х и у =");
		int Xenter=myScanner.nextInt()+4;
		int Yenter=myScanner.nextInt()+4;
		
		System.out.print("введите точку выхода  х и у =");
		int Xexit=myScanner.nextInt();
		int Yexit=myScanner.nextInt();
		
		int[][]Labirint;
		Labirint=new int[y][x];
		//int[] Point;
	//	Point=new int[4];
		int[] Point=   {Xenter,Yenter,Xexit,Yexit};
		
		PlusZabor Kon=new PlusZabor(Labirint,x,y,Point);
		//PlusZabor(int[][]Labirint, int x, int y,int[]Point ){
		Labirint=PlusZabor.Zabor1();
		PlusZabor.printLabirint();
		
		
	//	System.out.print("введите лабиринт ");
		System.out.print("введите лабиринт ");
		for (int i=0; i<y; i++){
			for (int j=0; j<x; j++){
				Labirint[i][j]=myScanner.nextInt();
			}
		}
		
		PlusZabor.printLabirint();
		
		
	}

}
