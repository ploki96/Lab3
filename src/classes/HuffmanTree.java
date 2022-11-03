package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class HuffmanTree {
	public BinaryTree<Node> huffTree;
	public HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
	public HashMap<Character, String> charToCode = new HashMap<Character, String>();
	public HashMap<String, Character> codeToChar = new HashMap<String, Character>();
	
	@SuppressWarnings("unchecked")
	public void buildTree(HashMap<Character, Integer> tableMap) {
		PriorityQueue<BinaryTree<Node>> pQueue = new PriorityQueue<>(
				(lt, rt) -> Integer.compare(lt.root.weight, rt.root.weight));
				
		for (Map.Entry<Character, Integer> entry : tableMap.entrySet()) {
			Node node = new Node(entry.getKey(), entry.getValue());
			BinaryTree aBinaryTree = new BinaryTree<Node>(node);
			pQueue.offer(aBinaryTree);
		}
		
		while (pQueue.size()>1) {
			BinaryTree<Node> left = pQueue.poll();
			int wl = left.root.weight;
			BinaryTree<Node> right = pQueue.poll();
			int wr = right.root.weight;
			Node sum = new Node('\u0000', wl+wr);
			var newTree = new BinaryTree<Node>(sum, left, right);
			pQueue.offer(newTree);
		}
		huffTree = pQueue.poll();
	}
	
	public void printCode(StringBuffer sb, String code, BinaryTree<Node> tree) {
		Node data = tree.root;
		if(data.c != '\u0000') {
			sb.append(data.c + ": " + code + "\n");
			charToCode.put(data.c, code);
			codeToChar.put(code, data.c);
		} else {
			printCode(sb, code + "0", tree.getLeftSubtree());
			printCode(sb, code + "1", tree.getRightSubtree());
		}
	}
	
	public String decode (String message) {
		var output = new StringBuffer();
		var tree = huffTree;
		for (int i=0; i<message.length();i++) {
			if (message.charAt(i) == '1') {
				tree = tree.getRightSubtree();
			} else {
				tree = tree.getLeftSubtree();
			}
			if(tree.isLeaf()) {
				Node node = tree.root;
				output.append(node.c);
				tree = huffTree;
			}
		}
		return output.toString();
	}
	
	
	
	
	

}
