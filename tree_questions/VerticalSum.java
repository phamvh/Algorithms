package tree_questions;

import java.util.HashMap;
import java.util.Map;

public class VerticalSum {
	public static void main(String[] args) {
		Map<Integer, Integer> sums = getVerticalSums(TreeFactory.generateTree());
		for(Map.Entry<Integer, Integer> entry: sums.entrySet()){
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}

	/**
	 * Find all the vertical sums of a tree.
	 * Example:
	 * Given:          1
	 *                / \
	 *               2   3
	 *              / \ / \
	 *             5  6 7  8
	 *                    /
	 *                   9   
	 *             
	 *   There are 5 vertical lines in this tree, from left to right:
	 *   (5), (2), (1,6,7) (3,9), (8)
	 *   So the sums are: 5, 2, 14, 12, 8, maybe together with the indexes of the vertical lines.
	 *   Return these sums             
	 *               
	 * @param root
	 * @return
	 */
	public static Map<Integer, Integer> getVerticalSums(Node root){
		return getVerticalSums(root, 0, new HashMap<Integer,Integer>());
	}
	
	
	
	private static Map<Integer, Integer> getVerticalSums(Node root, int width, Map<Integer, Integer> sums){
		if(sums.containsKey(width)){
			sums.put(width, sums.get(width)+root.getValue());
		}else{
			sums.put(width, root.getValue());
		}
		///
		if(root.getLeft()!=null){
			getVerticalSums(root.getLeft(), width-1, sums);
		}
		if(root.getRight()!=null)
			getVerticalSums(root.getRight(), width+1, sums);
		return sums;
	}
}
