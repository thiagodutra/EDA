package ds.lists;
/**
 * SinglyLinkedList creates a LinkedList
 * without the 'nil' element, so, at the end
 * the node points to null instead of nil
 * 
 * @author Thiago Dutra
 *
 */
public class SinglyLinkedList implements ListaEncadeada_IF {
	private Node first;

	/**
	 * Empty Constructor
	 */
	public SinglyLinkedList() {
		this.first = null;
	}
	/**
	 * isEmpty returns if there isn't elements in the list
	 * or, if there is a list at all
	 * @return <code>true</code> if the list is empty or 
	 * <code>false</code> otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}
	// ------------- Inicio métodos da interface -------------
	public int size() {
		int size = 1;
		Node current = first;
		if (isEmpty())
			return -1;
		while (current.getNext() != null ) {
			current = current.getNext();
			size+=1;
		}
		return size;
	}
	
	public void insert(int element) {
		Node newNode = new Node();
		newNode.setElement(element);
		newNode.setNext(first);
		first = newNode;
	}
	
	public int search(int element) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista está vazia");
		}
		Node current = first;
		while (current.getElement() != element) {
			if (current.getNext() == null) {
				throw new Exception("Elemento não encontrado");
			}
			current = current.getNext();
		}
		return current.getElement();
	}
	
	public void remove(int element) {
		Node current = first;
		if (first.getElement() == element) {					//se o dado estiver no primeiro elemento, 
			first = first.getNext();							//move a primeira posição da lista à frente
			current.setNext(null);								//faz o nó atual apontar para null
		}
		Node aux = current.getNext();							//cria nó auxiliar, estará a frente de current
		while (aux.getElement() != element) {
			if (aux.getNext() == null) {						//se aux apontar para null, percorreu toda a lista  não achou o elemento
				System.out.println("Elemento não encontrado, portanto não foi deletado");
				break;
			}
			aux = aux.getNext();								//move aux
			current = current.getNext();						//move current
		}
		current.setNext(aux.getNext());							//aponta current para o proximo de aux
		aux.setNext(null);										//aux aponta para null
	}
	
	public int[] toArray() {
		int[] a;
		if (isEmpty()) {
			return null;
		} else if (first.getNext() == null){					//se houve apenas um elemento
			a = new int[1];
			a[0] = first.getElement();
		}
		Node current = first;
		int i = 0;
		a = new int[size()];
		while (current.getNext() != null) {
			a[i] = current.getElement();
			i++;
		}
		return a;
	}
	
	
	// ------------- Fim métodos da interface -------------
	
	
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
	public void print() {
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
