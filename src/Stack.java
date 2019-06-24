

public class Stack<T> {

	private Node<T> data;

	public Stack() {
		data = new Node<T>();
	}

	public boolean isEmpty() {
		return this.data == null;
	}

	public T top() {
		return this.data.getValue();
	}

	public String toString() {
		String s = "[";
		Node<T> pos = this.data;
		while (pos.getNext().getNext() != null) {
			s += pos.getValue() + ", ";
			pos = pos.getNext();
		}
		s += pos.getValue() + "]";
		return s;
	}

	public void push(T x) {
		Node<T> pos = new Node<T>(x, this.data);
		data = pos;
	}

	public T pop() {
		T x = this.data.getValue();
		this.data = this.data.getNext();
		return x;
	}

	public T getItemAt(int k) {
		Node<T> pos = this.data;
		for (int i = 1; i < k && pos != null; i++) {
			pos = pos.getNext();
		}
		return pos.getValue();
	}

	public T removeItemAt(int k) {
		Node<T> temp = this.data;
		for (int i = 1; i < k-1 && temp.getNext() != null; i++) {
			temp = temp.getNext();
		}
		T value = temp.getNext().getValue();
		Node<T> pos = new Node<T>(temp.getValue(), temp.getNext().getNext());
		this.data = pos;
		return value;
	}

}