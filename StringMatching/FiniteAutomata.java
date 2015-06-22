package StringMatching;

public class FiniteAutomata {
	public static void main(String[] args) {
		finiteAutomataStringMatching("ABABACA", "ABAC");
	}
	
	public static void finiteAutomataStringMatching(String str, String pattern){
		int state = 0;
		int i = 0;
		char[] CHARACTERS = new char[256];
		for(char c = 0; c <=255; c++){
			CHARACTERS[c] = c;
		}
		int[][] table = computeStateTransitionTable(pattern.toCharArray(), CHARACTERS);
		for(i = 0; i <=str.length()-1; i++){
			char c = str.charAt(i);
			state = table[state][c];
			if(state==pattern.length())
				System.out.println("Pattern found at position "+i);
		}
	}
	
	public static int[][] computeStateTransitionTable(char[] pattern, char[] CHARACTERS){
		int[][] table = new int[pattern.length+1][CHARACTERS.length];
		for(int i = 0; i <= pattern.length; i++){
			for(int j = 0; j <CHARACTERS.length; j++){
				table[i][j] = getNextState(pattern, i, CHARACTERS[j]);
			}
		}
		return table;
	} 
	
	
	
	/**   
	 *  Given a pattern ABAC, we need to find out the next state based on 
	 *      (i) the current state and 
	 *      (ii) the encountered char
	 *  Example: pattern ABAC
	 *  
	 *             char | A     B    C   Others
	 *        state     | 
	 *        _____     |_________________________
	 *        0=""      | 1     0    0    0
	 *        1="A"     | 1     2    0    0
	 *        2="AB"    | 3     0    0    0
	 *        3="ABA"   | 1     2    4    0
	 *        4="ABAC"  | 1     0    0    0
	 *          
	 *    
	 * 
	 * @param pattern
	 * @param state
	 * @param x
	 * @return
	 */
	
	public static int getNextState(char[] pattern, int state, char x){
		int M = pattern.length;
		try{
			if((state < M) && (x==pattern[state]))
				return state+1;
		}catch(IndexOutOfBoundsException e){
			System.out.println("Pattern: "+pattern);
			System.out.println("state = "+state);
			System.out.println("x = "+x);
			throw e;
		}
		
		int ns, i;
		for(ns = state; ns >0; ns--){
			if(x==pattern[ns-1]){
				for(i = 1; ns-1-i >=0; i++){
					if(pattern[ns-1-i]!=pattern[state-i])
						break;
				}
				if(ns-1-i==0)
					return ns;
			}
		}
		return 0;
	}

}
