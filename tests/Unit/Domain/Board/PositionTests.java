package Unit.Domain.Board;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTests {

    @Test
    void positionA1() throws OutOfBoardException {
        Position position = new Position(1);

        assertEquals(Position.HORIZONTAL.A, position.getHorizontal());
        assertEquals(Position.VERTICAL.ONE, position.getVertical());
    }

    @Test
    void positionB1() throws OutOfBoardException {
        Position position = new Position(2);

        assertEquals(Position.HORIZONTAL.B, position.getHorizontal());
        assertEquals(Position.VERTICAL.ONE, position.getVertical());
    }

    @Test
    void positionH1() throws OutOfBoardException {
        Position position = new Position(8);

        assertEquals(Position.HORIZONTAL.H, position.getHorizontal());
        assertEquals(Position.VERTICAL.ONE, position.getVertical());
    }

    @Test
    void positionD4() throws OutOfBoardException {
        Position position = new Position(28);

        assertEquals(Position.HORIZONTAL.D, position.getHorizontal());
        assertEquals(Position.VERTICAL.FOUR, position.getVertical());
    }

    @Test
    void outOfBoundExceptions() {
        assertThrows(OutOfBoardException.class, () -> new Position(0));
        assertThrows(OutOfBoardException.class, () -> new Position(65));
    }

    @Test
    void toOrdinal() throws OutOfBoardException {
        Position position = new Position("H4");

        assertEquals(Position.HORIZONTAL.H, position.getHorizontal());
        assertEquals(Position.VERTICAL.FOUR, position.getVertical());
    }
}
