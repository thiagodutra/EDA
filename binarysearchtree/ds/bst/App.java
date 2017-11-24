package ds.bst;


public class App {

	public static void main(String[] args) throws Exception {
		BinarySearchTree a = new BinarySearchTree();
		a.insert(20);
		a.insert(10);
		a.insert(15);
		a.insert(5);
		a.insert(30);
		a.insert(40);
		a.insert(25);
		a.insert(54);
		a.insert(23);
		a.insert(31);
		System.out.println(a.search(19));
		a.traversalPre(); System.out.println();
		a.delete(20);
		
		System.out.println(a.countNodes());
		System.out.println(a.height());
		System.out.println(a.isComplete());
		System.out.println("Em Ordem");
		for (int i = 0; i < a.order().length; i++) {
			System.out.print("[" + a.order()[i] + "] " );
		}
		System.out.println();
		a.traversal();
		System.out.println();
		System.out.println("Pre");
		a.traversalPre();
		System.out.println();
		for (int i = 0; i < a.preOrder().length; i++) {
			System.out.print("[" + a.preOrder()[i] + "] " );
		}
		System.out.println();
		System.out.println("pos");
		a.traversalPos();
		System.out.println();
		for (int i = 0; i < a.postOrder().length; i++) {
			System.out.print("[" + a.postOrder()[i] + "] " );
		}
		System.out.println();
	}
}
