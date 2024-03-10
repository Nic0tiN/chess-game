package Domain.Figure;

import Domain.Figure.Move.Movement;

import java.util.Objects;

abstract public class Figure {
    abstract protected Boolean isSatisfied(Movement movement);

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

    public Boolean move(Movement movement) {
        if (this.isSatisfied(movement)) {
            this.countMoves++;

            return true;
        }

        return false;
    }

    public int getCountMoves() {
        return countMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Figure figure1 = (Figure) o;
        return color == figure1.color && figure == figure1.figure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, figure);
    }
}
