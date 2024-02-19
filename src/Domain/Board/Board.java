package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Figure.*;

import java.util.ArrayList;
import java.util.Optional;

public class Board {
    private static final int SIZE = Position.SIZE;
    private final Figure[][] board;
    private final ArrayList<Figure> figures;

    public Board() {
        this.board = new Figure[SIZE][SIZE];

        this.figures = new ArrayList<>((SIZE + SIZE) * 2);
        this.figures.add(new Rook(Color.ColorEnum.WHITE));
        this.figures.add(new Knight(Color.ColorEnum.WHITE));
        this.figures.add(new Bishop(Color.ColorEnum.WHITE));
        this.figures.add(new Queen(Color.ColorEnum.WHITE));
        this.figures.add(new King(Color.ColorEnum.WHITE));
        this.figures.add(new Bishop(Color.ColorEnum.WHITE));
        this.figures.add(new Knight(Color.ColorEnum.WHITE));
        this.figures.add(new Rook(Color.ColorEnum.WHITE));
        for (int i = 0; i < SIZE; i++) {
            this.figures.add(new Pawn(Color.ColorEnum.WHITE));
        }

        this.figures.add(new Rook(Color.ColorEnum.BLACK));
        this.figures.add(new Knight(Color.ColorEnum.BLACK));
        this.figures.add(new Bishop(Color.ColorEnum.BLACK));
        this.figures.add(new Queen(Color.ColorEnum.BLACK));
        this.figures.add(new King(Color.ColorEnum.BLACK));
        this.figures.add(new Bishop(Color.ColorEnum.BLACK));
        this.figures.add(new Knight(Color.ColorEnum.BLACK));
        this.figures.add(new Rook(Color.ColorEnum.BLACK));
        for (int i = 0; i < SIZE; i++) {
            this.figures.add(new Pawn(Color.ColorEnum.BLACK));
        }
    }

    public void initialize() throws OutOfBoardException {
        int iPosition;
        for (int i = 0; i < this.figures.size(); i++) {
            iPosition = i;
            if (iPosition >= 16) {
                iPosition = (SIZE * SIZE) - iPosition + (SIZE + SIZE) - 1;
            }
            Position position = new Position(iPosition + 1);
            this.board[position.getHorizontal().ordinal()][position.getVertical().ordinal()] = this.figures.get(i);
        }
    }

    public Optional<Figure> getFigureAtPosition(Position position) {
        return Optional.ofNullable(this.board[position.getHorizontal().ordinal()][position.getVertical().ordinal()]);
    }

    public void MoveFigureTo(Position position, Figure figure) {
        this.board[position.getHorizontal().ordinal()][position.getVertical().ordinal()] = figure;
    }
}
