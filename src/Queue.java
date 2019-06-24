

public class Queue<T> {

	private Node<T> first;

	private Node<T> last;

	public Queue(Node<T> first, Node<T> last) {
		this.first = first;
		this.last = last;
	}

	public Queue() {
		this.first = null;
		this.last = null;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public T head() {
		return this.first.getValue();
	}

	public void insert(T x) {
		Node<T> temp = new Node<T>(x);
		if (this.last == null) {
			this.first = temp;
			this.last = temp;
		} else {
			this.last.setNext(temp);
			this.last = temp;
		}
	}

	public T remove() {
		T x = this.first.getValue();
		this.first = this.first.getNext();
		if (this.first == null)
			this.last = null;
		return x;
	}

	public void reverse() {
		Node<T> last = null;
		Node<T> current = this.first;
		Node<T> next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(last);
			last = current;
			current = next;
		}
		this.first = last;
	}

	public String toString() {
		String st = "[";
		Node<T> pos = this.first;
		while (pos != null) {
			st = st + pos.getValue().toString();
			if (pos.getNext() != null)
				st = st + ",";
			pos = pos.getNext();
		}
		return st + "]";
	}

	public void clear() {
		this.first=null;
		this.last=null;
	}

}
