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
		if (root == null)
			return 0;		
		return countLeaves(root);
	}

	private int countLeaves(Node n) {
		if (n == null)
			return 0;		
		if (n.left == null && n.right == null)
			return 1;
	
		return countLeaves(n.left) + countLeaves(n.right);  
	}
}










