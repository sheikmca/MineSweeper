package model;

import java.util.Random;
import java.util.logging.Logger;

public class Minefield {
    private static final Logger logger = Logger.getLogger(Minefield.class.getName());

    private final int size;
    private final int mineCount;
    private final Cell[][] grid;

    public Minefield(int size, int mineCount) {
        this.size = size;
        this.mineCount = mineCount;
        this.grid = new Cell[size][size];
        initGrid();
        placeMines();
        calculateAdjacency();
    }

    private void initGrid() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = new Cell();
        logger.info("Initialized empty grid of size " + size + "x" + size);
    }

    private void placeMines() {
        Random rand = new Random();
        int placed = 0;
        while (placed < mineCount) {
            int r = rand.nextInt(size);
            int c = rand.nextInt(size);
            if (!grid[r][c].isMine()) {
                grid[r][c].setMine(true);
                placed++;
                logger.fine("Placed mine at (" + r + "," + c + ")");
            }
        }
        logger.info("Total mines placed: " + mineCount);
    }

    private void calculateAdjacency() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j].setAdjacentMines(countAdjacentMines(i, j));
        logger.info("Calculated adjacent mine counts for all cells");
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++)
            for (int dc = -1; dc <= 1; dc++) {
                int r = row + dr, c = col + dc;
                if (r >= 0 && r < size && c >= 0 && c < size && !(dr == 0 && dc == 0)) {
                    if (grid[r][c].isMine()) count++;
                }
            }
        return count;
    }

    public boolean reveal(int row, int col) {
        if (grid[row][col].isRevealed()) return false;
        grid[row][col].setRevealed(true);
        if (grid[row][col].isMine()) return true;
        if (grid[row][col].getAdjacentMines() == 0) revealNeighbors(row, col);
        return false;
    }

    private void revealNeighbors(int row, int col) {
        for (int dr = -1; dr <= 1; dr++)
            for (int dc = -1; dc <= 1; dc++) {
                int r = row + dr, c = col + dc;
                if (r >= 0 && r < size && c >= 0 && c < size && !(dr == 0 && dc == 0)) {
                    if (!grid[r][c].isRevealed() && !grid[r][c].isMine()) {
                        reveal(r, c);
                    }
                }
            }
    }

    public void revealAll() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j].setRevealed(true);
        logger.info("All cells revealed");
    }

    public int getSize() { return size; }
    public Cell[][] getGrid() { return grid; }
}