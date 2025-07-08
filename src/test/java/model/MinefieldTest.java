package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinefieldTest {
    @Test
    public void testMinePlacement() {
        Minefield minefield = new Minefield(5, 5);
        int mineCount = 0;
        for (Cell[] row : minefield.getGrid())
            for (Cell cell : row)
                if (cell.isMine()) mineCount++;
        assertEquals(5, mineCount);
    }

    @Test
    public void testRevealAndExpansion() {
        Minefield minefield = new Minefield(5, 0); // no mines
        boolean result = minefield.reveal(2, 2);
        assertFalse(result); // should not hit mine
        for (Cell[] row : minefield.getGrid())
            for (Cell cell : row)
                assertTrue(cell.isRevealed()); // all cells revealed
    }
}