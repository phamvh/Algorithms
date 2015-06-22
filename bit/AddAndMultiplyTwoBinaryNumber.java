package bit;

import java.util.HashMap;
import java.util.Map;

public class AddAndMultiplyTwoBinaryNumber {

	private Map<String, String> lookupTable = new HashMap<String, String>();
	
	public AddAndMultiplyTwoBinaryNumber() {
		lookupTable.put("0+0+0", "00");
		lookupTable.put("0+0+1", "01");
		lookupTable.put("0+1+0", "01");
		lookupTable.put("1+0+0", "01");
		lookupTable.put("1+1+0", "10");
		lookupTable.put("1+0+1", "10");
		lookupTable.put("0+1+1", "10");
		lookupTable.put("1+1+1", "11");
	}
	
	/**
	 * Add zero to the front of the binary number to make its length the same
	 * as the length of the result.
	 * @param s
	 * @param length
	 * @return
	 */
	private String padZeros(String s, int length){
		if(s.length()<length){
			s = "0"+s;
		}
		return s;
	}
	/**
	 * Add two binary numbers represented as strings
	 * @param s1
	 * @param s2
	 * @return
	 */
	public String add(String s1, String s2){
		int length = Math.max(s1.length(), s2.length());
		s1 = padZeros(s1, length);
		s2 = padZeros(s2, length);
		
		StringBuffer buf = new StringBuffer();
		char carry = '0';
		char a,b;
		String sum,key;
		for(int i=length-1; i>=0;i--){
			a = s1.charAt(i);
			b = s2.charAt(i);
			key = String.format("%c+%c+%c", a,b,carry);
			if(!lookupTable.containsKey(key))
				throw new IllegalArgumentException();
			sum = lookupTable.get(key);
			buf.insert(0, sum.charAt(1));
			carry = sum.charAt(0);
		}
		if(carry=='1')
			buf.insert(0, carry);
		return buf.toString();
	}
	
	/**
	 * Multiply two binary numbers represented as strings.
	 * We only need to go through one of the string, say s2.
	 * if s2.charAt(i)=='1', then the partial sum is just s1 (the result of 1*s1), and we just
	 * need to pad some zeros to the end of the partial sum.
	 * Example:
	 *   
	 *   101 *
	 *   011
	 *   ____
	 *   101 +
	 *  1010
	 * 00000 (this is not needed as it is all zero)
	 * ______ 
	 * That's it; simply add these partials sums using the previous function add();
	 *   
	 *   
	 * @param s1
	 * @param s2
	 * @return
	 */
	public String multiply(String s1, String s2){
		StringBuffer buf = new StringBuffer();
		int len = s2.length();
		char c;
		String result="";
		String zeroPad="";
		for(int i=len-1;i>=0;i--){
			c = s2.charAt(i);
			if(c=='1'){
				String partialSum = s1+zeroPad;
				result=add(result, partialSum);
			}
			zeroPad+="0";
		}
		return result;
	}
	
	public static void main(String[] args) {
		AddAndMultiplyTwoBinaryNumber main = new AddAndMultiplyTwoBinaryNumber();
		System.out.println(main.add("10011", "011010"));
	}
}
