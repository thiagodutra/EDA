package ds.lists;

public class App {

	public static void main(String[] args) {
		SinglyLinkedList a = new SinglyLinkedList();
		
		a.insertFirst(100);	a.print();
		a.insertFirst(2);	a.print();
		a.insertLast(99999);a.print();
		a.insertFirst(21);	a.print();
		a.insertFirst(531);	a.print();
		a.insertLast(15);	a.print();
		System.out.println(a.findRecursively(a.getFirst(), 531));
		System.out.println(a.findRecursively(a.getFirst(), 18));
		System.out.println(a.lengthRecursively(a.getFirst()));
		System.out.println(a.isEmpty());
		a.deleteFirst(); 	a.print();
		a.deleteFirst();	a.print();
		a.deleteFirst();	a.print();
		a.deleteFirst();	a.print();
		a.deleteFirst();	a.print();
		a.deleteFirst();	a.print();
		System.out.println(a.lengthRecursively(a.getFirst()));
		System.out.println(a.isEmpty());
		a.insertFirst(10);  a.print();
		a.insertFirst(11);	a.print();
		a.insertLast(13);	a.printListRecursively(a.getFirst());
		System.out.println(a.findRecursively(a.getFirst(), 13));
		System.out.println(a.lengthRecursively(a.getFirst()));
		System.out.println(a.isEmpty());
	}

}
