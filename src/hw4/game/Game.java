package hw4.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
    private Grid grid;
    private final int minimumSize;

   
    public Game(Grid grid) {
        this.grid = grid;
        this.minimumSize = 1;
    }

 
    public Game(int Size) {
        this.grid = null;
        this.minimumSize = Size;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

 
    public boolean play(Movement mv, Player player) {
        if (mv == null || player == null || grid == null) {
            return false;
        }
        Cell cur = player.getCurrentCell();
        CellComponents side;
        switch (mv) {
            case UP:    side = cur.getUp();    break;
            case DOWN:  side = cur.getDown();  break;
            case LEFT:  side = cur.getLeft();  break;
            case RIGHT: side = cur.getRight(); break;
            default:    return false;
        }

        // special case: exiting left
        if (mv == Movement.LEFT && side == CellComponents.EXIT) {
            System.out.println("Player has exited the maze!");
            return true;
        }

        // if there's no neighbor (boundary), fail
        Cell nbr = findNeighbor(player, mv);
        if (nbr == null) return false;

        // only APERTURE lets you move
        if (side == CellComponents.APERTURE) {
            player.moveTo(nbr);
            return true;
        }

        return false;
    }

  
    public Grid createRandomGrid(int size) {
        if (size < minimumSize || size % 2 == 0) {
            return null;
        }
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> cells = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                // start with all sides = WALL
                cells.add(new Cell(
                    CellComponents.WALL,
                    CellComponents.WALL,
                    CellComponents.WALL,
                    CellComponents.WALL
                ));
            }
            rows.add(new Row(new ArrayList<>(cells)));
        }
        int exitRow = new Random().nextInt(size);
        rows.get(exitRow).getCells().get(0).setLeft(CellComponents.EXIT);
        return new Grid(new ArrayList<>(rows));
    }

    private Cell findNeighbor(Player player, Movement move) {
    	   List<Row> rows = grid.getRows();
    	    int rowFound = -1, columnFound = -1;

    	    for (int r = 0; r < rows.size(); r++) {
    	        List<Cell> cells = rows.get(r).getCells();
    	        for (int c = 0; c < cells.size(); c++) {
    	            if (cells.get(c) == player.getCurrentCell()) {
    	                rowFound = r;
    	                columnFound = c;
    	                break;
    	            }
    	        }
    	        if (rowFound != -1) {
    	            break;
    	        }
    	    }

    	    if (rowFound == -1) {
    	        return null;
    	    }

    	    int r = rowFound;
    	    int c = columnFound;
    	    switch (move) {
    	        case UP:    r--; break;
    	        case DOWN:  r++; break;
    	        case LEFT:  c--; break;
    	        case RIGHT: c++; break;
    	    }

    	    if (r < 0 || r >= rows.size() ||
    	        c < 0 || c >= rows.get(r).getCells().size()) {
    	        return null;
    	    }

    	    return rows.get(r).getCells().get(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Game [grid=");
        sb.append("Grid [rows=[");
        List<Row> rows = grid.getRows();
        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            sb.append("Row [cells=[");
            List<Cell> cells = row.getCells();
            for (int j = 0; j < cells.size(); j++) {
                Cell cell = cells.get(j);
                sb.append("Cell [left=").append(cell.getLeft())
                  .append(", right=").append(cell.getRight())
                  .append(", up=").append(cell.getUp())
                  .append(", down=").append(cell.getDown())
                  .append("]");
                if (j < cells.size() - 1) sb.append(", ");
            }
            sb.append("]]");
            if (i < rows.size() - 1) sb.append(", ");
        }
        sb.append("]]").append("]");
        return sb.toString();
    }
}