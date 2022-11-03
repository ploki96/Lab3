package classes;


public class Node {
	public int weight;
	public char c;
	Node left, right;
	
	public Node(char c, int weight, Node left, Node right) {
		this.c = c;
		this.weight = weight;
		this.left = left;
		this.right = right;
	}
	
	public Node(char c, int weight) {
		this.c = c;
		this.weight = weight;
		this.left = null;
		this.right = null;
	}
}
 