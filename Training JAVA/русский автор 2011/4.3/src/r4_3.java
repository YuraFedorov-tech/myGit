class wer {
	static int a = 3;
	final	static int b = 1000;

	static void callMe() {
		System.out.println("a=" + a);
		System.out.println("b=" + b);

	}

}

public class r4_3 {

	public static void main(String[] args) {
		wer q1 = new wer();
		wer q2 = new wer();
		q1.callMe();
		q1.a = -10;
		q1.callMe();
		q2.callMe();

	}

}
