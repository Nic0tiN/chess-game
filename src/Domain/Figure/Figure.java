package Domain.Figure;

import Domain.Board.Color;
import Domain.Figure.Move.Move;

abstract public class Figure {
    abstract public Boolean move(Move move);

    public final Color.ColorEnum color;
    public final FigureEnum figure;

    public enum FigureEnum {
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN;
    }

    public Figure(FigureEnum figure, Color.ColorEnum color) {
        this.figure = figure;
        this.color = color;
    }
}
