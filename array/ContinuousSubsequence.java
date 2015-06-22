package array;

public class ContinuousSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * O(n^2) complexity
	 * Given an array, find out if there exists a continuous subsequence that sums up to a given T
	 * @param arr
	 * @param T
	 * @return
	 */
	public boolean continuousSubsequence(int[] arr, int T){
		for(int i =0; i < arr.length; i++){
			int j=0;
			int sum=0;
			while(i-j>=0){
				sum = sum + arr[i-j];
				if(sum==T)
					return true;
			}
		}
		return false;
	}
	/**
	 * O(n) complexity
	 * @param arr
	 * @param T
	 * @return
	 */
	public boolean continuousSubsequence_efficient(int[] arr, int T){
		int sum=0;
		int j=0;
		for(int i =0; i<arr.length;i++){
			while(j<arr.length){
				sum+=arr[j];
				if(sum==T)
					return true;
				if(sum>T){
					sum-=arr[i];
					if(sum==T)
						return true;
					if(sum>T){
						
						sum-=arr[j];
						j--;
					}
					
					break;//while
				}
				j++;
			}
		}
		return false;
	}

}
