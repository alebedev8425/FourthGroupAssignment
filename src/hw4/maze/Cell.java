package hw4.maze;


/**
 * A single cell within the maze
 * has four different sides ( left, right, up, down) 
 * can be WALL APERTURE or MAZE
 */
public class Cell {
	/**
	 * 
	 * Cell fields of type Cell Component
	 * and there respective directions
	 */
	public CellComponents left;
	
	public CellComponents right; 
	
	public CellComponents up; 	
	
	public CellComponents down; 
	
	/**
	 * Constructor for Cell all with there respective sides
	 * @param up  
	 * @param down  
	 * @param left 
	 * @param right 
	 */
	
	 public Cell(CellComponents up, CellComponents down, CellComponents left, CellComponents right) {
	        this.up = up;
	        this.down = down;
	        this.left = left;
	        this.right = right;
	 }
	 
	 /**
	  * @return top component 
	  */
	    public CellComponents getUp() {
	        return up;
	    }
	    
	    
	    /**
	     * 
	     * @return bottom component 
	     */

	    public CellComponents getDown() {
	        return down;
	    }

	    /**
	     * 
	     * @return left component 
	     */
	    public CellComponents getLeft() {
	        return left;
	    }

	    /**
	     * 
	     * @return right component 
	     */
	    public CellComponents getRight() {
	        return right;
	    }

	    /**
	     * sets component for top side of cell 
	     * @param new CellComponent up 
	     */
	    public void setUp(CellComponents up) {
	        this.up = up;
	    }
	    
	    /**
	     * sets component for bottom side of cell 
	     * @param new CellComponent down 
	     */
	    public void setDown(CellComponents down) {
	        this.down = down;
	    }

	    /**
	     * sets component for left side of cell 
	     * @param new CellComponent left 
	     */
	    public void setLeft(CellComponents left) {
	        this.left = left;
	    }

	    /**
	     * sets component for right side of cell 
	     * @param new CellComponent right
	     */
	    
	    public void setRight(CellComponents right) {
	        this.right = right;
	    }
	    
		/**
		 * returns details of cells components 
		 * @return string detailing each component of a cells direction
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
