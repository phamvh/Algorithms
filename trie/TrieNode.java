package trie;

import java.util.HashMap;

public class TrieNode {

	private char ch;
	private boolean isEnd;
	private HashMap<Character, TrieNode> children;
	
	public TrieNode(char ch) {
		this.ch = ch;
		isEnd = false;
		children = new HashMap<Character, TrieNode>();
	}

	public boolean isEndOfWord() { 
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public char getCh() {
		return ch;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}
}
