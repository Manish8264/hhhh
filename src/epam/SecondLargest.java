package epam;
import java.util.Arrays;
public class SecondLargest {
	

	    public static int findSecondLargest(int[] arr) {
	        // Check if the array has at least two elements
	        if (arr.length < 2) {
	            System.out.println("Array should have at least two elements.");
	            return -1; // Return -1 to indicate error
	        }

	        Arrays.sort(arr); // Sort the array in ascending order

	        // Start from the end of the array and find the second largest element
	        for (int i = arr.length - 2; i >= 0; i--) {
	            if (arr[i] != arr[arr.length - 1]) {
	                return arr[i];
	            }
	        }

	        System.out.println("There is no second largest element.");
	        return -1; // Return -1 to indicate error
	    }

	    public static void main(String[] args) {
	        int[] arr = { 5, 2, 8, 9, 1, 12, 7 };
	        int secondLargest = findSecondLargest(arr);
	        if (secondLargest != -1) {
	            System.out.println("The second largest element in the array is: " + secondLargest);
	        }
	    }
	}



