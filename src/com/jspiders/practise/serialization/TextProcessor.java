package com.jspiders.practise.serialization;


	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;

	public class TextProcessor {
	    public static void main(String[] args) {
	        String filename = "C:\\File\\TEST\\sample.txt";
	        
	        // Task 1: Find the number of times each word occurs
	        Map<String, Integer> wordCounts = new HashMap<>();
	        
	        // Task 2: Find the number of lines in the file
	        int lineCount = 0;

	        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Increment line count for non-empty lines beginning with an alphabet
	                if (!line.trim().isEmpty() && Character.isLetter(line.charAt(0))) {
	                    lineCount++;
	                }
	                
	                // Tokenize the line into words
	                String[] words = line.split("\\s+");

	                for (String word : words) {
	                    // Remove special characters and stand-alone numbers
	                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
	                    
	                    if (!word.isEmpty() && !Character.isDigit(word.charAt(0))) {
	                        // Update word count
	                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Print word counts
	        System.out.println("Word Counts:");
	        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }

	        // Print line count
	        System.out.println("Line Count: " + lineCount);
	    }
	}

