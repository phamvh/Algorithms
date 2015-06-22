package strings;

public class ReverseASentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void reverseSentence_elegant(char[] str){
		if((str==null) || (str.length<=2))
			return;
		int i=0,j=str.length-1;
		while(i<j){
			char t = str[i];
			str[i]=str[j];
			str[j]=t;
			i++;
			j++;
		}
		
		int startWord=0;
		int endWord=0;
		int index=0;
		while(index<str.length){
			if(str[i]!=' ')
				index++;
			else{
				endWord=i-1;
				//startWord ... endWord
				int left=startWord,right=endWord;
				while(right>left){
					char t=str[left];
					str[left]=str[right];
					str[right]=t;
					left++;
					right--;
				}
			
				startWord=i+1;
				index++;
			}
		}
	}
	
	public static void reverseSentence(char[] str){
		if((str==null) || (str.length<=2))
			return;
		
		int i=0,j=str.length-1;
		int i1=0,j1=str.length-1;
		boolean bothSpace=false;
		while(i<j){
			if((str[i]==' ') && (str[j]==' ')){
				//i1 ... i-1
				//j-1 ... j1
				int diff = (j1-(j-1))-(i-1-i1);
				//shift all chars between i+1 and j-1 to the right by diff positions if diff>0, else shift to the left
				if(diff>0){
					//exchange between i1+x...i-1 and j+1+diff+x...j1
					for(int x=0; i1+x<=i-1;x++){
						char t = str[i1+x];
						str[i1+x]=str[j+1+diff+x];
						str[j+1+diff+x] = t;
						
					}
					for(int x=0; x<diff-1;x++){
						char t = str[j+1+x];
						int y=j+1+x;
						while(y>=i1+1){
							str[y]=str[y-1];
						}
						str[i+1]=t;
					}
				}else if(diff<0){
					//similar
				}
				
				i1=i+1;
				j1=j-1;
			}
			if(str[i]!=' ')
				i++;
			if(str[j]!=' ')
				j--;
		}
	}

}
