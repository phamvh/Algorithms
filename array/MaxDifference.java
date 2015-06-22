package array;

public class MaxDifference {

	public static void main(String[] args) {
		int[] arr={5,8,9,1,6};
		maxDifference(arr);

	}
	/**
	 * Find the two elements in the array, first, and second, that gives the max difference: second - first
	 * "second" comes behind "first" in the array 
	 * @param arr
	 */
	public static void maxDifference(int[] arr){
		if(arr.length<2)
			System.out.println("Not enough data");
		int start = 0, newPossibleStart=0;
		int end = 1;
		int max = arr[end] -  arr[start];
		for(int i=2; i<arr.length;i++){
			
			if(arr[i]<arr[start]){
				newPossibleStart=i;
				continue;
			}
			if(arr[i]-arr[newPossibleStart]>max){
				end = i;
				max = arr[i]-arr[newPossibleStart];
				start = newPossibleStart;
			}
				
		}
		System.out.println(start+"="+arr[start]);
		System.out.println(end+"="+arr[end]);
	}

}
