import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Permutation {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> permutations = permutations(arr,2);
		for(List<Integer> perm : permutations){
			for(int x : perm){
				System.out.print(x);
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> permutations(int[] array, int n) throws IllegalArgumentException{
		if(n >= array.length)
			throw new IllegalArgumentException("n must be less than the size of the array");
		if(n==0){
			List<List<Integer>> permutations = new LinkedList<List<Integer>>();
			List<Integer> p = new LinkedList<Integer>();
			p.add(array[n]);
			permutations.add(p);
			return permutations;
		}
		
		List<List<Integer>> subPermutations = permutations(array, n-1);
		List<List<Integer>> permutations = new LinkedList<List<Integer>>();
		for(List<Integer> pm : subPermutations){
			int len = pm.size();
			for(int i = 0; i <= len; i++){
				List<Integer> list = new LinkedList<Integer>();
				list.addAll(pm);
				list.add(i, array[n]);
				permutations.add(list);
			}
		}
		
		return permutations;
		
	}

}
