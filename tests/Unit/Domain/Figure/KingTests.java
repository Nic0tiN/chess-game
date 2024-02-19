package Unit.Domain.Figure;

import Domain.Board.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Figure;
import Domain.Figure.King;
import Domain.Figure.Move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTests {
    @Test
    void testNoMoves() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A2"));
        assertFalse(getFigure().move(move));
    }

    @Test
    void testMoveBackward() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A1"));
        assertTrue(getFigure().move(move));
    }

    @Test
    void testMoveHorizontally() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("B2"));
        assertTrue(getFigure().move(move));
    }

    @Test
    void testMoveDiagonally() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("B3"));
        assertTrue(getFigure().move(move));
    }

    @Test
    void testMoveDiagonallyByTwoSquares() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("C4"));
        assertFalse(getFigure().move(move));
    }

    @Test
    void testMoveLShape() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("B4"));
        assertFalse(getFigure().move(move));
    }

    @Test
    void testMoveByOneSquare() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A3"));
        assertTrue(getFigure().move(move));
    }

    @Test
    void testMoveByTwoSquares() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A4"));
        assertFalse(getFigure().move(move));
    }

    Figure getFigure() {
        return new King(Color.ColorEnum.WHITE);
    }
}
