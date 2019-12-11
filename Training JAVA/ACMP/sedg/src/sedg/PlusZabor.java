package sedg;

public class PlusZabor {

	static int[][]Labirint;
	static int x;
	static int y;
	static int[]Point;
	
	
	PlusZabor(int[][]Labirint, int x, int y,int[]Point ){
		this.x=x;
		this.y=y;
		this.Labirint=Labirint;
		this.Point=Point;
	}
	static int[][] Zabor1(){
		for (int i=0; i<y; i++){
			for (int j=0; j<x; j++){
				Labirint[i][j]=1;
			}
		}
//		Labirint[Point[1]][Point[0]]=9;   // точка входа
//		Labirint[Point[3]][Point[2]]=9;   // точка выхода
		
		return Labirint;
		
	}
	

	static void printLabirint(){
		System.out.println();
		for (int i=0; i<y; i++){
			for (int j=0; j<x; j++){
				System.out.print(Labirint[i][j]);
			}
			System.out.println();
		}
			
	}

	static boolean findExit(int[][]Labirint, int[] XXX,int[] YYY, int Xenter, int Yenter ){ 
		boolean b=false;
		
		for (int i=0; i<4;i++){
			if (Labirint[Yenter+YYY[i]][Xenter+XXX[i]]==5){
				System.out.print("точку выхода нашли!");
				b=true;
			}
		}
		
		
		return b;
	}
	
	
}
