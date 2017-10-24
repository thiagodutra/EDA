package implementacao3;

public class PilhaComFilas implements Pilha_IF {
	FilaComArray que_1 = new FilaComArray();
	FilaComArray que_2 = new FilaComArray();

	public void push(int element) throws Exception {
		if (que_1.isEmpty() && que_2.isEmpty()) {
			que_1.enqueue(element);
		} else if (!que_1.isEmpty() && que_2.isEmpty()) {
			que_2.enqueue(element);
			while (!que_1.isEmpty()) {
				que_2.enqueue(que_1.dequeue());
			}
		} else if (que_1.isEmpty() && !que_2.isEmpty()) {
			que_1.enqueue(element);
			while (!que_2.isEmpty()) {
				que_1.enqueue(que_2.dequeue());
			}
		}

	}

	public int pop() throws Exception {
		if (que_1.isEmpty() && !que_2.isEmpty())
			return que_2.dequeue();
		else if (!que_1.isEmpty() && que_2.isEmpty())
			return que_1.dequeue();
		return -1;
	}

	public int top() throws Exception {
		if (!que_1.isEmpty() && que_2.isEmpty())
			return que_1.head();
		else if (que_1.isEmpty() && !que_2.isEmpty())
			return que_2.head();
		return -1;
	}

	public boolean isEmpty() {
		return (que_1.isEmpty() == que_2.isEmpty());
	}

	public boolean isFull() {
		return (que_1.isFull() || que_2.isFull());
	}

}
