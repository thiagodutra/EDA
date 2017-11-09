package ds.doublylinkedlist;

/**
 * Node class contains the attributes to create a DoublyLinkedList
 * by creating new Nodes we can link them, resulting in the LinkedList
 * 
 * @author Thiago Dutra
 *
 */



public class Node {
	private int element;
	private Node next;
	private Node previous;
	
	
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

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
