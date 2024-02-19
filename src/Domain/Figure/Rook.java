package Domain.Figure;

import Domain.Board.Color;
import Domain.Figure.Move.Move;

public class Rook extends Figure {
    public Rook(Color.ColorEnum color) {
        super(FigureEnum.ROOK, color);
    }

    @Override
    public Boolean move(Move move) {
        return (Math.abs(move.getHorizontalDistance()) == 1 || Math.abs(move.getVerticalDistance()) == 1)
                && Math.abs(move.getVerticalDistance() * move.getHorizontalDistance()) == 0;
    }
}
