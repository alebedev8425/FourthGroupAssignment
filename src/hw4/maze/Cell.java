package hw4.maze;

public class Cell {
	/*
	 * Cell fields of type Cell Component
	 */
	public CellComponents left;
	
	public CellComponents right; 
	
	public CellComponents up; 	
	
	public CellComponents down; 
	
	/*
	 * Constructor for Cell 
	 */
	 public Cell(CellComponents up, CellComponents bottom, CellComponents left, CellComponents right) {
	        this.up = up;
	        this.down = bottom;
	        this.left = left;
	        this.right = right;
	 }
	 
	 /*
	  * Getters for cell 
	  */
	    public CellComponents getUp() {
	        return up;
	    }

	    public CellComponents getDown() {
	        return down;
	    }

	    public CellComponents getLeft() {
	        return left;
	    }

	    public CellComponents getRight() {
	        return right;
	    }

	    /*
	     * Setters 
	     */
	    public void setUp(CellComponents up) {
	        this.up = up;
	    }

	    public void setDown(CellComponents down) {
	        this.down = down;
	    }

	    public void setLeft(CellComponents left) {
	        this.left = left;
	    }

	    public void setRight(CellComponents right) {
	        this.right = right;
	    }
	    
	    /*
	     * method to print details of a Cell
	     */
	    @Override
	    public String toString() {
	        return "Cell {\n" +
	               "  Up: " + up + "\n" +
	               "  Down: " + down + "\n" +
	               "  Left: " + left + "\n" +
	               "  Right: " + right + "\n" +
	               "}";
	    }
}
