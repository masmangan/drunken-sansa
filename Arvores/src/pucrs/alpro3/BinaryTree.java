package pucrs.alpro3;

// BinaryTree.java
public class BinaryTree {

	// Referência para a raiz da árvore. É null para o caso de uma
	// árvore vazia.
	private Node root;

	/*
	 * Node A árvore binária usa esta classe interna. Cada nodo contém uma
	 * informação e referências para as sub-árvores esquerda e direita.
	 */
	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}

	/* Cria uma árvore vazia, ou seja, uma referência nula. */
	public BinaryTree() {
		root = null;
	}

	/* Inserção na árvore. Usa o método auxiliar */
	public void insert(int data) {
		root = insert1(root, data);
	}

	/* Inserção não-recursiva. */
	private Node insert1(Node root, int data) {
		Node novo = new Node(data);

		if (root == null)
			return novo;

		Node node = root;

		while (true) {
			if (data < node.data)
				if (node.left == null) {
					node.left = novo;
					break;
				} else
					node = node.left;
			else if (node.right == null) {
				node.right = novo;
				break;
			} else
				node = node.right;
		}
		return root;
	}

	/*
	 * Inserção recursiva. Dado um nodo, percorre a sub-árvore até achar o
	 * local de inserção do valor pedido. Retorna uma referência para o novo
	 * nodo. Elementos repetidos são permitidos.
	 */
	private Node insert2(Node node, int data) {
		if (node == null)
			return new Node(data);
		if (data < node.data)
			node.left = insert2(node.left, data);
		else
			node.right = insert2(node.right, data);
		return node;
	}

	/* Destroi uma árvore chamando um método interno */
	public void destroy() {
		destroy(root);
		root = null;
	}

	/* Método interno para destruição */
	private void destroy(Node node) {
		if (node == null)
			return;
		destroy(node.left);
		destroy(node.right);
		node.left = node.right = null;
	}

	public int count() {
		return count(root);
	}

	private int count(Node n) {
		if (n == null)
			return 0;

		return 1 + count(n.left) + count(n.right);
	}

	public int countLeaves() {
		// if (root == null)
		// return 0;
		return countLeaves(root);
	}

	private int countLeaves(Node n) {
		if (n == null)
			return 0;
		if (n.left == null && n.right == null)
			return 1;

		return countLeaves(n.left) + countLeaves(n.right);
	}

	public boolean isEmpty() {
		return root == null;
	}

	// getParent(elem) - um m�todo que informa o valor armazenado no pai de um
	// nodo com conte�do elem.
	public int getParent(int elem) {
		return getParent(root, null, elem);
	}

	/**
	 * Gera uma exce��o caso o valor e n�o seja encontrado.
	 * 
	 * @param n
	 * @param p
	 * @param e
	 * @return
	 */
	private int getParent(Node n, Node p, int e) {
		if (n == null)
			throw new RuntimeException("Elemento n�o encontrado!");
		if (n.data == e) {
			if (p == null)
				throw new RuntimeException("N�o existe pai!");
			return p.data;
		}
		if (e < n.data)
			return getParent(n.left, n, e);

		return getParent(n.right, n, e);
	}

	public int getParent2(int elem) {
		return getParent2(root, elem);
	}

	private int getParent2(Node n, int e) {
		if (n == null)
			throw new RuntimeException("Elemento n�o encontrado!");

		if (e < n.data) {
			if (n.left != null && n.left.data == e)
				return n.data;
			return getParent2(n.left, e);
		}
		if (n.right != null && n.right.data == e)
			return n.data;
		return getParent2(n.right, e);
	}

	public int getUncle(int elem) {
		return getUncle(root, null, null, elem);
	}

	private int getUncle(Node n, Node p, Node a, int e) {
		if (n == null)
			throw new RuntimeException("Elemento n�o encontrado!");
		if (n.data == e) {
			if (a == null)
				throw new RuntimeException("N�o existe avo!");
			if (a.data < e && a.left != null)
				return a.left.data;
			if (a.data > e && a.right != null)
				return a.right.data;
			throw new RuntimeException("Nao existe tio.");
		}
		if (e < n.data)
			return getUncle(n.left, n, p, e);
		return getUncle(n.right, n, p, e);

	}

	public int getGrau(int element) {
		return getGrau(root, element);
	}

	private int getGrau(Node n, int e) {
		if (n == null) {
			throw new RuntimeException("Elemento n�o encontrado!");
		}
		if (n.data == e) {
			if (n.left == null && n.right == null)
				return 0;
			if (n.left != null && n.right != null)
				return 2;
			return 1;
		}
		if (e < n.data)
			return getGrau(n.left, e);

		return getGrau(n.right, e);

	}

	public int getAltura(int elem) {
		return getAltura(root, elem);
	}

	private int getAltura(Node n, int e) {
		if (n == null)
			throw new RuntimeException("Elemento n�o encontrado!");
		if (n.data == e) {
			return altura(n);
		}
		if (e < n.data)
			return getAltura(n.left, e);

		return getAltura(n.right, e);
	}

	private int altura(Node n) {
		if (n == null) {
			return -1;
		}
		return 1 
				+ Math.max(altura(n.left), 
						altura(n.right));
	}

	public int getNivel(int elem) {
		return getNivel(root, elem, 0);
	}

	private int getNivel(Node n, int e, int c) {
		if (n == null)
			throw new RuntimeException("Elemento n�o encontrado!");
		if (n.data == e) {
			return c;
		}
		if (e < n.data)
			return getNivel(n.left, e, c + 1);

		return getNivel(n.right, e, c + 1);
	
	}

}
