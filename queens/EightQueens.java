package queens;

public class EightQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Queens puzzle");
		int[] positions = new int[100];
		solve(positions, 0);
	}
	
	/**
	 * 
	 * @param possitions
	 * @param k - first k queens
	 */
	private static void solve(int[] positions, int k){
		if(k==positions.length){
			print(positions);
			return;//finished
		}
		for(int i = 0; i < positions.length; i++){
			if(isSafe(positions, k, i)){
				positions[k] = i;
				solve(positions, k+1);
			}
		}
	}
	
	private static boolean isSafe(int[] positions, int queenNumber, int rowPosition){ 
		if(queenNumber == 0)
			return true;
		for(int i = 0; i < queenNumber; i++){
			if(positions[i]==rowPosition)
				return false;
			if(     (rowPosition - (queenNumber - i) >= 0 )
					&& (positions[i]== rowPosition - (queenNumber - i))){
				return false;
			}
			if(     (rowPosition + (queenNumber - i) <= positions.length-1)
					&& (positions[i]== rowPosition + (queenNumber - i))){
				return false;
			}
		}
		return true;
	}
	
	private static void print(int[] arr){
		for(int x: arr){
			System.out.print(x+"   ");
		}
		System.out.println();
	}

}
