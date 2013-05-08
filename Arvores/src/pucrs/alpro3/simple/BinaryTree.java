package pucrs.alpro3.simple;

/**
 * A classe <code>BinaryTree</code> é uma implementação
 * de árvore binária conforme as discussões realizadas
 * durante as aulas de Algoritmos e Programação III, de
 * 2013/1.
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class BinaryTree {

	// Referência para a raiz da árvore.
	// É null no caso de uma árvore vazia.
	private Node root;

	/*
	 * Node A árvore binária usa esta classe interna. Cada nodo contém uma
	 * informação e referências para as sub-árvores esquerda e direita.
	 */
	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			left = right = null;
			this.data = data;
		}
	}

	/**
	 * Cria uma árvore vazia, ou seja, uma referência nula.
	 * 
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Insere um novo nodo com <code>data</code>.
	 * Chaves repetidas são permitidas.
	 * (Esta implementação utiliza um laço enquanto.)
	 * 
	 * @param data
	 */
	public void insert1(int data) {
		root = insert1(root, data);
	}

	/**
	 * Insere um novo nodo com <code>data</code>.
	 * Chaves repetidas são permitidas.
	 * (Esta implementação utiliza recursividade.)
	 * 
	 * @param data
	 */
	public void insert2(int data) {
		root = insert2(root, data);
	}	

	/**
	 * Destroi uma árvore chamando um método interno
	 */
	public void destroy() {
		destroy(root);
		root = null;
	}
	
	/**
	 * Conta quantos nodos estão presentes na árvore.
	 *  
	 * @return o número de nodos na árvore.
	 */
	public int count() {
		return count(root);
	}
	
	/**
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
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

	/**
	 * Inserção recursiva. Dado um nodo, percorre a sub-Ã¡rvore atÃ© achar o
	 * local de inserção do valor pedido. Retorna uma referÃªncia para o novo
	 * nodo. Elementos repetidos são permitidos.
	 * 
	 * @param node
	 * @param data
	 * @return
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

	/**
	 * 
	 * @param node
	 */
	private void destroy(Node node) {
		if (node == null)
			return;
		destroy(node.left);
		destroy(node.right);
		node.left = node.right = null;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	private int count(Node n) {
		if (n == null)
			return 0;

		return 1 + count(n.left) + count(n.right);
	}

	/**
	 * Conta o número de nodos folha na árvore.
	 * Um nodo folha é um nodo sem filhos.
	 * 
	 * @return o número de nodos folha.
	 */
	public int countLeaves() {
		return countLeaves(root);
	}

	/**
	 * Retorna o número de nodos folha.
	 * @param n
	 * @return
	 */
	private int countLeaves(Node n) {
		if (n == null)
			return 0;
		if (n.left == null && n.right == null)
			return 1;

		return countLeaves(n.left) + countLeaves(n.right);
	}

	/**
	 * Retorna true se a árvore está vazia.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * getParent(elem) - um método que informa o valor armazenado no pai de um
	 * 
	 * @param elem
	 * @return
	 */
	public int getParent(int elem) {
		return getParent(root, null, elem);
	}

	/**
	 * Gera uma exceção caso o valor e não for encontrado.
	 * (Esta versão causa uma chamada recursiva adicional.)
	 * @param n o nodo a ser processado
	 * @param p o nodo pai do nodo n
	 * @param e o valor a ser encontrado
	 * 
	 * @return o valor armazenado no nodo pai de n.
	 */
	private int getParent(Node n, Node p, int e) {
		if (n == null)
			throw new RuntimeException("Elemento não encontrado!");
		if (n.data == e) {
			if (p == null)
				throw new RuntimeException("Não existe pai!");
			return p.data;
		}
		if (e < n.data)
			return getParent(n.left, n, e);

		return getParent(n.right, n, e);
	}

	/**
	 * 
	 * @param elem
	 * @return
	 */
	public int getParent2(int elem) {
		return getParent2(root, elem);
	}

	/**
	 * 
	 * @param n
	 * @param e
	 * @return
	 */
	private int getParent2(Node n, int e) {
		if (n == null)
			throw new RuntimeException("Elemento não encontrado!");

		if (e < n.data) {
			if (n.left != null && n.left.data == e)
				return n.data;
			return getParent2(n.left, e);
		}
		if (n.right != null && n.right.data == e)
			return n.data;
		
		return getParent2(n.right, e);
	}

	/**
	 * 
	 * @param elem
	 * @return
	 */
	public int getUncle(int elem) {
		return getUncle(root, null, null, elem);
	}

	/**
	 * 
	 * @param n
	 * @param p
	 * @param a
	 * @param e
	 * @return
	 */
	private int getUncle(Node n, Node p, Node a, int e) {
		if (n == null)
			throw new RuntimeException("Elemento não encontrado!");
		
		if (n.data == e) {
			if (a == null)
				throw new RuntimeException("Não existe avo!");
			if (a.data < e && a.left != null)
				return a.left.data;
			if (a.data > e && a.right != null)
				return a.right.data;
			throw new RuntimeException("Nao existe tio.");
		}
		
		if (e < n.data)
			return getUncle(n.left, n, p, e);
		else
			return getUncle(n.right, n, p, e);

	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	public int getGrau(int element) {
		return getGrau(root, element);
	}

	/**
	 * 
	 * @param n
	 * @param e
	 * @return
	 */
	private int getGrau(Node n, int e) {
		if (n == null) {
			throw new RuntimeException("Elemento não encontrado!");
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
		else
			return getGrau(n.right, e);

	}

	/**
	 * 
	 * @param elem
	 * @return
	 */
	public int getAltura(int elem) {
		return getAltura(root, elem);
	}

	/**
	 * 
	 * @param n
	 * @param e
	 * @return
	 */
	private int getAltura(Node n, int e) {
		if (n == null)
			throw new RuntimeException("Elemento não encontrado!");
		
		if (n.data == e)
			return altura(n);
	
		if (e < n.data)
			return getAltura(n.left, e);
		else
			return getAltura(n.right, e);
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	private int altura(Node n) {
		if (n == null)
			return -1;
		
		return 1 + Math.max(altura(n.left), altura(n.right));
	}

	/**
	 * 
	 * @param elem
	 * @return
	 */
	public int getNivel(int elem) {
		return getNivel(root, elem, 0);
	}

	/**
	 * 
	 * @param n
	 * @param e
	 * @param c
	 * @return
	 */
	private int getNivel(Node n, int e, int c) {
		if (n == null)
			throw new RuntimeException("Elemento não encontrado!");
		
		if (n.data == e)
			return c;
		
		if (e < n.data)
			return getNivel(n.left, e, c + 1);
		else
			return getNivel(n.right, e, c + 1);

	}

}
