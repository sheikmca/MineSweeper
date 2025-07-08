package service;

import java.util.logging.Logger;

public class InputParser {
    private static final Logger logger = Logger.getLogger(InputParser.class.getName());

    public static int[] parseInput(String input, int gridSize) throws IllegalArgumentException {
        input = input.trim().toUpperCase();
        logger.info("Parsing input: " + input);

        if (input.length() < 2 || !Character.isLetter(input.charAt(0))) {
            throw new IllegalArgumentException("Invalid format. Use format like A1, B2.");
        }

        int row = input.charAt(0) - 'A';
        int col;
        try {
            col = Integer.parseInt(input.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid column number.");
        }

        if (row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
            throw new IllegalArgumentException("Input out of bounds.");
        }

        return new int[]{row, col};
    }
}