package dynamic_programming;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		char[] a = {'a','x','v','b','z','y','c','v','w','d'};
		char[] b = {'e','f','a','g','h','b','c','k','l','d','m','n'};
		System.out.println(longestCommonSubsequence_recursive(a, a.length-1, b, b.length-1));
		String lcs = longestCommonSubsequence_iterative(a,b);
		System.out.println(lcs);
	}

	public static int longestCommonSubsequence_recursive(char[] a, int i, char[] b, int j){
		if((i<0) || (j<0))
			return 0;
		if(a[i]==b[j]){
			return 1 + longestCommonSubsequence_recursive(a, i-1, b, j-1);
		}else{
			return Math.max(longestCommonSubsequence_recursive(a, i-1, b, j),
							longestCommonSubsequence_recursive(a, i, b, j-1)  );
		}
	}
	
	public static String longestCommonSubsequence_iterative(char[] a, char[] b){
		int[][] c = new int[a.length+1][b.length+1];
		for(int j =0; j<=b.length;j++){
			c[0][j] = 0;
		}
		for(int i=0; i<=a.length;i++){
			c[i][0] = 0;
		}
		
		for(int i = 1; i <= a.length; i++){
			for(int j = 1; j <= b.length; j++){
				if(a[i-1]==b[j-1]){
					c[i][j] = 1 + c[i-1][j-1];
				}else{
					c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
				}
			}
		}
		
		System.out.println("Optimal length: "+c[a.length][b.length]);
		for(int i = 0; i<=a.length; i++){
			for(int j =0; j<=b.length; j++){
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
		System.out.println("=======================================");
		//reconstruct the longest common subsequence itself by using c[][]
		StringBuffer buf = new StringBuffer();
		int i = a.length, j = b.length;
		while((i>=1) || (j>=1)){
			if((i==0) || (j==0))
				break;
			if(c[i][j]==1+c[i-1][j-1]){
				buf.append(a[i-1]);
				//i=i>1?i-1:i;
				//j=j>1?j-1:j;
				i--;
				j--;
			}else{
				if(c[i][j] == c[i-1][j]){
					i--;
				}else
					j--;
			}
		}
		return buf.reverse().toString();
 	}
}
