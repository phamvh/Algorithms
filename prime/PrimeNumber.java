package prime;

public class PrimeNumber {
	public static void main(String[] args) {
		findPrimeNumber(200);
	}
	
	public static void findPrimeNumber(int max){
		boolean[] marks = new boolean[max+1];
		for(int i=0; i<=max;i++)
			marks[i] = true;

		for(int i=2;i<Math.sqrt(max)+1;i++){
			if(marks[i]){
				for(int j=i; i*j<=max;j++){
					marks[i*j]=false;
				}
			}
		}
		
		for(int i=0; i<=max;i++){
			if(marks[i])
				System.out.print(i+",");
		}
	}

}
