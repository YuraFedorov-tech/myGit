import java.util.ArrayList;
import java.util.HashSet;

class Link<Item> {
	private Item name;

	public Link(Item name) {
		this.name = name;
	}

	public Item getName() {
		return name;
	}

	public void setName(Item name) {
		this.name = name;
	}

}

class SimpleHash<Item> {
	private int size;
	private Link[] myLink;

	public SimpleHash(int n) {
		myLink = new Link[n];
		size = 0;
	}

	public void put(int i, Item name) {
		myLink[size++] = new Link(name);
	}

	public ArrayList<Item> getValue() {
		ArrayList<Item> listName = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			listName.add((Item) myLink[i].getName());
		}
		return listName;
	}

	public void set(int i, Item name) {
		myLink[i].setName(name);

	}

}

public class SimpleHashSetGenericApp {
	public static void main(String[] args) {
		SimpleHash<String> s = new SimpleHash(1000);
		for (int i = 0; i < 11; i++) {
			s.put(i, "" + (char) (65 + i));
		}
		ArrayList<String> listName = s.getValue();
		System.out.println(listName);
		s.set(5, "aregadrhg");
		s.set(8, "ggggggggggggg");
		listName = s.getValue();
		System.out.println(listName);

		SimpleHash<Double> s2 = new SimpleHash(1000);
		for (int i = 0; i < 11; i++) {
			s2.put(i, (double) i * 10);
		}
		ArrayList<Double> listName2 = s2.getValue();
		System.out.println(listName2);
		s2.set(5, 1111111.2);
		s2.set(8, 2222222222222222222222.2);
		System.out.println(listName2);// почему эта строчка
		listName2 = s2.getValue();
		System.out.println(listName2);//и эта строчка дают разные представления одного и того же класса?

		HashSet<Integer> my=new HashSet<>();
		
	}

}
