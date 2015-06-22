package numbers;

import java.util.HashSet;
import java.util.Set;

public class HashCodeOfInteger {

	public static void main(String[] args) {
		System.out.println((new Integer(-1)).hashCode());
		System.out.println((new Integer(1)).hashCode());
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(-1);
		set.add(1);
		System.out.println(set.size());
	}
}
