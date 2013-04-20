package pucrs.alpro3;

import static org.junit.Assert.*;

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
		t.insert(123);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testDuoRigthLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert(123);
		t.insert(124);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDuoLeftLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert(124);
		t.insert(123);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testTrioLeftLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert(124);
		t.insert(123);
		t.insert(122);
		int actual = t.countLeaves();
		int expected = 1;
		assertEquals(expected, actual);
	}

	
	@Test
	public void testTrioBalanceLeaves() {
		BinaryTree t = new BinaryTree();
		t.insert(122);
		t.insert(121);
		t.insert(123);
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
		t.insert(123);
		int actual = t.count();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testDuoRight() {
		BinaryTree t = new BinaryTree();
		t.insert(123);
		t.insert(124);
		int actual = t.count();
		int expected = 2;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDuoLeft() {
		BinaryTree t = new BinaryTree();
		t.insert(124);
		t.insert(123);
		int actual = t.count();
		int expected = 2;
		assertEquals(expected, actual);
	}
	
}
