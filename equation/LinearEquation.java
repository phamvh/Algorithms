package equation;

import java.util.LinkedList;

public class LinearEquation {
	
	public static void main(String[] args) {
		System.out.println("ha  ha ha".replaceAll(" +", ""));
		System.out.println("ha+ha-ha".replaceAll("-", "+"));
	}

	public Double solveLinearEquation(String s){
		if(s==null || s.isEmpty())
			throw new IllegalArgumentException();
		
		s=s.replace(" +", "");
		String[] sides = s.split("=");
		String rightSide = sides[1];
		if(!rightSide.equals("0")){
			boolean minus=false;
			if(rightSide.startsWith("-"))
				minus=true;
			rightSide = rightSide.replaceAll("\\+", "plus");
			rightSide = rightSide.replaceAll("-", "+");
			rightSide = rightSide.replaceAll("plus", "-");
			if(minus){
				rightSide = rightSide.substring(1);
			}else{
				rightSide = "-"+rightSide;
			}
		}
		s = sides[0]+sides[1];
		String[] pComps = s.split("\\+");
		int num=0;
		LinkedList<String> mGroups = new LinkedList<String>();
		for(String pComp : pComps){
			if(pComp.contains("x")){
				mGroups.add(pComp);
			}else{
				num+=Integer.parseInt(pComp);
			}
		}
		
		LinkedList<String> xComps = new LinkedList<String>();
		for(String mGroup : mGroups){
			String[] mComps = mGroup.split("-");
			for(int i=0; i<mComps.length;i++){
				String mComp = mComps[i];
				if(mComp.contains("x")){
					if(i==0)
						xComps.add(mComp.replaceAll("*x", "").replaceAll("x", ""));
					else
						xComps.add("-"+mComp.replaceAll("*x", "").replaceAll("x", ""));
				}else{
					if(i==0)
						num+=Integer.parseInt(mComp);
					else
						num-=Integer.parseInt(mComp);
				}
			}
		}
		
		int xNum = 0;
		for(String xComp : xComps){
			xNum+=shrinkMultiplication(xComp);
		}		
		if(xNum==0)
			return null;
		return (double)-num/xNum;
	}
	
	/**
	 * shrink the expression by performing the multiplication operators
	 * @param s
	 * @return
	 */
	public int shrinkMultiplication(String s){
		return 0;
	}
}
