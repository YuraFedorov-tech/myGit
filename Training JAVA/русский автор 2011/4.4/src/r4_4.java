class wer {
	private int a ,b;
	

	private void callMe() {
		System.out.println("a=" + a);
		System.out.println("b=" + b);

	}

	void set(int x,int y) {
		a=x;b=y;
		System.out.println("��������� �������� �����!");		
	}
	void getAB() {
		System.out.println("�������� �������� �����!");	
		 callMe();
	}
	
	
}

public class r4_4 {

	public static void main(String[] args) {
		wer q1 = new wer();
		q1.set(1, 5);
		q1.getAB();
	}

}
