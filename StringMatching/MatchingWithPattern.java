package StringMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingWithPattern {

	public static void main(String[] args) {
		MatchingWithPattern main = new MatchingWithPattern();
		System.out.println("Yahoo!!!==========================");
		System.out.println(main.isMatch("Yahoo", "Ya*o") + "="+main.isMatch_yahoo("Yahoo", "Ya*o"));
		System.out.println(main.isMatch("Yahoo", "Y*o") + "="+main.isMatch_yahoo("Yahoo", "Y*o"));
		System.out.println(main.isMatch("Yahoo", "*oo") + "="+main.isMatch_yahoo("Yahoo", "*oo"));
		System.out.println(main.isMatch("Yahoo", "Y*.o") + "="+main.isMatch_yahoo("Yahoo", "Y*.o"));
		System.out.println(main.isMatch("Yahool", "Y*.o") + "="+main.isMatch_yahoo("Yahool", "Y*.o"));	
		
		System.out.println("Facebook!!!==========================");
		
		System.out.println(main.isMatch("Facebook", "Facebook") + "="+main.isMatch_facebook("Facebook", "Facebook"));
		System.out.println(main.isMatch("Facebook", "Face.ook") + "="+main.isMatch_facebook("Facebook", "Face.ook"));
		System.out.println(main.isMatch("Facebook", "Facebo*k") + "="+main.isMatch_facebook("Facebook", "Facebo*k"));
		System.out.println(main.isMatch("Facebook", ".acebo*k") + "="+main.isMatch_facebook("Facebook", ".acebo*k"));
		System.out.println(main.isMatch("Facebook", "F.ceboo*k") + "="+main.isMatch_facebook("Facebook", "F.ceboo*k"));
		System.out.println(main.isMatch("Facebook", "F.ceboo*kl") + "="+main.isMatch_facebook("Facebook", "F.ceboo*kl"));
		System.out.println(main.isMatch("Facebook", "Faceb.*k") + "="+main.isMatch_facebook("Facebook", "Faceb.*k"));
		System.out.println(main.isMatch("Faceoook", "Faceo**k") + "="+main.isMatch_facebook("Faceoook", "Faceo**k"));
		
		System.out.println("Facebook Efficient!================");
		System.out.println(main.isMatch("facebooook","facebo*ook")+"="+main.match("facebooook".toCharArray(), "facebo*ook".toCharArray()));
	}
	
	/**
	 * This is a wrong algorithm.
	 * Does not work for: str="facebooook", pattern="facebo*ook"
	 * @param text
	 * @param pattern
	 * @return
	 */
	public boolean match(char text[], char pattern[]) {
		if (text == null || text.length == 0) return false;
		if (pattern == null || pattern.length == 0) return false;
		
		for (int i=0, j=0; i<text.length; i++) {
			if (pattern[j] == '.') {
				j++;
			}
			else if (j > 0 && pattern[j] == '*') {
				if (text[i] != pattern[j-1]) {
					if (text[i] == pattern[j+1]) {
						j++;
					}
					else {
						return false;
					}
				}
			}
			else {
				if (text[i] != pattern[j]) {
					return false;
				}
				else {
					j++;
				}
			}
		}
		
		
		return true;
	}
	
	/*
	public boolean isMatch_efficient(String str, String pattern){
		for(int i=0,j=0; i<str.length();i++){
			if(pattern.charAt(j)=='.')
				j++;
			else{
				if(pattern.charAt(j)=='*'){
					if(j==0){ // '*' at the beginning of the pattern - just ignore it
						j++;
					}else{
						//1: do not match j and move on
						//2: match i and j once and move on
						//3: match i and j, and try to match more from str against j
						if(str.charAt(i) != str.charAt(i-1)){
							j++;
							i--;
						}
						else{ 
							if((pattern.charAt(j-1) == str.charAt(i)) && (str.charAt(i) == str.charAt(i-1))){
							
							}
							
						}
					}
				}else{
					if(pattern.charAt(j)==str.charAt(i))
						j++;
					else
						return false;
				}
			}
		}
	}
	*/
	/**
	 * Similar to isMatch_yahoo
	 * However, '*' has a different meaning: it means a previous character is repeated zero, 1 or more times. 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public boolean isMatch_facebook(String str, String pattern){
		boolean[][] matrix = new boolean[str.length()+1][pattern.length()+1];
		matrix[0][0]=true;
		for(int i=1;i<=str.length();i++){
			matrix[i][0] = false;//when pattern is empty but string is not empty
		}
		for(int j=1;j<=pattern.length();j++){
			if(pattern.charAt(j-1)=='*'){
				matrix[0][j]=matrix[0][j-1];//this = true only of all chars in the pattern are '*'
			}else
				matrix[0][j]=false;
		}
		
		for(int i = 1; i<=str.length(); i++){
			for(int j=1;j<=pattern.length();j++){
				char p = pattern.charAt(j-1);
				if(p=='.'){
					matrix[i][j] = matrix[i-1][j-1];
				}else{
					if(p=='*'){
						if(pattern.charAt(j-2)!='.'){
							matrix[i][j] = matrix[i][j-1] ||
									(matrix[i-1][j-1] && (pattern.charAt(j-2) == str.charAt(i-1)) && (str.charAt(i-1)==str.charAt(i-2)))                    ||
									(matrix[i-1][j] && (pattern.charAt(j-2) == str.charAt(i-1)) && (str.charAt(i-1)==str.charAt(i-2)));
						}else{
							matrix[i][j] = matrix[i][j-1] ||
									(matrix[i-1][j-1] && (str.charAt(i-1)==str.charAt(i-2)))  ||
									(matrix[i-1][j] && (str.charAt(i-1)==str.charAt(i-2)));
						}
					}else{
						if(p==str.charAt(i-1)){//two chars match
							matrix[i][j] = matrix[i-1][j-1];
						}else  //two chars do not match
							matrix[i][j] = false;
					}
				}
			}
		}
		
		return matrix[str.length()][pattern.length()];
		
		
	}
	
	/**
	 * Build a function that takes one string and one regex expression in inputs and output true if the string 
	 * matches the regex expression. 
	 *     string: a-z
	 *     regex: a-z . * (where '*' matches 0 or more character and '.' matches one character)
	 *     
	 * The function uses dynamic programming.
	 * matrix[i][j] basically is a subproblem, when the input string has i first chars, and the pattern has j first chars.     
	 *     
	 * @param str
	 * @param pattern
	 * @return
	 */
	public boolean isMatch_yahoo(String str, String pattern){
		boolean matrix[][] = new boolean[str.length()+1][pattern.length()+1];
	    matrix[0][0]=true;	
	    for(int i = 1; i <= str.length(); i++)
	    	matrix[i][0] = false;
		
	    for(int j = 1; j <= pattern.length(); j++){
	    	if(pattern.charAt(j-1)!='*')
	    		matrix[0][j] = false;
	    	else{
	    		matrix[0][j] = matrix[0][j-1];
	    	}
	    }
	    
	    for(int i = 1; i <= str.length(); i++){
	    	for(int j = 1; j <= pattern.length(); j++){
	    		if(pattern.charAt(j-1)=='.'){
	    			matrix[i][j] = matrix[i-1][j-1];
	    		}else{
	    			if(pattern.charAt(j-1)=='*'){
	    				matrix[i][j] = matrix[i][j-1] || matrix[i-1][j-1] || matrix[i-1][j];
	    			}else{
	    				if(pattern.charAt(j-1) == str.charAt(i-1)){
	    					matrix[i][j] = matrix[i-1][j-1];
	    				}else
	    					matrix[i][j] = false;
	    			}
	    		}
	    	}
	    }
	    
	    return matrix[str.length()][pattern.length()];
	}
	
	/**
	 * This function is copied from careerup
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
	      int count = 0;//the number of non-star chars in the pattern
	      for(int i = 0; i < p.length() ;i++){
	        if(p.charAt(i)!='*') count++;
	      }

	      if(count > s.length()) return false;

	      boolean[][]dp = new boolean[p.length() + 1][s.length() + 1];

	      dp[0][0] = true;
	      for(int i = 1; i <= p.length();i++){
	        if(p.charAt(i-1) == '*')
	          dp[i][0] = dp[i-1][0];  
	        else dp[i][0] = false;
	      }
	     
	     for(int i = 1; i <= s.length(); i++){
	        for(int j = 1; j <= p.length(); j++){
	          if(p.charAt(j -1) == '.') dp[j][i] = dp[j-1][i - 1];
	          else{ 
	        	  if(p.charAt(j -1) == '*'){
	        		  dp[j][i] = dp[j][i-1] | dp[j-1][i] | dp[j-1][i-1];
	        	  }else{
		        	  if(p.charAt(j -1) == s.charAt(i -1)){
		        		  dp[j][i] = dp[j - 1][i-1];
		        	  }else
		        		  dp[j][i] = false;
	        	  }
	          //else if(p.charAt(j -1) == s.charAt(i -1)) dp[j][i] = dp[j - 1][i-1];
	          //else dp[j][i] = false;
	          }
	        }
	     }
	      return dp[p.length()][s.length()];
	 }
	
	public boolean isMatchUsingJavaLib(String s, String p){
		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(s);
		return matcher.find();
		//return matcher.matches(); //this only for matching the entire input string against the pattern.
	}

}
