import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueExample {
	
	static class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return o2 - o1;
		}
		
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(10, new MyComparator());
		
		int[] arr = {1,3,9,4,7,8,13,2,6};
		
		for(int x: arr){
			q1.offer(x);
			q2.offer(x);
		}
		System.out.println("q1: "+q1);
		System.out.println("q2: "+q2);
		
		System.out.println("q1 peek: "+q1.peek());
		System.out.println("q2 peek: "+q2.peek());

	}

}
