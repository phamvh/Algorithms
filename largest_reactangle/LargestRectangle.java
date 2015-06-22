package largest_reactangle;

import java.util.Stack;

public class LargestRectangle {

	public static void main(String[] args) {
		LargestRectangle main = new LargestRectangle();
		
		int[][] m = {{0,1,0,0},{0,1,1,1},{0,1,1,1},{1,1,0,1}};

		int l = main.largestRectangle_brute_force(m);
		System.out.println(l);
	}
	
	/**
	 * Not well understood this algorithm.
	 * @param histogram
	 * @return
	 */
	public int largestRectangleOfHistogram(int[] histogram){
		Stack<Integer> stack = new Stack<Integer>();
		int[] max = new int[histogram.length];
		int i = 0;
		int maxArea=0;
		int areaWithTop=0;
		int top;//to store top of the stack
		while(i<histogram.length){
			// If this bar is higher than the bar on top stack, push it to stack
			if(stack.isEmpty() || (histogram[i]>= stack.peek())){
				stack.push(i);
				i++;
			}
			// If this bar is lower than top of stack, then calculate area of rectangle 
	        // with stack top as the smallest (or minimum height) bar. 'i' is 
	        // 'right index' for the top and element before top in stack is 'left index'
			else{
				top = stack.pop();
				
				// Calculate the area with hist[tp] stack as smallest bar
				areaWithTop=histogram[top]*(stack.isEmpty()?i:(i-stack.peek()-1));
				
				if(maxArea <areaWithTop)
					maxArea = areaWithTop;
			}
		}
		// Now pop the remaining bars from stack and calculate area with every
	    // popped bar as the smallest bar
		while(!stack.isEmpty()){
			top = stack.pop();
			areaWithTop=histogram[top]*(stack.isEmpty()?i:(i-stack.peek()-1));
			if(maxArea <areaWithTop)
				maxArea = areaWithTop;
		}
		return maxArea;
	}
	
	public int largestRectangle_efficient(int[][] matrix){
		int R = matrix.length;
		int C = matrix[0].length;
		int[][] H = new int[R][C];
		for(int row=0;row<R;row++){
			for(int col=0;col<C;col++){
				if(row==0){
					H[row][col] = matrix[row][col];
				}else{
					if(matrix[row][col]==1)
						H[row][col] =1+H[row][col-1];
					else
						H[row][col] = 0;
				}
			}
		}
		
		int[][] M = new int[R][C];
		for(int row=0;row<R;row++){
			for(int col=0;col<C;col++){
				if(row==0 || col==C-1){
					M[row][col]=0;
				}else{
					int maxArea = 0;
					for(int j=col+1; j<C;j++){
						int minHeight = H[row][col];
						
						for(int j1=col;j1<=j;j1++){
							if(H[row][j1]<minHeight)
								minHeight = H[row][j1];
						}
						int area = minHeight*(j-col);
						if(maxArea < area)
							maxArea = area;
					}
					M[row][col]=maxArea;
				}
				
			
			}
			
		}
		return getMax(M);
	}
	
	public int largestRectangle_brute_force(int[][] matrix){ 
		int R = matrix.length;
		int C = matrix[0].length;
		int[][] maxMatrix = new int[R][C];
		
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				int max = 0;
				for(int i1=i; i1<R;i1++){
					for(int j1=j;j1<C;j1++){
						if(isAllOne(matrix, i, j, i1, j1)){
							if ((i1-i+1)*(j1-j+1)>max)
								max = (i1-i+1)*(j1-j+1);
						}
					}
				}
				maxMatrix[i][j] = max;
			}
		}
		
		int largestArea = 0;
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(largestArea < maxMatrix[i][j])
					largestArea = maxMatrix[i][j];
			}
		}
		return largestArea;
			
		
	}
	
	public boolean isAllOne(int[][] matrix, int li, int lj, int ui, int uj){
		for(int i =li; i<=ui;i++){
			for(int j=lj; j<=uj;j++){
				if(matrix[i][j]==0)
					return false;
			}
		}
		return true;
	}
	
	public int getMax(int[][] M){
		int max = 0;
		for(int i=0;i<M.length;i++){
			for(int j=0; j<M[0].length;j++){
				if(max<M[i][j])
					max=M[i][j];
			}
		}
		return max;
	}

}
