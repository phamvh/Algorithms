package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AddUpToZero {

	public static void main(String[] args) {
		int[] arr = new int[]{-5,-4,-4,-2,-1,1,2,4,6};
		findZeroTripletWithDuplicates(arr); 
	}
	
	/**
	 * A function that finds three numbers in the given array that sum up to zero.
	 * Complexity O(n^3)
	 * @param arr
	 */
	public static void findZeroTriplet(int[] arr){
		if((arr==null) || (arr.length==0))
			return;
		for(int i=0; i<arr.length;i++){
			int comp1 = -arr[i];
			for(int j=i+1; j<arr.length;j++){
				int comp2 = comp1-arr[j];
				for(int k=j+1; k<arr.length;k++){
					if(arr[k]==comp2){
						System.out.println(arr[i]+","+arr[j]+","+arr[k]);
					}
				}
			}
		}
	}
	
	/**
	 * Similar to the function above.
	 * Just has a better time complexity O(n^2), space complexity O(n).
	 * @param arr
	 */
	public static void findZeroTripletWithHashMap(int[] arr){
		if((arr==null) || (arr.length==0))
			return;
		Map<Integer,Integer> indexMap = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length;i++){
			indexMap.put(arr[i],i);
		}
		for(int i=0; i<arr.length;i++){
			int comp1 = -arr[i];
			for(int j=i+1; j<arr.length;j++){
				int comp2 = comp1-arr[j];
				if(indexMap.containsKey(comp2)){
					if(indexMap.get(comp2)>j){
						System.out.println(arr[i]+","+arr[j]+","+comp2);
					}
				}
			}
		}
	}
	
	/**
	 * Similar to the function above, but arr can have duplicate elements. eg, number 2 can appear multiple times.
	 * Just has a better time complexity O(n^2), space complexity O(n).
	 * @param arr
	 */
	public static void findZeroTripletWithDuplicates(int[] arr){
		if((arr==null) || (arr.length==0))
			return;
		Map<Integer,Set<Integer>> indexMap = new HashMap<Integer, Set<Integer>>();
		for(int i=0; i<arr.length;i++){
			if(indexMap.containsKey(arr[i]))
				indexMap.get(arr[i]).add(i);
			else{
				Set<Integer> set = new TreeSet<Integer>();
				set.add(i);
				indexMap.put(arr[i],set);
			}
		}
		for(int i=0; i<arr.length;i++){
			int comp1 = -arr[i];
			for(int j=i+1; j<arr.length;j++){
				int comp2 = comp1-arr[j];
				if(indexMap.containsKey(comp2)){
					TreeSet<Integer> indexes = (TreeSet)indexMap.get(comp2);
					Set<Integer> tailSet = indexes.tailSet(j+1);
					for(int ind : tailSet){
						System.out.println(arr[i]+","+arr[j]+","+comp2);
					}
				}
			}
		}
	}
	
	
}
