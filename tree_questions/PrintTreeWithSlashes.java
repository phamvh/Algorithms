package tree_questions;

import java.util.LinkedList;

public class PrintTreeWithSlashes {

	public static void main(String[] args) {
		printTreeWithSlashes(TreeFactory.generateTreeForPrinting());

	}
	
	
	public static void printTreeWithSlashes(Node root){
		if(root==null)
			return;
		LinkedList<DNode> parentQueue = new LinkedList<DNode>();
		LinkedList<DNode> childrenQueue = new LinkedList<DNode>();
		LinkedList<DSlash> slashQueue = new LinkedList<DSlash>();
		System.out.println("                   "+root.getValue());
		parentQueue.add(new DNode(root, 20));
		while(!parentQueue.isEmpty()){
			DNode dNode = parentQueue.poll();
			if(dNode.getNode().getLeft()!=null){
				childrenQueue.add(new DNode(dNode.getNode().getLeft(), dNode.getD()-2));
				slashQueue.add(new DSlash('/', dNode.getD()-1));
			}
			if(dNode.getNode().getRight()!=null){
				childrenQueue.add(new DNode(dNode.getNode().getRight(), dNode.getD()+2));
				slashQueue.add(new DSlash('\\', dNode.getD()+1));
			}
			if(parentQueue.isEmpty()){
				printSlashQueue(slashQueue);
				printDNodeQueue(childrenQueue);
				parentQueue.addAll(childrenQueue);
				childrenQueue.clear();
				slashQueue.clear();
			}
		}
	}
	
	public static void printSlashQueue(LinkedList<DSlash> slashQueue){
		int prevD=0;
		for(DSlash dSlash:slashQueue){
			int d = dSlash.getD();
			char c = dSlash.getSlash();
			int d1 = d-prevD-1;
			for(int i=1; i<=d1;i++){
				System.out.print(' ');
			}
			System.out.print(c);
			prevD=d;
	
		}
		System.out.println();
	}
	
	public static void printDNodeQueue(LinkedList<DNode> dNodeQueue){
		int prevD=0;
		for(DNode dNode:dNodeQueue){
			int d = dNode.getD();
			int value = dNode.getNode().getValue();
			int d1 = d-prevD-1;
			for(int i=1; i<=d1;i++){
				System.out.print(' ');
			}
			System.out.print(value);
			prevD=d;
	
		}
		System.out.println();
	}
	
	

}

class DSlash{
	char slash;
	int d;
	public DSlash(char slash, int d) {
		super();
		this.slash = slash;
		this.d = d;
	}
	public char getSlash() {
		return slash;
	}
	public int getD() {
		return d;
	}
}

class DNode{
	Node node;
	int d;
	public DNode(Node node, int d) {
		super();
		this.node = node;
		this.d = d;
	}
	public Node getNode() {
		return node;
	}
	public int getD() {
		return d;
	}
	
}
