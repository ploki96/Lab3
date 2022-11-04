package main;

import java.io.BufferedReader;
import classes.HuffmanTree;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		StringBuffer output = new StringBuffer();   // creating output string
		output.append("Huffman Tree\r\n\n");
		
		String path = new File("").getAbsolutePath();   // creating path
		String encodeMessages[] = new String[100];   // Array used to hold messages to encode
		String decodeMessages[] = new String[100];   // Array used to hold messages to decode
		
		
		
		// input for table with values
		System.out.println("Please enter name of the file with the frequency table: (Ex. values.txt)\n");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		//getting output file name for table and codes
		System.out.println("Please enter name of the file you would like to print the Huffman Tree to: (Ex. huffmanTree.txt)\n");
		String tableOutput = scanner.nextLine();
		BufferedReader inputTable = new BufferedReader(new FileReader(new File(path + "/table/" + input)));
		PrintWriter outputTable = new PrintWriter(new FileWriter(path + "/output/" + tableOutput));
		
		HashMap<Character, Integer> tableMap= new HashMap<Character, Integer>(); // Creating hashmap for characters and count
		String line;
		
		// while loop to fill hashmap 
		while ((line = inputTable.readLine()) != null) {
			String intString = line.substring(4);
			int i = Integer.parseInt(intString);
			char c = line.charAt(0);
	    	tableMap.put(c, i);
	    }
		inputTable.close();
		
		// Initializing instance of Huffman Tree
		HuffmanTree huffmanTree = new HuffmanTree();
		
		huffmanTree.buildTree(tableMap);
		
		// outputting table with tree
		output.append(huffmanTree.huffTree.toString());
		output.append("\nHuffman Codes \n\n");
		huffmanTree.printCode(output, "", huffmanTree.huffTree);
		outputTable.print(output);
		output.delete(0, output.length());  //clearing output
		outputTable.close();
		
		int i = 0;
		
		//input for encoding 
		System.out.println("Please enter name of the file with messages to encode: (Ex. stringInput.txt)\n");
		input = scanner.nextLine();
		BufferedReader inputEncode = new BufferedReader(new FileReader(new File(path + "/input/" + input)));
		
		// getting output file for encoding
		System.out.println("Please enter name of the file you would like to print the encoded messages to: (Ex. binaryOutput.txt)\n\n");
		String encodeOutput = scanner.nextLine();
		PrintWriter outputEncode = new PrintWriter(new FileWriter(path + "/output/" + encodeOutput));
		
		output.append("Encoded Messages\n\n");   //adding title
		
		//Adds each expression in input file as its own element in encode array until end of input file is reached
		while ((line = inputEncode.readLine()) != null) {
			encodeMessages[i] = line;
	        i++;
	    }
		inputEncode.close();  //Closing BufferedReader
		
		// for loop, calling encode function to encode message, appending to output original message and encoded message
		for (int j=0; j<i;j++) {
			output.append(encodeMessages[j] + "\n");
			output.append(huffmanTree.encode(encodeMessages[j]) + "\n\n");
		}
		
		outputEncode.print(output);     // outputting encoded messages
		outputEncode.close();
		output.delete(0, output.length());  //clearing output
		
		
			
		//input for decoding
		System.out.println("Please enter name of the file with messages to decode: (Ex. binaryInput.txt)\n");
		input = scanner.nextLine();
		BufferedReader inputDecode = new BufferedReader(new FileReader(new File(path + "/input/" + input)));
		
		// getting output file for decoding
		System.out.println("Please enter name of the file you would like to print the decoded messages to: (Ex. stringOutput.txt)\n\n");
		String decodeOutput = scanner.nextLine();
		PrintWriter outputDecode = new PrintWriter(new FileWriter(path + "/output/" + decodeOutput));
		
		output.append("Decoded Messages\n\n");   //adding title
		
		i=0;
		
		//Adds each expression in input file as its own element in decode array until end of input file is reached
		while ((line = inputDecode.readLine()) != null) {  
			decodeMessages[i] = line;
	        i++;
	    }
		
		inputDecode.close(); // closing reader
		
		// for loop, calling encode function to decode message, appending to output original message and decoded message
		for (int j=0; j<i;j++) {
			output.append(decodeMessages[j] + "\n");
			output.append(huffmanTree.decode(decodeMessages[j]) + "\n\n");
		}
		
		outputDecode.print(output);     // outputting encoded messages
		outputDecode.close();  //closing writer
		output.delete(0, output.length());  //clearing output
		scanner.close();   // closing scanner
		
		inputDecode.close();   //Closing BufferedReader
		
		
		

		
		
	}
}
