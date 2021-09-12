package at.fhj.mdd.ss2020.generics;

public class IntegerBinaryTree {

	private IntegerNode topNode;

	public void add(int value) {
		if (topNode == null) {
			topNode = new IntegerNode(value);
		} else {
			insert(topNode, value);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		appendToString(builder, topNode);
		return builder.toString();
	}

	private void insert(IntegerNode node, int value) {
		if (node.value > value) {
			if (node.left == null) {
				node.left = new IntegerNode(value);
			} else {
				insert(node.left, value);
			}
		} else {
			if (node.right == null) {
				node.right = new IntegerNode(value);
			} else {
				insert(node.right, value);
			}
		}
	}

	private void appendToString(StringBuilder builder, IntegerNode node) {
		if (node != null) {
			appendToString(builder, node.left);
			if (builder.length() > 0) {
				builder.append(",");
			}
			builder.append(node.value);
			appendToString(builder, node.right);
		}
	}

	private class IntegerNode {
		private int value;
		private IntegerNode left;
		private IntegerNode right;

		public IntegerNode(int value) {
			super();
			this.value = value;
		}

	}
}
