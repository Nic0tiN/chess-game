package Unit.Domain;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Exception.WrongMoveException;
import Domain.Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    @Test
    void correctMoveWhiteFirst() throws OutOfBoardException, WrongMoveException {
        assertTrue(getGame().Move("B2", "B3"));
    }
    @Test
    void correctMoveBlackMoveNext() throws OutOfBoardException, WrongMoveException {
        Game game = this.getGame();
        assertTrue(game.Move("B2", "B3"));
        assertTrue(game.Move("B7", "B6"));
    }
    @Test
    void badMoveBlackFirst() {
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> this.getGame().Move("B7", "B6"));
        assertTrue(exception.getMessage().contains("It is not your turn."));
    }

    @Test
    void badMove() {
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> getGame().Move("B1", "C1"));
        assertTrue(exception.getMessage().contains("You can not take your own pieces."));
    }

    @Test
    void badMoveNotYourTurn() throws OutOfBoardException, WrongMoveException {
        Game game = this.getGame();
        game.Move("B2", "B3");
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> game.Move("C2", "C3"));
        assertTrue(exception.getMessage().contains("It is not your turn."));
    }

    @Test
    void badMoveNoFigure() throws OutOfBoardException {
        Game game = this.getGame();
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> game.Move("D4", "D5"));
        assertTrue(exception.getMessage().contains("No figures at position D4."));
    }

    @Test
    void badMoveOverFigures() throws OutOfBoardException {
        Game game = this.getGame();
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> game.Move("D1", "F3"));
        assertTrue(exception.getMessage().contains("You can not move over figures."));
    }
    @Test
    void enPassantTest() throws OutOfBoardException, WrongMoveException {
        Game game = this.getGame();
        game.Move("A2", "A4");
        game.Move("C7", "C6");
        game.Move("A4", "A5");
        game.Move("B7", "B5");
        assertTrue(game.Move("A5", "B6"));
    }

    private Game getGame() throws OutOfBoardException {
        return new Game();
    }
}
