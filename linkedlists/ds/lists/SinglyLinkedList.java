package ds.lists;

public class SinglyLinkedList {
	private Node first;

	public SinglyLinkedList() {

	}

	public boolean isEmpty() {
		return first == null;
	}

	// Usado para inserir no inicio da lista
	public void insertFirst(int element) {
		Node newNode = new Node();
		newNode.setElement(element);
		newNode.setNext(first);
		first = newNode;
	}

	public Node deleteFirst() {
		Node temp = first;
		first = first.getNext();
		return temp;
	}

	public void insertLast(int element) {
		Node atual = first;
		while (atual.getNext() != null) {
			atual = atual.getNext();
		}
		Node newNode = new Node();
		// newNode.setNext(null);
		newNode.setElement(element);
		atual.setNext(newNode);
	}

	public void printList() {
		System.out.println("Lista (Primeiro --> Fim) ");
		Node atual = first;
		while (atual != null) {
			atual.printNode();
			atual = atual.getNext();
		}
	}

}
