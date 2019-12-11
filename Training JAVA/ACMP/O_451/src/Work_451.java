import java.util.ArrayList;

public class Work_451 {
	public static String DeleteBrackets(String s, ArrayList<Double> polynomial,
			double[] ans) {
		while (true) {
			int first_back_bracet = Helper_451.Find_first_back_brace(s);
			// если равно -1 значит нет
			if (first_back_bracet == -1)
				return s;
			int first_video_bracet = Helper_451.Find_first_video_brace(s,
					first_back_bracet);
			if (first_video_bracet == -1) {
				ans[0] = Double.MAX_VALUE;
				return s;
			}
			String []s1 = {s.substring(0, first_video_bracet)};
			String []s2 = {s.substring(first_back_bracet + 1, s.length())};
			String breket = s.substring(first_video_bracet+1, first_back_bracet);
			double q = Simple_expression_without_cos.began(breket,polynomial,ans);
			if (ans[0] == Double.MAX_VALUE) 				
				return s;
			
			
			q=Helper_451.Chek_cos_or_sinus(s1,q);			
			
			polynomial.add(q);
			s=s1[0]+"!"+Integer.toString(polynomial.size()-1)+s2[0];
			System.out.println(s);
			
		}

	}
}
