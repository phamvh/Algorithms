package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberAddUpToX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean check(int[] arr, int x){
		for(int i=0; i<arr.length-1;i++){
			for(int j=i+1; j<arr.length;j++){
				if(arr[i] + arr[j]==x)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * nlog(n) complexity
	 * @param arr
	 * @param x
	 * @return
	 */
	public static boolean check_efficient(int[] arr, int x){
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			int y = x-arr[i];
			int index = Arrays.binarySearch(arr, y);
			if(index>=0){
				if(index!=i)
					return true;
				else{
					if(i>0){
						if(arr[i]==arr[i-1])
							return true;
					}else if(i < arr.length-1){
						if(arr[i]==arr[i+1])
							return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * O(n)
	 * @param arr
	 * @param x
	 * @return
	 */
	public static boolean check_mostEfficient(int[] arr, int x){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0; i<arr.length;i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
				
			}else{
				map.put(arr[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			int y = x - entry.getKey();
			if(y!=x){
				if(map.containsKey(y)){
					return true;
				}
			}else{
				if(map.get(arr[x]) > 1)
					return true;
			}
		}
		return false;
	}

}
