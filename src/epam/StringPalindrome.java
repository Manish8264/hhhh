package epam;

public class StringPalindrome {
	// String palindrome
	public static void main(String[] args) {
		String str = "nitin";

		int start = 0;
		int end = str.length() - 1;

		boolean isPalindrome = true;

		while (start < end) {

			if (str.charAt(start) != str.charAt(end)) {
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}
		if (isPalindrome) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not palindrome");
		}
	}
}
