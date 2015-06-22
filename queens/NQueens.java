package queens;

public class NQueens {

	public static void main(String[] args) {
		int[] positions = new int[100];
		NQueens main = new NQueens();
		main.nQueen(positions, 0);

	}
	
	public boolean isSafe(int[] positions, int queen, int row){
		if(queen==0)
			return true;
		for(int i=1; queen - i>=0; i++){
			if(positions[queen-i]==row)
				return false;
			if((positions[queen-i]==row-i) || (positions[queen-i]==row+i))
				return false;
			
			if(i==1){
				if((positions[queen-i]==row-2) || (positions[queen-i]==row+2))
					return false;
			}else if(i==2){
				if((positions[queen-i]==row-1) || (positions[queen-i]==row+1))
					return false;
			}
		}
		return true;
	}
	
	public void nQueen(int[] positions, int queen){
		int N = positions.length;
		for(int row=0; row<N; row++){
			if(isSafe(positions, queen, row)){
				positions[queen] = row;
				if(queen==N-1)
					print(positions);
				else
					nQueen(positions, queen+1);
			}
		}
	}
	
	public void print(int[] positions){
		for(int x: positions)
			System.out.print(x);
		System.out.println();
	}
	
	

}
