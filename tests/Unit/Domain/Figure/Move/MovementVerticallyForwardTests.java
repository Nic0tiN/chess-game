package Unit.Domain.Figure.Move;

import Domain.Figure.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveSpecification;
import Domain.Figure.Move.MoveVerticallyForward;
import Domain.Figure.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementVerticallyForwardTests {
    @Test
    void testMoveNorthByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("E5"));
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }
    @Test
    void testMoveNorthEastByOneSquare() throws OutOfBoardException {
        Movement movement = new Movement(new Position("E4"), new Position("F5"));
        assertFalse(getSpec().IsSatisfiedBy(movement));
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
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }

    @Test
    void testMoveBlackFigures() throws OutOfBoardException {
        Movement movement = new Movement(new Position("C7"), new Position("C6"), new Pawn(Color.ColorEnum.BLACK), null);
        assertTrue(getSpec().IsSatisfiedBy(movement));
    }

    @Test
    void testMoveBlackFiguresBackward() throws OutOfBoardException {
        Movement movement = new Movement(new Position("C6"), new Position("C7"), new Pawn(Color.ColorEnum.BLACK), null);
        assertFalse(getSpec().IsSatisfiedBy(movement));
    }

    MoveSpecification getSpec() {
        return new MoveVerticallyForward();
    }
}
