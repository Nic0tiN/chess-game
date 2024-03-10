package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Exception.WrongMoveException;
import Domain.Figure.*;
import Domain.Figure.Move.Movement;

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
        this.figures.add(new King(Color.ColorEnum.BLACK));
        this.figures.add(new Queen(Color.ColorEnum.BLACK));
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
            if (iPosition >= (SIZE + SIZE)) {
                iPosition = (SIZE * SIZE) - iPosition + (SIZE + SIZE) - 1;
            }
            Position position = new Position(iPosition + 1);
            this.board[position.getHorizontal().ordinal()][position.getVertical().ordinal()] = this.figures.get(i);
        }
    }

    public Optional<Figure> getFigureAtPosition(Position position) {
        return this.getPosition(position.getHorizontal().ordinal(), position.getVertical().ordinal());
    }

    public Optional<Figure> getPosition(int horizontal, int vertical) {
        return Optional.ofNullable(this.board[horizontal][vertical]);
    }

    public void MoveFigureTo(Position from, Position to, Figure figure) throws WrongMoveException {
        if (!figure.move(new Movement(from, to, figure, this.board[to.getHorizontal().ordinal()][to.getVertical().ordinal()]))) {
            throw new WrongMoveException("You can't move " + from + " to " + to);
        }
        this.board[from.getHorizontal().ordinal()][from.getVertical().ordinal()] = null;
        this.board[to.getHorizontal().ordinal()][to.getVertical().ordinal()] = figure;
    }

    public ArrayList<Position> getPositionsWithFigures(Color.ColorEnum color) throws OutOfBoardException {
        ArrayList<Position> positions = new ArrayList<>();
        for(int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] != null && this.board[i][j].color.equals(color)) {
                    positions.add(new Position(i, j));
                }
            }
        }

        return positions;
    }

    public Figure[][] getBoard() {
        return board;
    }
}
