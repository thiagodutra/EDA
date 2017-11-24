package ds.avltree;

public class AVLTree implements AVL_Tree_IF {

	private Node root;

	@Override
	public void insert(int element) {

		root = insert(root, element);

	}

	private Node insert(Node node, int element) {
		if (node == null)
			return new Node(element);
		if (element < node.getElement()) {
			node.setLeft(insert(node.getLeft(), element));
		} else {
			node.setRight(insert(node.getRight(), element));
		}

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		node = resolveHeights(element, node);

		return node;
	}
	
	private Node resolveHeights(int element, Node node) {
		int balance = getBalance(node);

		// Caso 1 - esq -> esq
		if (balance > 1 && element < node.getLeft().getElement()) {
			return rightRotation(node);
		}
		// Caso 2 - esq -> dir
		if (balance > 1 && element > node.getLeft().getElement()) {
			node.setLeft(leftRotation(node.getLeft()));
			return rightRotation(node);
		}
		// Caso 3 - dir -> dir
		if (balance < -1 && element > node.getRight().getElement()) {
			return leftRotation(node);
		}
		// Caso 4 - dir -> esq
		if (balance < -1 && element < node.getRight().getElement()) {
			node.setRight(rightRotation(node.getRight()));
			return leftRotation(node);
		}

		return node;
	}

	private Node leftRotation(Node node) {
		System.out.println("Rotacionando para esquerda");

		Node tempRight = node.getRight();
		Node temp = tempRight.getLeft();

		tempRight.setLeft(node);
		node.setRight(temp);

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		tempRight.setHeight(Math.max(height(tempRight.getLeft()), height(tempRight.getRight())) + 1);

		return tempRight;
	}

	private Node rightRotation(Node node) {
		System.out.println("Rotacionando para direita");

		Node tempLeft = node.getLeft();
		Node temp = tempLeft.getRight();

		tempLeft.setRight(node);
		node.setLeft(temp);

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		tempLeft.setHeight(Math.max(height(tempLeft.getLeft()), height(tempLeft.getRight())) + 1);

		return tempLeft;
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		return node.getHeight();
	}

	private int getBalance(Node node) {
		if (node == null)
			return 0;
		return height(node.getLeft()) - height(node.getRight());
	}

	@Override
	public void traverse() {
		if (root == null)
			return;
		inOrder(root);

	}

	private void inOrder(Node node) {
		if (node.getLeft() != null) {
			inOrder(node.getLeft());
		}
		System.out.println(node);
		if (node.getRight() != null) {
			inOrder(node.getRight());
		}
	}

}
