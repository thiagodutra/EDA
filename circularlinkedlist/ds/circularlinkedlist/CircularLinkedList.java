package ds.circularlinkedlist;
import ds.lists.Node;

public class CircularLinkedList {
	
	private Node first;
	private Node last;
	
	public CircularLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	private boolean isEmpty() {
		return first==null;
	}

	public void insertFirst (int data) {
		Node newNode = new Node();				
		newNode.setElement(data);
		
		if (isEmpty()) {
			last = newNode;
		}
		newNode.setNext(first);					//newNode --> antigo first
		first = newNode;						//first eh newNode
	}

	public void insertLast (int data) {
		Node newNode = new Node();
		newNode.setElement(data);
		
		if(isEmpty()) {
			first.setNext(newNode);
		} else {
			last.setNext(newNode);				//o ultimo nó apontará para o novo nó
			last = newNode;						//last aponta para newNode
		}
	}
	
	public int deleteFirst() {
		int temp = first.getElement();
		
		if(first.getNext() == null) {
			last = null;
		}	
		first = first.getNext();				//first apontará para o próximo do antigo first
		return temp;
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
