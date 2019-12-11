import java.util.ArrayList;
import java.util.Arrays;

public class Helper_582 {

	public static ArrayList<Integer> FindeOneFrom6(int integ,
			ArrayList<Integer> one, ArrayList<Integer> oneNew) {

		switch (integ) {
		case 0:
			oneNew.addAll(one);
			break;
		case 1:
			oneNew.addAll(one);
			ChangeTwoNumber(oneNew, 0, 1);
			break;
		case 2:
			Change2Forward(oneNew,  one,2,3,1,0,4,5);
			break;
		case 3:Change2Forward(oneNew,  one,3,2,0,1,4,5);
			break;
		case 4:Change2Forward(oneNew,  one,4,5,2,3,1,0);
		break;
		case 5:Change2Forward(oneNew,  one,5,4,2,3,0,1);
		break;
			
		}

		return oneNew;
	}



	private static void Change2Forward(ArrayList<Integer> oneNew,
			ArrayList<Integer> one, int x0,int x1, int x2, int x3, int x4, int x5 ) {
		oneNew.add(one.get(x0));
		oneNew.add(one.get(x1));
		oneNew.add(one.get(x2));
		oneNew.add(one.get(x3));
		oneNew.add(one.get(x4));
		oneNew.add(one.get(x5));
		
	}




	private static void ChangeTwoNumber(ArrayList<Integer> oneNew, int first,
			int second) {
		int x = oneNew.get(first);
		oneNew.set(first, oneNew.get(second));
		oneNew.set(second, x);

	}



	public static void prChekNew(ArrayList<Integer> chekNew) {
		for(int i=0;i<6;i=i+2)
			System.out.print(chekNew.get(i)+chekNew.get(i+1)+"\t");
		System.out.println();
		
	}



	public static ArrayList<Integer> FindOneFromFour(ArrayList<Integer> one,
			int integ, ArrayList<Integer> oneNew) {
		switch (integ) {
		case 0:
			oneNew.addAll(one);
			break;
		case 3:
			ChangePovorot(oneNew,  one);	
		case 2:
			ChangePovorot(oneNew,  one);
			
		
		case 1:
			ChangePovorot(oneNew,  one);
			break;
		
		}

		
		return oneNew;
	}



	private static void ChangePovorot(ArrayList<Integer> oneNew,
			ArrayList<Integer> one) {
		oneNew.add(one.get(0));
		oneNew.add(one.get(1));
		oneNew.add(one.get(5));
		oneNew.add(one.get(4));
		oneNew.add(one.get(2));
		oneNew.add(one.get(3));
	}



	public static ArrayList<Integer> DO_Chek(ArrayList<Integer> chek) {
	
		chek.add(1);
		chek.add(6);
		chek.add(3);
		chek.add(4);
		chek.add(5);
		chek.add(2);
		
		return chek;
	}

}
