import java.io.IOException;
import java.rmi.MarshalException;

class Queue  {
  private int[]queueArr;
  private int size;
  private int front;
  private int rear;
  
	public Queue(int max) {
		front=0;
		rear=-1;
		size=max+1;
		queueArr=new int[size];
	}

	public void insert (int j) throws Exception  {
		if(isFull()) 
			throw	 new IOException("queue is full");
		queueArr[++rear]=j;	
		if(rear==size-1)
			rear=-1;
	}

	public int remove() throws IOException {
		if(isEmpty()) 
			throw	 new IOException ("queue is empty");
		int temp=queueArr[front++];
		if(front==size)
			front=0;
		return temp;		
	}

	public boolean isEmpty() {
		if(rear+1==front || (front+size-1==rear))
			return true;
		return false;
	}
	public boolean isFull() {
		if(rear+2==front || ((front+size-2==rear) ))
			return true;
		return false;
	}
	
}
public class A_4_5_QueueApp {
	public static void main(String[] args) throws Exception {
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
		int n = theQueue.remove(); // (40, 50, 60, 70, 80)
		System.out.print(n);
		System.out.print(" ");
	}
	System.out.println("");
	
}
}
