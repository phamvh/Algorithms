package resursive;

import java.util.LinkedList;
import java.util.List;

public class StringsFromChars {

	public static void main(String[] args) {
		char[] chars = {'a','b'};
		List<String> strings = createAllStrings(chars, 3);
		for(String s: strings){
			System.out.println(s);
		}

	}
	
	/**
	 * Create all possible strings of a given length from a set of characters.
	 * Example: chars = {'a', 'b'}, length = 3, then
	 *     the strings are: aaa, aab, aba, baa, bbb, bba, bab, abb
	 * 
	 * @param chars
	 * @param length
	 * @return
	 */
	public static List<String> createAllStrings(char[] chars, int length){
		List<String> list = new LinkedList<String>();
		if(length==1){
			for(int i =0; i<chars.length; i++){
				list.add(""+chars[i]);
			}
			return list;
		}
		List<String> prefixes = createAllStrings(chars, length-1);
		for(String prefix : prefixes){
			for(int i=0; i<chars.length;i++){
				list.add(prefix+chars[i]);
			}
		}
		return list;
	}
}
