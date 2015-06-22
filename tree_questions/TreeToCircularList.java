package tree_questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeToCircularList {

	public static void main(String[] args) {
		TreeToCircularList main = new TreeToCircularList();
		List<Node> list = main.inOrderTraversal(TreeFactory.generateTree());
		for(Node node:list){
			System.out.print(node.getValue());
		}
		System.out.println();
	}
	
	public Node repurposeList(List<Node> list){
		Node prev=null;
		Node head=null;
		for(Node node : list){
		
			if(prev==null){
				node.setLeft(node);
				head = node;
			}
			else{
				node.setLeft(prev);
				prev.setRight(node);
			}
			prev=node;
		}
		if(prev!=null)
			prev.getRight().setRight(prev.getRight());
		return head;
	}
	
	public List<Node> inOrderTraversal(Node root){
		List<Node> list = new LinkedList<Node>();
		inOrderTraversal(root,list);
		return list;
	}
	
	private void inOrderTraversal(Node root, List<Node> nodes){
		if(root==null)
			return;
		if(root.hasLeft())
			inOrderTraversal(root.getLeft(), nodes);
		nodes.add(root);
		if(root.hasRight())
			inOrderTraversal(root.getRight(), nodes);
	}
	
	private void inOrderTraversal_iterative(Node root){
		Node current = root;
		Stack<Node> stack = new Stack();
		while((current!=null) || (!stack.isEmpty())){
			while(current!=null){
				stack.push(current);
				current = current.getLeft();				
			}
			current = stack.pop();
			System.out.print(current.getValue());
			if(current.hasRight()){
				current = current.getRight();
			}else
				current = null;
		}
	}
}
