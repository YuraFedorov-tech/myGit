class wer {
	private int a = 10001, b;

	void show() {
		werInside e = new werInside();
		e.display();
	}

	class werInside {
		void display() {
			System.out.println("Присвоены значения полям!");
			System.out.println(a);
		}
	}

}

public class r4_6 {

	public static void main(String[] args) {
		wer q1 = new wer();
		q1.show();
	}

}
