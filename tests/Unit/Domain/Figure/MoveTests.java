package Unit.Domain.Figure;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTests {
    @Test
    void testVerticalDistance() throws OutOfBoardException {
        Move move = new Move(new Position("A1"), new Position("A4"));
        assertEquals(3, move.getVerticalDistance());
    }
    @Test
    void testVerticalDistanceWith8() throws OutOfBoardException {
        Move move = new Move(new Position("A1"), new Position("A8"));
        assertEquals(7, move.getVerticalDistance());
    }

    @Test
    void testHorizontalDistance() throws OutOfBoardException {
        Move move = new Move(new Position("A1"), new Position("B1"));
        assertEquals(1, move.getHorizontalDistance());
    }

    @Test
    void testHorizontalDistanceWithH() throws OutOfBoardException {
        Move move = new Move(new Position("A1"), new Position("H1"));
        assertEquals(7, move.getHorizontalDistance());
    }
}
