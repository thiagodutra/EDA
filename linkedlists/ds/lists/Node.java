package ds.lists;

public class Node {
	private int element;
	private Node next = null;
	
	
	public void printNode() {
		System.out.println("[ " + getElement() + " ]");
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}
}
