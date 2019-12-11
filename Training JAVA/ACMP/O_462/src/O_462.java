import java.util.Scanner;

public class O_462 {
	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
		
B(u.nextInt());
		
	}

	private static void B(int n) {
int ans=0;
int three=1;
int fife=2;
for(int i=0;i<n;i+=2){
	three++;fife++;
	if(three==3){
		three=0;
		if(fife==5)
			fife=0;
		continue;
	}
	if(fife==5){
		fife=0;
	continue;
	}
	ans++;
}

	System.out.println(ans);
	}

	
}