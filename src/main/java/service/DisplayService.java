package service;

import model.Cell;
import model.Minefield;

public class DisplayService {
    public static void display(Minefield minefield) {
        int size = minefield.getSize();
        Cell[][] grid = minefield.getGrid();

        System.out.print("  ");
        for (int i = 1; i <= size; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < size; i++) {
            char rowLabel = (char) ('A' + i);
            System.out.print(rowLabel + " ");
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                if (!cell.isRevealed()) System.out.print("_ ");
                else if (cell.isMine()) System.out.print("* ");
                else System.out.print(cell.getAdjacentMines() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}