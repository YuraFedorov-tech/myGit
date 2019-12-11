import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class wer {

	public static void main(String[] args) {
		long a[]=new long [15];
		long geron[]=new long [15];
		long Start1 = System.currentTimeMillis();
		for (int t = 0; t < 10000; t++) {
			for (int i = 10000; i <100000; i++) {
				int x1 = i;
				int x2 = i + 4;
				int x3 = i + 8;

				int y1 = i + 7;
				int y2 = i + 1;
				int y3 = i + 12;
				double sqwear = Work_wer.FindSqwear(x1, y1, x2, y2, x3, y3);
			
				
				
		
			}
	}
		
		
		
		long Start2 = System.currentTimeMillis();
		System.out.println(Start2 - Start1);
	
		
	
		for (int t = 0; t < 10000; t++) {
			for (int i = 10000; i <100000; i++) {
				int x1 = i;
				int x2 = i + 4;
				int x3 = i + 8;

				int y1 = i + 7;
				int y2 = i + 1;
				int y3 = i + 12;
				double sqwear = Work_Geron.FindSqwear(x1, y1, x2, y2, x3, y3);
			
			}
		}
	
		long Start3 = System.currentTimeMillis();
		System.out.println(Start3 - Start2);
	}

}
