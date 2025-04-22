package hw4.maze;

import java.util.ArrayList;

/**
 * A single row within the maze 
 * comprised of a list of Cells
 */
public class Row {
ArrayList<Cell> cells; 
	
	
	/**
	 * Row constructor 
	 * @param list of cells
	 */
	public Row(ArrayList<Cell> cells)  {
		this.cells = cells; 
	}
	
	/**
	 * @returns cells in the list 
	 */
	
	public ArrayList<Cell> getCells()  {
		return cells; 
	}
	
	/**
	 * sets list of cells 
	 * 
	 * @param new cell object 
	 */
	 public void setCells(ArrayList<Cell> cells) {
	        this.cells = cells;
	    }
	 
	 /**
	  * @return string including details on the cells
	  */
	 @Override
	    public String toString() {
	        return "Row [cells=" + cells + "]";
	    }
}
