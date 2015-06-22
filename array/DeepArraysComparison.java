package array;

public class DeepArraysComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean compare(Object[] a1, Object[] a2){
		if((a1==null) || (a2==null))
			return false;
					
		if(a1.length!=a2.length)
			return false;
		for(int i = 0; i <a1.length; i++){
			Object xi = a1[i];
			Object yi = a2[i];
			
			if(xi==yi)
				continue;
			else{
				if((xi instanceof Object[]) && (yi instanceof Object[])){
					if(compare((Object[])xi, (Object[])yi))
						continue;
				}else{
					if(xi.equals(yi))
						continue;
				}
			}
		}
		return true;
	}

}
