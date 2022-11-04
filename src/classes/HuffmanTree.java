package classes;

import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
	
	// data fields
	public BinaryTree<Node> huffTree = new BinaryTree<Node>();
	public HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
	public HashMap<Character, String> charToCode = new HashMap<Character, String>();
	
	// function to build binaryTree
	public void buildTree(HashMap<Character, Integer> tableMap) {
		PriorityQueue<BinaryTree<Node>> pQueue = new PriorityQueue<>(    // creating priority queue
				(lt, rt) -> Integer.compare(lt.root.weight, rt.root.weight));
				
		// loading priority queue with Binary Trees containing each node
		for (Map.Entry<Character, Integer> entry : tableMap.entrySet()) {   //looping through hashmap
			String cha = Character.toString(entry.getKey());
			Node node = new Node(cha, entry.getValue());					// creating node
			BinaryTree<Node> aBinaryTree = new BinaryTree<Node>(node);		// creating Binary Tree
			pQueue.offer(aBinaryTree);										// inserting into priority queue
		}
	
		// while loop to combine Binary Trees 
		while (pQueue.size()>1) {
			BinaryTree<Node> left = pQueue.poll(); // creating Binary Tree containing first Binary Tree found in priority queue
			BinaryTree<Node> right = pQueue.poll(); // creating Binary Tree containing second Binary Tree found in priority queue
			int wl = left.root.weight;				// variables containing Binary Tree information
			String sl = left.root.cha;
			int wr = right.root.weight;
			String sr = right.root.cha;
			Node sum = new Node(sl+sr, wl+wr);		// creating new node containing data of both left and right
			
			if(pQueue.size()> 2) {					// tiebreaker system, compares right to first Binary Tree in priority queue
				BinaryTree<Node> check = pQueue.peek();
				if (check.root.weight == wr) {
					if ((check.root.cha.length() < sr.length()) || (check.root.cha.length() == sr.length()) && check.root.cha.charAt(0) < sr.charAt(0)) {
						check = pQueue.poll();
						pQueue.offer(right);
						right = check;
					}
				}
			}
			
			if((wl == wr && sl.length() == sr.length() && sl.charAt(0) > sr.charAt(0)) || (wl == wr && sl.length() > sr.length())) {    // tiebreaker, compares left to right
				BinaryTree<Node> temp = left;
				left = right;
				right = temp;
				sum.cha = sr+sl;
			} 
			
			var newTree = new BinaryTree<Node>(sum, left, right);     // creates new Binary Tree with new node
			pQueue.offer(newTree);										// adds Tree to priority queue
		} // end while

		huffTree = pQueue.poll();   // Huffman Tree is the only tree left in priority queue, contains all other trees
		
	}
	
	// creates hashmap of characters to huffman codes
	public void createMaps (char c, String code) {
		charToCode.put(c, code);
	}
	
	// printing out the Huffman codes
	public void printCode(StringBuffer sb, String code, BinaryTree<Node> tree) {
		if (tree != null) {
			
			Node data = tree.root;
			if(data.cha.length() == 1) {
				char c = data.cha.charAt(0);
				sb.append(c + ": " + code + "\n");
				createMaps(c, code);
			} else {
				printCode(sb, code + "0", tree.getLeftSubtree());
				printCode(sb, code + "1", tree.getRightSubtree());
			}
		}
		
	}
	
	// decode function
	public String decode (String message) {
		var output = new StringBuffer();
		var tree = huffTree;
		for (int i=0; i<message.length();i++) {  // for loop, finds code by searching tree for leaf
			if (message.charAt(i) == '1') {
				tree = tree.getRightSubtree();
			} else {
				tree = tree.getLeftSubtree();
			}
			if(tree.isLeaf()) {                  // if node is leaf, code is appended to output
				Node node = tree.root;
				output.append(node.cha);
				tree = huffTree;
			}
		} // end for
		return output.toString();    // return output
	}
	
	// encode function
	public String encode (String message) {
		var output = new StringBuffer();
		for (int i=0; i<message.length();i++) {                 // for loop, searches hashmap for huffman codes
			if (Character.isLetter(message.charAt(i))) {		// checking string for letters only
				char upper = Character.toUpperCase(message.charAt(i));      // checks hashmap with uppercase keys
				output.append(charToCode.get(upper));						// appending code to output
			} 
		} // end for
		return output.toString();								// returning output
	}
	

	
	
	
	
	

}
