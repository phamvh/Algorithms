package array;

import java.util.HashSet;
import java.util.Set;

public class ThreeNumbersAddToZero {

	public static void main(String[] args) {
		ThreeNumbersAddToZero main = new ThreeNumbersAddToZero();
		int[] arr={-10,2,4,5,12};
		System.out.println(main.addToZero_efficient(arr));

	}
	
	/**
	 * Find out if three numbers in the array add up to zero.
	 * Repititions are allowed (one number can be used multiple times)
	 * 
	 * O(n^3)
	 * 
	 * @param arr
	 * @return
	 */
	public boolean addToZero(int[] arr){
		for(int i=0; i<arr.length;i++){
			int x = -arr[i];
			for(int j=0; j<arr.length;j++){
				int y = x-arr[j];
				for(int k=0; k<arr.length;k++){
					if(arr[k]==y)
						return true;
				}
			}
		}
		return false;
	}
	
	public boolean addToZero_efficient(int[] arr){
		Set<Integer> set = new HashSet<Integer>();
		for(int x:arr){
			set.add(x);
		}
		for(int i=0; i<arr.length;i++){
			int x = -arr[i];
			for(int j=0; j<arr.length;j++){
				int y=x-arr[j];
				if(set.contains(y))
					return true;
			}
		}
		return false;
	}
	

}
