package hw4.maze;
/**
 * Testing the Cell to make sure it functions properly 
 */
public class MazeTest {

	public static void main(String[] args) {
		
		Cell myCell = new Cell(
			    new CellComponents(ComponentType.APERTURE),
			    new CellComponents(ComponentType.WALL),
			    new CellComponents(ComponentType.EXIT),
			    new CellComponents(ComponentType.WALL)
			);
		
		System.out.println(myCell);

	}

}
