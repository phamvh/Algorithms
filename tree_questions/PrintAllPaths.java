package tree_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintAllPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllPaths_WithStack(TreeFactory.generateTree(), new Stack<Node>());

	}
	
	/**
	 * This methods uses too many ArrayLists.
	 * @param root
	 * @param prePath
	 */
	public static void printAllPaths(Node root, ArrayList<Node> prePath){
		if(root==null)
			return;
		prePath.add(root);
		if(root.getLeft()==null && root.getRight()==null){
			printPath(prePath);
		}else{
			if(root.getLeft()!=null){
				ArrayList<Node> ar = new ArrayList<Node>();
				ar.addAll(prePath);
				printAllPaths(root.getLeft(), ar);
			}
			if(root.getRight()!=null){
				ArrayList<Node> ar = new ArrayList<Node>();
				ar.addAll(prePath);
				printAllPaths(root.getRight(), ar);
			}
		}
		
	}
	/**
	 * This method uses only one stack
	 * @param root
	 * @param stack
	 */
	public static void printAllPaths_WithStack(Node root, Stack<Node> stack){
		stack.push(root);
		if(root.hasLeft()){
			printAllPaths_WithStack(root.getLeft(), stack);
		}
		if(root.hasRight()){
			printAllPaths_WithStack(root.getRight(), stack);
		}
		if(!root.hasChildren()){
			printPath(stack);
			
		}
		stack.pop();
		
	}
	
	/**
	 * This method uses only one stack, and it is iterative.
	 * The idea is similar to the one in printing a tree level by level, while two queues are used: one for nodes, one
	 * for booleans indicating if a node is at the end of each level.
	 * In this case, the boolean indicates if for a given node during the traveling, its right child has been processed.
	 * @param root
	 */
	public static void printAllPathIterative(Node root){
		if(root==null)return;
		Stack<Node> nStack = new Stack<Node>();
		Stack<Boolean> bStack = new Stack<Boolean>();
		Node curr = root;
		nStack.push(curr);
		bStack.push(false);
		while( (!nStack.isEmpty())  || (curr!=null)){
			while((curr!=null) && (curr.getLeft()!=null)){
				curr = curr.getLeft();
				nStack.push(curr);
				bStack.push(false);
			}
			Node n = nStack.peek();
			boolean b = bStack.peek();
			if(!n.hasChildren()){
				print(nStack);
				nStack.pop();
				bStack.pop();
				curr=null;
			}
			else if(n.hasRight()){
				if(!b){
					curr=n.getRight();
					nStack.push(curr);
					bStack.pop();
					bStack.push(true);
					bStack.push(false);
				}else{
					nStack.pop();
					bStack.pop();
					curr=null;
				}
			}else{
				nStack.pop();
				bStack.pop();
				curr = null;
				
			}
		}
		
	}
	
	public static void print(Stack<Node> s){
		for(Node n: s){
			System.out.print(n.getValue()+" ");
		}
		System.out.println();
	}
	
	
	public static void printPath(List<Node> path){
		for(Node node : path){
			System.out.print(node.getValue());
		}
		System.out.println();
	}

}
