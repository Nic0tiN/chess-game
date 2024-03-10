package Unit.Domain.Figure.Move;

import Domain.Figure.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.MoveSpecification;
import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveDiagonallyForward;
import Domain.Figure.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovementDiagonallyForwardTests {
    @Test
    void testMoveNorthByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("E5"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveNorthEastByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F5"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveEastByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F4"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
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
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveNorthWestByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("D5"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }

    @Test
    void testMoveBlackFigures() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E5"), new Position("F4"), new Pawn(Color.ColorEnum.BLACK), null);
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }

    @Test
    void testMoveBlackFiguresBackward() throws OutOfBoardException {
        Movement movement = new Movement(new Position("F4"), new Position("E5"), new Pawn(Color.ColorEnum.BLACK), null);
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }

    MoveSpecification getSpec() {
        return new MoveDiagonallyForward();
    }
}
