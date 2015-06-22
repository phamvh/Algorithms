package test_tree;

import java.util.Set;
import java.util.TreeSet;

public class TestTree<T> {
	PersonComparator comparator;
	public static void main(String[] args) {
		Set<Person> set = new TreeSet<Person>();
		set.add(new Person("Van"));
		set.add(new Person("Pandush"));
		set.add(new Person("zebra"));
		set.add(new Person("Richard"));
		for(Person p:set){
			System.out.println(p.name);
		}
	}
	
	/*private int compare(T p1, T p2){
		if(comparator!=null)
			return comparator(p1, p2);
		else{
			Comparable c1 = (Comparable)p1;
			Comparable c2 = (Comparable)p2;
			return c1.compareTo(c2);
		}
			
		}
	}*/

}
