package Unit.Domain.Figure;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovementTests {
    @Test
    void testVerticalDistance() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A1"), new Position("A4"));
        assertEquals(3, movement.getVerticalDistance());
    }
    @Test
    void testVerticalDistanceWith8() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A1"), new Position("A8"));
        assertEquals(7, movement.getVerticalDistance());
    }

    @Test
    void testHorizontalDistance() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A1"), new Position("B1"));
        assertEquals(1, movement.getHorizontalDistance());
    }

    @Test
    void testHorizontalDistanceWithH() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A1"), new Position("H1"));
        assertEquals(7, movement.getHorizontalDistance());
    }
}
