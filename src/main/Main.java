package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		StringBuffer output = new StringBuffer();
		output.append("Huffman Tree\r\n");
		String path = new File("").getAbsolutePath();
		
		System.out.println("Please enter name of the frequency table: \n");
		Scanner scanner = new Scanner(System.in);
		String table = scanner.nextLine();
		
		BufferedReader input = new BufferedReader(new FileReader(new File(path + "/input/" + table)));
		
		HashMap<Character, Integer> tableMap= new HashMap<Character, Integer>();
		String line;
	    
		while ((line = input.readLine()) != null) {
			String number = line.substring(4);
			tableMap.put(line.charAt(0), Integer.parseInt(number));
	    }
		
		System.out.println("Please enter name of the input file (ex: input.txt): \n");
		
		
	}
}
