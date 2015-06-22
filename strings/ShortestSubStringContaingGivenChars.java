package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortestSubStringContaingGivenChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Find the shortest substring that contains all chars in a given array.
	 * @param chars
	 * @param str
	 * @return
	 */
	public static String shortSequence(char[] chars, String str){
		Set<Character> charSet = new HashSet<Character>();
		for(Character ch:chars)
			charSet.add(ch);
		Set<Character> toBeEnc = new HashSet<Character>();
		toBeEnc.addAll(charSet);
		int i =0;
		int start=0;
		int end=-1;
		int minLen=-1;
		while(i<str.length()){
			
			toBeEnc.remove(str.charAt(i));
			if(toBeEnc.size()>0){
				if(str.charAt(i)==str.charAt(start)){
					start++;
					int trim = numberOfDuplicates(str,start);
					start+=trim;
				}
				i++;
			}else{
				String sub = str.substring(start, i+1);
				if((minLen<0) || (sub.length() < minLen)){
					minLen = sub.length();
					end = i;
				}
				
				toBeEnc.add(str.charAt(start));
				start++;
				
			}
		}
		if(end<0)
			return null;
		return str.substring(end-minLen, end+1);
	}
	
	public static int numberOfDuplicates(String str, int start){
		int i=start;
		while((i<str.length()) && (str.charAt(i)==str.charAt(i+1))){
			i++;
		}
		return i-start;
	}
	
	public static String trimDuplicates(String str){
		StringBuffer s= new StringBuffer(str);
		int i=0;
		while((i<str.length()-1) && (str.charAt(i)==str.charAt(i+1)))
			s.delete(0, 1);
		return s.toString();
	}
	
	
}
