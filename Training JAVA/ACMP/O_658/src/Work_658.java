import java.util.ArrayList;


public class Work_658 {

	public static boolean FIND_Googtriangle_orNo(
			int x1, int y1, int x2, int y2, int x3, int y3, int[][] coordinat, boolean[] buzy, int first) {
		 // если правда то тругольник хороший и в нем деревьев нет
boolean needCountTrangle=true;
double SqwearTrangle=0;

		for(int i=first+1;i<coordinat.length;i++){
			 
	int findOrNo=Find_findOrNo(buzy,coordinat,x1,x2,x3,y1,y2,y3,i);
//	 System.out.print(findOrNo+"\t");
	// 0 - берем следущую точку
	// 1
	//2- треугольник хороший, надо добовлять
	//3-   2 дерева совпадают какаято хрень
	//4-надо считать площади
	switch (findOrNo){
	case 0: continue;
	case 2:return true;
	case 4:break;	
	default: System.out.println("mistake");
	}
	if(needCountTrangle){
		SqwearTrangle=FindSqwear(x1,y1,x2,y2,x3,y3);
		needCountTrangle=false;
	}
	boolean GoodTrangle=Find_GoodTrangle_Sqwear(x1,x2,x3,y1,y2,y3,coordinat[i][0],coordinat[i][1],SqwearTrangle);
	//если правда значит точка не лежит в треугольнике и надо делать continue;
	// если ложь значит надо return false
	if(GoodTrangle){
		continue;
	}else
		return false;
	
}
	
	
		
		
		
		
		return true;
	}
	
	
	 private static boolean Find_GoodTrangle_Sqwear(int x1, int x2, int x3,
			int y1, int y2, int y3, int xTree, int yTree, double sqwearTrangle) {
		 
			//если правда значит точка не лежит в треугольнике и надо делать continue;
			// если ложь значит надо return false
			
		 double sqwear1=FindSqwear(x1,y1,xTree,yTree,x2,y2);
		 double sqwear2=FindSqwear(x2,y2,xTree,yTree,x3,y3);
		 double sqwear3=FindSqwear(x1,y1,xTree,yTree,x3,y3); 
		 double summa=sqwear1+sqwear2+sqwear3;
		 int delta=(int) (1000*(sqwearTrangle-summa));
		 delta/=1000;
		 if(delta==0)
				return false;
			 
		return true;
	}


	static double FindSqwear(int x1, int y1, int x2, int y2, int x3,
				int y3) {

			double a = FindSqwearIn_sqwear(x1, y1, x2, y2);
			double b = FindSqwearIn_sqwear(x2, y2, x3, y3);
			double c = FindSqwearIn_sqwear(x3, y3, x1, y1);

			double sqwear = a+b+c;
			if(sqwear<0)
				sqwear=-sqwear;
			return sqwear;
		}
		private static double FindSqwearIn_sqwear(double x1, double y1, double x2, double y2) {
			double sqwear=0;
			//y1+=20000;
			//y2+=20000;

			sqwear=(x2-x1)*(y2+y1)/2;

					
					
					return sqwear;
				}
				
	
	
	
	private static int Find_findOrNo(boolean[] buzy, int[][] coordinat, int x1,
			int x2, int x3, int y1,int y2 ,int y3, int i) {
		// 0 - берем следущую точку
		// 1
		//2- треугольник хороший, надо добовлять
		//3-   2 дерева совпадают какаято хрень
		//4-надо считать площади
		if(buzy[i] )
			return 0;
	//	if(coordinat[i][0]<x1)
	//		return 0;
		
	
		if(coordinat[i][0]>=x3)
			return 2;
		
		boolean CountTR=Find_CountTR(y1,y2,y3,coordinat[i][1]);
		// если правда то тоыка находится в прямоугольнике треугольника
		// и возращаем 4
			if(CountTR)	{
				return 4;
			}else
					return 0;
		
		//return 3;
	}

	private static boolean Find_CountTR(int y1, int y2, int y3, int yPoint) {
// если правда то тоыка находится в прямоугольнике треугольника
// и возращаем 4
		int yMin=Math.min(y1, y2);
		 yMin=Math.min(yMin,y3);
		 
		 int yMax=Math.max(y1, y2);
		 yMax=Math.max(yMax,y3); 
		 if(yPoint>yMin &yPoint<yMax)
			 return true;
		 
		return false;
	}

}
