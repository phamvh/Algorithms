package trie;

import java.util.List;

public class Test {
	   public static void main(String[] args) {
	        Trie dict = new Trie();        
	        dict.insert("are");
	        dict.insert("area");
	        dict.insert("base");
	        dict.insert("cat");
	        dict.insert("cater");        
	        dict.insert("basement");
	        
	        List<String> words = dict.findWordsWithPrefix("cat");
	        for(String word: words){
	        	System.out.println(word);
	        }
	         
	        /*
	        String input = "caterer";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "basement";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	         
	        input = "are";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "arex";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "basemexz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	         
	        input = "xyz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));          
	        */            
	    }
	}