package ds.bst;



/**
 * Node class contains the attributes to create a BST
 * by creating new Nodes we can link them, resulting in the Binary Search Tree
 * 
 * @author Thiago Dutra
 *
 */

public class BSTNode {
	private int element;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(int element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}
	
	public void printNode() {
		System.out.println("[ " + getElement() + " ]");
	}
}

