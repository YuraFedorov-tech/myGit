
public class HashTableSet<Item> {
	private int size;
	private Link[] myLink; // как его сделать обощенным?
//	private Link<Item> myLink3;
	private Link nonItem;

	public HashTableSet(int i) {
		size = i;
		myLink = new Link[size];// как его сделать обощенным?
		nonItem = new Link(null, -1);
	}

	public void displayTable() {
		for (int i = 0; i < size; i++) {
			if (myLink[i] == null) {
				System.out.print("n");
				continue;
			}
			if (myLink[i].getvalue() == nonItem.getvalue())
				System.out.print("**" + " ");
			else
				System.out.print(myLink[i].getvalue() + " ");
		}
		System.out.println();
	}

	public int hashFunc(int key) {
		return key % size;
	}

	public Item remove (Item val) {
		int key = FindKey(val);
		int hachVal = hashFunc(key);
		while (myLink[hachVal] != null) {
			if(myLink[hachVal].getvalue()==val) {
				myLink[hachVal]=nonItem;
				return val; 
			}
		}
		
		
		return null;
	}

	public void add(Item val) {
		int key = FindKey(val);
		Link<Item> next = new Link<Item>(val, key);
		int hachVal = hashFunc(key);
		while (myLink[hachVal] != null && myLink[hachVal].getKey() != -1) {
			if (myLink[hachVal++].getvalue() == val)
				return;
			hachVal %= size;
		}
		myLink[hachVal] = next;
	}

	private int FindKey(Item val) {
		String s = val.toString();
		int y=FindFromS(s);
		return y;
	}

	private int FindFromS(String s) {
		int an=0;
		for(int i=0;i<s.length();i++) {
			an+=s.charAt(i)*Math.pow(10, i);
		}
		return an;
	}

}
