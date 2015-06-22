
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,9,1,3,6,5,2,8};
		//int[] arr = {4,9,1};
		//MyOwnInsertionSort(arr);
		TypicalInsertionSort(arr);
		System.out.println();
		for(int x : arr){
			System.out.print(x);
		}

	}
	
	private static int[] TypicalInsertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			int j = i-1;
			while((j>= 0)  &&  (key < arr[j])){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;	
		}
		return arr;
	}

	private static int[] MyOwnInsertionSort(int[] arr) {
		int len = arr.length;
		//increasing order
		//sorted - from 0 to i-1
		
		for(int i = 1; i < len; i++){
			//find the position for inserting arr[i]
			int j = 0;
			while(j < i){
				if(arr[j] > arr[i]){
					break;
				}
				j++;
			}
			//put arr[i] into arr[j] and shift all arr[j+1]->arr[i-1] to the right by 1 position
			int temp = arr[i];
			int index = i;
			while(index > j){
				arr[index] = arr[index-1];
				index--;
			}
			arr[j] = temp;
		}
		
		for(int x:arr){
			System.out.print(x);
		}
		return arr;
	}

}
