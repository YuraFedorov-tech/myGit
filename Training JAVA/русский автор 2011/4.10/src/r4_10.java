class MyClass {
	int number = 0;
	MyClass next ;

	void greate(int n) {
		MyClass obiB; // = new MyClass();
		MyClass obiA = this;
		for (int i = 1; i <= n; i++) {
			obiB = new MyClass();
			obiA.next = obiB;
			obiB.number = obiA.number + 1;
			obiA = obiB;
		}
		obiA.next = this;
	}

	int getNumber(int k) {
		MyClass obiA = this;
		for (int i = 1; i <= k; i++)
			obiA = obiA.next;
		return obiA.number;
	}
}

public class r4_10 {
	public static void main(String[] args){
		MyClass q=new MyClass();
		q.greate(3);
		System.out.println("Значение поля number объектов:");
		System.out.println("2-й после начального -> "+q.getNumber(2));
		System.out.println("4-й после начального -> "+q.getNumber(4));
		System.out.println("2-й после 1-го -> "+q.next.getNumber(2));
		
		
	}
}
