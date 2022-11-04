package classes;


public class Node {
	// data field
	public int weight;
	public String cha;
	Node left, right;
	
	//constructors
	public Node(String c, int weight, Node left, Node right) {
		this.cha = c;
		this.weight = weight;
		this.left = left;
		this.right = right;
	}
	
	public Node(String cha, int weight) {
		this.cha = cha;
		this.weight = weight;
		this.left = null;
		this.right = null;
	}
}
 