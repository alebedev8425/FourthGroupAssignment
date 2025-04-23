package hw4.playGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hw4.game.*;
import hw4.maze.*;
import hw4.player.*;
/**
 * main class with the purpose of initializing and simulating the game. 
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		final int size = 5; //Test game will be 5x5 
        final int minSize = 3;
        
        //Creating the game and generating a grid of random size.    
        Game game = new Game(minSize);
        Grid grid = game.createRandomGrid(size);
        game.setGrid(grid);

        //Putting the player at the bottom right cell where they are supposed to start. 
        Row startRow   = grid.getRows().get(size - 1);
        Cell startCell = startRow.getCells().get(size - 1);
        Player player  = new Player(startRow, startCell);

        Random rand = new Random();
        int steps = 0;

        //movement loop. player will continue to move until escaped 
        while (true) {
            Cell current = player.getCurrentCell();

            //if statements allow only valid and legal movements. 
            
            var options = new java.util.ArrayList<Movement>();
            
            if (current.getUp()    == CellComponents.APERTURE) options.add(Movement.UP);
            
            if (current.getDown()  == CellComponents.APERTURE) options.add(Movement.DOWN);
            
            if (current.getRight() == CellComponents.APERTURE) options.add(Movement.RIGHT);
    
            if (current.getLeft()  == CellComponents.APERTURE
            		
             || current.getLeft()  == CellComponents.EXIT) options.add(Movement.LEFT);

            
            // pick one at random	
            Movement mv = options.get(rand.nextInt(options.size()));
            boolean isExitMove = (mv == Movement.LEFT
                                && current.getLeft() == CellComponents.EXIT);

            game.play(mv, player);
            steps++;
            
            //display movement results 
            System.out.printf("Action %d: %s%n", steps,
            	    isExitMove ? "Agent escaped" : "Agent moved " + mv);
            printGrid(grid, player);

            if (isExitMove) {
                System.out.printf("Congratulations, Agent escaped in %d steps %n", steps);
                break;
            }
        }
      
        }
	
		/**
		 * Displays the current grid including Agents current location  and Exit 
		 * @param grid
		 * @param player
		 */
        private static void printGrid(Grid grid, Player player) {
            int n = grid.getRows().size();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Cell cell = grid.getRows().get(i).getCells().get(j);
                    if (cell == player.getCurrentCell()) {
                        System.out.print("A ");
                    } else if (j == 0 && cell.getLeft() == CellComponents.EXIT) {
                        System.out.print("E ");
                    } else {
                        System.out.print("S ");
                    }
                }
                System.out.println();
            }
            System.out.println();

	}

}
