package dynamic_programming;

public class Knapsack {

	/**
	 * 
	 * @param values 
	 * @param weights
	 * @param W - the remaining weight that the knapsack can carry more
	 * @param i - all items are numbered, 1st, 2nd, ..., i-th,..., nth
	 * so i indicates the consideration of optimal solution when there are i first items in arrays values and weights
	 * @return
	 */
	public static int knapsack(int[] values, int[] weights, int W, int i){
		if((W==0) || (i==0))
			return 0;
		/*
		 * Let assume that OPT is an optimal solution, which contains a specific subset of items that maximize the values.
		 * Consider the i-th item: there are only two cases: (1) i belongs to OPT, (2) and i does NOT belong to OPT.
		 * if W < weights[i] then it is sure that i-th does not belong to OPT because i-th cannot be added to OPT (overweight)
		 * if W > weights[i-1], then i-th may be added to OPT
		 * */
		if(W < weights[i])
			return knapsack(values, weights, W, i-1);
		else{
			return Math.max(knapsack(values, weights, W, i-1), values[i]+knapsack(values, weights, W-weights[i], i-1));
		}
	}
}
