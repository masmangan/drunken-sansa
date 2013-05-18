package pucrs.alpro3.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe <code>BinaryTree</code> � uma implementa��o de �rvore bin�ria
 * conforme as discuss�es realizadas durante as aulas de Algoritmos e
 * Programa��o III, de 2013/1.
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class BinaryTree {

	// Refer�ncia para a raiz da �rvore.
	// � null no caso de uma �rvore vazia.
	private Node root;

	/*
	 * Node A �rvore bin�ria usa esta classe interna. Cada nodo cont�m uma
	 * informa��o e refer�ncias para as sub-�rvores esquerda e direita.
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
	 * Cria uma �rvore vazia, ou seja, uma refer�ncia nula.
	 * 
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Insere um novo nodo com <code>data</code>. Chaves repetidas s�o
	 * permitidas. (Esta implementa��o utiliza um la�o enquanto.)
	 * 
	 * @param data
	 */
	public void insert1(int data) {
		root = insert1(root, data);
	}

	/**
	 * Insere um novo nodo com <code>data</code>. Chaves repetidas s�o
	 * permitidas. (Esta implementa��o utiliza recursividade.)
	 * 
	 * @param data
	 */
	public void insert2(int data) {
		root = insert2(root, data);
	}

	/**
	 * Destroi uma �rvore chamando um m�todo interno
	 */
	public void destroy() {
		destroy(root);
		root = null;
	}

	/**
	 * Conta quantos nodos est�o presentes na �rvore.
	 * 
	 * @return o n�mero de nodos na �rvore.
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
	 * Inser��o recursiva. Dado um nodo, percorre a sub-árvore até achar o
	 * local de inser��o do valor pedido. Retorna uma referência para o novo
	 * nodo. Elementos repetidos s�o permitidos.
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
	 * Conta o n�mero de nodos folha na �rvore. Um nodo folha � um nodo sem
	 * filhos.
	 * 
	 * @return o n�mero de nodos folha.
	 */
	public int countLeaves() {
		return countLeaves(root);
	}

	/**
	 * Retorna o n�mero de nodos folha.
	 * 
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
	 * Retorna true se a �rvore est� vazia.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * getParent(elem) - um m�todo que informa o valor armazenado no pai de um
	 * 
	 * @param elem
	 * @return
	 */
	public int getParent(int elem) {
		return getParent(root, null, elem);
	}

	/**
	 * Gera uma exce��o caso o valor e n�o for encontrado. (Esta vers�o causa
	 * uma chamada recursiva adicional.)
	 * 
	 * @param n
	 *            o nodo a ser processado
	 * @param p
	 *            o nodo pai do nodo n
	 * @param e
	 *            o valor a ser encontrado
	 * 
	 * @return o valor armazenado no nodo pai de n.
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
			throw new RuntimeException("Elemento n�o encontrado!");

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
			throw new RuntimeException("Elemento n�o encontrado!");

		if (n.data == e)
			return c;

		if (e < n.data)
			return getNivel(n.left, e, c + 1);
		else
			return getNivel(n.right, e, c + 1);

	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	public void printInOrder() {
		printInOrder(root);
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

	private void printPreOrder(Node n) {
		if (n == null)
			return;
		System.out.println(n.data);
		printPreOrder(n.left);
		printPreOrder(n.right);
	}

	private void printInOrder(Node n) { // Central
		if (n == null)
			return;
		printInOrder(n.left);
		System.out.println(n.data);
		printInOrder(n.right);
	}

	private void printPostOrder(Node n) {
		if (n == null)
			return;
		printPostOrder(n.left);
		printPostOrder(n.right);
		System.out.println(n.data);
	}

	public void printByLevel() {
		int h = getAltura(root.data);

		for (int i = 0; i <= h; i++) {
			System.out.printf("N�vel: %d\n", i);
			printByLevel(root, i, 0);
		}
	}

	private void printByLevel(Node n, int level, int count) {
		if (n == null)
			return;
		if (level == count) {
			System.out.println("*" + n.data);
		} else {
			printByLevel(n.left, level, count + 1);
			printByLevel(n.right, level, count + 1);
		}

	}

	public void questao8() {
		int h = getAltura(root.data);

		for (int i = 0; i <= h; i++) {
			
			List<Integer> l = new ArrayList<Integer>();
			getByLevel(l, root, i, 0);
			int p = 0;
			for (Integer x : l) {
				if (x % 2 == 0) {
					p++;
				}
			}
			System.out.printf("N�vel %d\n", i);
			System.out.println(l);

			if (p == 0) {
				System.out.printf("***N�vel composto por �mpares!\n");
			}
			
		}
		
	}

	private void getByLevel(List<Integer> nodes, Node n, int level, int count) {
		if (n == null)
			return;
		if (level == count) {
			nodes.add(n.data);
		} else {
			getByLevel(nodes, n.left, level, count + 1);
			getByLevel(nodes, n.right, level, count + 1);
		}

	}

	// todos os caminhos formados por pares.
	public void questao7()
	{
		processar(root);
	}
	
	private void processar(Node n) {
		if (n != null) {
			
			List<Integer> l = new ArrayList<Integer>();
			getCaminho(l, root, n.data);
			System.out.println(l);
			
			processar(n.left);
			processar(n.right);
		}
	}
	
	private void getCaminho(List<Integer> nodes, Node n, int e) {
		if (n == null)
			throw new RuntimeException("Elemento n�o encontrado!");

		if (n.data % 2 == 1) {
			nodes.clear();
			return;
			// o caminho cont�m um �mpar!!! N�o h� resposta!
		}
		nodes.add(n.data);
		if (n.data == e) {
			return;
			// final do caminho, nodes cont�m a resposta!
		}

		if (e < n.data)
			getCaminho(nodes, n.left, e);
		else
			getCaminho(nodes, n.right, e);
	}	
	
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.insert2(8);
		t.insert2(12);
		t.insert2(4);
		t.insert2(6);
		t.insert2(2);
		t.insert2(14);
		//t.insert2(6);
		//t.insert2(8);

		// t.printInOrder();
		//t.printByLevel();
		//t.questao8();
		t.questao7();
	}

}
