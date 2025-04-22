package hw4.maze;

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
