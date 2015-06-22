
public class Test {

	public static void main(String[] args) {
		System.out.println(shrinkOperator("32*2+5+2*1"));
	}
		
		
		public static String shrinkOperator(String expression){
			int timeIndex = expression.indexOf('*');
			
			while(timeIndex>0){
				StringBuffer firstFactor = new StringBuffer();
				StringBuffer secondFactor = new StringBuffer();
				char fc,sc;
				int i=1,j=1;
				fc = expression.charAt(timeIndex-i);
				sc = expression.charAt(timeIndex+j);
				while(Character.isDigit(fc)){
					firstFactor.append(fc);
					i++;
					if(timeIndex-i < 0 )
						break;
					fc = expression.charAt(timeIndex - i);
				}
				while(Character.isDigit(sc)){
					secondFactor.append(sc);
					j++;
					if(timeIndex+j>expression.length()-1)
						break;
					sc = expression.charAt(timeIndex+j);
				}
				int timeVal = Integer.parseInt(firstFactor.reverse().toString())*
						Integer.parseInt(secondFactor.toString());
				String timeExp = firstFactor.reverse().append('*').append(secondFactor).toString();
				expression = expression.replace(timeExp, (new Integer(timeVal)).toString());
				timeIndex = expression.indexOf('*');
			}
			return expression;
		}
		
}
