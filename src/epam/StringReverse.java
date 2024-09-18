package epam;

import java.util.Scanner;

public class StringReverse {
	/*Create a function that reverses a string with a unique property, it contand three special characters (@,_,$ ), and when reversed:

		1. Alphabets should be reversed.

		2. Special characters should remain in their original positions. 
		Example1: Input:   Ni@te_sh$ 
				  Output:  hs@et_iN$
		
		*/
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String input = scanner.nextLine();
	        String output = solve(input);
	        System.out.println(output);
	    }

	    public static String solve(String input) {
	        char[] arr = input.toCharArray();
	        int n = arr.length;
	        int start = 0, end = n - 1;
	        while (start < end) {
	            if (arr[start] == '@' || arr[start] == '_' || arr[start] == '$') {
	                start++;
	            } else if (arr[end] == '@' || arr[end] == '_' || arr[end] == '$') {
	                end--;
	            } else {
	                char temp = arr[start];
	                arr[start] = arr[end];
	                arr[end] = temp;
	                start++;
	                end--;
	            }
	        }
	        return new String(arr);
	    }
	}


