package ds.lists;
/**
 * SinglyLinkedList creates a LinkedList
 * without the 'nil' element, so, at the end
 * the node points to null instead of nil
 * 
 * @author Thiago Dutra
 *
 */
public class SinglyLinkedList {
	private Node first;

	/**
	 * Empty Constructor
	 */
	public SinglyLinkedList() {
	}
	/**
	 * isEmpty returns if there isn't elements in the list
	 * or if there is a list at all
	 * @return <code>true</code> if the list is empty or if
	 * there isn't a list yet.
	 * <code>false</code> otherwise
	 */
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
	
	
	/**
	 * Prints the list recursively
	 * 
	 * @param list 		the first node of the list
	 * 					can be retrieved by obj.getFirst
	 * @see 			SinglyLinkedList#getFirst()
	 */
	public void printListRecursively (Node list) {		//Imprime Recursivamente
		if (list == null)
	      return;
	    else {
	      System.out.println(list.getElement());
	      printListRecursively(list.getNext());
	    }
	  }
	/**
	 * Returns the length of the linked list
	 * how many elements the list contains
	 * 
	 * @param list		the first node of the list
	 * 					can be retrieved by obj.getFirst
	 * @return			0 if the list is null,
	 * 					sum of the number of nodes, otherwise
	 */
	public int lengthRecursively (Node list) {			//Retorna o tamanho da lista
	    if (list == null)
	      return 0;
	    else
	      return 1 + lengthRecursively(list.getNext());
	  }
	
	/**
	 * Searches if an element is in the list
	 * @param list		the first node of the list
	 * 					can be retrieved by obj.getFirst
	 * @param value		value to be found
	 * @return			-1 if the element is not found
	 * 					Node#getElement() when found
	 * 
	 * @see				Node#getElement()
	 */
	public int findRecursively (Node list, int value) {	//Procura um elemento na lista
	    if (list == null)
	      return -1;
	    else
	      if (list.getElement() == value)
	        return list.getElement();
	      else
	        return findRecursively(list.getNext(), value);
	  }
	
	/**
	 * Access the first node of the list
	 * @return			Returns the first node of the list
	 * 					the one in the head of the list
	 */
	public Node getFirst() {							//Getters Setters
		return first;
	}

}
