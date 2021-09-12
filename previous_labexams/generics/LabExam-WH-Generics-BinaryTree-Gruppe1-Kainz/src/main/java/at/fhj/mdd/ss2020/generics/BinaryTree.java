package at.fhj.mdd.ss2020.generics;

public class BinaryTree<T extends Comparable<T>> {
	private Node topNode;

	public void add(T value) {
		if (topNode == null) {
			topNode = new Node(value);
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

	private void insert(Node node, T value) {
		if (node.value.compareTo(value) > 0) {
			if (node.left == null) {
				node.left = new Node(value);
			} else {
				insert(node.left, value);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(value);
			} else {
				insert(node.right, value);
			}
		}
	}

	private void appendToString(StringBuilder builder, Node node) {
		if (node != null) {
			appendToString(builder, node.left);
			if (builder.length() > 0) {
				builder.append(",");
			}
			builder.append(node.value);
			appendToString(builder, node.right);
		}
	}

	private class Node {
		private T value;
		private Node left;
		private Node right;

		public Node(T value) {
			super();
			this.value = value;
		}

	}
}
