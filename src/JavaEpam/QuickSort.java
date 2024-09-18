package JavaEpam;

public class QuickSort {
	public static void quickSort(int[] array,int low,int high) {
		if(low<high) {
			int pi = partition(array,low,high);
			quickSort(array, low, pi-1);
			quickSort(array, pi +1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot=array[high];
		int i= low-1;
		for(int j =low;j<high;j++) {
			if(array[j]<pivot) {
				i++;
				//Swap array[i] and array[j]
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
		//Swap array[j+1] and array[high] (or pivot)
		int temp= array[i+1];
		array[i+1]= array[high];
		array[high]=temp;
		return i+1;	
	}
	public static void main(String[] args) {
		int[] array= {12,11,13,5,6};
		int n = array.length;
		quickSort(array,0,n-1);
		for(int num:array) {
			System.out.println(num + " ");
		}
	}
}
