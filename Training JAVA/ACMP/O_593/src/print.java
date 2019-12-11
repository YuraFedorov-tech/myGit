import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class print {

     public static void pr(double[][] a) {
         System.out.println();
         for (int i1 = 0; i1 < 2; i1++) {
             for (int i = 0; i < a[0].length; i++) {
                 if (a[i1][i] < 10)
                     System.out.print(" ");
                 System.out.print(a[i1][i] + " ");

             }
             System.out.println();
         }

     }

     public static void pr(double[] extrenum) {
         System.out.println();
         for (int i = 0; i < extrenum.length; i++)
             System.out.print(extrenum[i] + " ");
             System.out.println();

     }

     public static void pr(double[][][] urav) {
         System.out.println();
         for (int i1 = 0; i1 < 2; i1++) {
             for (int i11 = 0; i11 < urav[0].length; i11++) {
                 for (int i111 = 0; i111 < urav[0].length; i111++) {
                     double newDouble = new 
BigDecimal(urav[i1][i11][i111]).setScale(2, RoundingMode.UP).doubleValue();
                     if (urav[i1][i11][i111] < 10)
                         System.out.print(" ");
                     System.out.print(newDouble + " ");
                 }
                 System.out.println();
             }
             System.out.println("b");
         }

     }

	   public static void pr(int[] extrenum) {
         System.out.println();
         for (int i = 0; i < extrenum.length; i++)
        	 System.out.print(i+1 + " ");
         System.out.println();
         for (int i = 0; i < extrenum.length; i++)
             System.out.print(extrenum[i] + " ");
             System.out.println();

     }
}
