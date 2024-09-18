package JavaEpam;

//It is useful when the array  is sorted

public class BinarySearch {
	public static int binarySearch(int[] array,int target) {
		int low =0;
		int high=array.length-1;
		while(low <=high) {
			int mid= low+(high-low)/2;
			if (array[mid]== target) {
				return mid;
			}else if (array[mid]<target) {
				low= mid+1;
			}else {
				high = mid -1;
			}
		}
		return -1; //Return -1 if the target element is not found
	}
public static void main(String[] args) {
	int[]array= {5,10,35,45,60};
	int target= 45;
	int index = binarySearch(array, target);
	if (index != -1) {
		System.out.println("Element is sorted at :" + index);
	}else {
		System.out.println("Element is not found");
	}
}

}
