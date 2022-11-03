package classes;

public class BinaryTree<E> {
	Node root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public BinaryTree(char c, int weight, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		this.root = new Node(c, weight);
		if (leftTree != null) {
			root.left = leftTree.root;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		}
	}
	
	public BinaryTree(Node root, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		this.root = new Node(root.c, root.weight);
		if (leftTree != null) {
			root.left = leftTree.root;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		}
	}
	
	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree<E>(root.left);
		} else {
			return null;
		}
	}
	
	public BinaryTree<E> getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree<E>(root.right);
		} else {
			return null;
		}
	}
	
	public boolean isLeaf() {
		return (root.left == null && root.right == null);
	}
	
	public String toString() {
		var sb = new StringBuilder();
		toString(root, 1, sb);
		return sb.toString();
	}
	
	public void toString(Node node, int depth, StringBuilder sb) {
		for (int i=1; i<depth; i++) {
			sb.append("\t");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(Character.toString(node.c));
			toString(node.left, depth + 1, sb);
			toString(node.right, depth + 1, sb);
		}
	}
}
