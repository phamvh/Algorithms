package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordPuzzle {

	public static void main(String[] args) {
		

	}
	
	public List<List<Coordinate>> wordFound(char[][] matrix, String word){
		if((word==null) || (word.isEmpty()))
			return null;
		List<List<Coordinate>> results = new LinkedList<List<Coordinate>>();
		if(word.length()==1){
			for(int i=0; i<matrix.length;i++){
				for(int j=0; j<matrix[0].length; j++){
					if(matrix[i][j]==word.charAt(0)){
						List<Coordinate> list = new LinkedList<Coordinate>();
						list.add(new Coordinate(i,j));
						results.add(list);
					}
				}
			}
			return results;
		}
		
		List<List<Coordinate>> prevRes = wordFound(matrix, word.substring(0,word.length()-1));
		for(List<Coordinate> list: prevRes){
			Coordinate lastCoor = list.get(list.size()-1);
			List<Coordinate> surroundings = getSurroundings(matrix, lastCoor, word.charAt(word.length()-1), list);
			if(surroundings.isEmpty())
				continue;
			for(Coordinate c : surroundings){
				List<Coordinate> newList = new LinkedList<Coordinate>();
				newList.addAll(list);
				newList.add(c);
				results.add(newList);
			}
		}
		
		return results;
	}
	
	public boolean cellVisited(List<Coordinate> list, Coordinate coor){
		for(Coordinate c:list){
			if(c.equals(coor))
				return true;
		}
		return false;
	}
	
	public List<Coordinate> getSurroundings(char[][] matrix, Coordinate coor, char ch, List<Coordinate> path){
		return null;
		//
	}
	

}

class Coordinate{
	int i;
	int j;

	public Coordinate(int i1, int j1){
		i=i1;
		j=j1;
	}
	
	public boolean equals(Object ob){
		Coordinate coor = (Coordinate)ob;
		return ((i==coor.i) && (j==coor.j));
	}
}
