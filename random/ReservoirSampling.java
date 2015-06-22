package random;

import java.util.Random;

public class ReservoirSampling {

	/**
	 * Using the Reservoir Sampling algorithm (see wikipedia) to get a random node
	 * from a linkedlist of unknown length, with only one pass.
	 * @param head
	 * @return
	 */
	public Node geRandomNode(Node head){
		Node reservoir=head;
		Node current = head;
		Random r = new Random();
		while(current.next!=null){
			if(r.nextBoolean())
				reservoir = current.next;
			current = current.next;
		}
		return reservoir;
	}
	/**
	 * Using the Reservoir Sampling algorithm (see wikipedia) to get k random node
	 * from a linkedlist of unknown length, with only one pass.
	 * Assume that k < the length of the list
	 * @param head
	 * @return
	 */
	public Node[] getRandomNodes(Node head, int k){
		Node[] reservoir = new Node[k];
		Node current = head;
		int i=0;
		for(i =0; i<k;i++){
			reservoir[i] = current;
			current = current.next;
		}
		Random r = new Random();
		int rnum;
		while(current!=null){
			rnum = r.nextInt(i+1);
			if(rnum < k){
				reservoir[rnum]=current;
			}
			i++;
		}
		return reservoir;
	}
	
}

class Node{
	Node next;
	int ID;
	
}
