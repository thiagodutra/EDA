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
		System.out.println(a.findRecursively(a.getFirst(), 531));
		System.out.println(a.findRecursively(a.getFirst(), 18));
		System.out.println(a.lengthRecursively(a.getFirst()));
		System.out.println(a.isEmpty());
		a.deleteFirst(); 	a.printList();
		a.deleteFirst();	a.printList();
		a.deleteFirst();	a.printList();
		a.deleteFirst();	a.printList();
		a.deleteFirst();	a.printList();
		a.deleteFirst();	a.printList();
		System.out.println(a.lengthRecursively(a.getFirst()));
		System.out.println(a.isEmpty());
		a.insertFirst(10);  a.printList();
		a.insertFirst(11);	a.printList();
		a.insertLast(13);	a.printListRecursively(a.getFirst());
		System.out.println(a.findRecursively(a.getFirst(), 13));
		System.out.println(a.lengthRecursively(a.getFirst()));
		System.out.println(a.isEmpty());
	}

}
