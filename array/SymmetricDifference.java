package array;

import java.util.*;

public class SymmetricDifference {
	
	public static void main(String[] args) {
		//testSymDiffWithDuplicates();
		testDetSymDiffFromSortedArrays();
	}


	public static void testDetSymDiffFromSortedArrays(){
		int[] arr1={1,2,2,3,4,4,4,4};
		int[] arr2={1,1,2,2,2,4,4};
		getSymDiffFromSortedArrays(arr1, arr2);
	}
	public static void testSymDiffWithDuplicates() {
		List<Integer> list1 = new LinkedList<Integer>();
		for(int i=1; i<=10; i++){
			list1.add(i);
			if(i%3==0)
				list1.add(i);
		}
		
		List<Integer> list2 = new LinkedList<Integer>();
		for(int i=6; i<=15; i++){
			list2.add(i);
		}
		
		List<Integer> list = getSymDiff_SpaceEfficient(list1,list2);
		for(int x:list){
			System.out.print(x+",");
		}
	}
	
	
	public static void getSymDiffFromSortedArrays(int[] arr1, int[] arr2){
		if((arr1==null) && (arr2==null)){
			return;
		}
		if(arr1==null)
			System.out.println(arr2.toString());
		if(arr2==null)
			System.out.println(arr1.toString());
		
		
		System.out.println(arr2.toString());
		System.out.println(arr1.toString());
		int i=0,j=0;
		while((i<arr1.length) || (j<arr2.length)){
			if((i<arr1.length) && (j<arr2.length)){
				if(arr1[i]==arr2[j]){
					i++;
					j++;
				}else{
					if(arr1[i]>arr2[j]){
						System.out.print(arr2[j]+",");
						j++;
					}else{
						System.out.print(arr1[i]+",");
						i++;
					}
				}
			}else{
				if(i<arr1.length){
					System.out.print(arr1[i++]+",");
				}else{
					System.out.print(arr2[j++]);
				}
			}
		}
		
	}
	
	/**
	   Given two lists,
	   return all the elements that are in one list but not in the other.
	   This is called symmetric difference.
	   Note that a number may appear in one list multiple times.
	   For example:
	   list1 = 1,2,2,3,3
	   list2 = 1,1,2,3,3,3
	   then the symmetric difference is 1 (from list2), 2(from list1), 3(from list2)
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<Integer> getSymDiff(List<Integer> list1, List<Integer> list2){
		List<Integer> diff = new LinkedList<Integer>();
		if((list1==null) && (list2==null))
			return diff;
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		for(int x:list1){
			if(map1.containsKey(x)){
				map1.put(x, map1.get(x)+1);
			}else{
				map1.put(x,1);
			}
		}
		
		System.out.println(map1.toString());
		
		Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
		for(int x:list2){
			if(map2.containsKey(x)){
				map2.put(x, map2.get(x)+1);
			}else{
				map2.put(x,1);
			}
		}
		System.out.println(map2.toString());
		
		////
		Map<Integer,Integer> rs = new HashMap<Integer,Integer>();
		for(Map.Entry<Integer, Integer> entry: map1.entrySet()){
			int key = entry.getKey();
			if(map2.containsKey(key)){
				int d = Math.abs(entry.getValue()-map2.get(key));
				if(d>0)
					rs.put(key,d);
			}else{
				rs.put(entry.getKey(),entry.getValue());
			}
		}
		
		System.out.println(rs.toString());
		
		for(Map.Entry<Integer, Integer> entry: map2.entrySet()){
			int key = entry.getKey();
			if(!map1.containsKey(key)){
				rs.put(entry.getKey(),entry.getValue());
			}
		}
		System.out.println(rs.toString());
		List<Integer> list = new LinkedList<Integer>();
		for(Map.Entry<Integer, Integer> entry: rs.entrySet()){
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			for(int i=1; i<=value;i++){
				list.add(key);
			}
		}
		return list;
	}
	
	/**
	 * Similar to the function above.
	 * Just use less space.
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<Integer> getSymDiff_SpaceEfficient(List<Integer> list1, List<Integer> list2){
		List<Integer> diff = new LinkedList<Integer>();
		if((list1==null) && (list2==null))
			return diff;
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		for(int x:list1){
			if(map1.containsKey(x)){
				map1.put(x, map1.get(x)+1);
			}else{
				map1.put(x,1);
			}
		}
		
		System.out.println(map1.toString());
		
		for(int x:list2){
			if(map1.containsKey(x)){
				map1.put(x,map1.get(x)-1); //keep deducting. If it becomes negative, like -2, then it means x appears 2 times more in the list2 than in the list 1
			}else{
				map1.put(x, -1); //negative means x comes from list2.
			}
		}
		
		for(Map.Entry<Integer, Integer> entry: map1.entrySet()){
			int key = entry.getKey();
			int times = Math.abs(entry.getValue());
			for(int i=1; i<=times; i++){
				diff.add(key);
			}
		}
		return diff;
		
	
	}
	
	
}
