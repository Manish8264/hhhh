package epam;

public class ReverseString {
	    public static String reverse(String str) {
	        // Check if the input string is null or empty
	        if (str == null || str.isEmpty()) {
	            return str;
	        }

	        // Convert the string to a character array
	        char[] charArray = str.toCharArray();

	        // Initialize pointers for swapping characters
	        int start = 0;
	        int end = charArray.length - 1;

	        // Swap characters from start to end
	        while (start < end) {
	            // Swap characters
	            char temp = charArray[start];
	            charArray[start] = charArray[end];
	            charArray[end] = temp;

	            // Move pointers towards the center
	            start++;
	            end--;
	        }

	        // Convert the character array back to a string and return
	        return new String(charArray);
	    }

	    public static void main(String[] args) {
	        String originalString = "Hello, world!";
	        String reversedString = reverse(originalString);
	        System.out.println("Original string: " + originalString);
	        System.out.println("Reversed string: " + reversedString);
	    }
	}

