package epam;


//2nd highest element i array

//complexity is 0(n)
public class Array2ndLargerst {
	
	public static void main(String[] args) {
		int[] arr= {1,24,45,3,56};
		int length= arr.length;
		
		int highest=0;
		int secondHigh=0;
		
		for(int i=0;i<length;i++) {
			if(arr[i]> highest) {
				secondHigh=highest;
				highest=arr[i];
			}
			
			if(arr[i] <highest && arr[i]>secondHigh) {
				secondHigh=arr[i];
			}
		}
		
		System.out.println("Second Highest element is :"
				+ secondHigh);
	}
	

}
