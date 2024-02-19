package Unit.Domain;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Exception.WrongMoveException;
import Domain.Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    @Test
    void correctMove() throws OutOfBoardException, WrongMoveException {
        assertTrue(getGame().Move("B2", "B3"));
    }

    @Test
    void badMove() throws OutOfBoardException, WrongMoveException {
        assertFalse(getGame().Move("B1", "C1"));
    }

    private Game getGame() throws OutOfBoardException {
        return new Game();
    }
}
