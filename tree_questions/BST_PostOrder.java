package tree_questions;

public class BST_PostOrder {
	
	public static void main(String[] args) {
		int[] arr={1,2,4,6,5,3};
		int[] arr1={8,2,1,3,9,1,6};
		int[] arr2={1,2,4,6,5,3};
		System.out.println(isPostOrderOfBST(arr1, 0, arr1.length-1));
	}

	public static boolean isPostOrderOfBST(int[] arr, int l, int r){
		if(arr==null)
			return false;
		if(r==l)
			return true;
		int root = arr[r];
		boolean onLeftSide=true;
		int borderIndex=-1;
		for(int i=l; i<=r-1;i++){
			if(onLeftSide){
				if(arr[i]>root){
					onLeftSide=false;
					borderIndex=i;
				}
			}else{
				if(arr[i]<root)
					return false;
			}
		}
		if(borderIndex==-1){
			return isPostOrderOfBST(arr, l, r-1);
		}else{
			return isPostOrderOfBST(arr, l, borderIndex-1) && isPostOrderOfBST(arr, borderIndex, r-1);
		}
			
	}
}
