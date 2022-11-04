package classes;

public class BinaryTree<E> {
	Node root;
	
	// base constructor for Binary Tree
	public BinaryTree() {
		this.root = null;
	}
	
	// constructor for Binary Tree with one node
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	// constructor for Binary Tree with node information and two Binary Trees
	public BinaryTree(String c, int weight, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		this.root = new Node(c, weight);
		if (leftTree != null) {
			root.left = leftTree.root;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		}
	}
	
	// constructor for Binary tree with Node and two Binary Trees
	public BinaryTree(Node root, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		this.root = root;
		if (leftTree != null) {
			root.left = leftTree.root;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		}
	}
	
	// returns left subtree
	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree<E>(root.left);
		} else {
			return null;
		}
	}
	
	// returns right subtree
	public BinaryTree<E> getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree<E>(root.right);
		} else {
			return null;
		}
	}
	
	// checks if Binary Tree root is a leaf
	public boolean isLeaf() {
		return (root.left == null && root.right == null);
	}
	
	// printing out the tree start
	public String toString() {
		var sb = new StringBuilder();
		toString(root, 1, sb);
		return sb.toString();
	}
	
	// recursively printing out the tree
	public void toString(Node node, int depth, StringBuilder sb) {
		for (int i=1; i<depth; i++) {
			sb.append("  ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.cha);
			sb.append("\n");
			toString(node.left, depth + 1, sb);
			toString(node.right, depth + 1, sb);
		}
	}
	
}
