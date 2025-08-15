package com.mst.iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
	public static void main(String[] args) {
		String sourceFilePath = "example.txt";
		String destinationFilePath = "destination.txt";
		int totalWords = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
			String line;
			int lineNumber = 0;
			
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				String[] words = line.split("\\s+");
				int wordCount = words.length;
				int charCount = line.length();
				totalWords += wordCount;
				
				writer.write("Line " + lineNumber + ": " + charCount + " characters");
				writer.newLine();
			}
			
			writer.write("Total words: " + totalWords);
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
