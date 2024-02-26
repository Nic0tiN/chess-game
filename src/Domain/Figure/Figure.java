package Domain.Figure;

import Domain.Figure.Move.Move;

abstract public class Figure {
    abstract protected Boolean isSatisfied(Move move);

    public final Color.ColorEnum color;
    public final FigureEnum figure;
    private int countMoves = 0;

    public enum FigureEnum {
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
    }

    public Figure(FigureEnum figure, Color.ColorEnum color) {
        this.figure = figure;
        this.color = color;
    }

    public Boolean move(Move move) {
        if (this.isSatisfied(move)) {
            this.countMoves++;

            return true;
        }

        return false;
    }

    public int getCountMoves() {
        return countMoves;
    }
}
