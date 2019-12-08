class Link<T> {
	T item;
	Link next;

	public Link(T item) {
		this.item = item;
	}

	public void display() {
		System.out.print(item + " ");
	}

}

class LinkList<T> {
	Link first;

	public void insertFirst(T item) {
		Link cur = new Link(item);
		cur.next = first;
		first = cur;
	}

	public T removeFirst() {
		Link temp = first;
		first = first.next;
		return (T) temp.item;
	}

	public T peek() {
		T it = (T) first.item;
		return it;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void display() {
		Link cur = first;
		while (cur != null) {
			cur.display();
			cur = cur.next;
		}
		System.out.println();
	}
}

class LinkStack<T> {
	LinkList<T> stack = new LinkList();
	public void push(T item) {
		stack.insertFirst(item);
	}

	public T pop() {
		T temp = stack.removeFirst();
		return temp;
	}

	public void displayStack() {
		stack.display();
	}

	public T peek() {
		return stack.peek();
	}

}

public class A_5_4_LinkStackApp {
	public static void main(String[] args) {
		LinkStack<Integer> theStack = new LinkStack<>(); // �������� �����
		theStack.push(20); // ������� ���������
		theStack.push(40);
		theStack.displayStack(); // ����� ����������� �����
		theStack.push(60); // ������� ���������
		theStack.push(80);
		theStack.push(90);
		theStack.displayStack(); 
		System.out.println(theStack.pop());
		System.out.println(theStack.peek());
		System.out.println(theStack.peek());
		theStack.displayStack();
		
		
		LinkStack<Double> stack = new LinkStack<>(); // �������� �����
		stack.push(20.1); // ������� ���������
		stack.push(40.1);
		stack.displayStack(); // ����� ����������� �����
		stack.push(60.1); // ������� ���������
		stack.push(80.1);
		stack.push(90.1);
		stack.displayStack(); 
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		stack.displayStack();
		
		
		LinkStack<String> strStack = new LinkStack<>(); // �������� �����
		strStack.push("a"); // ������� ���������
		strStack.push("B");
		strStack.displayStack(); // ����� ����������� �����
		strStack.push("dg"); // ������� ���������
		strStack.push("g");
		strStack.push("qqqqqqq");
		strStack.displayStack(); 
		System.out.println(strStack.pop());
		System.out.println(strStack.peek());
		System.out.println(strStack.peek());
		strStack.displayStack();
	}
}
