
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,6,2,3,9,3,10};
		//System.out.println(arr);
		for(int x:arr){
			System.out.print(x);
		}
		int len = arr.length;
		int current=0, maxIndex = 0;
		while(current != len-1){
			maxIndex = current;
			for(int i = current+1; i < len; i++){
				if(arr[i] > arr[maxIndex] ){
					maxIndex = i;
				}
			}
			if(current!=maxIndex){
				int temp = arr[current];
				arr[current] = arr[maxIndex];
				arr[maxIndex] = temp;
			}
			current++;
		}

		//System.out.println(arr);
		System.out.println();
		for(int x : arr){
			System.out.print(x);
		}
	}

}
