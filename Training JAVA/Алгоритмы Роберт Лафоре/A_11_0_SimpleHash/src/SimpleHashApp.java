import java.util.ArrayList;

class Link {
	private String name;
	private int salary;

	public Link(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

}

class SimpleHash {
	private Link[] myLink;
	private int size;

	public SimpleHash(int n) {
		myLink = new Link[n];
		size=0;
	}

	public void put(int i, String name, int salary) {
		myLink[size++] = new Link(name, salary);
		
	}
	public ArrayList<String>  getName(){
		ArrayList<String> listName=new ArrayList<>();
		for(int i=0;i<size;i++) {
			listName.add(myLink[i].getName());
		}
		return listName;
		
	}

	public ArrayList<Integer> getSalary() {
		ArrayList<Integer> listSalary=new ArrayList<>();
		for(int i=0;i<size;i++) {
			listSalary.add(myLink[i].getSalary());
		}
		return listSalary;
	}
}

public class SimpleHashApp {
	private static String name[] = { "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "jj", "kk", "lll" };

	public static void main(String[] args) {
		SimpleHash s = new SimpleHash(1000);
		for (int i = 0; i < 11; i++) {
			s.put(i, findName(i), i+100);
		}
		ArrayList<String> listName =s.getName();
		System.out.println(listName);
		ArrayList<Integer> listSalary =s.getSalary();
		System.out.println(listSalary);
	}

	

	private static String findName(int i) {
		return name[i];
	}

}
