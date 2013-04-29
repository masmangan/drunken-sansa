package pucrs.alpro3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testEmptyLeaves() {
		BinaryTree t = new BinaryTree();
		int actual = t.countLeaves();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert1(123);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testDuoRigthLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert1(123);
		t.insert1(124);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testDuoLeftLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert1(124);
		t.insert1(123);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testTrioLeftLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert1(124);
		t.insert1(123);
		t.insert1(122);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testTrioBalanceLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert1(122);
		t.insert1(121);
		t.insert1(123);
		int actual = t.countLeaves();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void testEmpty() {
		BinaryTree t = new BinaryTree();
		int actual = t.count();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testUnity() {
		BinaryTree t = new BinaryTree();
		t.insert1(123);
		int actual = t.count();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testDuoRight() {
		BinaryTree t = new BinaryTree();
		t.insert1(123);
		t.insert1(124);
		int actual = t.count();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void testDuoLeft() {
		BinaryTree t = new BinaryTree();
		t.insert1(124);
		t.insert1(123);
		int actual = t.count();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void testTio() {
		BinaryTree t = new BinaryTree();
		t.insert1(122);
		t.insert1(121);
		t.insert1(123);
		t.insert1(120);

		int actual = t.getUncle(120);
		int expected = 123;
		assertEquals(expected, actual);
	}

	@Test
	public void testGrau() {
		BinaryTree t = new BinaryTree();
		t.insert1(122);
		t.insert1(121);
		t.insert1(123);
		t.insert1(120);

		int actual = t.getGrau(120);
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testGrau2() {
		BinaryTree t = new BinaryTree();
		t.insert1(122);
		t.insert1(121);
		t.insert1(123);
		t.insert1(120);

		int actual = t.getGrau(122);
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void testGrau1() {
		BinaryTree t = new BinaryTree();
		t.insert1(122);
		t.insert1(121);
		t.insert1(123);
		t.insert1(120);

		int actual = t.getGrau(121);
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testAlturaFolha() {
		BinaryTree t = new BinaryTree();
		t.insert1(122);
		t.insert1(121);
		t.insert1(123);
		t.insert1(120);

		int actual = t.getAltura(123);
		int expected = 0;
		assertEquals(expected, actual);
		actual = t.getAltura(120);
		expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testAlturaRaiz() {
		BinaryTree t = new BinaryTree();
		t.insert1(122);
		t.insert1(121);
		t.insert1(123);
		t.insert1(120);

		int actual = t.getGrau(122);
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testTioArvoreVazia() {
		BinaryTree t = new BinaryTree();

		t.getUncle(120);
		fail();
	}

}
