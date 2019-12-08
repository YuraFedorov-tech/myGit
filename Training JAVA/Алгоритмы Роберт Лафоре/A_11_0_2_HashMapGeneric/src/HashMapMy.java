
public class HashMapMy<T, V> {
	private final int size;
	private Link[] myLink; // как его сделать обощенным?
//	private Link<Item> myLink3;
	private Link nonItem;

	public HashMapMy(int simpleNumberSize) {
		size = simpleNumberSize;
		myLink = new Link[size];
		nonItem = new Link(null, null, -1);
	}

	public void displayTable() {
		for (int i = 0; i < size; i++) {
			if (myLink[i] == null) {
				System.out.println("null");
				continue;
			}
			if (myLink[i].getKeyHash() == nonItem.getKeyHash())
				System.out.println("**" + " ");
			else
				System.out.println(myLink[i].getKey() + " " + myLink[i].getValue());
		}
		System.out.println();
	}

	public int hashFunc(int key) {
		return key % size;
	}

	public T remove(T key) {
		int keyHash = FindKey(key);
		int hachVal = hashFunc(keyHash);
		while (myLink[hachVal] != null) {
			if (myLink[hachVal].getKey().equals(key)) {
				myLink[hachVal] = nonItem;
				return key;
				
				
			}
			hachVal++;
			hachVal %=size;
		}
		return null;
	}

	public void put(T key, V val) {
		int keyHash = FindKey(key);
		Link<T, V> next = new Link<T, V>(key, val, keyHash);
		int hachVal = hashFunc(keyHash);
		while (myLink[hachVal] != null && myLink[hachVal].getKeyHash() != -1) {
			if (myLink[hachVal++].getValue() == val)
				return;
			hachVal %= size;
		}
		myLink[hachVal] = next;
	}

	public boolean containsKey(T key) {
		for (int i = 0; i < size; i++) {
			if (myLink[i] == null || myLink[i].getKeyHash() == -1)
				continue;
			if (myLink[i].getKey().equals(key))
				return true;
		}
		return false;
	}

	public boolean containsValue(V val) {
		for (int i = 0; i < size; i++) {
			if (myLink[i] == null || myLink[i].getKeyHash() == -1)
				continue;
			if (myLink[i].getValue().equals(val))
				return true;
		}
		return false;
	}

	public V get(T key) {
		for (int i = 0; i < size; i++) {
			if (myLink[i] == null || myLink[i].getKeyHash() == -1)
				continue;
			if (myLink[i].getKey().equals(key))
				return (V) myLink[i].getValue();
		}
		return null;
	}

	private int FindKey(T key) {
		String s = key.toString();
		int y = FindFromS(s);
		return y;
	}

	private int FindFromS(String s) {
		int an = 0;
		for (int i = 0; i < s.length(); i++) {
			an += s.charAt(i) * Math.pow(10, i);
		}
		return an;
	}

}
