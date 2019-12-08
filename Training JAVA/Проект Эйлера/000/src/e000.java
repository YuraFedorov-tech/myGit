
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class e000 {
	private static int a[][]=new int[4][4];
	public static void main(String[] args) {
rek(0,0);

		
		
	}

	private static void rek(int step, int j) {
		if(step==6) {
			if(Chek()) {
				pr();				
			}
			return;
		}
		for(int i=j;i<16;i++) {
			int y=i/4;
			int x=i-y*4;
			if(a[y][x]==1)
				continue;
			a[y][x]=1;
			rek(step+1,i);
			
			a[y][x]=0;
		}
		
		
		
		
		
	}

	private static void pr() {
		for(int i=0;i<4;i++) {						
			for(int j=0;j<4;j++) {
				System.out.print(a[i][j]+"\t");					
			}
			System.out.println();
		}	
		System.out.println();
	}

	private static boolean Chek() {
	if(vert())
		if(gor())
		return true;
	return false;
	}

	private static boolean gor() {
		for(int i=0;i<4;i++) {
			int q=0;			
			for(int j=0;j<4;j++) {
				if(a[i][j]==0)
					q++;
			}
			if(q%2!=0)
				return false;
		}
		return true;
	}


	private static boolean vert() {
		for(int i=0;i<4;i++) {
			int q=0;			
			for(int j=0;j<4;j++) {
				if(a[j][i]==0)
					q++;
			}
			if(q%2!=0)
				return false;
		}
		return true;
	}

}