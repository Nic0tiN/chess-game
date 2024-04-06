package Unit.Domain.Rule;

import Domain.Board.Board;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Exception.WrongMoveException;
import Domain.Figure.*;
import Domain.Figure.Move.Movement;
import Domain.Rule.CastlingRule;
import Domain.Rule.Rule;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CastlingRuleTests {
    @Test
    public void canNotCastleWhiteKingSideOutOfCheck() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("E7"), new Position("E5"));
        board.MoveFigureTo(new Position("F8"), new Position("B4"));
        board.MoveFigureTo(new Position("D2"), new Position("D3"));
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> rule.handle(board, new Movement(new Position("E1"), new Position("G1"), new King(Color.ColorEnum.WHITE), null)));
        assertEquals("Can't castle out-of check.", exception.getMessage());
    }
    @Test
    public void canNotCastleWhiteKingSideIntoCheck() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("F8"), new Position("C5"));
        board.MoveFigureTo(new Position("F2"), new Position("F4"));
        board.MoveFigureTo(new Position("G1"), new Position("F3"));
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> rule.handle(board, new Movement(new Position("E1"), new Position("G1"), new King(Color.ColorEnum.WHITE), null)));
        assertEquals("Can't castle into check.", exception.getMessage());
    }
    @Test
    public void canNotCastleWhiteKingSideThroughCheck() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("B7"), new Position("B6"));
        board.MoveFigureTo(new Position("C8"), new Position("A6"));
        board.MoveFigureTo(new Position("E2"), new Position("E4"));
 //       board.MoveFigureTo(new Position("H1"), new Position("H3"), new Rook(Color.ColorEnum.WHITE));
        WrongMoveException exception = assertThrows(WrongMoveException.class, () -> rule.handle(board, new Movement(new Position("E1"), new Position("G1"), new King(Color.ColorEnum.WHITE), null)));
        assertEquals("Can't castle through check.", exception.getMessage());
    }
    @Test
    public void castleWhiteKingSide() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("F1"), new Position("D3"));
        board.MoveFigureTo(new Position("G1"), new Position("F3"));
        assertTrue(rule.handle(board, new Movement(new Position("E1"), new Position("G1"), new King(Color.ColorEnum.WHITE), null)));
    }
    @Test
    public void castleWhiteQueenSide() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("D1"), new Position("C2"));
        board.MoveFigureTo(new Position("B1"), new Position("C3"));
        assertTrue(rule.handle(board, new Movement(new Position("E1"), new Position("C1"), new King(Color.ColorEnum.WHITE), null)));
    }

    private Rule getRule() {
        return new CastlingRule();
    }
}
