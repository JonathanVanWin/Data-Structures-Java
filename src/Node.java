

public class Node<T> {
	private T value;

	private Node<T> next;

	public Node(T value) {
		this.value = value;
		this.next = null;
	}

	public Node() {
		this.value = null;
		this.next = null;
	}

	public Node(T... values) {
		if (values.length >= 1)
			this.value = values[0];
		if (values.length >= 2)
			this.next = new Node<T>(values[1]);
		if (values.length >= 3)
			this.next.next = new Node<T>(values[2]);
		Node<T> pos = this.next;
		for (int i = 3; i < values.length; i++) {
			pos = pos.getNext();
			pos.setNext(new Node<T>(values[i]));
		}
		pos = pos.getNext();
	}

	public Node(Node<T> chain) {
		this.value = chain.getValue();
		if (chain.getNext() == null)
			this.next = null;
		else
			this.next = new Node<T>(chain.getNext().getValue(), chain.getNext());
	}

	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return this.value;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public boolean hasNext() {
		return this.next != null;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public int size() {
		int c = 0;
		Node<T> pos = this;
		while (pos != null) {
			c++;
			pos = pos.getNext();
		}
		return c;
	}

	public void displayChain(String msg) {
		Node<T> pos = this;
		while (pos != null) {
			System.out.println(msg + pos.getValue());
			pos = pos.getNext();
		}
	}

	public static Node<Integer> generateRandChain(int min, int max) {
		Node<Integer> chain = new Node<Integer>(((int) (Math.random() * (max - min + 1)) + min));
		Node<Integer> pos = chain;
		int size = (int) (Math.random() * (max - min + 1)) + min - 1;
		for (int i = 0; i < size; i++) {
			pos.setNext(new Node<Integer>((int) (Math.random() * (max - min + 1)) + min));
			pos = pos.getNext();
		}
		return chain;
	}

	public static Node<Character> generateRandChainChar(int min, int max) {
		Node<Character> chain = new Node<Character>((char) ((int) (Math.random() * (max - min + 1)) + min));
		Node<Character> pos = chain;
		int size = (int) (Math.random() * (max - min + 1)) + min - 1;
		for (int i = 0; i < size; i++) {
			pos.setNext(new Node<Character>((char) ((int) (Math.random() * (max - min + 1)) + min)));
			pos = pos.getNext();
		}
		return chain;
	}

	public Node<T> delateDuplic() {
		Node<T> pos = this;
		while (pos != null) {
			int index = pos.indexOf(pos.getValue());
			if (index != -1) {
				return null;
			}
		}
		return pos;
	}

	public int indexOf(Object object) {
		int c = 0;
		Node<T> pos = this;
		while (pos != null) {
			if (object.equals(pos.getValue()))
				return c;
			c++;
			pos = pos.getNext();
		}
		return -1;
	}

	public int lastIndexOf(Object object) {
		Node<T> pos = new Node<T>(this.getValue(), this.getNext() == null ? null : this.getNext());
		System.out.println("*/*Size " + pos.size());

		int index = pos.reverseChain().indexOf(object);
		return index == -1 ? -1 : index;
	}

	public Node<T> reverseChain() {
		if (this == null || this.getNext() == null)
			return this;

		Node<T> pos1 = this;
		Node<T> pos2 = pos1.getNext();
		while (pos1 != null && pos2 != null) {
			Node<T> temp = pos2.getNext();
			pos2.setNext(pos1);
			pos1 = pos2;
			pos2 = temp;
		}
		pos1.displayChain("Pos3: ");
		return pos1;
	}

	public T remove(Node<T> n) {
		Node<T> pos = this;
		while(pos!=null && pos.getNext()!=n){
			pos = pos.getNext();
		}
		if(pos==null)return null;
		Node<T> temp = pos.getNext();
		pos = temp==null?null:temp.getNext();
		temp.setNext(null);
		return temp.getValue();
	}

	public String toString() {
		return "Value: " + this.value;
	}
}