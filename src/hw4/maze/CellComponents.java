package hw4.maze;

public class CellComponents {
private ComponentType type;
    
    public static final CellComponents WALL = new CellComponents(ComponentType.WALL);
    public static final CellComponents APERTURE = new CellComponents(ComponentType.APERTURE);
    public static final CellComponents EXIT = new CellComponents(ComponentType.EXIT);


    public CellComponents(ComponentType type) {
        this.type = type;
    }

    /*
     * getter
     */
    public ComponentType getType() {
        return type;
    }

    /*
     * setter
     */
    public void setType(ComponentType type) {
        this.type = type;
    }
    
	/*
	 * toString()
	 */
    @Override
    public String toString() {
        return type.toString();
    }
	


}
