import java.util.ArrayList;


public class Work {

	public static ArrayList<Integer> DoRaxnitca(ArrayList<Integer> listInput, ArrayList<Integer> raznitza) {
for(int i=0;i<listInput.size()-1;i++){
	raznitza.add(listInput.get(i+1)-listInput.get(i));
}

		
		return raznitza;
	}

	public static int count(ArrayList<Integer> listCurrent,
			ArrayList<Integer> raznitza) {
		listCurrent.add(1);
int ans=0;
for(int i=0;i<listCurrent.size();i++)
	ans+=listCurrent.get(i)*raznitza.get(i);
listCurrent.remove(listCurrent.size()-1);
		
		
		return ans;
	}

}
