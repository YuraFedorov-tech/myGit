package sef;

public class jhg {

	public static void main(String[] args) {
		int n=0;
		
f(1,n);


		
		
	}

	
	static void f(int x, int n){
		n+=1;
		System.out.print(x+" ");
		System.out.println(n+" ");
		if (x<40){
			f(2*x,n);
		}
		System.out.print(x+" ");
	}
}
