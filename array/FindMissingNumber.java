package array;

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] arr = {1,2,4,5,7,8};
		System.out.println(findMissingNumber(arr, 0, arr.length-1, 8));
	}
	
	/**
	 * Given an array of unique numbers, sorted in increasing order.
	 * The size of array is m
	 * The number ranges from 1 to n, where n > m
	 * So there are n-m missing numbers in the array.
	 * Find such first missing number in O(log n).
	 * Example: 
	 * int[] arr = {1,2,4,6,7,8,9}
	 * The first missing number is 3. The second missing number is 5.
	 * @param arr
	 * @return
	 */
	public static int findMissingNumber(int[] arr, int l, int r, int max){
		if((arr==null) || (arr.length==0))
			return -1;
		if(arr[0]>1)
			return 1;
		
		if(r-l==1){
			if(arr[l]+1<arr[r])
				return arr[l]+1;//assume 1 is always present
			else{
				if(arr[arr.length-1]<max)
					return max;
				else return -1;
			}
				
		}
		int mid = (l+r)/2;
		int lDiff = arr[mid] - arr[l];

		if(lDiff>mid-l){
			return findMissingNumber(arr,l,mid,max);
		}else{
			return findMissingNumber(arr,mid,r,max);
		}
		
	}
}
