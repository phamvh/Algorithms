package tree_questions;

public class ClosestNode {

	public static void main(String[] args) {
		//Node node = ceil_iterative(TreeFactory.generateBinarySearchTree(), 3.5);
		Node node = ceil_recursive(TreeFactory.generateBinarySearchTree(), 3.5);
		System.out.println(node!=null?node.getValue():"null");

	}
	
	public static Node ceil_recursive(Node root, double d){
		if(root.getValue() > d){
			if(root.getLeft()==null)
				return root;
			else
				return min(root, ceil_recursive(root.getLeft(), d));
		}else{
			if(root.getRight()!=null)
				return ceil_recursive(root.getRight(), d);
			else return null;
		}
	}
	
	public static Node min(Node node1, Node node2){
		if((node1==null) && (node2==null))
			return null;
		if(node1==null)
			return node2;
		if(node2==null)
			return node1;
		if(node1.getValue() < node2.getValue())
			return node1;
		else return node2;
	}
	
	
	
	public static Node ceil_iterative(Node root, double d){
		Node ceil=null;
		Node current = root;
		while(current!=null){
			if(current.getValue() > d){
				ceil = current;
				current = current.getLeft();
			}else{
				current = current.getRight();
			}
		}
		return ceil;
		
	}
	
	public void getClosestNode(Node root, double d){
		Integer floor = null, ceil = null;
		boolean isLeftChild = false;
		Node current;
		if(root.getValue() > d){
			current = root.getLeft();
			isLeftChild = true;
			ceil = root.getValue();
		}
		else{
			current = root.getRight();
			isLeftChild = false;
			floor = root.getValue();		
		}
		
		while(current!=null){
			if(isLeftChild){
				if(current.getValue() < d){
					floor = current.getValue();
					current = current.getRight();
					isLeftChild = false;
				}else{
					ceil = current.getValue();
					current = current.getLeft();
					isLeftChild = true;
				}
			}else{
				
			}
		}
		
	}

}
