package Unit.Domain.Rule;

import Domain.Board.Board;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Color;
import Domain.Figure.King;
import Domain.Figure.Move.Movement;
import Domain.Rule.CheckmateRule;
import Domain.Rule.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckmateRuleTests {
    @Test
    public void testCheckmateWhite() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("F2"), new Position("F3"));
        board.MoveFigureTo(new Position("E7"), new Position("E5"));
        board.MoveFigureTo(new Position("G2"), new Position("G4"));
        board.MoveFigureTo(new Position("D8"), new Position("H4"));

        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> rule.handle(board, new Movement(new Position("E1"), new Position("F2"), new King(Color.ColorEnum.WHITE), null)));
        assertEquals("Checkmate !", exception.getMessage());
    }

    @Test
    public void testCheckmateBlack() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("E2"), new Position("E4"));
        board.MoveFigureTo(new Position("B7"), new Position("B6"));
        board.MoveFigureTo(new Position("D2"), new Position("D4"));
        board.MoveFigureTo(new Position("C8"), new Position("B7"));
        board.MoveFigureTo(new Position("F1"), new Position("D3"));
        board.MoveFigureTo(new Position("F7"), new Position("F5")); // F5
        board.MoveFigureTo(new Position("E4"), new Position("F5")); // exf5
        board.MoveFigureTo(new Position("B7"), new Position("G2")); // Bxg2
        board.MoveFigureTo(new Position("D1"), new Position("H5")); // Qh5+
        board.MoveFigureTo(new Position("G7"), new Position("G6")); // g6
        board.MoveFigureTo(new Position("F5"), new Position("G6")); // fxg6
        board.MoveFigureTo(new Position("G8"), new Position("F6")); // Nf6
        board.MoveFigureTo(new Position("G6"), new Position("H7"));
        board.MoveFigureTo(new Position("F6"), new Position("H5"));
        board.MoveFigureTo(new Position("D3"), new Position("G6"));

        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> rule.handle(board, new Movement(new Position("E8"), new Position("F7"), new King(Color.ColorEnum.BLACK), null)));
        assertEquals("Checkmate !", exception.getMessage());
    }


    @Test
    public void testEscapeCheckmate() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("F2"), new Position("F3"));
        board.MoveFigureTo(new Position("E7"), new Position("E5"));
        board.MoveFigureTo(new Position("G2"), new Position("G4"));
        board.MoveFigureTo(new Position("D8"), new Position("H4"));

        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> rule.handle(board, new Movement(new Position("E1"), new Position("F2"), new King(Color.ColorEnum.WHITE), null)));
        assertEquals("Checkmate !", exception.getMessage());

        board.MoveFigureTo(new Position("D2"), new Position("D3"));

        assertTrue(rule.handle(board, new Movement(new Position("E1"), new Position("D2"), new King(Color.ColorEnum.WHITE), null)));
    }

    private Rule getRule() {
        return new CheckmateRule();
    }
}
