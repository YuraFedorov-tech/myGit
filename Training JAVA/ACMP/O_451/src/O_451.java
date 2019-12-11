import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class O_451 {

	public static void main(String[] args) {

		Scanner my = new Scanner(System.in);
		String s = my.nextLine();
		
		double []ans={0};
		if(s.equals(" ")){
			ans[0]=Double.MAX_VALUE;
		}else
			s=s.trim();
		
    //    s=Helper_451.DeleteSpace(s);
    //    System.out.println(s);
        ArrayList<Double> polynomial  = new ArrayList<>();
		ArrayList<String> znak = new ArrayList<>();
		
        s=Work_451.DeleteBrackets(s,polynomial,ans);
        double q =0;
        if(ans[0]!=Double.MAX_VALUE)
    // 	System.out.println("Error");
         q = Simple_expression_without_cos.began(s,polynomial,ans);
        if(ans[0]==Double.MAX_VALUE){
        	if(!s.equals(" "))
             	System.out.println("Error");
        }else{
        	double newDouble = new BigDecimal(q).setScale(3, RoundingMode.UP).doubleValue();
            if(newDouble==(int)newDouble){
            	 System.out.println((int) newDouble);
            }else
            System.out.println( newDouble);
        }
        	;
	}

}
