package math.expression;

import java.util.Stack;

public class MathExpressionEvaluation {
	public static void main(String[] args) {
		String word ="Hello";
		int N = 5;
		boolean[][][] tables = new boolean[word.length()][N][N];
		for(int k=1; k<=word.length();k++){
			for(int i=0; i<N; i++){
				for(int j=0; j<N;j++){
					System.out.print(tables[k-1][i][j]);
				}
				System.out.println();
			}
			System.out.println("*************");
		}
		
	}
	
	public String convertInfixWithParensToPostFix(String expr){
		if((expr==null) || (expr.isEmpty()))
			return expr;
		StringBuffer buf = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		String str = expr.replaceAll(" +", " ");
		String[] tokens = str.split(" ");
		for(String token:tokens){
			if(isNumber(token))
				buf.append(token).append(' ');
			else{ //not number
				if(isOperator(token)){
					if(stack.isEmpty())
						stack.push(token.charAt(0));
					else{
						char c = stack.peek();
						while(hasHigherPriority(c, token.charAt(0))){
							buf.append(stack.pop()).append(' ');
							if(stack.isEmpty())
								break;
							c=stack.peek();
						}
						stack.push(token.charAt(0));
					}
				}else{ //not operator
					if(isleftparen(token.charAt(0))){
						stack.push(token.charAt(0));
					}else{//not left paren, and therefore is a right paren
						char c1 = stack.pop();
						while(c1!='('){
							buf.append(c1).append(' ');
							c1=stack.pop();
						}
					}
				}	
			}
		}
		while(!stack.isEmpty()){
			buf.append(stack.pop()).append(' ');
		}
		return buf.toString().trim();
	}
	
	public int inFixWithoutParens(String expr){
		if((expr==null) || (expr.isEmpty()))
			throw new IllegalArgumentException("No expression is given.");
		Stack<Integer> operandStack = new Stack<Integer>();
		Stack<Character> operatorStack = new Stack<Character>();
		String str = expr.replaceAll(" +", " ");
		String[] tokens = str.split(" ");
		for(String token : tokens){
			if(isNumber(token))
				operandStack.push(Integer.parseInt(token));
			else{
				if(operatorStack.isEmpty())
					operatorStack.push(token.charAt(0));
				else{
					if(!hasHigherPriority(operatorStack.peek(), token.charAt(0)))
						operatorStack.push(token.charAt(0));
					else{
						int num1 = operandStack.pop();
						int num2 = operandStack.pop();
						char op = operatorStack.pop();
						int value = evaluate(num1, num2, op);
						operandStack.push(value);
						operatorStack.push(token.charAt(0));
					}
				}
			}
		}
		while(!operatorStack.isEmpty()){
			char operator = operatorStack.pop();
			int num1 = operandStack.pop();
			int num2 = operandStack.pop();
			int value = evaluate(num1, num2, operator);
			operandStack.push(value);
		}
		if(operandStack.size()>1)
			throw new IllegalArgumentException("Two many operands");
		return operandStack.pop();
	}
	
	public boolean hasHigherPriority(char operator1, char operator2){
		return false;
	}
	
	public int postFix(String expr){
		if((expr==null) || (expr.isEmpty()))
			throw new IllegalArgumentException("No expression is given.");
		Stack<Integer> stack = new Stack<Integer>();
		String str = expr.replaceAll(" +", " ");
		String[] tokens = str.split(" ");
		for(String token: tokens){
			if(isNumber(token))
				stack.push(Integer.parseInt(token));
			else{
				if(stack.size()<2)
					throw new IllegalArgumentException();
				int num1 = stack.pop();
				int num2 = stack.pop();
				int val = evaluate(num1, num2, token.charAt(0));
				stack.push(val);
			}
		}
		if(stack.size()>1)
			throw new IllegalArgumentException("Too many operands");
		

		
		return stack.pop();
	}
	
	public static boolean isNumber(String token){
		return false;
	}
	
	public static boolean isOperator(String token){
		return false;
	}
	
	public static boolean isleftparen(char c){
		return false;
	}
	
	public static boolean isRightParen(char c){
		return false;
	}
	
	public static int evaluate(int num1, int num2, char operator){
		return 0;
	}

}
