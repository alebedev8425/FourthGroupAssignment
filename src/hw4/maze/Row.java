package hw4.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Row {
private List<Cell> cells; 
	
	/**
	 * constructor for creating row from cells
	 * @param cells2 - inputs cells
	 */
	
	public Row(ArrayList<Cell> cells2) {
		this.cells = Objects.requireNonNull(cells2); 
	}
	
	/**
	 * get cells function
	 * @return ArrayList of cells
	 */

	public ArrayList<Cell> getCells()  {
		return (ArrayList<Cell>) cells; 
	}
	
	/**
	 * set cells function
	 * @param cells - cells of grid
	 */
	
	 public void setCells(ArrayList<Cell> cells) {
	        this.cells = cells;
	    }
	 
	 /**
	  * toString for the rows
	  */
	 
	 @Override
	    public String toString() {
	        return "Row [cells=" + cells.toString() + "]";
	    }
}
