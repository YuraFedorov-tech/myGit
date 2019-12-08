
class StackX {
	private int a[];
	private int size;

	public StackX(int n) {
		a = new int[100];
		size = -1;
	}

	public void push(int n) {
		a[++size] = n;
	}

	public long pop() {
		return a[size--];
	}

	public boolean isEmpty() {
		return size==-1;
	}

}

public class A_4_1_StackApp {
	public static void main(String[] args) {
		StackX theStack = new StackX(10); // �������� ������ �����
		theStack.push(20); // ��������� ��������� � ����
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		while (!theStack.isEmpty()) // ���� ���� �� ������ ������
		{ // ������� ������� �� �����
			long value = theStack.pop();
			System.out.print(value); // ����� �����������
			System.out.print(" ");
		}
		System.out.println("");
	}
}
