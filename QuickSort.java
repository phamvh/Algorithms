
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,2,8,4,9,3,1,0,12};
		//System.out.println(partition(arr, 0, 8));
		//print(arr);
		
		quickSort(arr, 0, arr.length-1);
		//partition_again(arr, 0, arr.length-1);
		print(arr);

	}
	
	public static void quickSort(int[] arr, int l, int r){
		if(r > l){
			int pivotIndex = partition_again(arr, l, r);
			if(pivotIndex-1 > l)
				quickSort(arr, l, pivotIndex-1);
			if(pivotIndex+1<r)
				quickSort(arr, pivotIndex+1, r);
		}
	}
	
	/*
	 * Just write the partition again for practice. It's not trivial
	 */
	public static int partition_again(int[] arr, int l, int r){
		if((l==r))
			return l;
		int pivot = arr[l];
		int currentPartition = l;
		int i = l+1;
		while(i<=r){
			if(arr[i] <= pivot){
				int temp = arr[currentPartition+1];
				arr[currentPartition+1] = arr[i];
				arr[i] = temp;
				currentPartition++;
			}
			
			i++;
		}
		//swap
		int temp = arr[currentPartition];
		arr[currentPartition] = arr[l];
		arr[l] = temp;
		return currentPartition;
		
	}
	
	/**
	 * This function does not work properely
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public static int partition(int[] arr, int l, int r){
		int pivot = arr[l];
		int current = l; //the current position that defines the border of the partitioning so far.
		for(int i = l+1; i <= r; i++){
			if(arr[i] <= pivot){
				//swap arr[i] with the one right before the current;
				swap(arr, current+1, i);
				current++;
			}
		}
		swap(arr, 0, current);
		return current;
		
		/*int pivot = arr[l];
		
		int current = 0;
		
		for(int i = l+1; i <= r; i++){
			if(arr[i] <= pivot){
				if(i == current+1){
					int t = arr[i];
					arr[i] = arr[current];
					arr[current] = t;
					current++;
				}else{
					int t = arr[current + 1];
					arr[current + 1] = arr[current];
					arr[current] = arr[i];
					arr[i] = t;
					current++;
				}
			}
		}
		
		return current;*/
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void print(int[] arr){
		for(int x: arr){
			System.out.print(x+",");
			
		}
		System.out.println();
	}

}
