package reconstruct_binary_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Reconstruct {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		while(set.size()>0){
			for(int key:set){
				System.out.print(key);
				set.remove(key);
				break;
			}
		}
	}



	public Node reconstructTree(List<Node> list){
		Map<Integer, List<Node>> parentMap = new HashMap<Integer, List<Node>>(); 
		Map<Integer, Node> selfMap = new HashMap<Integer, Node>(); 
		for(Node node:list){
			selfMap.put(node.value, node);
			if(parentMap.containsKey(node.parent.value)){
				parentMap.get(node.parent.value).add(node);
			}else{
				List<Node> l = new LinkedList<Node>();
				l.add(node);
				parentMap.put(node.parent.value, l);
			}
		}
		
		while(parentMap.size()>1){
			Set<Integer> keys = parentMap.keySet();
			for(int key: keys){
				Node parent = selfMap.get(key);
				List<Node> children = parentMap.get(key);
				for(Node child: children){
					child.parent = parent;
				}
				parentMap.remove(key);
				//break;
			}
		}
		
		return null;
	}
	

}

class Node{
	int value;
	Node parent;
	public Node(int value, Node parent) {
		this.value = value;
		this.parent = parent;
	}
	public int hashCode(){
		return value;
	}
	
}
