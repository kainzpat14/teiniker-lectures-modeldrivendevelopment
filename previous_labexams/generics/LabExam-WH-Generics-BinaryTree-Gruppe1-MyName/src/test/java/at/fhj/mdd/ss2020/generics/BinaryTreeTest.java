package at.fhj.mdd.ss2020.generics;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testIntegerTree() {
		IntegerBinaryTree tree = new IntegerBinaryTree();
		tree.add(20);
		tree.add(10);
		tree.add(30);
		tree.add(5);
		tree.add(25);
		tree.add(15);
		tree.add(35);
		Assert.assertEquals("5,10,15,20,25,30,35", tree.toString());
	}

	@Test
	public void testGenericIntegerTree() {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.add(20);
		tree.add(10);
		tree.add(30);
		tree.add(5);
		tree.add(25);
		tree.add(15);
		tree.add(35);
		Assert.assertEquals("5,10,15,20,25,30,35", tree.toString());
	}

	@Test
	public void testGenericDoubleTree() {
		BinaryTree<Double> tree = new BinaryTree<>();
		tree.add(0.20);
		tree.add(0.10);
		tree.add(0.30);
		tree.add(0.5);
		tree.add(0.25);
		tree.add(0.15);
		tree.add(0.35);
		// NOTE: If your system is german this might cause the "." to be replaced by
		// ",", so change them here if your test fails
		Assert.assertEquals("0.1,0.15,0.2,0.25,0.3,0.35,0.5", tree.toString());
	}

	@Test
	public void testGenericCoordinateTree() {
		BinaryTree<Coordinate> tree = new BinaryTree<>();
		tree.add(new Coordinate(0, 0));
		tree.add(new Coordinate(1, 0));
		tree.add(new Coordinate(0, 10));
		tree.add(new Coordinate(5, 0));
		tree.add(new Coordinate(0, 3));
		tree.add(new Coordinate(5, 5));
		tree.add(new Coordinate(1, 1));
		Assert.assertEquals("(0,0),(1,0),(1,1),(0,3),(5,0),(5,5),(0,10)", tree.toString());
	}
}
