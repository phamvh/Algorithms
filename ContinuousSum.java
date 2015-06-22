import java.util.ArrayList;


public class ContinuousSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean continuousSum(int[] arr, int T){
		if(arr[0] == T)
			return true;
		for(int i = 1; i < arr.length-1; i++){
			int currentSum = arr[i];
			if(currentSum == T)
				return true;
			
			int j = i-1;
			while((currentSum < T) && (j>=0)){
				currentSum+=arr[j];
				if(currentSum == T)
					return true;
				j--;
			}
		}
		return false;
	}
	
	public static boolean efficientContinuousSum(int[] arr, int T){
		if(arr[0] == T)
			return true;
		ArrayList<Integer>[] data = new ArrayList[arr.length];
		data[0] = new ArrayList<Integer>();
		if(arr[0] < T)
			data[0].add(arr[0]);
		
		for(int i = 1; i < arr.length-1; i++){
			int currentSum = arr[i];
			data[i] = new ArrayList<Integer>();
			data[i].add(arr[i]);
 			if(currentSum == T)
				return true;
 			for(Integer prevSum: data[i-1]){
 				currentSum += prevSum;
 				if(currentSum == T)
 					return true;
 				if(currentSum > T)
 					break;
 				data[i].add(currentSum);
 			}
 			
		}
		return false;
	}

}
