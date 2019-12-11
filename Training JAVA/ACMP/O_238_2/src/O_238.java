import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O_238 { //Main

	public static void main(String[] args) {
		Scanner my = new Scanner(System.in);
		ArrayList<Long> list = new ArrayList<Long>();
		int n = my.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(my.nextLong());
		}
		double[] ans = new double[1];
		Collections.sort(list);
		ArrayList<Long> l_answ = new ArrayList<Long>();
		l_answ = find(ans, list,l_answ);
prinNew(l_answ,ans);


		//ans = printing(ans);

	}



	private static void prinNew(ArrayList<Long> l_answ, double[] ans) {
	for(int i=l_answ.size()-1;i>=0;i--){
		System.out.print(l_answ.get(i));
	}
		prinAns(ans);
	}



	private static void prinAns(double[] ans) {
		String str = Double.toString(ans[0]);
	while(str.length()<4){
		str+="0";
	}
		str=str.substring(1,4);
		System.out.print(str);
		
	}



	private static ArrayList<Long> find(double[] ans, ArrayList<Long> list, ArrayList<Long> l_answ) {

		while (true) {
			if (list.size() == 1)
				break;
			l_answ = plus(list, ans,l_answ);

		}
		

		return l_answ;
	}

	private static ArrayList<Long> plus(ArrayList<Long> list, double[] ans, ArrayList<Long> l_answ) {
		long u = list.get(0) + list.get(1);
		l_answ = procentit(ans, u,l_answ);

		list.remove(0);
		list.set(0, u);
		list = Sortirovat(list);

		return l_answ;
	}

	private static ArrayList<Long> procentit(double[] ans, long u, ArrayList<Long> l_answ) {
	double prom_ans=u * 0.05;
	l_answ=DlinArifm(l_answ,prom_ans,ans);
		

 
		return l_answ;
	}

	private static ArrayList<Long> DlinArifm(ArrayList<Long> l_answ, double prom_ans,
			double[] ans) {
int n=(int) prom_ans;
prom_ans-=n;
ans[0]+=prom_ans;
l_answ=plus_n(l_answ,n);		
		
		return l_answ;
	}



	private static ArrayList<Long> plus_n(ArrayList<Long> l_answ, int n) {
String str = Integer.toString(n);
ArrayList<Long> list = new ArrayList<Long>();
list=ToList_from_String(list,str);
l_answ=listPlusList(l_answ,list);	
		return l_answ;
	}







	private static ArrayList<Long> listPlusList(ArrayList<Long> l_answ,
			ArrayList<Long> list) {
if(l_answ.size()>=list.size()){
	l_answ=Plusit(l_answ,list);
}else
	l_answ=Plusit(list,l_answ);

		
		return l_answ;
	}



	private static ArrayList<Long> Plusit(ArrayList<Long> l_answ,
			ArrayList<Long> list) {
		int next=0;		
for(int i=0;i<=l_answ.size();i++){
	if(i==l_answ.size()){
		if(next==1)
			l_answ.add((long) 1);
		break;
	}
		
	long g=l_answ.get(i)+next;
	next=0;
	if(i<list.size())
		g+=list.get(i);
	if(g>9){
		g-=10;
		next=1;
	}
	l_answ.set(i, g);	
	
	
}

		
		return l_answ;
	}



	private static ArrayList<Long> ToList_from_String(ArrayList<Long> list,
			String str) {
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(str.length()-1-i);
			
			list.add((long) (ch-'0'))	;
		}
		return list;
	}



	private static ArrayList<Long> Sortirovat(ArrayList<Long> list) {
		Collections.sort(list);

		return list;
	}



	
}
