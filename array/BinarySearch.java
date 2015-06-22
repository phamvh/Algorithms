package array;

public class BinarySearch {
	public static void main(String[] args) {
		BinarySearch main = new BinarySearch();
		int[] array = {1,2,5,6,9,13,14,15};
		int[] results = main.findKClosestElements(array, 8, 6);
		for(int x : results){
			System.out.println(x);
		}
	}
	
	public int[] findKClosestElements(int[] array, int x, int k){
		int[] results = new int[k];
		int position = binarySearchOfRandomElement(array, x, 0, array.length-1);
		int i = position;
		int j = position + 1;
		int count = 0;
		while (count < k){
			if(x - array[i] < array[j] - x){
				results[count] = array[i];
				i--;
			}else{
				results[count] = array[j];
				j++;
			}
			count++;
		}
		if(count < k)
			throw new IllegalArgumentException("Not enough elements to find.");
		return results;
	}
	
	/**
	 * Search for the position of the largest element that is still smaller than x.
	 * @param arr
	 * @param x
	 * @param start
	 * @param end
	 * @return
	 */
	public int binarySearchOfRandomElement(int[] arr, int x, int start, int end){
		if(start==end){
			if(arr[start] <= x)
				return start;
			else
				return -1;
		}
		if(start==end-1){
			if((x >= arr[start])){
				if(x < arr[end])
					return start;
				else
					return end;
			}
			if(x < arr[start])
				return -1;
		}
		
		int middle = (int)(start+end)/2;//middle is guaranteed to be greater than start here.
		if(x < arr[middle])
			return binarySearchOfRandomElement(arr, x, start, middle-1);
		else
			return binarySearchOfRandomElement(arr, x, middle, end);
	}

	/**
	 * Binary search in a sorted array.
	 * Find the position of the element that is equal to x.
	 * Call:
	 *     int i = binarySearch(arr, x, 0, arr.length-1);
	 * @param arr
	 * @param x
	 * @param start
	 * @param end
	 * @return
	 */
	public int binarySearch(int[] arr, int x, int start, int end){
		if(start==end){
			if(arr[start]!=x)
				return -1;
			else
				return start;
		}
		int middle = (int)(start+end)/2;
		if(arr[middle]==x)
			return middle;
		
		if(arr[middle]>x){
			if(middle==start)
				return -1;
			return binarySearch(arr, x, start, middle-1);
		}else{
			return binarySearch(arr, x, middle, end);
		}
	}
}
