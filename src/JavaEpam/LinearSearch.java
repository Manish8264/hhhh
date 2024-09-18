package JavaEpam;

public class LinearSearch {
	
	public static int linearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;//return the index of target element if found
			}	
		}
		return -1;  //return -1 if the target element is not found
	}
	
	public static void main(String[] args) {
		int[] array= {5,3,8,4,2,9};
		int target = 8;
		int index = linearSearch(array,target);
		if (index != -1) {
			System.out.println("Element found at Index:" + index);
		}
		else {
			System.out.println("Element not found");
		}
	}
	
	//Time complexity is O(n)-no.of iteration= no.of array length
	

}
