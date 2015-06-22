package anagram;
import java.util.*;
public class GroupAnagamsTogether {
	
	public static void main(String[] args) {
		//System.out.println(checkAnagrams2("abc", "acs"));
		List<String> words = new LinkedList<String>();
		words.add("trees");
		words.add("steer");
		words.add("cars");
		words.add("arcs");
		words.add("bike");

		List<List<String>> groups = groupWordsOfTheSameAnagrams(words);
		for(List<String> list: groups){
			for(String w:list){
				System.out.print(w+",");
			}
			System.out.println();
		}
	}

	public static List<List<String>> groupWordsOfTheSameAnagrams(List<String> words){
		List<List<String>> groups = new LinkedList<List<String>>();
		if((words==null) || (words.isEmpty()))
			return groups;
		
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		for(String w:words){
			if(w==null)
				continue;
			String sw = countingSortWord(w.toLowerCase());
			if(map.containsKey(sw)){
				map.get(sw).add(w);
			}else{
				List<String> list = new LinkedList<String>();
				list.add(w);
				map.put(sw,list);
			}
		}
		
		for(Map.Entry<String, List<String>> entry: map.entrySet()){
			groups.add(entry.getValue());
		}
		return groups;
	}
	
	public static String quickSortWord(String s){
		if(s==null)
			return null;
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
		
	}
	
	public static String countingSortWord(String s){
		if(s==null)
			return null;
		char[] chars = new char[26];
		int len = s.length();
		for(int i=0; i<len;i++){
			chars[s.charAt(i)-'a']+=1;
		}
		char[] arr = new char[len];
		int index=0;
		for(int i=0; i<26;i++){
			int count = chars[i];
			for(int j=0;j<count;j++){
				arr[index++]=(char)(i+'a');
			}
		}
		return new String(arr);
	}
	
	public static boolean checkAnagrams1(String s1, String s2){
		if((s1==null) || (s2==null))
			return false;
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1!=len2)
			return false;
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}
	
	public static boolean checkAnagrams2(String s1, String s2){
		if((s1==null) || (s2==null))
			return false;
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1!=len2)
			return false;
		
		int NUMBER_OF_CHARS = 256;
		int[] a1 = new int[NUMBER_OF_CHARS];
		for(int i=0; i<len1;i++){
			a1[s1.charAt(i)]=a1[s1.charAt(i)]+1;
			a1[s2.charAt(i)]=a1[s2.charAt(i)]-1;
			
			print(a1);
		}	
		for(int i=0; i<NUMBER_OF_CHARS;i++){
			if(a1[i]!=0)
				return false;
		}
		/*
		int[] a2 = new int[NUMBER_OF_CHARS];
		for(int i=0; i<len1;i++){
			a1[s1.charAt(i)]+=1;
			a2[s2.charAt(i)]+=1;
		}		
		for(int i=0; i<NUMBER_OF_CHARS;i++){
			if(a1[i]!=a2[i])
				return false;
		}
		*/
		
		return true;
		

	}
	
	public static void print(int[] a){
		for(int x:a){
			System.out.print(x);
		}
		System.out.println();
	}
}
