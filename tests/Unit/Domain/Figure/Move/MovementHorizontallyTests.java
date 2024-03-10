package Unit.Domain.Figure.Move;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveHorizontally;
import Domain.Figure.Move.MoveSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementHorizontallyTests {
    @Test
    void testMoveNorthByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("E5"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveNorthEastByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F5"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveEastByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F4"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveSouthEastByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F3"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveSouthByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("E3"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveSouthWestByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("D3"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveWestByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("D4"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveNorthWestByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("D5"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }

    MoveSpecification getSpec() {
        return new MoveHorizontally();
    }
}
