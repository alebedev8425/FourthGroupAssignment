package hw4.playGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hw4.game.*;
import hw4.maze.*;
import hw4.player.*;

public class Main {

	public static void main(String[] args) {
		final int size = 5;
        final int minSize = 3;
        Game game = new Game(minSize);
        Grid grid = game.createRandomGrid(size);
        game.setGrid(grid);

        Row startRow   = grid.getRows().get(size - 1);
        Cell startCell = startRow.getCells().get(size - 1);
        Player player  = new Player(startRow, startCell);

        Random rand = new Random();
        int steps = 0;

        while (true) {
            Cell current = player.getCurrentCell();

            // collect only legal moves from here
            var options = new java.util.ArrayList<Movement>();
            if (current.getUp()    == CellComponents.APERTURE) options.add(Movement.UP);
            if (current.getDown()  == CellComponents.APERTURE) options.add(Movement.DOWN);
            if (current.getRight() == CellComponents.APERTURE) options.add(Movement.RIGHT);
            // allow LEFT if it’s either an APERTURE *or* the EXIT
            if (current.getLeft()  == CellComponents.APERTURE
             || current.getLeft()  == CellComponents.EXIT)    options.add(Movement.LEFT);

            // pick one at random
            Movement mv = options.get(rand.nextInt(options.size()));
            boolean isExitMove = (mv == Movement.LEFT
                                && current.getLeft() == CellComponents.EXIT);

            game.play(mv, player);
            steps++;
            System.out.printf("Step %2d: %-5s → %s%n",
                              steps,
                              mv,
                              isExitMove ? "ESCAPED!" : "moved");
            printGrid(grid, player);

            if (isExitMove) {
                System.out.printf("You escaped in %d steps! %n", steps);
                break;
            }
        }
      
        }
	
		
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
