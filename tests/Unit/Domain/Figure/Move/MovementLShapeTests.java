package Unit.Domain.Figure.Move;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveLShape;
import Domain.Figure.Move.MoveSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementLShapeTests {
    @Test
    void testMoveNorthLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F6"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
        movement = new Movement(new Position("E4"), new Position("G5"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }

    @Test
    void testMoveNorthEastLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("H5"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveEastLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("G3"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
        movement = new Movement(new Position("E4"), new Position("F2"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveSouthEastLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F1"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveSouthLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("D2"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
        movement = new Movement(new Position("E4"), new Position("C3"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveSouthWestLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("B3"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveWestLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("C5"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
        movement = new Movement(new Position("E4"), new Position("D6"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveNorthWestLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("D7"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }

    MoveSpecification getSpec() {
        return new MoveLShape();
    }
}
