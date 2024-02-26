package Unit.Domain.Board;


import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Board.PositionIterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionIteratorTests {
    @Test
    void testHorizontal() {
        PositionIterator iterator = this.getIterator("A1", "D1");
        assertEquals("B1", iterator.next().toString());
        assertEquals("C1", iterator.next().toString());
        assertEquals("D1", iterator.next().toString());
    }
    @Test
    void testHorizontalBackward() {
        PositionIterator iterator = this.getIterator("D1", "A1");
        assertEquals("C1", iterator.next().toString());
        assertEquals("B1", iterator.next().toString());
        assertEquals("A1", iterator.next().toString());
    }
    @Test
    void testHorizontalPlainBoard() {
        PositionIterator iterator = this.getIterator("C5", "G5");
        assertEquals("D5", iterator.next().toString());
        assertEquals("E5", iterator.next().toString());
        assertEquals("F5", iterator.next().toString());
        assertEquals("G5", iterator.next().toString());
    }
    @Test
    void testHorizontalPlainBoardBackward() {
        PositionIterator iterator = this.getIterator("G5", "C5");
        assertEquals("F5", iterator.next().toString());
        assertEquals("E5", iterator.next().toString());
        assertEquals("D5", iterator.next().toString());
        assertEquals("C5", iterator.next().toString());
    }
    @Test
    void testVertical() {
        PositionIterator iterator = this.getIterator("A1", "A4");
        assertEquals("A2", iterator.next().toString());
        assertEquals("A3", iterator.next().toString());
        assertEquals("A4", iterator.next().toString());
    }
    @Test
    void testVerticalBackward() {
        PositionIterator iterator = this.getIterator("A4", "A1");
        assertEquals("A3", iterator.next().toString());
        assertEquals("A2", iterator.next().toString());
        assertEquals("A1", iterator.next().toString());
    }
    @Test
    void testVerticalPlainBoard() {
        PositionIterator iterator = this.getIterator("E4", "E7");
        assertEquals("E5", iterator.next().toString());
        assertEquals("E6", iterator.next().toString());
        assertEquals("E7", iterator.next().toString());
    }
    @Test
    void testVerticalPlainBoardBackward() {
        PositionIterator iterator = this.getIterator("E7", "E4");
        assertEquals("E6", iterator.next().toString());
        assertEquals("E5", iterator.next().toString());
        assertEquals("E4", iterator.next().toString());
    }
    @Test
    void testDiagonalNorthEast() {
        PositionIterator iterator = this.getIterator("D4", "G7");
        assertEquals("E5", iterator.next().toString());
        assertEquals("F6", iterator.next().toString());
        assertEquals("G7", iterator.next().toString());
    }
    @Test
    void testDiagonalSouthEast() {
        PositionIterator iterator = this.getIterator("D4", "G1");
        assertEquals("E3", iterator.next().toString());
        assertEquals("F2", iterator.next().toString());
        assertEquals("G1", iterator.next().toString());
    }
    @Test
    void testDiagonalNorthWest() {
        PositionIterator iterator = this.getIterator("D4", "B6");
        assertEquals("C5", iterator.next().toString());
        assertEquals("B6", iterator.next().toString());
    }
    @Test
    void testDiagonalSouthWest() {
        PositionIterator iterator = this.getIterator("D4", "B2");
        assertEquals("C3", iterator.next().toString());
        assertEquals("B2", iterator.next().toString());
    }

    PositionIterator getIterator(String from, String to) {
        try {
            return new PositionIterator(new Position(from), new Position(to));
        } catch (OutOfBoardException ignored) {}

        return null;
    }
}
