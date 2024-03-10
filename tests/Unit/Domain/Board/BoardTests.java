package Unit.Domain.Board;

import Domain.Board.Board;
import Domain.Figure.Color;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Figure.Figure;

import Domain.Board.Position;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTests {
    @Test
    void testInitialize() throws OutOfBoardException {
        Board board = this.getBoard();

        assertInstanceOf(Board.class, board);
    }

    @Test
    void testBlackKnightPosition() throws OutOfBoardException {
        Board board = this.getBoard();
        Optional<Figure> figure = board.getFigureAtPosition(new Position(57));

        assertTrue(figure.isPresent());
        assertSame(Figure.FigureEnum.ROOK, figure.get().figure);
        assertSame(Color.ColorEnum.BLACK, figure.get().color);
    }

    @Test
    void testWhiteKingPosition() throws OutOfBoardException {
        Board board = this.getBoard();
        Optional<Figure> figure = board.getFigureAtPosition(new Position(4));

        assertTrue(figure.isPresent());
        assertSame(Figure.FigureEnum.QUEEN, figure.get().figure);
        assertSame(Color.ColorEnum.WHITE, figure.get().color);
    }

    @Test
    void testNoFigures() throws OutOfBoardException {
        Board board = this.getBoard();
        assertTrue(board.getFigureAtPosition(new Position("D4")).isEmpty());
    }

    @Test
    void testGetPositionsWithFigures() throws OutOfBoardException {
        Board board = this.getBoard();
        assertEquals(16, board.getPositionsWithFigures(Color.ColorEnum.WHITE).size());
    }

    Board getBoard() throws OutOfBoardException {
        Board board = new Board();
        board.initialize();

        return board;
    }
}
