
public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = {5,2,8,4,9,3,1,0,12};
		mergeSort(arr, 0, arr.length-1);
		print(arr);
	}

	public static void mergeSort(int[] arr, int l, int r){
		if(r>l){
			int middle = (int)(l+r)/2;
			mergeSort(arr, l, middle);
			mergeSort(arr, middle+1, r);	
			merge(arr,l, middle, r);
		}
	}
	
	public static void merge(int[] arr, int l, int middle, int r){
		int[] a = new int[r-l+1];
		int i = l, j = middle+1;
		for(int index = 0; index <= r-l; index++){
			if((i<=middle) && (j<=r)){
				if(arr[i] <= arr[j]){
					a[index] = arr[i];
					i++;
				}else{
					a[index] = arr[j];
					j++;
				}
			}else{
				if(i>middle){
					a[index] = arr[j];
					j++;
				}else{
					a[index] = arr[i];
					i++;
				}
			}
		}
		
		for(int index = 0; index <= r-l; index++){
			arr[l+index] = a[index];
		}
		
	}
	private static void print(int[] arr){
		for(int x: arr){
			System.out.print(x+",");
			
		}
		System.out.println();
	}
}
