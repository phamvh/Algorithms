package tree_questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS_BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dfs_recursive(TreeFactory.generateTree());
		//dfs_iterative(TreeFactory.generateTree());
		bfs_iterative_level_by_level(TreeFactory.generateTree());
		System.out.println("\n-----");
		bfs_iterative_level_by_level_two_queues_for_nodes(TreeFactory.generateTree());
	}
	
	public static void bfs_iterative_level_by_level_two_queues_for_nodes(Node root){
		if(root==null)
			return;
		LinkedList<Node> currentLevelQueue = new LinkedList<Node>();
		LinkedList<Node> nextLevelQueue = new LinkedList<Node>();
		
		currentLevelQueue.add(root);
		while(!currentLevelQueue.isEmpty()){
			Node node = currentLevelQueue.poll();
			System.out.print(node.getValue());
			if(node.getLeft()!=null)
				nextLevelQueue.add(node.getLeft());
			if(node.getRight()!=null)
				nextLevelQueue.add(node.getRight());
		
			if(currentLevelQueue.isEmpty()){
				//swap
				currentLevelQueue.addAll(nextLevelQueue);
				nextLevelQueue.clear();
				System.out.println();
			}
		}
	}

	
	/**
	 * To print a tree level by level, use two queues:
	 * First queue stores nodes
	 * Second queue stores the levels of the corresponding nodes in the first queue.
	 * @param root
	 */
	public static void bfs_iterative_level_by_level(Node root){
		if(root==null)
			return;
		LinkedList<Node> nodeQueue = new LinkedList<Node>();
		LinkedList<Integer> levelQueue = new LinkedList<Integer>();
		
		nodeQueue.add(root);
		levelQueue.add(0);
		
		int currentLevel = 0;
		
		while(!nodeQueue.isEmpty()){
			Node node = nodeQueue.poll();
			int level = levelQueue.poll();
			if(level>currentLevel){
				System.out.println();
				currentLevel++;
			}
			System.out.print("("+node.getValue()+","+level+")");
			
			if(node.getLeft()!=null){
				nodeQueue.add(node.getLeft());
				levelQueue.add(level+1);
			}
			if(node.getRight()!=null){
				nodeQueue.add(node.getRight());
				levelQueue.add(level+1);
			}
		}
	}
	
	public static void bfs_iterative(Node root){
		if(root==null)
			return;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.print(node.getValue());
			if(node.getLeft()!=null)
				queue.add(node.getLeft());
			if(node.getRight()!=null)
				queue.add(node.getRight());
		}
	}
	
	public static void dfs_recursive(Node root){
		if(root==null)
			return;
		System.out.print(root.getValue());
		dfs_recursive(root.getLeft());
		dfs_recursive(root.getRight());
		
	}
	
	public static void dfs_iterative(Node root){
		if(root==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			System.out.print(node.getValue());
			if(node.getRight()!=null)
				stack.push(node.getRight());
			if(node.getLeft()!=null)
				stack.push(node.getLeft());
		}
	}

}
