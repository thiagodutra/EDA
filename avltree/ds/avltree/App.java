package ds.avltree;

public class App {

	public static void main(String[] args) {
		
		AVL_Tree_IF avl = new AVLTree();
		
		avl.insert(10);
		avl.insert(20);
		avl.insert(30);
		avl.insert(40);
		avl.insert(50);
		avl.insert(60);
		
		avl.traverse();

	}

}
