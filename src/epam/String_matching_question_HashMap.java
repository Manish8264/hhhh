package epam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
The input array contains at least one string and at most 10^4 strings.

Each string in array consists of lowercase English letters only.

If there are multiple strings with the same maximum frequency, you can return the first one.
Input Format:

line 1: array of space separated strings

Example 1:

Input: apple banana apple banana cherry apple

Output: apple

Explanation: In the given example, the string "apple" appears three times, which is the highest frequency among all the strings in the array. Therefore, the function should return "apple" as the most frequent string.

Example 2:

Input: apple banana orange grape kiwi

Output: apple

Explanation: In this case, each string appears only once, and there is no string that appears more frequently than others, Since all strings have the same frequency (which is 1), the expected output will be "apple".

Output in format below
class Main {

 */
public class String_matching_question_HashMap {
	    // Helper function to read an array of strings
	    public static String[] readStrings() {
	        Scanner scanner = new Scanner(System.in);
	        String line = scanner.nextLine();
	        String[] array = line.split(" ");
	        return array;
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
	        HashMap<String, Integer> frequencyMap = new HashMap<>();

	        // Iterate over the input array and update the frequency of each string in the HashMap
	        for (String str : inputstr) {
	            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
	        }

	        // Find the string with the maximum frequency
	        int maxFrequency = 0;
	        String mostFrequentString = "";
	        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
	            if (entry.getValue() > maxFrequency) {
	                maxFrequency = entry.getValue();
	                mostFrequentString = entry.getKey();
	            }
	        }

	        // Return the most frequent string
	        return mostFrequentString;
	    }
	}


