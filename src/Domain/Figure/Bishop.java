package Domain.Figure;

import Domain.Board.Color;
import Domain.Figure.Move.Move;

public class Bishop extends Figure {
    public Bishop(Color.ColorEnum color) {
        super(FigureEnum.BISHOP, color);
    }

    @Override
    public Boolean move(Move move) {
        return Math.abs(move.getVerticalDistance() * move.getHorizontalDistance()) >= 1
                && Math.abs(move.getVerticalDistance()) == Math.abs(move.getHorizontalDistance());
    }
}
