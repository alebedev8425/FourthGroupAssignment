package hw4.player;

import hw4.maze.Cell;
import hw4.maze.CellComponents;


public enum Movement {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    /**
     * Attempts to move the player in the given direction based on current cell's open paths.
     * @param player the player to move
     * @param neighbor the adjacent cell in the given direction
     */
    public void move(Player player, Cell neighbor) {
        Cell current = player.getCurrentCell();
        CellComponents side = switch (this) {
            case UP -> current.getUp();
            case DOWN -> current.getDown();
            case LEFT -> current.getLeft();
            case RIGHT -> current.getRight();
        };

        if (side == CellComponents.APERTURE || side == CellComponents.EXIT) {
            player.moveTo(neighbor);
            if (side == CellComponents.EXIT && this == LEFT) {
                System.out.println("Player has exited the maze!");
            }
        }
    }
}