package service;

import model.Cell;
import model.Minefield;

import java.util.logging.Logger;

public class GameStatusChecker {
    private static final Logger logger = Logger.getLogger(GameStatusChecker.class.getName());

    public static boolean checkWin(Minefield minefield) {
        Cell[][] grid = minefield.getGrid();
        int size = minefield.getSize();

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                if (!cell.isMine() && !cell.isRevealed())
                    return false;
            }

        logger.info("All non-mine cells revealed — player has won.");
        return true;
    }

    public static boolean isGameOver(Minefield minefield) {

        return false; // placeholder for future expansion

    }
}