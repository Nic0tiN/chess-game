package Domain.Figure;

import Domain.Board.Color;
import Domain.Figure.Move.*;
import Lib.Specification.ISpecification;
import Lib.Specification.NotSpecification;

public class Knight extends Figure {
    public Knight(Color.ColorEnum color) {
        super(FigureEnum.KNIGHT, color);
    }

    @Override
    public Boolean move(Move move) {
        ISpecification<Move> knightMoves = new MoveLShape();

        return knightMoves.IsSatisfiedBy(move);
    }
}
