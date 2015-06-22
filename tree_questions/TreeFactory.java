package tree_questions;

public class TreeFactory {

	public static Node generateTree(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		node3.setLeft(node6);
		node3.setRight(node7);
		node5.setLeft(node8);
		
		return node1;
	}
	
	public static Node generateTreeForPrinting(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		node3.setRight(node6);
		
		node4.setLeft(node7);
		node5.setLeft(node8);
		
		return node1;
	}
	
	public static Node generateBinarySearchTree(){
		Node node1 = new Node(4);
		Node node2 = new Node(2);
		Node node3 = new Node(6);
		Node node4 = new Node(1);
		Node node5 = new Node(3);
		Node node6 = new Node(5);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		node3.setLeft(node6);
		node3.setRight(node7);
		node7.setRight(node8);
		
		return node1;
	}
}
