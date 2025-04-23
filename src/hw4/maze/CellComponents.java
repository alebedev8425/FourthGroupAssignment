package hw4.maze;
/**
 * Each side of a cell is a component
 * Can either be WALL, APERTURE, or EXIT
 * Each is a public static final constant 
 */
public class CellComponents {
	
/** type of this cell component*/
private ComponentType type;
    

/** WALL, APERATURE, and EXIT CellComponents types*/
    public static final CellComponents WALL = new CellComponents(ComponentType.WALL);
    public static final CellComponents APERTURE = new CellComponents(ComponentType.APERTURE);
    public static final CellComponents EXIT = new CellComponents(ComponentType.EXIT);

/**
 * Constructor for a new CellComponents object 
 * @param type of component 
 */
    public CellComponents(ComponentType type) {
        this.type = type;
    }



}
