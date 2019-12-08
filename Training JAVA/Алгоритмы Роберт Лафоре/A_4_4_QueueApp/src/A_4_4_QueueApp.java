
class Queue {
	private int[] queueArr;
	private int Size;
	private int front;
	private int rear;
	private int nItem;

	public Queue(int n) {
		Size = n;
		queueArr = new int[n];
		front = rear = nItem = 0;
	}

	public void insert(int key) {		
		queueArr[rear++] = key;
		if(rear==Size)
			rear=0;
		nItem++;
	}

	public int remove() {
		int temp=queueArr[front++];
		if(front==Size)
			front=0;
		nItem--;
		return temp;
	}

	public boolean isEmpty() {
		return nItem == 0;
	}
	public boolean isFull() {
		return nItem == Size;
	}
	public int size() {
		return Size;
	}
}

public class A_4_4_QueueApp {

	public static void main(String[] args) {
		Queue theQueue = new Queue(5); // ������� �� 5 �����
		theQueue.insert(10); // ������� 4 ���������
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		theQueue.remove(); // ���������� 3 ���������
		theQueue.remove(); // (10, 20, 30)
		theQueue.remove();
		theQueue.insert(50); // ������� ��� 4 ���������
		theQueue.insert(60); // (� ����������� ���������)
		theQueue.insert(70);
		theQueue.insert(80);
		while (!theQueue.isEmpty()) // ���������� � �����
		{ // ���� ���������
			long n = theQueue.remove(); // (40, 50, 60, 70, 80)
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");

	}

}
