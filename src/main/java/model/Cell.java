package model;

public class Cell {
    private boolean mine;
    private boolean revealed;
    private int adjacentMines;

    public boolean isMine() { return mine; }
    public void setMine(boolean mine) { this.mine = mine; }

    public boolean isRevealed() { return revealed; }
    public void setRevealed(boolean revealed) { this.revealed = revealed; }

    public int getAdjacentMines() { return adjacentMines; }
    public void setAdjacentMines(int count) { this.adjacentMines = count; }
}