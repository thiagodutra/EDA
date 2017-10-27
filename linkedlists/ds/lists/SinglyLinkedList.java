package ds.lists;

public class SinglyLinkedList {
	private Node first;
	private Node nil;
	

	public SinglyLinkedList() {
		nil.setNext(null);
		first.setNext(nil);
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	//Métodos Iterativos.
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
		while (atual.getNext() != nil) {
			atual = atual.getNext();
		}
		Node newNode = new Node();
		newNode.setNext(nil);
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
	
	//Inicio dos Métodos Recursivos
	
	public void printListRecursively (Node atual)
	  {
		atual = first;
	    if (atual == null)
	      return;
	    else {
	      System.out.println(atual.getElement());
	      printListRecursively(atual.getNext());
	    }
	  }
	
	public int lengthRecursively (Node l)
	  {
	    if (l == null)
	      return 0;
	    else
	      return 1 + lengthRecursively(l.getNext());
	  }

	public Node findRecursively (Node l, int value)
	  {
	    if (l == null)
	      return null;
	    else
	      if (l.getElement() == value)
	        return l;
	      else
	        return findRecursively(l.getNext(), value);
	  }
}
