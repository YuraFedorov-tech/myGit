
public class HashTableApp {
	private final static int size = 7;

	public static void main(String[] args) {
		HashTableSet<Integer> myHashSet = new HashTableSet<Integer>(getSimpleNumberSize());
		for(int i=0;i<size;i++) {
			myHashSet.add(i);
		}
		myHashSet.displayTable();
		myHashSet.remove(3);
		myHashSet.displayTable();
		myHashSet.add(3);
		myHashSet.displayTable();
		
		
		
		HashTableSet<Double> myHashSet2 = new HashTableSet<Double>(getSimpleNumberSize());
		for(int i=0;i<size;i++) {
			myHashSet2.add((double)i*5.7);
		}
		myHashSet2.displayTable();	
		

	}

	private static int getSimpleNumberSize() {
		int j = size * 2 ;
		while (true) {
			if (isSimple(j++))
				return --j;
		}

	}

	private static boolean isSimple(int j) {
		for (int i = 2; i * i <= j; i++)
			if (j % i == 0)
				return false;
		return true;
	}
}
