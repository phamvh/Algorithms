package tree_questions;

public class Node {
	private Node left;
	private Node right;
	private int value;
	
	/**
	 * This is optional.
	 * This points to the next node in the same level, to the right.
	 * Just added this for an interview question asking to populate the "right references"
	 */
	private Node nextRight;
	
	public Node getNextRight() {
		return nextRight;
	}

	public void setNextRight(Node nextRight) {
		this.nextRight = nextRight;
	}

	public Node(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getLeft(){
		return left;
	}
	
	public boolean hasLeft(){
		return (left!=null);
	}
	
	public boolean hasRight(){
		return (right!=null);
	}
	
	public boolean hasChildren(){
		return (left!=null) || (right!=null);
	}
	
	public boolean equals(Object node){
		return (value == ((Node)node).getValue());
	}
	

}
