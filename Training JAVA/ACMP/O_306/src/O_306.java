import java.util.ArrayList;
import java.util.Scanner;


public class O_306 {
	public static void main(String[] args) {
	Scanner o = new Scanner(System.in);
	int n=o.nextInt();
	ArrayList<Integer> b = new ArrayList<Integer>();
	ArrayList<Integer> e = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		if(i%2==0){
			b.add(1);
		}else
			b.add(0);
	while(b.size()!=0){
		int t=b.size()-1;
		e.add(0,b.get(t));
		b.remove(t);
		if(t!=0){
			int u=e.size()-1;
			e.add(0, e.get(u));
			e.remove(u+1);
		}
		
	}
	
	for(int i=0;i<n;i++)
		if(e.get(i)==1){
			System.out.print("B");
		}else
			System.out.print("R");
	
	
}




}