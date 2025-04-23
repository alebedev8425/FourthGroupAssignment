package hw4.maze;

import java.util.List;
import java.util.Objects;

public class Grid {
	
	private List<Row> rows;
	
	/**
     * @param creates a grid out of rows, must not be null rows
     */
    public Grid(List<Row> rows) {
        this.rows = Objects.requireNonNull(rows);
    }
    
    /**
     * get rows functionality
     * @return returns rows of grid
     */

	public List<Row> getRows() {
		return rows;
	}
	
	/**
	 * set rows functionality
	 * @param rows - a list of rows
	 */

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
	/**
	 * toString function for the grid
	 */

	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
    
    
	

}
