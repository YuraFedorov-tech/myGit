import java.util.ArrayList;


public class Helping {

	public static int[] Plus1toall(int[] counrForNewInt, ArrayList<Integer> road) {
		// TODO Auto-generated method stub
		return counrForNewInt;
	}

	public static int FindNumber(ArrayList<Integer> road) {
		int n=0;
for(int x: road)
n+=x;
		return n;
	}

	public static int[] plus_counrForNewInt_on_road(int[] counrForNewInt,
			ArrayList<Integer> road, int n, int findNumberInt) {    // ���� n=0, ������ ���������� �� ���� ������
for(int i=1;i<road.size()-n+1;i++)                                    // tckb n=1 , �� ��������� ����� �� �������
	counrForNewInt[i]+=findNumberInt;
		
		return counrForNewInt;
	}

}
