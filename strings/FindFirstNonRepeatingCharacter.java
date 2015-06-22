package strings;
import java.util.*;

public class FindFirstNonRepeatingCharacter {

	public static void main(String[] args) {
		System.out.println(getFirstNonRepeatingChar("abcdabd"));
	}
	public static Character getFirstNonRepeatingChar(String s){
		Set<Character> repeated = new HashSet<Character>();
		LinkedHashSet<Character> non_repeated = new LinkedHashSet<Character>();
		int len = s.length();
		for(int i=0; i<len; i++){
			if(!repeated.contains(s.charAt(i))){
				if(non_repeated.contains(s.charAt(i))){
					repeated.add(s.charAt(i));
					non_repeated.remove(s.charAt(i));
				}else{
					non_repeated.add(s.charAt(i));
				}
			}
		}
		Iterator<Character> it = non_repeated.iterator();
		if(it.hasNext())
			return it.next();
		else
			return null;
	}
}
