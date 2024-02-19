package Unit.Domain.Figure;

import Domain.Board.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Move;
import Domain.Figure.Pawn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTests {
    @Test
    void testNoMoves() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A2"));
        assertFalse(getPawn().move(move));
    }

    @Test
    void testMoveBackward() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A1"));
        assertFalse(getPawn().move(move));
    }

    @Test
    void testMoveHorizontally() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("B2"));
        assertFalse(getPawn().move(move));
    }

    @Test
    void testMoveDiagonallyNoFigure() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("B3"));
        assertFalse(getPawn().move(move));
    }

    @Test
    void testCapturingDiagonally() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("B3"), new Pawn(Color.ColorEnum.BLACK));
        assertTrue(getPawn().move(move));
    }

    @Test
    void testMoveDiagonallyByTwoSquares() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("C4"));
        assertFalse(getPawn().move(move));
    }

    @Test
    void testFirstMoveByOneSquares() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A3"));
        assertTrue(getPawn().move(move));
    }

    @Test
    void testFirstMoveByTwoSquares() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A4"));
        assertTrue(getPawn().move(move));
    }

    @Test
    void testSecondMoveByTwoSquares() throws OutOfBoardException {
        Move move = new Move(new Position("A2"), new Position("A4"));
        Pawn pawn = getPawn();
        assertTrue(pawn.move(move));

        move = new Move(new Position("A4"), new Position("A6"));
        assertFalse(pawn.move(move));
    }

    Pawn getPawn() {
        return new Pawn(Color.ColorEnum.WHITE);
    }
}
