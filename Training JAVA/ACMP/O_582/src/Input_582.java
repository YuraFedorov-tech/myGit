import java.util.ArrayList;
import java.util.Scanner;


public class Input_582 {

	public static ArrayList<Integer> input(ArrayList<Integer> one,
			ArrayList<Integer> two) {
		Scanner my = new Scanner(System.in);
	for(int i=0;i<6;i++)
		one.add(my.nextInt());
	for(int i=0;i<6;i++)
		two.add(my.nextInt());
		return one;
	}

}
