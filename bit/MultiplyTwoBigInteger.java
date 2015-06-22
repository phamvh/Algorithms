package bit;

public class MultiplyTwoBigInteger {
	
	public static void main(String[] args) {
		MultiplyTwoBigInteger main = new MultiplyTwoBigInteger();
		String s1="1345";
		String s2="421";
		System.out.println(main.multiply(s1, s2));
		System.out.println(Integer.parseInt(s1)*Integer.parseInt(s2));
	}

	/**
	 * Multiply two big integers represented as String.
	 * Example : "2398239403289434"*"239849203849308492348";
	 * @param s1
	 * @param s2
	 * @return
	 */
	public String multiply(String s1, String s2){
		int[] result = new int[s1.length()+s2.length()];
		for(int i=0;i<s2.length();i++){
			for(int j=0; j<s1.length();j++){
				result[i+j] = result[i+j]+Integer.parseInt(""+s2.charAt(s2.length()-i-1))*Integer.parseInt(""+s1.charAt(s1.length()-j-1));
			}
		}
		for(int i=0;i<result.length;i++){
			if(result[i]>=10){
				result[i+1] +=(int)result[i]/10;
				result[i]=result[i]%10;
			}
		}
		
		StringBuffer buf = new StringBuffer();
		int i=result.length-1;
		while(result[i]==0)
			i--;
		
		while(i>=0){
			buf.append(result[i]);
			i--;
		}
		
		return buf.toString();
	}
}
