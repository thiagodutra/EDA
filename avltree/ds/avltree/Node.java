package ds.avltree;

public class Node {

	private int element;
	private Node right;
	private Node left;
	private int height;

	public Node(int element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "" + this.element;
	}

	// Getters and Setters
	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
