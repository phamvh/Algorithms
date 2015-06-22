package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode((char)0);
	}
	
	public TrieNode getRoot(){
		return root;
	}
	
	public void insert(String word){
		if((word ==null) || (word.isEmpty()))
			return;
		HashMap<Character, TrieNode> children;
		int len = word.length();
		TrieNode current = root;
		for(int i =0 ; i<len; i++){
			char ch = word.charAt(i);
			children = current.getChildren();
			if(children.containsKey(ch)){
				current = children.get(ch);
			}else{
				TrieNode node = new TrieNode(ch);
				children.put(ch, node);
				current = node;
			}
		}
		current.setEnd(true);
	}
	
	/**
	 * Find all the words in the tree given a prefix.
	 * This is common in search engine (google, amazon) when you type something,
	 * and a list of automatic suggested words appear.
	 * @param prefix
	 * @return
	 */
	
	public List<String> findWordsWithPrefix(String prefix){
		List<String> results = new LinkedList<String>();
		if((prefix==null) || (prefix.isEmpty())){
			return results;
		}
		TrieNode current = root;
		int len = prefix.length();
		HashMap<Character, TrieNode> children;
		int i;
		boolean found = false;
		for(i =0; i<len; i++){
			char ch = prefix.charAt(i);
			children = current.getChildren();
			if(children.containsKey(ch)){
				current = children.get(ch);	
				if(i==len-1)
					found = true;
			}else{
				break;
			}
		}
		if(!found)
			return results;//empty list
		results = getAllSuffixes(current, new StringBuffer(prefix.substring(0,prefix.length()-1)));
		return results;
		
	}
	
	
	/**
	 * node has NOT been included in the prefix
	 * @param node
	 * @param prefix
	 * @return
	 */
	public List<String> getAllSuffixes(TrieNode node, StringBuffer prefix){
		List<String> results = new LinkedList<String>();
		if(node==null)
			return null;
		if(node.isEndOfWord()){
			results.add(prefix.toString()+node.getCh());
		}
		StringBuffer pf = new StringBuffer(prefix);
		pf.append(node.getCh());
		HashMap<Character, TrieNode> children = node.getChildren();
		if((children==null) || (children.isEmpty()))
			return results;
		for(Map.Entry<Character, TrieNode> entry: children.entrySet()){
			//StringBuffer pf = new StringBuffer(prefix);
			//pf.append(entry.getKey());
			results.addAll(getAllSuffixes(entry.getValue(), pf));
		}
		return results;
	}
	
	/**
	 * Given a string, find the longest word in the trie that is a prefix of this string. 
	 * @param word
	 * @return
	 */
	public String getMatchingPrefix(String str){
		if((str ==null) || (str.isEmpty()))
			return "";
		StringBuffer result = new StringBuffer();
		String previousMatch = null;
		HashMap<Character, TrieNode> children;
		TrieNode current = root;
		int len = str.length();
		for(int i = 0; i < len; i++){
			char ch = str.charAt(i);
			children = current.getChildren();
			if(children.containsKey(ch)){
				result.append(ch);
				current = children.get(ch);
				if(current.isEndOfWord())
					previousMatch = result.toString();
			}else{
				break;
			}
		}
		return previousMatch;
	}
	
}
