package tree_questions;

import java.util.Stack;

public class TreeToDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	/**
	 * Convert a tree to a doubly-linked list.
	 * Repurpose the right and left references.
	 * 
	 * Method: do in-order traversal, keep track of the previous node visited.
	 * @param root
	 * @return
	 */
	public Node toDoublyLinkedList_recursive(Node root){
		if(root==null)
			return null;
		Node left=null, right=null;
		left=toDoublyLinkedList_recursive(root.getLeft());
		right=toDoublyLinkedList_recursive(root.getRight());
		if(left!=null){
			while(left.hasRight())
				left=left.getRight();
			left.setRight(root);
			root.setLeft(left);
		}
		if(right!=null){
			root.setRight(right);
			right.setLeft(root);
		}
		//return
		if(left!=null){
			return left;
		}
		return root;
		
		
	}
	
	public Node toDoublyLinkedList_iterative(Node root){
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		Node prev = null;
		Node head=null;
		while((current!=null) || (!stack.isEmpty())){
			while(current!=null){
				stack.push(current);
				current = current.getLeft();
			}
			current = stack.pop();
			if(prev==null){
				head=current;
				current.setLeft(null);
				prev=current;
			}else{
				prev.setRight(current);
				current.setLeft(prev);
				prev=current;
			}
			if(current.hasRight())
				current=current.getRight();
			else
				current=null;
			
		}
		return head;
	}

}
