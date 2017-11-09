package ds.doublylinkedlist;

/**
 * DoublyLinkedList uses two pointers: previous and next
 * 
 * @see Node
 * 
 * 
 * @author Thiago Dutra
 *
 */
public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
	/**
	 * insertFirst()
	 * @param data		(int) inserts a new Node in the first place of the list
	 * 					and it becomes the new first
	 */
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.setElement(data);
		
		if (isEmpty()) {
			last = newNode;
		} else {
			first.setPrevious(newNode);				//se vazia, next vai se referir ao novo Node 'newNode' sendo criado
		}
		newNode.setNext(first);						//o next do novo Node irá apontar para o antigo first
		this.first = newNode;						//first referenciará o novo Node 'newNode'
	}
	
	/**
	 * insertLast()
	 * @param data		(int) inserts a new Node in the last place of the list
	 * 					and it becomes the new last
	 */
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.setElement(data);
		if (isEmpty()) {
			first = newNode;
		} else {
			last.setNext(newNode);					//o velho last apontará para o newNode
			newNode.setPrevious(last);				//newNode previous apontará para o velho last
		}
		last = newNode;								//atualiza o last
	}
	
	/**
	 * deleteFirst()
	 * 
	 * Deletes the first node of the list, if it's not empty. And returns the deleted Node
	 * 
	 * @returns Node
	 */
	public Node deleteFirst() {
		Node temp = first;
		if (!isEmpty() && first.getNext() == null) {//Se a lista não estiver vazia e houver apenas um nó
			last = null;
		} else {
			first.getNext().setPrevious(null);		//o novo primeiro nó (first), apontará para null (desfaz link com o antigo first)
		}
		
		first = first.getNext();					//first apontará para o novo first, aquele após o antigo first (pois first já aponta para o primeiro)
		return temp;								//retorna o nó deletado
	}
	/**
	 * deleteLast()
	 * 
	 * Deletes the last node of the list, if it's not empty. And returns the deleted Node
	 * 
	 * @returns Node
	 */
	public Node deleteLast() {
		Node temp = last;
		if (!isEmpty() && first.getNext() == null) {// se a lista não estiver vazia e houver apenas um elemento
			first = null;							//first apontará para null
		} else {
			last.getPrevious().setNext(null);		//o antecessor de last apontará para null, deixando de apontar para o antigo último
			
		}
		last = last.getPrevious();					//novo last é agora o antecessor do antigo last
		temp.setPrevious(null);						//temp que aponta para o antigo last, faz o antigo last parar de apontar para o antigo antecessor e o corta da lista.		
		return temp;
	}
	
	
	/**
	 * insertAfter()
	 * Inserts a node after, if found, a specific one.
	 * @param place				the data that you want insert after
	 * @param data				the data of the new Node
	 * @return					true if founds a node, false if it doesn't founds.
	 */
	public boolean insertAfter(int place, int data) {
		Node current = first;							//Atual vai se referir ao first
		while (current.getElement() != place) {			//Enquanto o dado do nó atual for diferente do dado procurado
			current = current.getNext();				//atual move para o pŕoximo
			if (current == null)						//se percorrer toda a lista  não achar o dado, retorna falso
				return false;
		}
		Node newNode = new Node();						//cria o novo nó
		
		if(current == last) {							//se o atual for o último, chama o método insertLast(), e retorna true
			insertLast(data);
			return true;
		} else {										//se o elemento estiver no meio da lista, irá ser inserido na posição após
			newNode.setElement(data);
			newNode.setNext(current.getNext());			//faz o novo nó apontar para o próximo nó ao atual
			current.getNext().setPrevious(newNode);		//o previous do nó após o atual apontará para o novo nó
		}
		newNode.setPrevious(current);					//faz o previous apontar para o nó atual, fazendo dele antecessor
		current.setNext(newNode);						//faz o nó atual apontar para o novo nó, terminando  inserção entre dpos nós. e retorna true
		return true;
	}
	
	/**
	 * deleteNode()
	 * Deletes a specific Node found by the data in it.
	 * @param data			data to be found
	 * @return				true if deletes, false if not
	 */
	public Node deleteNode(int data) {
		Node current = first;										//atual se refere ao first
		while (current.getElement() != data) {						//enquanto o elemento a ser deletado não é encontrado, vá para o próximo
			current = current.getNext();	
			if (current == null)									//se não achar, retorne null (vazio)
				return null;
		}
		if (current == first) {										//se o atual for first, retorne deleteFirst()
			return deleteFirst();
		} else if (current == last){								//se o atual for last, retorne deleteLast()
			return deleteLast();
		} else {
			current.getPrevious().setNext(current.getNext());		//se estiver no meio, antecessor aponta para o sucessor
			current.getNext().setPrevious(current.getPrevious());	//sucessor aponta para antecessor
		}
		return current;												//retorne o atual
	}
	
	/**
	 * printListForward()
	 * Prints the Linked List from the first to the last element
	 */
	public void printListForward () {
		System.out.println("Lista (Primeiro --> Fim) ");
		Node atual = first;
		while (atual != null) {
			atual.printNode();
			atual = atual.getNext();
		}
	}
	
	/**
	 * printListBackwards()
	 * Prints the Linked List from the Last to the First element
	 */
	public void printListBackwards () {
		System.out.println("Lista (Fim --> Primeiro) ");
		Node atual = last;
		while (atual != null) {
			atual.printNode();
			atual = atual.getPrevious();
		}
	}
	
	
}
