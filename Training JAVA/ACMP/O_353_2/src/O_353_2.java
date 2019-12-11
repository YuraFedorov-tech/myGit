

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Scanner;

	public class O_353_2 {// Main

		public static void main(String[] args) {
			Scanner myScanner = new Scanner(System.in);

			int n = myScanner.nextInt();
			// System.out.print(ans[0]);
			// ArrayList<String> list = new ArrayList<String>();
			// int ans[]=new int[1];
			// System.out.print(ans[0]);
			ArrayList<Integer> list = new ArrayList<Integer>();
			int ans[] = new int[1];
			double sqwear=0;
			for (int i = 0; i < n; i++)
				list.add(myScanner.nextInt());
			Collections.sort(list);
			MinusList(list,ans);
			if(ans[0]!=1000){
			 sqwear=FindSqwear(list.get(list.size()-1),list.get(list.size()-2),list.get(list.size()-3));
			
			 
			 
			}

			System.out.print(sqwear);
		}

		private static double FindSqwear(Integer aa, Integer bb,
				Integer cc) {
		double a=(double)aa;
		double b=(double)bb;
		double c=(double)cc;
			
	double p=(a+b+c)/2;
	double s=p*(p-a)*(p-b)*(p-c);
	s=Math.sqrt(s);
			
			return s;
		}

		private static void MinusList(ArrayList<Integer> list, int[] ans) {
	for(int i=0;i<=list.size()-3;i++){
		if(list.get(i+2)<=list.get(i)+list.get(i+1))
			continue;
		list.remove(i+2);
		
		
	}

	ans[0]=1000;		
			
			
		}

	}
