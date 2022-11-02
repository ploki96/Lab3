package classes;

import java.util.HashMap;
import java.util.Comparator;

public class HuffmanTree {
	public HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
	public int size;
	public Node root;
	public PriorityQueue<Node> priorityQueue;
	
	public HuffmanTree(HashMap<Character, Integer> characterCount) {
		this.size = 0;
		characterCount = new HashMap<Character, Integer>();
		priorityQueue = new PriorityQueue<Node>((left, right) -> Double.compare(left.weight, right.weight));
	}
	
	public void buildTree() {
		
	}
	
	

}
