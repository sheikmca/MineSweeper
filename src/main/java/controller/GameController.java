package controller;

import model.Minefield;
import service.DisplayService;
import service.GameStatusChecker;
import service.InputParser;

import java.util.Scanner;
import java.util.logging.Logger;

public class GameController {
    private static final Logger logger = Logger.getLogger(GameController.class.getName());

    private final Scanner scanner = new Scanner(System.in);
    private Minefield minefield;
    private boolean gameOver;

    public void startGame() {
        logger.info("Game started.");
        System.out.println("Welcome to Minesweeper!");

        int size = promptInt("Enter the size of the grid (e.g. 4 for a 4x4 grid): ", 2, 26);
        int maxMines = (int) (size * size * 0.35);
        int mines = promptInt("Enter the number of mines (maximum is " + maxMines + "): ", 1, maxMines);

        minefield = new Minefield(size, mines);
        gameOver = false;

        while (!gameOver) {
            DisplayService.display(minefield);
            System.out.print("Select a square to reveal (e.g. A1): ");
            String input = scanner.nextLine().trim().toUpperCase();

            int[] coordinates = InputParser.parseInput(input, size);
            if (coordinates == null) {
                System.out.println("Invalid input. Try again.");
                logger.warning("User entered invalid input: " + input);
                continue;
            }

            int row = coordinates[0];
            int col = coordinates[1];

            boolean mineHit = minefield.reveal(row, col);

            if (mineHit) {
                minefield.revealAll();
                DisplayService.display(minefield);
                System.out.println("💥 Oh no, you detonated a mine! Game over.");
                logger.info("Mine hit at [" + row + "," + col + "]. Game over.");
                gameOver = true;
            } else {
                int adj = minefield.getGrid()[row][col].getAdjacentMines();
                System.out.println("This square contains " + adj + " adjacent mine" + (adj == 1 ? "." : "s."));
                logger.info("Revealed square [" + row + "," + col + "] with " + adj + " adjacent mine(s).");
                if (GameStatusChecker.checkWin(minefield)) {
                    DisplayService.display(minefield);
                    System.out.println("🎉 Congratulations, you have won the game!");
                    logger.info("Game won by uncovering all safe squares.");
                    gameOver = true;
                }
            }
        }
        System.out.println("Press any key to play again...");
        scanner.nextLine();
        startGame(); // restart the game
    }

    private int promptInt(String message, int min, int max) {
        int result;
        while (true) {
            System.out.print(message);
            try {
                result = Integer.parseInt(scanner.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid number. Try again.");
        }
    }
}
