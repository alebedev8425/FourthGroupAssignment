package hw4.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Row {
private List<Cell> cells; 
	
	
	
	public Row(ArrayList<Cell> cells2) {
		this.cells = Objects.requireNonNull(cells2); 
	}

	public ArrayList<Cell> getCells()  {
		return (ArrayList<Cell>) cells; 
	}
	
	 public void setCells(ArrayList<Cell> cells) {
	        this.cells = cells;
	    }
	 
	 @Override
	    public String toString() {
	        return "Row [cells=" + cells.toString() + "]";
	    }
}
