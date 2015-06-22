package array;

public class DutchNationalFlag {

	public static void main(String[] args) {
	
		int[] arr = new int[]{2,3,3,1,1,2,2,2,3,3,1,1,2};
		dutchNationalFlagSort_Numbers(arr);
		for(int x:arr){
			System.out.print(x+" ");
		}
	
	}
	
	/**
	 * Given an array that contains objects of three different types, say, 3 different colors, as in enum Color below.
	 * Sort the array with O(1) space complexity and O(N) time complexity.
	 * This is the Dutch national flag problem.
	 * @param arr
	 * @return
	 */
	public static void dutchNationalFlagSort(Ball[] arr){
		int i=-1;
		int j=arr.length;
		int k=0;
		while(k<j){
			if(arr[k].color==Color.YELLOW){
				swap(arr,k,i+1);
				
				i++;
				k++;
			}else if(arr[k].color==Color.RED){
				swap(arr,k,j-1);
				j--;
				
			}else if(arr[k].color==Color.GREEN){
				k++;
			}

		}
	}
	/**
	 * This is just for testing for simplicity by using numbers instead of Balls
	 * Assume all the numbers are either 1,2 or 3.
	 * @param arr
	 */
	public static void dutchNationalFlagSort_Numbers(int[] arr){
		int i=-1;
		int j=arr.length;
		int k=0;
		while(k<j){
			if(arr[k]==1){
				swap(arr,i+1,k);				
				i++;
				k++;
			}else if(arr[k]==3){
				swap(arr,k,j-1);
				j--;
				
			}else if(arr[k]==2){
				k++;
			}

		}
	}
	public static void swap(Ball[] arr, int i, int j){
		Ball temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int[] arr){
		for(int x:arr){
			System.out.print(x+" ");
		}
	}
	
	class Ball implements Comparable<Ball>{
		Color color;
		int ID;
		public int compareTo(Ball ball){
			return color.compareTo(ball.color); 
		}
	}
	
	public enum Color{
		RED,
		GREEN,
		YELLOW
	}
}
