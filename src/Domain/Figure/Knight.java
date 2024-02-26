package Domain.Figure;

import Domain.Figure.Move.*;
import Lib.Specification.ISpecification;

public class Knight extends Figure {
    public Knight(Color.ColorEnum color) {
        super(FigureEnum.KNIGHT, color);
    }

    @Override
    protected Boolean isSatisfied(Move move) {
        ISpecification<Move> knightMoves = new MoveLShape();

        return knightMoves.IsSatisfiedBy(move);
    }
}
