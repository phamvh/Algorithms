package graph;

import java.util.List;

public class Node {
	private List<Node> neighbors;
	int value;
	public Node(int value) {
		this.value = value;
	}
	public List<Node> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}
	public int getValue() {
		return value;
	}
	public int hashCode(){
		return value;
	}
	public boolean equals(Object o){
		return (((Node)o).getValue()==value);
	}
	

}
