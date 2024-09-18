package epam;

public class Palindrome {
	    public static boolean isPalindrome(String str) {
	        // Convert the string to lowercase to ignore case sensitivity
	        str = str.toLowerCase();

	        // Initialize pointers for checking characters from start and end
	        int start = 0;
	        int end = str.length() - 1;

	        // Compare characters until the pointers meet
	        while (start < end) {
	            // If characters at start and end are not equal, return false
	            if (str.charAt(start) != str.charAt(end)) {
	                return false;
	            }
	            // Move pointers towards the center
	            start++;
	            end--;
	        }
	        // If the loop completes without returning false, the string is a palindrome
	        return true;
	    }

	    public static void main(String[] args) {
	        String str = "level";
	        if (isPalindrome(str)) {
	            System.out.println(str + " is a palindrome.");
	        } else {
	            System.out.println(str + " is not a palindrome.");
	        }
	    }
	}


