package Unit.Domain.Figure.Move;

import Domain.Figure.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.MoveSpecification;
import Domain.Figure.Move.Move;
import Domain.Figure.Move.MoveDiagonallyForward;
import Domain.Figure.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveDiagonallyForwardTests {
    @Test
    void testMoveNorthByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("E5"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveNorthEastByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("F5"));
        assertTrue(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveEastByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("F4"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveSouthEastByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("F3"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveSouthByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("E3"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveSouthWestByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("D3"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveWestByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("D4"));
        assertFalse(getSpec().IsSatisfiedBy(move));
    }
    @Test
    void testMoveNorthWestByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("E4"), new Position("D5"));
        assertTrue(getSpec().IsSatisfiedBy(move));
    }

    @Test
    void testMoveBlackFigures() throws OutOfBoardException {
        Move move = new Move(new Position("E5"), new Position("F4"), new Pawn(Color.ColorEnum.BLACK), null);
        assertTrue(getSpec().IsSatisfiedBy(move));
    }

    @Test
    void testMoveBlackFiguresBackward() throws OutOfBoardException {
        Move move = new Move(new Position("F4"), new Position("E5"), new Pawn(Color.ColorEnum.BLACK), null);
        assertFalse(getSpec().IsSatisfiedBy(move));
    }

    MoveSpecification getSpec() {
        return new MoveDiagonallyForward();
    }
}
