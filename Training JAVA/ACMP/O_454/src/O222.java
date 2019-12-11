import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class O222 {
	public static void main(String[] args) {

		Scanner M = new Scanner(System.in);
		int n = M.nextInt();
		int m = M.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = n; i <= m; i++)
			list.add(i);
		
		
B(list);
System.out.print( list.get(0));
if(list.size()!=1)
	System.out.print("asdrfg");

	}



	private static void B(ArrayList<Integer> list) {
		int r=0;
	while(list.size()!=1){
		System.out.println(list);
		if(r++%2==0){
			// удаляем цифры с нечетных мест
			minusNECHET(list,0);
		}else
			minusNECHET(list,1);
			
	}
		
	}

	private static void minusNECHET(ArrayList<Integer> list, int j) {
		// удаляем цифры с нечетных мест
		//а это четные показатели
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=j;i<list.size();i+=2)
		l.add(i);
		for(int i=l.size()-1;i>=0;i--){
			int x=l.get(i);
			list.remove(x);
		}
	}
}
