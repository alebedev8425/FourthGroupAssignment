package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;
import java.util.Objects;

/**
 * Tracks the agent’s current position in the maze.
 */
public class Player {
    private Cell currentCell;
    private Row currentRow;

    /**
     * Constructs a Player at a specific cell.
     * @param cell the Cell where the player starts (must not be null)
     */
    public Player(Cell cell) {
        this.currentCell = Objects.requireNonNull(cell);
        this.currentRow = null; // unknown unless explicitly provided
    }

    /**
     * Compatibility constructor with Row and Cell.
     * @param row  the Row where the player starts
     * @param cell the Cell within that row
     */
    public Player(Row row, Cell cell) {
        this.currentCell = Objects.requireNonNull(cell);
        this.currentRow = Objects.requireNonNull(row);
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public Row getCurrentRow() {
        return currentRow;
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
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}