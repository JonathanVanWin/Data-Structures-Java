import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NodeClass<T> {
	private T value;
	private NodeClass<T> next;

	public NodeClass(T value) {
		this.value = value;
		this.next = null;
	}

	public NodeClass(T... values) {
		if (values.length == 0) {
			this.value = null;
			this.next = null;
		} else {
			this.value = values[0];
			if (values.length == 1)
				this.next = null;
			else {
				NodeClass<T> pos = this;
				for (int i = 1; i < values.length; i++) {
					if (i == 1) {
						pos.next = values.length >= 2 ? new NodeClass<T>(values[i], new NodeClass<T>(values[i + 1]))
								: new NodeClass<T>(values[i]);
					} else {
						pos.setNext(new NodeClass<T>(values[i]));
					}
					pos = pos.getNext();
				}
			}
		}
	}

	public NodeClass(T value, NodeClass<T> next) {
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return this.value;
	}

	public NodeClass<T> getNext() {
		return this.next;
	}

	public boolean hasNext() {
		return this.next != null;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setNext(NodeClass<T> next) {
		this.next = next;
	}

	public String toString() {
		return "Value: " + this.value;
	}

	public int size() {
		int c = 0;
		NodeClass<T> pos = this;
		while (pos != null) {
			c++;
			pos = pos.getNext();
		}
		return c;
	}

	public void displayNode(String... msgs) {
		NodeClass<T> pos = this;
		if (pos.size() == msgs.length)
			for (String msg : msgs) {
				if (pos != null) {
					System.out.println(msg + pos.getValue());
					pos = pos.getNext();
				}
			}
		else if (msgs.length > 0)
			while (pos != null) {
				System.out.println(msgs[0] + pos.getValue());
				pos = pos.getNext();
			}
		else
			while (pos != null) {
				System.out.println(pos.getValue());
				pos = pos.getNext();
			}
	}

	public T[] toArray() {
		NodeClass<T> pos = this;
		T[] array = (T[]) Array.newInstance(this.value.getClass(), this.size());

		for (int i = 0; i < array.length && pos != null; i++) {
			array[i] = pos.getValue();
			pos = pos.getNext();
		}
		return array;
	}

	public static NodeClass<Integer> createRandIntNode(int size, int beginR, int endR) {
		NodeClass<Integer> chain = new NodeClass<Integer>((int) (Math.random() * (endR - beginR + 1)) + beginR);
		NodeClass<Integer> pos = chain;
		for (int i = 0; i < size - 1; i++)// Already created one
		{
			pos.setNext(new NodeClass<Integer>((int) (Math.random() * (endR - beginR + 1)) + beginR));
			pos = pos.getNext();
		}
		return chain;
	}

	public static <T> NodeClass<T> reverseChain(NodeClass<T> chain) {
		NodeClass<T> current = chain;
		NodeClass<T> last = null;
		NodeClass<T> next;
		while (current != null) {
			next = current.getNext();
			current.next = last;
			last = current;
			current = next;
		}
		return last;
	}

	public static NodeClass<Integer> sort(NodeClass<Integer> chain) {
		ArrayList<Integer> some = new ArrayList<>(Arrays.asList(chain.toArray()));
		Collections.sort(some);
		return new NodeClass<Integer>(some.toArray(new Integer[some.size()]));
	}

	/*public static Node<Integer> orderChain(Node<Integer> chain){
		Node<Integer> pos=chain;
		Node<Integer> temp=null;
		int tempN=0, temp2=0;
		while(pos!=null)
		{
			pos=chain;
			while(pos!=null){
				if(pos)
				pos=pos.getNext();
			}
		}
		return temp;
	}*/

}