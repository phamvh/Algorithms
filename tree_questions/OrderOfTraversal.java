package tree_questions;

import java.util.LinkedList;
import java.util.Stack;

public class OrderOfTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		inOrderTraversal(TreeFactory.generateTree());
		System.out.println();
		preOrderTraversal(TreeFactory.generateTree());
		System.out.println();
		postOrderTraversal(TreeFactory.generateTree());
		*/
		//iterativeInOrderTraversal(TreeFactory.generateTree());
		LinkedList<Node> queue = iterativeInOrderTraversal_Again(TreeFactory.generateTree());
		for(Node node: queue){
			System.out.print(node.getValue());
		}
	}
	
	public static LinkedList<Node> iterativeInOrderTraversal_Again(Node root){
		LinkedList<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		if(root==null)
			return queue;
		Node current = root;
		while((current!=null) || (!stack.isEmpty())){
			while(current!=null){
				stack.push(current);
				current = current.getLeft();
			}
			current = stack.pop();
			//System.out.print(current.getValue());
			queue.add(current);
			if(current.getRight()!=null){
				current = current.getRight();
			}else
				current = null;
		}
		return queue;
		
	}
	
	public static void iterativeInOrderTraversal(Node root){
		if(root==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		
		while((current!=null) || (!stack.isEmpty())){
			while(current!=null){
				stack.push(current);
				current = current.getLeft();
			}
			current = stack.pop();
			System.out.print(current.getValue());
			if(current.getRight()!=null){
				current = current.getRight();
			}else
				current = null;
			
		}
		
		/*Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node current = root;
		while(!stack.isEmpty()){	
			
			while(current.getLeft()!=null){
				stack.push(current.getLeft());
				current = current.getLeft();
			}
			current = stack.pop();
			System.out.print(current.getValue());
			if(current.getRight()!=null){
				stack.push(current.getRight());
				current = current.getRight();
			}
		}
		*/
	}
	
	public static void inOrderTraversal(Node root){
		if(root==null)
			return;
		inOrderTraversal(root.getLeft());
		System.out.print(root.getValue());
		inOrderTraversal(root.getRight());
	}
	
	public static void preOrderTraversal(Node root){
		if(root==null)
			return;
		System.out.print(root.getValue());
		
		preOrderTraversal(root.getLeft());
		
		preOrderTraversal(root.getRight());
	}
	
	public static void postOrderTraversal(Node root){
		if(root==null)
			return;
		postOrderTraversal(root.getLeft());
		
		postOrderTraversal(root.getRight());
		
		System.out.print(root.getValue());
	}
	
	

}
