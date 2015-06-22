
public class SelectionMinMax {
	public static void main(String[] args) {
		int[] arr = {3,6,1,9,3,6,8};
		int min = arr[0], max = arr[0];
		int i = 1;
		while(i<arr.length-1){
			if(arr[i]>arr[i+1]){
				if(arr[i]>max)
					max = arr[i];
				if(arr[i+1] < min)
					min = arr[i+1];
			}else{
				if(arr[i+1]>max)
					max = arr[i];
				if(arr[i] < min)
					min = arr[i+1];
			}		
			i=i+2;
		}
		if(i==arr.length-1){
			if(arr[i]>max){
				max = arr[i];
			}else{
				if(arr[i]< min)
				max = arr[i];
			}
		}
	}
}
