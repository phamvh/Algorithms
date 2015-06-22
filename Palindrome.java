
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public static boolean isPalindrome(String str){
		if((str==null) || (str.isEmpty()))
			return false;
	
	    int left = 0, right = str.length()-1;
	    while(right > left){
	    	char lc = str.charAt(left);
	    	char rc = str.charAt(right);
	    	if(Character.isLetterOrDigit(lc) && Character.isLetterOrDigit(rc)){
	    		if(lc != rc)
	    			return false;
	    		left++;
	    		right--;
	    	}else{
	    		if(Character.isLetterOrDigit(lc))
	    			right--;
	    		else
	    			left++;
	    	}
	    }
	    return true;
	
	}
	

}
