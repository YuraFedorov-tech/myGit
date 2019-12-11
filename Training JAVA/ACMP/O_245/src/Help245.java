import java.util.ArrayList;


public class Help245 {

	public static long BB(ArrayList<Long> list, int j, int n, int leftIndex,
			int rightIndex) {
boolean g=Chek(list,leftIndex,rightIndex);
if(g)
	return Count(list,leftIndex,rightIndex);

long leftDelete =FindLEF_DELETE(list,  j,  n,  leftIndex,rightIndex);
long rightDelete =FindRIGHT_DELETE(list,  j,  n,  leftIndex,rightIndex);
if(leftDelete>=rightDelete)
	return leftDelete;



		return rightDelete;
	}

	private static long FindRIGHT_DELETE(ArrayList<Long> list, int j, int n,
			int leftIndex, int rightIndex) {
		long max=0;
	for(int i=0;i<rightIndex-j;i++){
	if(i!=0)
		if(list.get(rightIndex-i)==list.get(rightIndex-i+1))
			continue;
		long a=FindSummaRight(list,leftIndex,rightIndex-i,j);
		if(a>max)
			max=a;
	}
		
		return max;
	}

	private static long FindSummaRight(ArrayList<Long> list, int leftIndex,
			int rightIndex, int j) {
		boolean g=Chek(list,leftIndex,rightIndex);
		if(g)
			return Count(list,leftIndex,rightIndex);
		while(j!=leftIndex){
			leftIndex++;
			if(Chek(list,leftIndex,rightIndex))
				return Count(list,leftIndex,rightIndex);
		}
			
		
		
		return 0;
	}

	private static long FindLEF_DELETE(ArrayList<Long> list, int j, int n,
			int leftIndex, int rightIndex) {
		long max=0;
	for(int i=1;i<=j-leftIndex;i++){
		if(i!=0)
			if(list.get(leftIndex+(i))==list.get(leftIndex+(i)-1))
				continue;
		long a=FindSummaLeft(list,leftIndex+(i),rightIndex,j);
		if(a>max)
			max=a;
	}
		
		return max;
	}

	private static long FindSummaLeft(ArrayList<Long> list, int leftIndex, int rightIndex, int j) {
		boolean g=Chek(list,leftIndex,rightIndex);
		if(g)
			return Count(list,leftIndex,rightIndex);
		
while(j!=rightIndex){
	rightIndex--;
	if(Chek(list,leftIndex,rightIndex))
		return Count(list,leftIndex,rightIndex);
}
		
		return 0;
	}

	private static long Count(ArrayList<Long> list, int leftIndex,
			int rightIndex) {
		long a=0;
		for(int i=leftIndex;i<=rightIndex;i++)
			a+=list.get(i);
		return a;
	}

	private static boolean Chek(ArrayList<Long> list, int leftIndex,
			int rightIndex) {
		if(rightIndex-leftIndex<2)
			return true;
	if(list.get(leftIndex)+list.get(leftIndex+1)>=list.get(rightIndex))
		return true;
	
		
		return false;
	}


}
