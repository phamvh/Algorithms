package n_stairs;

import java.util.LinkedList;
import java.util.List;

public class AllPathsAlongNStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllPathsAlongNStairs main = new AllPathsAlongNStairs();
		List<List<Integer>> paths = main.getAllPaths(3);
		for(List<Integer> path: paths){
			main.printPath(path);
		}
		
	}
	
	public void printPath(List<Integer> path){
		for(int x: path){
			System.out.print(x);
		}
		System.out.println();
	}
	
	/**
	 * Given N stairs, find all paths that one person can climb.
	 * Note that this is to find all paths, not just the number of ways to climb.
	 * Also, note that: if there are N stairs, the problem means the final step is on the N-th stair.
	 * @param N
	 * @return
	 */
	public List<List<Integer>> getAllPaths(int N){
		List<List<Integer>> listOfPaths = new LinkedList<List<Integer>>();
		if(N==0){
			List<Integer> path = new LinkedList<Integer>();
			listOfPaths.add(path);
			return listOfPaths;
		}
		if(N==1){
			List<Integer> path = new LinkedList<Integer>();
			path.add(1);
			listOfPaths.add(path);
			return listOfPaths;
		}
		
		List<List<Integer>> list1 = getAllPaths(N-1);
		List<List<Integer>> list2 = getAllPaths(N-2);
		
		for(List<Integer> path : list1){
			path.add(1);
		}
		for(List<Integer> path : list2){
			path.add(2);
		}
		listOfPaths.addAll(list1);
		listOfPaths.addAll(list2);
		return listOfPaths;
		
		
			
	}

}
