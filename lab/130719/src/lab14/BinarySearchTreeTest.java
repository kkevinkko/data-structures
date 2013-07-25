package lab14;
import lab14.BinaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testContains() {
		BinarySearchTree t = new BinarySearchTree();
		t.fillSampleTree1();
		t.print();
		assertTrue(t.contains("a"));
		assertTrue(t.contains("b"));
		assertTrue(t.contains("c"));
	}

}
