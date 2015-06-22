package tree_questions;

import java.util.Stack;

public class Insert_Delete_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = TreeFactory.generateBinarySearchTree();
		printTreeInorderTraversal(root);
		
		System.out.println();
		
		//insert(root, new Node(0));
		//printTreeInorderTraversal(root);
		
		//Node node = getParent(root, 8);
		//System.out.println(node!=null?node.getValue():"null");
		
		Node x = getNode(root, 4);
		root = delete(root, x);
		printTree(root);
		//printTreeInorderTraversal(root);
		
	}
	
	public static Node delete(Node root, Node x){
		if((!root.hasChildren()) && (root.equals(x)))
				return null;
		Node parent = getParent(root, x.getValue());
		//x has no children
		if(!x.hasChildren()){
			
			if(parent.getLeft().getValue()==x.getValue())
				parent.setLeft(null);
			else
				parent.setRight(null);
			
			return root;
		}
		//x has only one child
		if((x.getLeft()!=null)  && (x.getRight()==null)){
			if(parent.getLeft().getValue()==x.getValue())
				parent.setLeft(x.getLeft());
			else
				parent.setRight(x.getLeft());
			
			return root;
		}
		if((x.getLeft()==null)  && (x.getRight()!=null)){
			if(parent.getLeft().getValue()==x.getValue())
				parent.setLeft(x.getRight());
			else
				parent.setRight(x.getRight());
			
			return root;
		}
		
		//x has two children
		////get successor of x
		Node successor = x.getRight();
		while(successor.getLeft()!=null)
			successor = successor.getLeft();
		
		////cut successor out of the tree
		if(successor.getRight()!=null){
			Node p = getParent(root, successor.getValue());
			if(p.getLeft().getValue()==successor.getValue())
				p.setLeft(successor.getRight());
			else
				p.setRight(successor.getRight());
		}
		
		////put successor in the place of x. Note that x has two children
		if(parent==null){
			successor.setLeft(x.getLeft());
			successor.setRight(x.getRight());
		}else{
			successor.setLeft(x.getLeft());
			successor.setRight(x.getRight());
			if(parent.getLeft().getValue()==x.getValue())
				parent.setLeft(successor);
			else
				parent.setRight(successor);
		}
		if(root.equals(x))
			return successor;
		else 
			return root; 
		
	}
	
	public static Node insert(Node root, Node x){
		if(x==null)
			throw new IllegalArgumentException("null argument x");
		if(root==null)
			return x;
		Node parent = root;
		boolean isLeft = false;
		while(true){
			if(parent.getValue() > x.getValue()){
				if(parent.getLeft()!=null){
					parent = parent.getLeft();
				}else{
					isLeft = true;
					break;
				}
			}else{
				if(parent.getRight()!=null){
					parent = parent.getRight();
				}else{
					isLeft = false;
					break;
				}
			}
			
		}
		
		if(isLeft){
			parent.setLeft(x);
		}else
			parent.setRight(x);
		
		return root;
	}
	
	public static Node getNode(Node root, int x){
		if(root==null)
			return null;
		if(root.getValue()==x)
			return root;
		if(root.getValue() > x)
			return getNode(root.getLeft(), x);
		if(root.getValue() < x)
			return getNode(root.getRight(), x);
		return null;
	}
	
	public static Node getParent(Node root, int x){
		if(!root.hasChildren())
			return null;
		Node current = root;
		Node parent = null;
		while(true){
			if(current==null)
				break;
			if(current.getValue()==x){
				return parent;
			}
			if(current.getValue() > x){
				parent = current;
				current = current.getLeft();
			}else{
				parent = current;
				current = current.getRight();
			}
		}
		return null;
	}
	
	/**
	 * In-order-traversal using a stack and a variable "current".
	 * @param root
	 */
	public static void printTreeInorderTraversal(Node root){
		if(root == null)
			return;
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		stack.push(current);
		while((current!=null) || (!stack.isEmpty())){
			while(current!=null){
				if(current.getLeft()!=null){
					current = current.getLeft();
					stack.push(current);
				}else
					current = null;
			}
			current = stack.pop();
			System.out.print(current.getValue());
			if(current.getRight()!=null){
				current = current.getRight();
				stack.push(current);
			}else
				current = null;
			
		}
	}
	
	public static void printTree(Node root){
		if(root==null)
			return;
		if(root.getLeft()!=null)
			printTree(root.getLeft());
		System.out.print(root.getValue());
		if(root.getRight()!=null)
			printTree(root.getRight());
	}

}
