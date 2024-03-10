package Unit.Domain.Figure;

import Domain.Figure.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Figure;
import Domain.Figure.Move.Movement;
import Domain.Figure.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTests {

    @Test
    void testMoveBackward() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("A1"));
        assertTrue(getFigure().move(movement));
    }

    @Test
    void testMoveHorizontally() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("B2"));
        assertTrue(getFigure().move(movement));
    }

    @Test
    void testMoveDiagonally() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("B3"));
        assertFalse(getFigure().move(movement));
    }

    @Test
    void testMoveDiagonallyByTwoSquares() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("C4"));
        assertFalse(getFigure().move(movement));
    }

    @Test
    void testMoveLShape() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("B4"));
        assertFalse(getFigure().move(movement));
    }


    @Test
    void testMoveByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("A3"));
        assertTrue(getFigure().move(movement));
    }

    @Test
    void testMoveByTwoSquares() throws OutOfBoardException {
        Movement movement = new Movement(new Position("A2"), new Position("A4"));
        assertTrue(getFigure().move(movement));
    }

    Figure getFigure() {
        return new Rook(Color.ColorEnum.WHITE);
    }
}
