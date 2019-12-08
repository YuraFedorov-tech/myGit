class wer {
	static int a = 3, b;

	void met(double x) {
		System.out.println("x=" + x);
		System.out.println("a=" + a);
		System.out.println("b=" + b);

	}

	static {
		System.out.println("static");
		b = 4 * a;
	}
}

public class r4_2 {

	public static void main(String[] args) {
wer q=new wer();
q.met(5);;		
		
	}

}
