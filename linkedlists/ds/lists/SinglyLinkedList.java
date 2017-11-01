package ds.lists;

public class SinglyLinkedList {
	private Node first;

	public SinglyLinkedList() {
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	// ----------------> Inicio dos Métodos Iterativos <----------------
	
	// Usado para inserir no inicio da lista
	public void insertFirst(int element) {
		Node newNode = new Node();
		newNode.setElement(element);
		newNode.setNext(first);
		first = newNode;
	}
	//Deleta o primeiro elemento
	public Node deleteFirst() {
		Node temp = first;
		first = first.getNext();
		return temp;
	}
	//Insere no fim
	public void insertLast(int element) {
		Node atual = first;
		while (atual.getNext() != null) {
			atual = atual.getNext();
		}
		Node newNode = new Node();
		newNode.setNext(null);
		newNode.setElement(element);
		atual.setNext(newNode);
	}
	//Imprime os elementos da lista
	public void printList() {
		System.out.println("Lista (Primeiro --> Fim) ");
		Node atual = first;
		while (atual != null) {
			atual.printNode();
			atual = atual.getNext();
		}
	}
	
	// ----------------> Inicio dos Métodos Recursivos <----------------
	
	//Imprime Recursivamente
	public void printListRecursively (Node list) {
		if (list == null)
	      return;
	    else {
	      System.out.println(list.getElement());
	      printListRecursively(list.getNext());
	    }
	  }
	//Retorna o tamanho da lista
	public int lengthRecursively (Node list) {
	    if (list == null)
	      return 0;
	    else
	      return 1 + lengthRecursively(list.getNext());
	  }
	//Procura um elemento na lista
	public int findRecursively (Node list, int value) {
	    if (list == null)
	      return -1;
	    else
	      if (list.getElement() == value)
	        return list.getElement();
	      else
	        return findRecursively(list.getNext(), value);
	  }
	
	//Getters Setters
	public Node getFirst() {
		return first;
	}

}
