package ds.doublylinkedlist;

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
	
	public Node deleteLast() {
		Node temp = last;
		if (!isEmpty() && first.getNext() == null) {
			first = null;
		} else {
			last.getPrevious().setNext(null);
			
		}
		temp.setPrevious(null);
		last = last.getPrevious();	
		return temp;
	}
	
	public boolean insertAfter(int place, int data) {
		Node current = first;
		while (current.getElement() != place) {
			current = current.getNext();
			if (current == null)
				return false;
		}
		Node newNode = new Node();
		
		if(current == last) {
			insertLast(data);
			return true;
		} else {
			newNode.setElement(data);
			newNode.setNext(current.getNext());
			current.getNext().setPrevious(newNode);
		}
		newNode.setPrevious(current);
		current.setNext(newNode);
		return true;
	}
	
	public Node deleteNode(int data) {
		Node current = first;
		while (current.getElement() != data) {
			current = current.getNext();
			if (current == null)
				return null;
		}
		if (current == first) {
			return deleteFirst();
		} else if (current == last){
			return deleteLast();
		} else {
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
		}
		return current;
	}
	
	public void printListForward () {
		System.out.println("Lista (Primeiro --> Fim) ");
		Node atual = first;
		while (atual != null) {
			atual.printNode();
			atual = atual.getNext();
		}
	}
	
	public void printListBackwards () {
		System.out.println("Lista (Fim --> Primeiro) ");
		Node atual = last;
		while (atual != null) {
			atual.printNode();
			atual = atual.getPrevious();
		}
	}
	
	
}
