package ds.circularlinkedlist;
import ds.lists.Node;

/**
 * Circular List
 * 
 * 
 * @author Thiago Dutra
 *
 */
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
	/**
	 * Inserts in the first position of the list
	 * 
	 * @param data					(int) data to be inserted along with
	 * 								the node
	 */
	public void insertFirst (int data) {
		Node newNode = new Node();				
		newNode.setElement(data);
		
		if (isEmpty()) {
			last = newNode;
		}
		newNode.setNext(first);					//newNode --> antigo first
		first = newNode;						//first eh newNode
	}
	/**
	 * Inserts in the last position of the list
	 * 
	 * @param data					(int) data to be inserted along with
	 * 								the node
	 */
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
	/**
	 * Deletes the first position, sets the next node as the new first
	 * and returns the value of the old first node
	 * 					
	 */
	public int deleteFirst() {
		int temp = first.getElement();
		
		if(first.getNext() == null) {
			last = null;
		}	
		first = first.getNext();				//first apontará para o próximo do antigo first
		return temp;
	}
	/**
	 * Prints the list, just the same as the printList
	 * in the SinglyLinkedList
	 * 
	 * @see SinglyLinkedList#printList();
	 */
	public void printList() {
		System.out.println("Lista (Primeiro --> Fim) ");
		Node atual = first;
		while (atual != null) {
			atual.printNode();
			atual = atual.getNext();
		}
	}
 }
