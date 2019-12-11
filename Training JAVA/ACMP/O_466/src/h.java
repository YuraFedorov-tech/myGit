
public class h {

	public static int began(int n) {
	   
	    	 if(n==0)return 0; 
	    	 if(n==1)return 1; 
	    	 if(n%2==0)return began(n/2); 
	    	 return began(n/2)+began(n/2+1); 


	    	 }
		
	}


