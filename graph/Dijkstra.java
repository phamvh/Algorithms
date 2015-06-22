package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

	/**
	 * Better implementation of Dijkstra
	 * This method just populates the shortest path from source to every node in the graph, and set 
	 * the prev in each DNode so that it is possible to trace back the path from a node to the source.
	 * @param source
	 */
	public void dijkstraShortestPath(DNode source){
		PriorityQueue<DNode> queue = new PriorityQueue<DNode>();
		source.setD(0);
		queue.add(source);
		while(!queue.isEmpty()){
			DNode node = queue.poll();
			Edge[] adj = node.getAdjcencies();
			for(Edge e:adj){
				DNode nb = e.getTarget();
				if(nb.getD()>node.getD()+e.getWeight()){
					queue.remove(nb);
					nb.setD(node.getD()+e.getWeight());
					nb.setPrev(node);
					queue.add(nb);
				}
			}
		}
		
	}
	
	/**
	 * Just a Bad implementation of Dijkstra
	 * @param source
	 * @param destination
	 * @param V
	 * @return
	 */
	public DNode shortestPath(Node source, Node destination, List<Node> V){
		List<DNode> S = new LinkedList<DNode>();
		PriorityQueue<DNode> queue = new PriorityQueue<DNode>();
		Map<Node,DNode> map = new HashMap<Node, DNode>();
		DNode ds = new DNode(source);
		ds.setPrev(null);
		ds.setD(0);
		for(Node v:V){
			DNode dv = new DNode(v);
			dv.setD(Integer.MIN_VALUE);
			dv.setPrev(null);
			queue.add(dv);
			map.put(v, dv);
		}
		DNode min = null;
		while(!queue.isEmpty()){
			min = queue.poll();
			if(min.getNode().equals(destination))
				return min;
			S.add(min);
			List<Node> neighbors = min.getNode().getNeighbors();
			for(Node nb: neighbors){
				DNode dnb = map.get(nb);
				if(dnb.getD()>min.getD()+distance(min.getNode(), dnb.getNode())){
					dnb.setD(min.getD()+distance(min.getNode(), dnb.getNode()));
					if(queue.remove(dnb))
						queue.add(dnb);
				}
			}
		}
		return min;
		
	}
	
	public int distance(Node u, Node v){
		return 0;
	}
}

class Edge{
	DNode target;
	int weight;
	public Edge(DNode target, int weight) {
		super();
		this.target = target;
		this.weight = weight;
	}
	public DNode getTarget() {
		return target;
	}
	public int getWeight() {
		return weight;
	}
	
}

class DNode implements Comparable<DNode>{
	public DNode(Node node) {
		this.node = node;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public DNode getPrev() {
		return prev;
	}
	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	public Node getNode() {
		return node;
	}
	Node node;
	int d;
	DNode prev;
	Edge[] adjcencies;
	
	public Edge[] getAdjcencies() {
		return adjcencies;
	}
	public void setAdjcencies(Edge[] adjcencies) {
		this.adjcencies = adjcencies;
	}
	@Override
	public int compareTo(DNode o) {
		if(d>o.d)
			return 1;
		else if(d==o.d)
			return 0;
		else
			return -1;
	}
	
}
