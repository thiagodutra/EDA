package ds.lists;

public class App {

	public static void main(String[] args) {
		SinglyLinkedList a = new SinglyLinkedList();
		
		a.insertFirst(100);	a.printList();
		a.insertFirst(2);	a.printList();
		a.insertLast(99999);a.printList();
		a.insertFirst(21);	a.printList();
		a.insertFirst(531);	a.printList();
		a.insertLast(15);	a.printList();

	}

}
