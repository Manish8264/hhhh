package JavaEpam;

public class SelectionSort {
	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n-1; i++) {
			int minIndex=i;
			for (int j = i+1; j < n; j++) {
				if(array[j]< array[minIndex]) {
					minIndex=j;
				}
			}
			//Swap array[i] with array[minIndex]
			int temp = array[minIndex];
			array[minIndex]= array[i];
			array[i]=temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array= {64,25,12,22,11};
		selectionSort(array);
		System.out.println("Sorted array is :");
		for(int num:array) {
			System.out.println(num + " ");
		}
		
	}

}
