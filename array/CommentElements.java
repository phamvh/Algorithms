package array;

public class CommentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {2,5,8,9};
		int[] a2 = {5,6,7,8,9,12,14};
		int[] a3 = {2,5,6,7,8,9,10};
		commonElements(a1,a2,a3);

	}
	
	/**
	 * Find common elements in three SORTED arrays
	 * @param a1
	 * @param a2
	 * @param a3
	 */
	public static void commonElements(int[] a1, int[] a2, int[] a3){
		int i=0,j=0,k=0;
		boolean found2, found3;
		while((i<a1.length) || (j<a2.length) || (k<a3.length)){
			found2=false;
			found3=false;
			int x = a1[i];
			while((j<a2.length) && (a2[j]<=x)){
				if(a2[j]==x){
					found2=true;
					break;
				}
				else
					j++;
			}
			while((k<a3.length) && (a3[k]<=x)){
				if(a3[k]==x){
					found3=true;
					break;
				}
				else
					k++;
			}
			if(found2 && found3){
				System.out.println(x);
			}
			
			i++;
			if(i>a1.length-1)
				break;
			
		}
	}

}
