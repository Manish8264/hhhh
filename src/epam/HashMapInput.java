package epam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapInput {
	
	    // Helper function to read an array of strings
	    public static String[] readStrings() {
	        Scanner scanner = new Scanner(System.in);
	        String line = scanner.nextLine();
	        return line.split(" ");
	    }

	    // Driver function
	    public static void main(String args[]) throws Exception {
	        String[] texts = readStrings();
	        String result = solve(texts);
	        System.out.println(result);
	    }

	    // Function to find the most frequent string in an array of strings
	    public static String solve(String[] inputstr) {
	        // Create a HashMap to store the frequency of each string
	        Map<String, Integer> frequencyMap = new HashMap<>();

	        // Iterate over the input array and update the frequency of each string in the HashMap
	        for (String str : inputstr) {
	            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
	        }

	        // Find the entry with the maximum frequency
	        Map.Entry<String, Integer> maxEntry = Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue());

	        // Return the key of the entry with the maximum frequency
	        return maxEntry.getKey();
	    }
	}

