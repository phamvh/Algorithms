package tree_questions;

import java.util.LinkedList;

/**
 * For each node, give a reference "right" to the next node on the same level on the right side
 *       A
 *     B   C
 *   D  E F  G
 *   
 *  so A.right=null
 *  B.right=C, C.right=null
 *  D.right=E, e.right=F, F.right=G, G.right=null  
 *       
 * 
 * 
 * @author Van
 *
 */
public class ReferenceToRightNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a root, populate the right references in all the tree.
	 * See comment above (class level).
	 * @param root
	 */
	public void populateRightReferences(Node root){
		LinkedList<Node> currentLevel = new LinkedList<Node>();
		LinkedList<Node> nextLevel = new LinkedList<Node>();
		
		if(root==null) return;
		
		currentLevel.add(root);
		Node previousLeft=null;
		while(!currentLevel.isEmpty()){
			Node node = currentLevel.poll();
			if(previousLeft!=null){
				previousLeft.setNextRight(node);
			}
			previousLeft = node;
			if(node.getLeft()!=null)
				nextLevel.add(node.getLeft());
			if(node.getRight()!=null)
				nextLevel.add(node.getRight());
			
			if(currentLevel.isEmpty()){
				currentLevel.addAll(nextLevel);
				nextLevel.clear();
				previousLeft=null;
			}
		}
	}

}
