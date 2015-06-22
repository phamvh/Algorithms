package array;

public class SmallestUnsortedArray {
	
	public static void main(String[] args) {
		SmallestUnsortedArray main = new SmallestUnsortedArray();
		int[] arr = {1,3, 8, 10, 15, 12, 11, 9,30,40 };
		int rightest = main.largestSortedRightSubarray(arr);
		System.out.println(rightest);
	}

	/**
	 * This return the index i, for which arr[0] to arr[i] is the largest sorted subarray in increasing order.
	 * We need another similar function to this that returns j, for which {arr[j],...,arr[length-1]} is the largest sorted in increasing order.
	 * the subarray between i and j is the smallest subarray of arr, sorting which would make entire arr sorted.
	 * 
	 * A better algorithm is find smallest and largest elements of arr.
	 * Then scan from left of arr, if elements are increasing and all < than smallest and keep moving right until
	 * "break", then the index where "break" happens is i. Similarly for j.
	 * 
	 * @param arr
	 * @return
	 */
	public int largestSortedRightSubarray(int[] arr){
		int maxIncreasing = maxIncreasingFromLeft(arr);
		int currentMaxIncreasing = maxIncreasing;
		int i = currentMaxIncreasing+1;
		while(i<arr.length-1){
			if(arr[i] < arr[i-1]){
				for(int j = i-1; j>=0; j--){
					if(arr[j] < arr[i]){
						currentMaxIncreasing = j;
						break;
					}
				}
			}
			i++;
		}
		return currentMaxIncreasing;
		
	}
	
	/**
	 * return the minimum index i, for which all elements of arr, from i till the end of the array,
	 * are sorted in increasing order.
	 * @param arr
	 * @return
	 */
	public int minDecreasingFromRight(int[] arr){
		int min = arr.length-1;
		if(arr.length==1)
			return 0;
		int i;
		for(i = arr.length-2; i >=0; i--){
			if(arr[i] > arr[i+1])
				break;
		}
		return i+1;
	}
	
	/**
	 * return the right most position in the array, for which
	 * all elements (starting from arr[0]) are sorted in increasing order
	 * @param arr
	 * @return
	 */
	public int maxIncreasingFromLeft(int[] arr){
		int max = 0;
		if(arr.length==1)
			return 0;
		int i;
		for(i = 1; i < arr.length; i++){
			if(arr[i] < arr[i-1])
				break;
		}
		return i-1;
	}
	
	class Range{
		int start;
		int end;
		public Range(int start, int end) {
			this.start= start;
			this.end = end;
			// TODO Auto-generated constructor stub
		}
	}
}

