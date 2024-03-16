package Unit.Domain.Rule;

import Domain.Board.Board;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Exception.WrongMoveException;
import Domain.Figure.*;
import Domain.Figure.Move.Movement;
import Domain.Rule.EnPassantRule;
import Domain.Rule.Rule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnPassantRuleTests
{
    @Test
    public void blackPawnEnPassantTest() throws OutOfBoardException, WrongMoveException {
        Rule rule = this.getRule();
        Board board = new Board();
        board.initialize();

        board.MoveFigureTo(new Position("B7"), new Position("B5"), new Pawn(Color.ColorEnum.BLACK));
        board.MoveFigureTo(new Position("D2"), new Position("D3"), new Pawn(Color.ColorEnum.WHITE));
        board.MoveFigureTo(new Position("B5"), new Position("B4"), new Pawn(Color.ColorEnum.BLACK));
        board.MoveFigureTo(new Position("C2"), new Position("C4"), new Pawn(Color.ColorEnum.WHITE));
        assertTrue(rule.handle(board, new Movement(new Position("B4"), new Position("D3"), new Pawn(Color.ColorEnum.BLACK), null)));
    }

    private Rule getRule() throws OutOfBoardException {
        List<Movement> movements = new ArrayList<>();
        movements.add(new Movement(new Position("C2"), new Position("C4"), new Pawn(Color.ColorEnum.WHITE), null));
        return new EnPassantRule(movements);
    }

}
