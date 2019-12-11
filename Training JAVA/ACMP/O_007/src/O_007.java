import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class fru {
	int y;

	public fru(int n) {
		y = n;
	}

	public void Y() {
		System.out.println(y + 1);

	}

}
public class O_007 {
	

	

	public static void main(String[] args)  {

		 Scanner M = new Scanner(System.in);
		    int n = M.nextInt();
		    fru qw=new fru(n);
		    qw.Y();
}
}



