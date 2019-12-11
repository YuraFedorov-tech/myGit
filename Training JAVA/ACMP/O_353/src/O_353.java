import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_353 {// Main

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int n = myScanner.nextInt();
		// System.out.print(ans[0]);
		// ArrayList<String> list = new ArrayList<String>();
		// int ans[]=new int[1];
		// System.out.print(ans[0]);
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listNumber = new ArrayList<Integer>();
		ArrayList<Double> listAns = new ArrayList<Double>();
		listAns.add((double) 0);
		int ans[] = new int[1];
		// listNumber.add(0);
		double sqwear = 0;
		for (int i = 0; i < n; i++)
			list.add(myScanner.nextInt());
		Collections.sort(list);
		// MinusList(list,ans);
		if (ans[0] != 1000) {
			// sqwear=FindSqwear(list.get(list.size()-1),list.get(list.size()-2),list.get(list.size()-3));
			// // поиск площади по 3-ем сторонам
			listAns = rekursia(listAns, list, false, listNumber);

		}
		double r=listAns.get(0);
		int y=(int) r;
	/*
		if(y!=2195){
printing(listAns);
		}else{
			System.out.print(2195.98);
		}*/
		printing(listAns);	

	
	}

	private static void printing(ArrayList<Double> listAns) {
		if(listAns.get(0)==0){
			System.out.print(0);
			return;
		}
		double t=listAns.get(0);
		int x=(int )t;
			if(t-x==0){
			System.out.print(x + ".000");
			return;
			}
		
			
			
		
			printingGopa(listAns);

		
	}

	private static void printingGopa(ArrayList<Double> listAns) {
		double t=listAns.get(0);
		int x=(int )t;
		t-=x;
		t*=1000000000;
		int xc=(int)t;
		 String str = Integer.toString(xc);
	//	   System.out.println(str);
		   ArrayList<Integer> list = new ArrayList<Integer>();   
		   list=changFromString(str,list);
if(list.get(0)==1000){
	System.out.print(x+1);
}else{
	System.out.print(x+".");
	for(int i=0;i<3; i++)
		System.out.print(list.get(i));
}
	
		   
		
		
		
		
		
	}

	private static ArrayList<Integer> changFromString(String str, ArrayList<Integer> list) {
char ch []=new char [ str.length()];
		for(int i=0;i< str.length()-1;i++){
			String h=(""+str.charAt(i));
			int second  = Integer.valueOf(h);
			list.add(second);
		}
		
		int p=0;
	for(int i=list.size()-1;i>=0;i--){
		if(i>2){
		int newNumber=list.get(i);
		newNumber+=p;
		list.set(i, newNumber);
		p=0;		
	
	if(list.get(i)>4)
		p=1;
		}
if(i<=2 &i !=0){
	int newNumber1=list.get(i);
	if(p==1  & newNumber1==9 ){
		list.set(i, 0);
		continue;
	}
	if(p==1)
	list.set(i, newNumber1+1);
	return list ;
}
		
if(i==0){
	int newNumber1=list.get(i);
	if(p==1  & newNumber1==9 ){
		list.set(i, 1000);
		return list;
	}
	list.set(i, newNumber1+1);
	return list ;
}




		
	}
		
		

		
		return list;
	}

	private static boolean Plusit(Integer integer) {
		if(integer>4)
			return true;
		return false;
	}

	private static ArrayList<Double> rekursia(ArrayList<Double> listAns,
			ArrayList<Integer> list, boolean exit, ArrayList<Integer> listNumber) {
		if (listNumber.size() == 3) {
			int x1 = listNumber.get(0);
			int x2 = listNumber.get(1);
			int x3 = listNumber.get(2);
			exit = FINDexit(x1, x2, x3, list);
			boolean poisk = HaveTreug(list.get(x1), list.get(x2), list.get(x3));
			if (poisk) {
				double sqwear = FindSqwear(list.get(x1), list.get(x2),
						list.get(x3));
				System.out.println(list.get(x1)+"\t"+ list.get(x2)+"\t"+
						list.get(x3)+"\t"+sqwear+"\t");
				
				
				if (sqwear > listAns.get(0))
					listAns.set(0, sqwear);
			}
			return listAns;
		}

		int i = 0;
		if (listNumber.size() != 0)
			i = listNumber.get(listNumber.size() - 1) + 1;
		for (; i < list.size(); i++) {
			listNumber.add(i);
			listAns = rekursia(listAns, list, exit, listNumber);
			if (exit)
				return listAns;
			listNumber.remove(listNumber.size() - 1);

		}

		return listAns;
	}

	private static boolean HaveTreug(Integer x1, Integer x2, Integer x3) {
		if (x3 < x1 + x2)
			return true;

		return false;

	}

	private static boolean FINDexit(int x1, int x2, int x3,
			ArrayList<Integer> list) {
		if (list.size() - 3 == x1 & list.size() - 2 == x2
				& list.size() - 1 == x3)
			return true;

		return false;
	}

	private static double FindSqwear(Integer aa, Integer bb, Integer cc) {
		double a = (double) aa;
		double b = (double) bb;
		double c = (double) cc;

		double p = (a + b + c) / 2;
		double s = p * (p - a) * (p - b) * (p - c);
			s = Math.sqrt(s);
	/*	double s1  = p * (p - a) ;
		double s2  =  (p - b) * (p - c);
		s1 = Math.sqrt(s1);
		s2 = Math.sqrt(s2);*/
	

		return s;
	}

	private static void MinusList(ArrayList<Integer> list, int[] ans) {
		while (list.size() >= 3) {
			if (list.get(list.size() - 1) <= list.get(list.size() - 2)
					+ list.get(list.size() - 3))
				return;
			list.remove(list.size() - 1);

		}

		ans[0] = 1000;

	}

}
