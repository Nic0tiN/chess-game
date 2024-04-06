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
    void checkmateTest() throws OutOfBoardException, WrongMoveException {
        Game game = this.getGame();
        game.Move("F2", "F3");
        game.Move("E7", "E5");
        game.Move("G2", "G4");
        game.Move("D8", "H4");

        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> game.Move("G1", "H3"));
        assertTrue(exception.getMessage().equals("Checkmate !"));
    }

    @Test
    void escapeCheckmateTest() throws OutOfBoardException, WrongMoveException {
        Game game = this.getGame();
        game.Move("D2", "D4");
        game.Move("F7", "F5");
        game.Move("C1", "G5");
        game.Move("H7", "H6");
        game.Move("G5", "F4");
        game.Move("G7", "G5");
        game.Move("F4", "G3");
        game.Move("F5", "F4");
        game.Move("E2", "E3");
        game.Move("H6", "H5");
        game.Move("F1", "D3");
        game.Move("H8", "H6");
        game.Move("D1", "H5"); // Check !

        assertTrue(game.Move("H6", "H5")); // Out-of-check

        game.Move("D3", "G6"); // Checkmate !

        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> game.Move("G8", "F6"));
        assertTrue(exception.getMessage().equals("Checkmate !"));
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
