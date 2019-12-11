import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class tir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextInt();
		double m = sc.nextInt();
		int k = sc.nextInt();
        sc.close();
		double p=1/(n*m);	
		double q=1-p;
		double []a=new double[k];
		double mimo=0;
		double One=0;
		for (int i=0;i<k; i++){
			if (i==k-1){
				a[i]=1-One;
				continue;
			}
			mimo=p*Math.pow(q, i);
			a[i]=mimo;
			One+=a[i];
		}
		double Answear=0;
		
	
		
		for (int i=0;i<k; i++){
			
			Answear+=a[i]*(i+1);
			
			
		}
		Answear = new BigDecimal(Answear).setScale(13, RoundingMode.UP)
				.doubleValue();
		System.out.println(Answear);
	}

}
