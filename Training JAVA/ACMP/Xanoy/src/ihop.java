
public class ihop {

	public static void main(String[] args) {


	Hanoy(3,1,3);
	
	
	
	
	
	
		
		
		

	}

	static void Hanoy(int n, int i,int j){
	
		if(n!=0){
		Hanoy (n-1,i,6-i-j);
		System.out.println(i + " - "+j);
		
		Hanoy (n-1,6-i-j,j);
		}
	}
	
}
