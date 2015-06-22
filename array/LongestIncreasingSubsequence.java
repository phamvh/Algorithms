package array;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr={10, 22, 9, 33, 21, 50, 41, 60, 80};
		longestIncreasingSubsequence(arr);
	}
	
	/**
	 * Given an array, find the longest common subsequence (not need be consecutive)
	 * @param arr
	 * @return
	 */
	public static void longestIncreasingSubsequence(int[] arr){
		int[] OPT = new int[arr.length];
		int[] trace = new int[arr.length];
		for(int i=0; i<arr.length;i++){
			trace[i]=-1;
		}
		//OPT[i] is the longest increasing subsequence that ends at i (it includes the i-th element as the last one)
		OPT[0] = 1;
		for(int i=1; i<arr.length;i++){
			for(int j=0; j<i;j++){
				if(arr[j]<arr[i]){
					if(1+OPT[j]>OPT[i]){
						OPT[i]=1+OPT[j];
						trace[i]=j;
					}
				}
			}
		}
		int maxIndex=0;
		int maxLength=OPT[0];
		for(int i=1; i<arr.length;i++){
			if(OPT[i]>maxLength){
				maxLength=OPT[i];
				maxIndex=i;
			}
				
		}
		
		int traceIndex = maxIndex;
		while(traceIndex>=0){
			System.out.print(arr[traceIndex]+",");
			traceIndex = trace[traceIndex];
		}
		
		
	}

}
