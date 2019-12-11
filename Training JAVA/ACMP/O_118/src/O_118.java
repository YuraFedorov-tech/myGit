import java.util.ArrayList;
import java.util.Scanner;


public class O_118 {
	public static void main(String[] args) {
	Scanner M = new Scanner(System.in);
	int n = M.nextInt();
	int k = M.nextInt();
	B(n,k);
}

	private static void B(int n, int k) {
		if(n==0 ){
			System.out.println(n);
			return;
		}
		if(k==1 ){
			System.out.println(n);
			return;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index=1;
		list.add(1);
		list.add(0);
if(k%2==0){
	//list.add(0);
	index=1;
}
n--;
while(n--!=1){
	index++;
	index-=k;
	int h=list.size();
	while(index<=0)
		index+=h;
	//index--;
	if(index==h){
		index=h;
		list.add(0);
	}else
		list.add(index,0);
//	System.out.print(list+"\t");
	//System.out.println(index);
	
}
int ans=list.size()-index+k;
while(ans>list.size()){
if(ans>list.size())
	ans-=list.size();
}
//System.out.print(list+"\t");
//System.out.println(index);
		System.out.println(ans);
	}
}