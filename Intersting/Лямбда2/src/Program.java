import java.util.*;
import java.util.stream.IntStream;

public class Program {

	public static void main(String[] args) {
		List<Person> persones = new ArrayList<>();
		persones.add(new Person("Mike", 24));
		persones.add(new Person("Julia", 19));
		persones.add(new Person("Sophia", 9));
		persones.add(new Person("Jhon", 7));
		persones.add(new Person("Polina", 26));
		persones.add(new Person("Alena", 15));

		for (Person p : persones)
			System.out.println(p);
		pr();
		persones.stream().forEach(p -> System.out.println(p));
		pr();
		persones.stream().filter(p -> p.getAge() > 8).forEach(System.out::println);
		pr();
		persones.stream().filter(p -> p.getAge() > 8).sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.forEach(System.out::println);
		pr();
		persones.stream().filter(p -> p.getAge() > 8).sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.map(p -> p.getName()).forEach(System.out::println);
		pr();
		int summa = 0, n = 0;
		for (Person p : persones)
			if (p.getAge() > 8) {
				summa += p.getAge();
				n++;
			}
		System.out.println((double) summa / n);
		double ans = persones.stream().filter(p -> p.getAge() > 8).mapToInt(p -> p.getAge()).average().getAsDouble();
		System.out.println(ans);

	}

	private static void pr() {
		System.out.println("///////////////////////////////////");

	}
}
