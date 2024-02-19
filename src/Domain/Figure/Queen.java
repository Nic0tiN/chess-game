package Domain.Figure;

import Domain.Board.Color;
import Domain.Figure.Move.Move;

public class Queen extends Figure {
    public Queen(Color.ColorEnum color) {
        super(FigureEnum.QUEEN, color);
    }

    @Override
    public Boolean move(Move move) {
        return Math.abs(move.getVerticalDistance() + move.getHorizontalDistance()) >= 1;
    }
}
