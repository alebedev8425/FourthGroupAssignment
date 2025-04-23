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
    	if (size < minimumSize || size > 7) return null;

        Random rand = new Random();
        // arrays to hold each side
        CellComponents[][] left  = new CellComponents[size][size];
        CellComponents[][] right = new CellComponents[size][size];
        CellComponents[][] up    = new CellComponents[size][size];
        CellComponents[][] down  = new CellComponents[size][size];

        int exitRow = 0;

        // 2) FIRST PASS: mirror from neighbors, random elsewhere
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            // LEFT
            if (j == 0) {
              left[i][j] = (i == exitRow
                            ? CellComponents.EXIT
                            : CellComponents.WALL);
            } else {
              left[i][j] = right[i][j-1];
            }
            // UP
            if (i == 0) {
              up[i][j] = CellComponents.WALL;
            } else {
              up[i][j] = down[i-1][j];
            }
            // RIGHT (random except last column)
            right[i][j] = (j == size-1
                           ? CellComponents.WALL
                           : (rand.nextBoolean()
                              ? CellComponents.APERTURE
                              : CellComponents.WALL));
            // DOWN (random except last row)
            down[i][j] = (i == size-1
                          ? CellComponents.WALL
                          : (rand.nextBoolean()
                             ? CellComponents.APERTURE
                             : CellComponents.WALL));
          }
        }

        // 3) CARVE a guaranteed corridor from start→exit (*never* overwritten)
        int sr = size - 1, sc = size - 1;
        // horizontal corridor to column 0
        for (int j = sc; j > 0; j--) {
          left[sr][j]      = CellComponents.APERTURE;
          right[sr][j-1]   = CellComponents.APERTURE;
        }
        // vertical corridor up or down to exitRow
        if (exitRow < sr) {
          for (int i = sr; i > exitRow; i--) {
            up[i][0]       = CellComponents.APERTURE;
            down[i-1][0]   = CellComponents.APERTURE;
          }
        } else {
          for (int i = sr; i < exitRow; i++) {
            down[i][0]     = CellComponents.APERTURE;
            up[i+1][0]     = CellComponents.APERTURE;
          }
        }

        // 4) SECOND PASS: open at least one side on *every* other cell
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            boolean hasA = left[i][j]==CellComponents.APERTURE
                        || right[i][j]==CellComponents.APERTURE
                        || up[i][j]==CellComponents.APERTURE
                        || down[i][j]==CellComponents.APERTURE;

            if (!hasA) {
              List<String> opts = new ArrayList<>();
              if (j>0)        opts.add("L");
              if (j<size-1)   opts.add("R");
              if (i>0)        opts.add("U");
              if (i<size-1)   opts.add("D");
              String pick = opts.get(rand.nextInt(opts.size()));

              switch (pick) {
                case "L" -> { left[i][j] = CellComponents.APERTURE;
                             right[i][j-1] = CellComponents.APERTURE; }
                case "R" -> { right[i][j] = CellComponents.APERTURE;
                             left[i][j+1] = CellComponents.APERTURE; }
                case "U" -> { up[i][j] = CellComponents.APERTURE;
                             down[i-1][j] = CellComponents.APERTURE; }
                default  -> { down[i][j] = CellComponents.APERTURE;
                             up[i+1][j]   = CellComponents.APERTURE; }
              }
            }
          }
        }

        // 5) Build the actual Grid
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          ArrayList<Cell> crow = new ArrayList<>();
          for (int j = 0; j < size; j++) {
            crow.add(new Cell(
              left[i][j],
              right[i][j],
              up[i][j],
              down[i][j]
            ));
          }
          rows.add(new Row(crow));
        }
        return new Grid(rows);
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
