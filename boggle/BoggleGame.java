package boggle;

import java.util.LinkedList;
import java.util.List;

/**
 * Just some ideas for the boggle game using dynamic programming.
 * For each word of length k, we have k tables, each of the same size as the boggle board char[][] M = new char[N][N].
 * 
 * boolean[][][] tables = new boolean[k][N][N]
 * In each of this table, if tables[k][i][j]=true, then the word of length k can be found, and it finishes at tables[k],
 * at coordinates i and j.
 * @author Van
 *
 */
public class BoggleGame {
	String word="Hello world";
	int N=5;
	char[][] M = new char[N][N];
	
	boolean[][][] tables = new boolean[word.length()][N][N];
	public void boggle(){
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        if(M[i][j]==word.charAt(0))
		            tables[0][i][j]=true;
		    }    
		}
	
		for(int k=2; k<word.length(); k++){
		    for(int i=0; i<N; i++){
		        for(int j=0; j<N; j++){
		        	List<Cell> adjacencies = getAdjacencies(new Cell(i,j), N);
		        	for(Cell adj: adjacencies){
		        		if(tables[k-2][adj.i][adj.j]==true)
		        				tables[k-1][i][j]=true;
		        	}
		            
		            
		        }
		    }
		}
	}

	public List<Cell> getAdjacencies(Cell cell, int N){
	    int i=cell.i;
	    int j=cell.j;
	    List<Cell> list = new LinkedList<Cell>();
	    if(i<N-1){
	        list.add(new Cell(i+1,j));
	        if(j<N-1){
	            list.add(new Cell(i+1,j+1));
	            list.add(new Cell(i,j+1));
	        }
	        if(j>0){
	            list.add(new Cell(i+1,j-1));
	            list.add(new Cell(i,j-1));
	        }
	    }
	    if(i>0){
	        //add
	    }
	    return list;
	    
	}

	class Cell{
	    int i;
	    int j;
	    public Cell(int i, int j){
	        this.i=i;
	        this.j=j;
	    }
	}
}
