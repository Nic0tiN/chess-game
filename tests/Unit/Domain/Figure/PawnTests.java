package Unit.Domain.Figure;

import Domain.Figure.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Movement;
import Domain.Figure.Pawn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTests {

    @Test
    void testMoveBackward() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("A1"));
        assertFalse(getPawn().move(movement));
    }

    @Test
    void testMoveHorizontally() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("B2"));
        assertFalse(getPawn().move(movement));
    }

    @Test
    void testMoveDiagonallyNoFigure() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("B3"));
        assertFalse(getPawn().move(movement));
    }

    @Test
    void testCapturingDiagonally() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("B3"), new Pawn(Color.ColorEnum.WHITE), new Pawn(Color.ColorEnum.BLACK));
        assertTrue(getPawn().move(movement));
    }

    @Test
    void testMoveDiagonallyByTwoSquares() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("C4"));
        assertFalse(getPawn().move(movement));
    }

    @Test
    void testFirstMoveByOneSquares() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("A3"));
        assertTrue(getPawn().move(movement));
    }

    @Test
    void testFirstMoveByTwoSquares() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("A4"));
        assertTrue(getPawn().move(movement));
    }

    @Test
    void testSecondMoveByTwoSquares() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("A4"));
        Pawn pawn = getPawn();
        assertTrue(pawn.move(movement));

        movement = new Movement(new Position("A4"), new Position("A6"));
        assertFalse(pawn.move(movement));
    }

    Pawn getPawn() {
        return new Pawn(Color.ColorEnum.WHITE);
    }
}
