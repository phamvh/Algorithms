
public class CalculationExpression {

	public static void main(String[] args) {
		System.out.println(shrinkOperator(shrinkOperator("32*2+5+2*1",'*'),'+'));
	}
		
		
		public static String shrinkOperator(String expression, char operator){
			int operatorIndex = expression.indexOf(operator);
			
			while(operatorIndex>0){
				StringBuffer firstFactor = new StringBuffer();
				StringBuffer secondFactor = new StringBuffer();
				char fc,sc;
				int i=1,j=1;
				fc = expression.charAt(operatorIndex-i);
				sc = expression.charAt(operatorIndex+j);
				while(Character.isDigit(fc)){
					firstFactor.append(fc);
					i++;
					if(operatorIndex-i < 0 )
						break;
					fc = expression.charAt(operatorIndex - i);
				}
				while(Character.isDigit(sc)){
					secondFactor.append(sc);
					j++;
					if(operatorIndex+j>expression.length()-1) 
						break;
					sc = expression.charAt(operatorIndex+j);
				}
				int value;
				String operatorExp;
				if(operator=='*'){
					value = Integer.parseInt(firstFactor.reverse().toString())*
						Integer.parseInt(secondFactor.toString());
					operatorExp = firstFactor.append('*').append(secondFactor).toString();
					expression = expression.replace(operatorExp, (new Integer(value)).toString());
					operatorIndex = expression.indexOf('*'); 
				}
				else{
					value = Integer.parseInt(firstFactor.reverse().toString()) +
							Integer.parseInt(secondFactor.toString());
					operatorExp = firstFactor.append('+').append(secondFactor).toString();
					expression = expression.replace(operatorExp, (new Integer(value)).toString());
					operatorIndex = expression.indexOf('+'); 
				}
				
				
				 
			}
			return expression;
		}
		

}
