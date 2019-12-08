
public class HashMapGenericApp {
	private final static int size = 7;

	public static void main(String[] args) {
		HashMapMy<String, Integer> myHashSet = new HashMapMy<String, Integer>(getSimpleNumberSize());

		for (int i = 0; i < size; i++) {
			myHashSet.put(Integer.toString(i), i * 10);
		}
		boolean q = myHashSet.containsKey("2");
		System.out.print(q);
		q = myHashSet.containsKey("1000");
		System.out.println(q);
		q = myHashSet.containsValue(20);
		System.out.print(q);
		q = myHashSet.containsValue(200000000);
		System.out.println(q);
		
		int qq=myHashSet.get("2");
		System.out.print(qq);
		System.out.println(myHashSet.get("20000000"));
		
		myHashSet.displayTable();
		myHashSet.remove("2");
		myHashSet.remove("5");
		myHashSet.displayTable();
	}

	private static int getSimpleNumberSize() {
		int j = size * 2;
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
