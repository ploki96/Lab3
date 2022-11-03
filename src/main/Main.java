package main;

import java.io.BufferedReader;
import classes.HuffmanTree;
import classes.PriorityQueue;
import classes.Node;
import classes.BinaryTree;


import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		StringBuffer output = new StringBuffer();
		output.append("Huffman Tree\r\n");
		String path = new File("").getAbsolutePath();
		
		System.out.println("Please enter name of the file with the frequency table: \n");
		Scanner scanner = new Scanner(System.in);
		String table = scanner.nextLine();
		
		BufferedReader inputTable = new BufferedReader(new FileReader(new File(path + "/table/" + table)));
		HashMap<Character, Integer> tableMap= new HashMap<Character, Integer>();
		
		String line;
		
		while ((line = inputTable.readLine()) != null) {
			String intString = line.substring(4);
			int i = Integer.parseInt(intString);
			char c = line.charAt(0);
	    	tableMap.put(c, i);
	    }
		
		HuffmanTree huffmanTree  = new HuffmanTree();
		
		huffmanTree.buildTree(tableMap);
		
		
		huffmanTree.printCode(output, "", huffmanTree.huffTree);
		System.out.println(output);
		
		
		
		
//		for (Map.Entry<Character, Integer> set :tableMap.entrySet()) {
//			System.out.println("Key:" + set.getKey() + ", Value:" + set.getValue());
//		} 
		
		System.out.println("Please enter name of the input file (ex: input.txt): \n");
		
		
	}
}
