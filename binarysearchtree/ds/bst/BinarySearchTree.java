package ds.bst;

public class BinarySearchTree implements BST_IF {

	private BSTNode root;

	@Override
	public void insert(int element) {

		if (root == null) {
			root = new BSTNode(element);
		} else {
			insertNode(element, root);
		}

	}

	private void insertNode(int element, BSTNode node) {

		if (element < node.getElement()) {
			if (node.getLeft() != null) {
				insertNode(element, node.getLeft());
			} else {
				BSTNode newNode = new BSTNode(element);
				node.setLeft(newNode);
			}
		} else {
			if (node.getRight() != null) {
				insertNode(element, node.getRight());
			} else {
				BSTNode newNode = new BSTNode(element);
				node.setRight(newNode);
			}
		}
	}

	@Override
	public int search(int element) throws Exception {
		if (root == null)
			throw new Exception ("Árvore vazia"); 
		return searchNode(element, root);
	}
	
	private int searchNode(int element, BSTNode node) throws Exception {
		if (element == node.getElement()) {
			if (element < node.getElement()) {
				searchNode(element, node.getLeft());
			}
			if (element > node.getElement()) {
				searchNode(element, node.getRight());
			}
			return node.getElement();
		}
		throw new Exception ("Elemento não encontrado.");
	}

	@Override
	public int[] preOrder() {
		int[] array = new int[countNodes()];
		preOrder(root, array, 0);
		return array;
	}

	private int preOrder(BSTNode node, int[] array, int i) {
		if (node == null)
			return i;
		array[i] = node.getElement();
		i = preOrder(node.getLeft(), array, i + 1);
		i = preOrder(node.getRight(), array, i);
		return i;
	}

	@Override
	public int[] order() {
		int[] array = new int[countNodes()];
		inOrder(root, array, 0);
		return array;
	}

	private int inOrder(BSTNode node, int[] array, int i) {
		if (node == null)
			return i;
		i = inOrder(node.getLeft(), array, i);
		array[i] = node.getElement();
		i = inOrder(node.getRight(), array, i + 1);
		return i;
	}

	@Override
	public int[] postOrder() {
		int[] array = new int[countNodes()];
		postOrder(root, array, 0);
		return array;
	}

	private int postOrder(BSTNode node, int[] array, int i) {
		if (node == null)
			return i;
		i = postOrder(node.getLeft(), array, i);
		i = postOrder(node.getRight(), array, i);
		array[i] = node.getElement();
		return i + 1;
	}

	/**
	 * Retorna se a árvore está completa ou não através da verificação entre número
	 * de nós na árvore e o máximo de nós que ela pode ter
	 */
	@Override
	public boolean isComplete() {
		return (countNodes() == (Math.pow(2, height() + 1)) - 1);
	}

	/**
	 * Método para retornar a altura da árvore
	 * 
	 * @return altura da árvore
	 */
	public int height() {
		return height(root) - 1;
	}

	private int height(BSTNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
	}

	/**
	 * Método para retorna o número de nós da árvores.
	 * 
	 * @return numero de nós da arvóre
	 */
	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
	}

	public void delete(int element) {
		deleteNode(root, element);
	}
	
	private BSTNode deleteNode(BSTNode node, int element) {
		if (node == null) 
			return node;
		if (element < node.getElement()) {
			node.setLeft(deleteNode(node.getLeft(), element));
		} else if (element > node.getElement()) {
			node.setRight(deleteNode(node.getRight(), element));
		} else {
			//Encontramos o nó a ser removidos
			
			//Nó é uma folha da árvore
			if (isLeaf(node)) {
				System.out.println("Removendo uma folha da árvore");
				return null;
			}
			//Nó tem apenas o filho direito
			if (node.getLeft() == null) {
				System.out.println("Removendo filho direito");
				BSTNode newNode = node.getRight();
				node = null;
				return newNode;
			//Nó tem apenas o filho esquerdo
			} else if (node.getRight() == null){
				System.out.println("Removendo filho esquerdo");
				BSTNode newNode = node.getLeft();
				node = null;
				return newNode;
			}
			System.out.println("Removendo nó com dois filhos");
			//Caso o nó a ser removido tenha dois filhos
			BSTNode newNode = getSucessor(node.getRight());
			node.setElement(newNode.getElement());
			node.setLeft(deleteNode(node.getLeft(), node.getElement()));
		}
		
		return node;
	}
	
	private BSTNode getSucessor(BSTNode node) {
		if (node.getLeft() != null)
			return getSucessor(node.getLeft());
		return node;
	}
	
	/**
	 * Métodos auxiliares e de testes
	 */

	public boolean isLeaf(BSTNode node) {
		return (node.getLeft() == null && node.getRight() == null);
	}
	public void traversal() {
		if (root != null) {
			inOrderTraversal(root);
		}
	}

	public void traversalPre() {
		if (root != null) {
			preTraversal(root);
		}
	}

	public void traversalPos() {
		if (root != null) {
			posTraversal(root);
		}
	}

	private void preTraversal(BSTNode node) {

		System.out.print("[" + node.getElement() + "] ");

		if (node.getLeft() != null) {
			preTraversal(node.getLeft());
		}

		if (node.getRight() != null) {
			preTraversal(node.getRight());
		}
	}

	private void posTraversal(BSTNode node) {
		if (node.getLeft() != null) {
			posTraversal(node.getLeft());
		}

		if (node.getRight() != null) {
			posTraversal(node.getRight());
		}

		System.out.print("[" + node.getElement() + "] ");
	}

	private void inOrderTraversal(BSTNode node) {
		if (node.getLeft() != null) {
			inOrderTraversal(node.getLeft());
		}
		System.out.print("[" + node.getElement() + "] ");

		if (node.getRight() != null) {
			inOrderTraversal(node.getRight());
		}
	}
}
