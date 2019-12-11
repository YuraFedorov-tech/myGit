import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class O_364_ { //Main

	public static void main(String[] args) {
		String aa = "6, 28, 496, 8128, 33550336, 8589869056, 137438691328, 2305843008139952128";
		String[] a = aa.split(", ");
		Scanner my = new Scanner(System.in);
		String g = my.nextLine();
		String[] aaaa = g.split(" ");
		String	n=aaaa[0];
		String m=aaaa[1];
		n=n.trim();
		m=m.trim();

		List<Integer> list1 = Arrays.asList(new Integer[] { 6 });
		List<Integer> list2 = Arrays.asList(new Integer[] { 2, 8 });
		List<Integer> list3 = Arrays.asList(new Integer[] { 4, 9, 6 });
		List<Integer> list4 = Arrays.asList(new Integer[] { 8, 1, 2, 8 });
		List<Integer> list5 = Arrays.asList(new Integer[] { 3, 3, 5, 5, 0, 3,
				3, 6 });
		List<Integer> list6 = Arrays.asList(new Integer[] { 8, 5, 8, 9, 8, 6,
				9, 0, 5, 6 });
		List<Integer> list7 = Arrays.asList(new Integer[] { 1, 3, 7, 4, 3, 8,
				6, 9, 1, 3, 2, 8 });
		List<Integer> list8 = Arrays.asList(new Integer[] { 2, 3, 0, 5, 8, 4,
				3, 0, 0, 8, 1, 3, 9, 9, 5, 2, 1, 2, 8 });
int [][]a1=new int [8][20];
	a1[0]=findFrom_list1(a1,0,list1);
	a1[1]=findFrom_list1(a1,1,list2);
	a1[2]=findFrom_list1(a1,2,list3);	
	a1[3]=findFrom_list1(a1,3,list4);	
	a1[4]=findFrom_list1(a1,4,list5);	
	a1[5]=findFrom_list1(a1,5,list6);	
	a1[6]=findFrom_list1(a1,6,list7);	
	a1[7]=findFrom_list1(a1,7,list8);	
		
		ArrayList<Integer> nn = new ArrayList<Integer>();
		ArrayList<Integer> mm = new ArrayList<Integer>();
		nn = findList(n, nn);
		mm = findList(m, mm);
//
	//	System.out.print(nn);
	//	System.out.print(mm);

		int find=Find_begin(nn,a1,1);
//		System.out.println(find);
		int end=Find_end(mm,a1);
//		System.out.println(end);
		boolean more=false;
		
		   more=morer(nn,mm);
		   if(!more)
				more=moreYet(mm);
		if((a1[0][0]==1 &a1[0][1]<6) | end<find |more ){
			System.out.println("Absent");
		}
		else
			printlin(find,end,a1);
	}

	private static boolean moreYet(ArrayList<Integer> mm) {
if(mm.size()==1)
	if(mm.get(0)<6)
		return true;
		return false;
	}

	private static boolean morer(ArrayList<Integer> nn, ArrayList<Integer> mm) {
if(nn.size()>mm.size())
	return true;
if(nn.size()<mm.size())
	return false;

		for(int i=0;i<nn.size();i++){
		if(nn.get(i)<mm.get(i))
			return false;
		if(nn.get(i)>mm.get(i))
			return true;;
		
	}
		return false;
	}

	private static void printlin(int find, int end, int[][] a1) {
for(int i=find;i<=end;i++){
	pr(a1,i);
}
		
	}

	private static void pr(int[][] a1, int n) {
	for(int i=1;i<a1[n][0]+1;i++){
		
		System.out.print(a1[n][i]);
	
	}
	System.out.println();	
	}

	private static int Find_end(ArrayList<Integer> mm, int[][] a1) {
		int r=0;
		for(int i=a1.length-1;i>0;i--)	{
			if((mm.size()>a1[i][0]))
				return i;
			if(mm.size()==a1[i][0]){
				boolean t=moreOrNo_ENDING(mm,a1,i);
				
				if(t)
					return i;
				return i-1;
			}
			
			
		}
				return r;
			}

		

	private static boolean moreOrNo_ENDING(ArrayList<Integer> mm, int[][] a1,
			int n) {
		for(int i=0;i<mm.size();i++){
			if((a1[n][i+1]<mm.get(i)))
					return true;
			if(a1[n][i+1]==mm.get(i))
				continue;
			return false;
			}
				return true;
			}

	private static int Find_begin(ArrayList<Integer> nn, int[][] a1, int pokazatel) {
int r=0;
for(int i=0;i<a1[0].length;i++)	{
	if((pokazatel==1 &nn.size()<a1[i][0])|(pokazatel==-1 &nn.size()>a1[i][0]))
		return i;
	if(nn.size()==a1[i][0]){
		boolean t=moreOrNo(nn,a1,i,pokazatel);
		
		if(t)
			return i;
		return i+1;
	}
	
	
}
		return r;
	}

	
	private static boolean moreOrNo(ArrayList<Integer> nn, int[][] a1, int n, int pokazatel) {
for(int i=0;i<nn.size();i++){
	if((pokazatel==1 &a1[n][i+1]>nn.get(i)) |(pokazatel==-1 &a1[n][i+1]<nn.get(i)))
			return true;
	if(a1[n][i+1]==nn.get(i))
		continue;
	return false;
	}
		return true;
	}

	private static int[] findFrom_list1(int[][] a1, int n, List<Integer> list1) {
a1[n][0]=list1.size();
for(int i =0;i<list1.size();i++){

	a1[n][i+1]=list1.get(i);
}

		
		return a1[n];
	}

	private static ArrayList<Integer> findList(String n, ArrayList<Integer> nn) {
		for (int i = 0; i < n.length(); i++) {
			char ch = n.charAt(i);
			nn.add(ch - '0');
		}

		return nn;
	}

}
