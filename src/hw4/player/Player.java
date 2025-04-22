package hw4.player;

import hw4.maze.Cell;
import java.util.Objects;

/**
 * Tracks the agent’s current position in the maze.
 */
public class Player {
    private Cell currentCell;

    /**
     * Constructs a Player at a specific cell.
     * @param cell the Cell where the player starts (must not be null)
     */
    public Player(Cell cell) {
        this.currentCell = Objects.requireNonNull(cell);
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Updates the player's position to the new cell.
     * @param cell the new cell to move to
     */
    public void moveTo(Cell cell) {
        this.currentCell = Objects.requireNonNull(cell);
    }

    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + "]";
    }
}
