

public class StackQueue {

	public static void stacker(Stack<Queue<Integer>> SQ, int num) {
		Stack<Queue<Integer>> temp = new Stack<Queue<Integer>>();
		while (!SQ.isEmpty()) {
			Queue<Integer> q = new Queue<>();
			while (!q.isEmpty()) {
				if (q.head() == num)
					break;
				else
					q.insert(SQ.top().remove());
			}
			temp.push(SQ.pop());
		}
	}

	public static void main(String[] args) {

	}

}
