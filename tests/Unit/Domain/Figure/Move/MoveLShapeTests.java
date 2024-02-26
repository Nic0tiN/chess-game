package Unit.Domain.Figure.Move;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Move;
import Domain.Figure.Move.MoveLShape;
import Domain.Figure.Move.MoveSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveLShapeTests {
    @Test
    void testMoveNorthLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("F6"));
        assertTrue(getSpec().IsSatisfiedBy(move));
        move = new Move(new Position("E4"), new Position("G5"));
        assertTrue(getSpec().IsSatisfiedBy(move));
    }

    @Test
    void testMoveNorthEastLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("H5"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveEastLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("G3"));
        assertTrue(getSpec().IsSatisfiedBy(move));
        move = new Move(new Position("E4"), new Position("F2"));
        assertTrue(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveSouthEastLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("F1"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveSouthLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("D2"));
        assertTrue(getSpec().IsSatisfiedBy(move));
        move = new Move(new Position("E4"), new Position("C3"));
        assertTrue(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveSouthWestLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("B3"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveWestLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("C5"));
        assertTrue(getSpec().IsSatisfiedBy(move));
        move = new Move(new Position("E4"), new Position("D6"));
        assertTrue(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveNorthWestLShape() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("D7"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }

    MoveSpecification getSpec() {
        return new MoveLShape();
    }
}
