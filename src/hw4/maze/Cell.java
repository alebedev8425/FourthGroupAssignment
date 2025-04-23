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
	 * constructor for Cell all with there respective sides
	 * @param up  
	 * @param down  
	 * @param left 
	 * @param right 
	 */
	
	 public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		 	this.left = left;
		 	this.right = right;
	        this.up = up;
	        this.down = down;
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
	    	this.up = (up != null ? up : CellComponents.WALL);	    }
	    
	    /**
	     * sets component for bottom side of cell 
	     * @param new CellComponent down 
	     */
	    public void setDown(CellComponents down) {
	    	this.down = (down != null ? down : CellComponents.WALL);
	    }

	    /**
	     * sets component for left side of cell 
	     * @param new CellComponent left 
	     */
	    public void setLeft(CellComponents left) {
	    	this.left = (left != null ? left : CellComponents.WALL);	    }

	    /**
	     * sets component for right side of cell 
	     * @param new CellComponent right
	     */
	    
	    public void setRight(CellComponents right) {
	    	this.right = (right != null ? right : CellComponents.WALL);	    }
	    
		/**
		 * returns details of cells components 
		 * @return string detailing each component of cells direction
		 */
	    @Override
	    public String toString() {
	        return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	    }
}
